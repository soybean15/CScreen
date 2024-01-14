package me.araopj.cscreen.components;

import me.araopj.cscreen.classes.Position;
import me.araopj.cscreen.classes.Utilities;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.PrintStream;
import java.util.*;

/**
 * The `CTable` class represents a customizable table for displaying tabular data on a screen.
 * It extends the `CList` class to inherit basic list functionality.
 */
public class CTable extends CList {

    // Properties specific to CTable
    private final String[] columnHeader;
    private final HashMap<Integer, Position> alignments = new HashMap<>();
    int[] spaces;

    private final List<List<String>> list2D;
    private List<List<String>> tempList2D;

    private boolean onSearch;
    private boolean hasSeparator;

    /**
     * Constructs a `CTable` with the specified column headers.
     *
     * @param columnHeader The headers for each column.
     */
    public CTable(String... columnHeader) {
        super();
        this.columnHeader = columnHeader;
        this.list2D = new ArrayList<>();

        if (columnHeader == null) {
            this.list2D.add(Arrays.asList(" ", " ", " ", " "));
        } else {
            this.list2D.add(Arrays.asList(Utilities.createEmptyList(columnHeader)));
        }

        this.list = new ArrayList<>();
    }

    /**
     * Constructs a `CTable` with the specified 2D list and column headers.
     *
     * @param arr          The 2D list representing the table data.
     * @param columnHeader The headers for each column.
     */
    public CTable(List<List<String>> arr, String... columnHeader) {
        super();
        this.columnHeader = columnHeader;
        this.list2D = arr;
        this.list = new ArrayList<>();
    }

    /**
     * Constructs a `CTable` with the specified 2D array and column headers.
     *
     * @param arr          The 2D array representing the table data.
     * @param columnHeader The headers for each column.
     */
    public CTable(String[][] arr, String... columnHeader) {
        super();
        this.columnHeader = columnHeader;
        this.list2D = Arrays.stream(arr).map(Arrays::asList).collect(Collectors.toList());
        this.list = new ArrayList<>();
    }

    /**
     * Constructs a `CTable` with the specified 2D list, column headers, position, and separator option.
     *
     * @param arr          The 2D list representing the table data.
     * @param pos          The position of the table title.
     * @param hasSeparator Indicates whether to use a separator between columns.
     * @param columnHeader The headers for each column.
     */
    public CTable(List<List<String>> arr, Position pos, boolean hasSeparator, String... columnHeader) {
        super();
        this.columnHeader = columnHeader;
        this.list2D = arr;
        this.hasSeparator = hasSeparator;
        this.pos = pos;
        this.list = new ArrayList<>();
    }

    /**
     * Initializes the table, preparing it for display.
     */
    void init() {
        if (!onSearch) {
            tempList2D = new ArrayList<>(this.list2D);
        }

        int len = this.tempList2D.size() + 2;

        if (!onSearch) {
            if (columnHeader != null) {
                this.tempList2D = Utilities.addHeader(this.list2D, this.columnHeader);
                len = this.tempList2D.size() + 3;
            }
        } else {
            len = this.tempList2D.size() + 3;
        }

        onSearch = false;

        int colSize = combineRow(tempList2D) + 1;
        this.screen = new char[len][colSize];
    }

    /**
     * Displays the table on the screen.
     */
    public void display() {
        try {
            generateScreen();
            PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8.name());
            Arrays.stream(screen).forEach(value -> {
                IntStream.range(0, screen[0].length).forEachOrdered(j -> out.print(value[j]));
                out.println();
            });
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Combines rows and prepares the list for display.
     *
     * @param arr The 2D list representing the table data.
     * @return The total width of the combined rows.
     */
    private int combineRow(List<List<String>> arr) {
        list = new ArrayList<>();

        char separator = charSets.vertical;
        if (!hasSeparator) {
            separator = ' ';
        }
        spaces = Utilities.getMaxByColumn(arr);

        int max = 0;

        if (columnHeader != null) {
            StringBuilder header = new StringBuilder();
            for (int i = 0; i < columnHeader.length; i++) {
                int space = spaces[i];
                String firstLine = Utilities.alignedString(columnHeader[i], space, Position.CENTER);
                header.append(firstLine).append(separator);
            }
            list.add(header.toString());
        }

        for (List<String> strings : arr) {
            StringBuilder line = new StringBuilder();
            max = Math.max(max, Utilities.getMax(strings.toArray(new String[0])));
            for (int j = 0; j < strings.size(); j++) {
                int space = spaces[j];
                String firstLine = Utilities.alignedString(strings.get(j), space, alignments.getOrDefault(j, null));
                line.append(firstLine).append(separator);
            }
            list.add(line.toString());
        }
        return list.get(0).length();
    }

    /**
     * Sets whether the table has a separator between columns.
     *
     * @param hasSeparator Indicates whether to use a separator.
     */
    public void hasSeparator(boolean hasSeparator) {
        this.hasSeparator = hasSeparator;
    }

    /**
     * Adds a column header to the screen.
     *
     * @param str The column header text.
     */
    private void addColumnHeader(String str) {
        for (int i = 0, j = 0; i < str.length(); i++) {
            if (i == 0 || i == str.length() - 1) {
                screen[1][i] = charSets.vertical;
                if (i == 0) {
                    screen[2][i] = charSets.sideConnectors[0];
                } else {
                    screen[2][i] = charSets.sideConnectors[1];
                }
            } else {
                screen[1][i] = str.charAt(j++);
                if (screen[1][i] == charSets.vertical) {
                    screen[2][i] = charSets.sideConnectors[4];
                    screen[0][i] = charSets.sideConnectors[2];
                } else {
                    screen[2][i] = charSets.horizontal;
                }
            }
        }
    }

    /**
     * Generates the screen for displaying the table.
     */
    private void generateScreen() {
        init();

        int start = 0;
        int end = screen.length - 1;
        int idx = 0;

        String str = "";
        for (int i = 0; i < screen.length; i++) {
            if (i > start && i < end) {
                str = list.get(idx);
                idx++;
            }
            for (int j = 0, k = 0; j < screen[0].length; j++) {
                screen[i][j] = ' ';
                if (i == 0 || i == screen.length - 1) {
                    screen[i][j] = charSets.horizontal;
                    if (i == screen.length - 1) {
                        if (screen[screen.length - 2][j] == charSets.vertical) {
                            screen[i][j] = charSets.sideConnectors[3];
                        }
                    }
                } else {
                    if (j > 0) {
                        if (k > str.length() - 1) {
                            continue;
                        }
                        screen[i][j] = str.charAt(k++);
                    }
                    if (j == 0 || j == screen[0].length - 1) {
                        screen[i][j] = charSets.vertical;
                    }
                }
                if (i == 1) {
                    if (screen[i][j] == charSets.vertical) {
                        screen[0][j] = charSets.sideConnectors[2];
                    }
                }
            }
        }
        //corners
        setCorners(screen[0], charSets.corners[0], charSets.corners[1], screen[screen.length - 1], charSets.corners[2], charSets.corners[3]);

        if (columnHeader != null) {
            addColumnHeader(list.get(0) + " ");
        }
    }

    /**
     * Adds a row to the table.
     *
     * @param row The values to be added as a row.
     */
    public void addRow(String... row) {
        if (this.list2D.get(0).get(0).equals(" ")) {
            this.list2D.remove(0);
        }
        this.list2D.add(Arrays.asList(row));
    }

    /**
     * Retrieves the values of a specific row.
     *
     * @param index The index of the row to retrieve.
     * @return The values of the specified row.
     */
    public List<String> getRow(int index) {
        return list2D.get(index);
    }

    /**
     * Retrieves the values of a specific column.
     *
     * @param index The index of the column to retrieve.
     * @return The values of the specified column.
     */
    public List<String> getColumn(int index) {
        return this.list2D.stream().map(value -> value.get(index)).collect(Collectors.toList());
    }

    /**
     * Removes a row from the table.
     *
     * @param index The index of the row to be removed.
     */
    public void removeRow(int index) {
        this.list2D.remove(index);
        if (this.list2D.isEmpty()) {
            if (columnHeader == null) {
                this.list2D.add(Arrays.asList(" ", " ", " ", " "));
            } else {
                this.list2D.add(Arrays.asList(Utilities.createEmptyList(columnHeader)));
            }
        }
    }

    /**
     * Retrieves the value of a specific cell in the table.
     *
     * @param row    The row index of the cell.
     * @param column The column index of the cell.
     * @return The value of the specified cell.
     */
    public String getCell(int row, int column) {
        return list2D.get(row).get(column);
    }

    /**
     * Sets the value of a specific cell in the table.
     *
     * @param row    The row index of the cell.
     * @param column The column index of the cell.
     * @param str    The new value for the cell.
     */
    public void setCell(int row, int column, String str) {
        list2D.get(row).set(column, str);
    }

    /**
     * Adds a list of rows to the table.
     *
     * @param arr The 2D list representing the rows to be added.
     */
    public void addList(List<List<String>> arr) {
        if (this.list2D.get(0).get(0).equals(" ")) {
            this.list2D.remove(0);
        }
        this.list2D.addAll(arr);
    }

    /**
     * Finds and retrieves rows based on a specified column and text.
     *
     * @param column The index of the column to search.
     * @param text   The text to search for in the specified column.
     * @return The list of rows matching the search criteria.
     */
    public List<List<String>> findRows(int column, String text) {
        return this.list2D.stream().filter(row -> row.get(column).equals(text)).collect(Collectors.toList());
    }

    /**
     * Sets the alignment for a specific column in the table.
     *
     * @param columnIndex The index of the column.
     * @param position    The alignment position for the column.
     */
    public void setColumnAlignment(int columnIndex, Position position) {
        alignments.put(columnIndex, position);
    }

    /**
     * Calculates the total sum of numeric values in a specific column.
     *
     * @param columnIndex The index of the column.
     * @return The total sum of numeric values in the specified column.
     */
    public int getTotal(int columnIndex) {
        return list2D.stream()
                .filter(i -> i.stream().filter(Utilities::isNumeric).isParallel()).mapToInt(row -> columnIndex).sum();
    }

    /**
     * Calculates the total sum of floating-point values in a specific column.
     *
     * @param columnIndex The index of the column.
     * @return The total sum of floating-point values in the specified column.
     */
    public double getFloatTotal(int columnIndex) {
        return list2D.stream()
                .filter(i -> i.stream().filter(Utilities::isNumeric).isParallel()).mapToDouble(row -> columnIndex).sum();
    }
}
