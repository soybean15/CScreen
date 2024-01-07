package tech.araopj.cscreen.components;

import tech.araopj.cscreen.classes.Position;
import tech.araopj.cscreen.classes.Utilities;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.PrintStream;
import java.util.*;

public class CTable extends CList {

    private String[] columnHeader;

    private final HashMap<Integer, Position> alignments = new HashMap<>();
    int[] spaces;

    private List<List<String>> list2D;
    private List<List<String>> tempList2D;

    private boolean onSearch;


    private boolean hasSeparator;


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


    public CTable(List<List<String>> arr, String... columnHeader) {
        super();

        this.columnHeader = columnHeader;

        this.list2D = arr;

        this.list = new ArrayList<>();

    }

    public CTable(String[][] arr, String... columnHeader) {
        super();
        this.columnHeader = columnHeader;
        this.list2D = Arrays.stream(arr).map(Arrays::asList).collect(Collectors.toList());
        this.list = new ArrayList<>();
    }


    public CTable(List<List<String>> arr, Position pos, boolean hasSeparator, String... columnHeader) {
        super();
        this.columnHeader = columnHeader;
        this.list2D = arr;
        this.hasSeparator = hasSeparator;
        this.pos = pos;
        this.list = new ArrayList<>();
    }


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

    public void display() throws UnsupportedEncodingException {
        generateScreen();
        PrintStream out = new PrintStream(System.out, true, StandardCharsets.UTF_8.name());
        Arrays.stream(screen).forEach(value -> {
            IntStream.range(0, screen[0].length).forEachOrdered(j -> out.print(value[j]));
            out.println();
        });
    }

    private int combineRow(List<List<String>> arr) {
        list = new ArrayList<>();

        char separator = charSets.vertical;
        if (!hasSeparator) {
            separator = ' ';
        }
        spaces = Utilities.getMaxByColumn(arr);

        int max = 0;
        int idx = 0;

        if (columnHeader != null) {
            String header = "";
            for (int i = 0; i < columnHeader.length; i++) {
                int space = spaces[i];
                String fline = Utilities.alignedString(columnHeader[i], space, Position.CENTER);
                header = header + fline + separator;
            }
            list.add(header);
        }


        for (int i = 0; i < arr.size(); i++) {
            String line = "";
            max = Math.max(max, Utilities.getMax(arr.get(i).toArray(new String[0])));
            for (int j = 0; j < arr.get(i).size(); j++) {
                int space = spaces[j];
                //System.out.println(alignments);
                String fline = Utilities.alignedString(arr.get(i).get(j), space, alignments.getOrDefault(j, null));
                line = line + fline + separator;
            }
            list.add(line);
            idx++;
        }
        return list.get(0).length();
    }

    public void hasSeparator(boolean hasSeparator) {
        this.hasSeparator = hasSeparator;
    }

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


    public void addRow(String... row) {
        if (this.list2D.get(0).get(0).equals(" ")) {
            this.list2D.remove(0);
        }
        this.list2D.add(Arrays.asList(row));
    }


    public List<String> getRow(int index) {
        return list2D.get(index);
    }

    // TODO: Test method -> getColumn()
    public List<String> getColumn(int index) {
        return this.list2D.stream().map(value -> value.get(index)).collect(Collectors.toList());
//        List<String> newList = new ArrayList<>();
//        for (List<String> strings : list2D) {
//            newList.add(strings.get(index));
//        }
//        return newList;
    }

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

    public String getCell(int row, int column) {
        return list2D.get(row).get(column);
    }

    public void setCell(int row, int column, String str) {
        list2D.get(row).set(column, str);
    }

    public void addList(List<List<String>> arr) {
        if (this.list2D.get(0).get(0).equals(" ")) {
            this.list2D.remove(0);
        }
        this.list2D.addAll(arr);
        //this.list2D= arr;
    }

    // TODO: Test method -> findRows()
    public List<List<String>> findRows(int column, String text) {
        return this.list2D.stream().filter(row -> row.get(column).equals(text)).collect(Collectors.toList());

//        List<List<String>> newArr = new ArrayList<>();
//        for (List<String> strings : this.list2D) {
//            if (strings.get(column).equals(text)) {
//                newArr.add(strings);
//            }
//        }
//        return newArr;
    }
//    public void searchRow(int column, String item){
//
//       List<List<String>> newList = new ArrayList<>(findItem( column,  item));
//        if(!newList.isEmpty()){
//            tempList2D = new ArrayList<>(newList);
//            System.out.println(tempList2D.size()+" item(s) out of "+list2D.size()+" row(s) Found");
//            if (columnHeader != null) {
//                tempList2D = Utilities.addHeader(tempList2D,this.columnHeader);
//            }
//            onSearch=true;
//        }else{
//            System.out.println("No item found");
//        }
//    }

    public void setColumnAlignment(int columnIndex, Position position) {
        alignments.put(columnIndex, position);
    }

    // TODO: Test method -> getTotal()
    public int getTotal(int columnIndex) {
        return list2D.stream()
                .filter(i -> i.stream().filter(Utilities::isNumeric).isParallel()).mapToInt(row -> columnIndex).sum();
//        int result = 0;
//        for (List<String> strings : list2D) {
//            result += Utilities.isNumeric(strings.get(columnIndex));
//        }
//       return result;
    }

    // TODO: Test method -> getFloatTotal()
    public double getFloatTotal(int columnIndex) {
        return list2D.stream()
                .filter(i -> i.stream().filter(Utilities::isNumeric).isParallel()).mapToDouble(row -> columnIndex).sum();
//        float result = 0;
//        for (List<String> strings : list2D) {
//            result += Utilities.isNumeric(strings.get(columnIndex));
//        }
//        return result;
    }
}
