package me.araopj.cscreen.components;

import me.araopj.cscreen.classes.CharSets;
import me.araopj.cscreen.classes.Position;
import me.araopj.cscreen.classes.Symbol;
import me.araopj.cscreen.classes.Utilities;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The `CList` class represents a customizable list for displaying information on a screen.
 */
public class CList {

    // Properties of the CList class
    protected char[][] screen;
    protected List<String> list;
    private String title = "";
    Position pos;
    protected int width;
    boolean displayed; // Check if display() has already been called

    CharSets charSets;

    /**
     * Constructs a `CList` with an array of items and a specified width.
     *
     * @param arr   Array of items to initialize the list.
     * @param width The width of the list.
     */
    public CList(String[] arr, int width) {
        setCharSets(null);
        List<String> temp = Arrays.asList(arr);
        list = new ArrayList<>(temp);
        this.width = width;
    }

    /**
     * Constructs an empty `CList`.
     */
    public CList() {
        this.list = new ArrayList<>();
        list.add(""); // Add an empty item to the list
        setCharSets(null);
    }

    /**
     * Constructs a `CList` with an array of items.
     *
     * @param arr Array of items to initialize the list.
     */
    public CList(String[] arr) {
        List<String> temp = Arrays.asList(arr);
        this.list = new ArrayList<>(temp);
        setCharSets(null);
    }

    /**
     * Sets the character sets used for drawing the list.
     *
     * @param symbol The symbol to be used for drawing.
     */
    protected void setCharSets(Symbol symbol) {
        charSets = CharSets.getInstance(symbol);
    }

    /**
     * Sets the character sets to use box drawing characters for the list.
     */
    public void useBoxSet() {
        setCharSets(Symbol.BOX_DRAWING);
    }

    /**
     * Sets the width of the list.
     *
     * @param width The new width of the list.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Generates the screen representation of the list.
     */
    private void generateScreen() {
        if (this.title.length() > 0 && this.width <= title.length()) {
            this.width = title.length();
        }

        int start = 0;
        if (!displayed) {
            if (width > Utilities.getMax(this.list.toArray(new String[0]))) {
                width = width + 2;
            } else {
                width = Utilities.getMax(this.list.toArray(new String[0])) + 2;
            }
            displayed = true;
        }

        int r = this.list.size() + 2;
        if (title.length() > 0) {
            r += 2;
            start = 2;
        }
        this.screen = new char[r][width];

        int idx = 0;

        String str = "";
        for (int i = 0; i < screen.length; i++) {
            if (i > start && i < screen.length - 1) {
                str = list.get(idx);
                idx++;
            }
            for (int j = 0, k = 0; j < width; j++) {
                screen[i][j] = ' ';
                if (i == 0 || i == screen.length - 1) {
                    screen[i][j] = charSets.horizontal;
                } else {
                    if (j == 0 || j == width - 1) {
                        screen[i][j] = charSets.vertical;
                    }
                    if (j > 0) {
                        if (k > str.length() - 1) {
                            continue;
                        }
                        screen[i][j] = str.charAt(k++);
                    }
                }
            }
        }
        //corners
        setCorners(screen[0], charSets.corners[0], charSets.corners[1], screen[screen.length - 1], charSets.corners[2], charSets.corners[3]);
    }

    /**
     * Sets the corner characters for the screen borders.
     *
     * @param chars   The array of characters representing the top or bottom border.
     * @param corner  The character for the top-left corner.
     * @param corner2 The character for the top-right corner.
     * @param chars2  The array of characters representing the bottom border.
     * @param corner3 The character for the bottom-left corner.
     * @param corner4 The character for the bottom-right corner.
     */
    protected static void setCorners(char[] chars, char corner, char corner2, char[] chars2, char corner3, char corner4) {
        chars[0] = corner;
        chars[chars.length - 1] = corner2;
        chars2[0] = corner3;
        chars2[chars.length - 1] = corner4;
    }

    /**
     * Sets the title of the list and its position.
     *
     * @param title The title to be set.
     * @param pos   The position of the title (START, CENTER, or END).
     */
    public void setTitle(String title, Position pos) {
        this.title = title;
        this.pos = pos;
    }

    /**
     * Adds the title to the screen representation of the list.
     */
    private void addTitle() {
        int start = 0;
        int end = 0;

        if (this.title.length() > 0) {
            if (width - 4 < this.title.length()) {
                this.title = this.title.substring(0, screen[0].length - 2);
            }

            if (pos == Position.START) {
                start = 1;
                end = this.title.length() + 1;
            } else if (pos == Position.CENTER) {
                start = Math.abs(((screen[0].length - this.title.length()) / 2)) + 1;
                if (this.title.length() + 2 >= screen[0].length) {
                    start = 1;
                }
                end = start + this.title.length();
            } else if (pos == Position.END) {
                start = (screen[0].length - this.title.length()) - 1;
                end = start + this.title.length();
            }

            for (int i = start, j = 0; i < end; i++) {
                screen[1][i] = this.title.charAt(j++);
            }
            //├┤
            for (int i = 1; i < width - 1; i++) {
                screen[2][i] = charSets.horizontal;
            }
            screen[2][0] = charSets.sideConnectors[0];
            screen[2][width - 1] = charSets.sideConnectors[1];
        }
    }

    /**
     * Displays the screen representation of the list.
     *
     * @throws UnsupportedEncodingException If an unsupported encoding is encountered.
     */
    public void display() throws UnsupportedEncodingException {
        generateScreen();
        if (title.length() > 0) addTitle();
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[0].length; j++) {
                charSets.printChar(screen[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Adds a counter to each item in the list.
     */
    public void addCounter() {
        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            this.list.set(i, String.valueOf(count) + "." + this.list.get(i));
            count++;
        }
    }

    /**
     * Adds an item to the list.
     *
     * @param item The item to be added.
     */
    public void addItem(String item) {
        if (this.list.get(0).equals("")) {
            this.list.remove(0);
        }
        this.list.add(item);
    }

    /**
     * Gets the item at the specified index.
     *
     * @param index The index of the item to retrieve.
     * @return The item at the specified index.
     */
    public String getItem(int index) {
        return this.list.get(index);
    }

    /**
     * Removes the item at the specified index.
     *
     * @param index The index of the item to be removed.
     */
    public void remove(int index) {
        this.list.remove(index);
        if (list.isEmpty()) {
            list.add("");
        }
    }

    /**
     * Sets the item at the specified index.
     *
     * @param index The index of the item to be set.
     * @param item  The new value for the item.
     */
    public void set(int index, String item) {
        this.list.set(index, item);
    }
}
