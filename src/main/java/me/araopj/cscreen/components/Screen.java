package me.araopj.cscreen.components;

import me.araopj.cscreen.classes.CharSets;
import me.araopj.cscreen.classes.Position;
import me.araopj.cscreen.classes.Symbol;

/**
 * The `Screen` class represents a screen with the ability to display components and borders.
 * It includes features like setting dimensions, adding titles, and generating the screen layout.
 */
public class Screen {

    // Properties of the Screen class
    char[][] screen;
    private int c;
    private int r;
    private boolean hasBorder;
    private String title = "";
    CharSets charSets;

    /**
     * Constructs a `Screen` with default dimensions and no border.
     */
    public Screen() {
        setCharSets(null);
        if (r < 4) {
            r = 3;
        }
        if (c < 5) {
            c = 4;
        }
        this.screen = new char[r][c];
    }

    /**
     * Constructs a `Screen` with specified dimensions and no border.
     *
     * @param r The number of rows in the screen.
     * @param c The number of columns in the screen.
     */
    public Screen(int r, int c) {
        setCharSets(null);
        this.r = r;
        this.c = c;

        if (r < 4) {
            this.r = 3;
        }
        if (c < 5) {
            this.c = 4;
        }
        this.screen = new char[r][c];

        generateScreen();
    }

    /**
     * Constructs a `Screen` with specified dimensions and an optional border.
     *
     * @param r         The number of rows in the screen.
     * @param c         The number of columns in the screen.
     * @param hasBorder A boolean indicating whether the screen should have a border.
     */
    public Screen(int r, int c, boolean hasBorder) {
        setCharSets(null);
        this.hasBorder = hasBorder;
        this.r = r;
        this.c = c;

        if (r < 4) {
            this.r = 3;
        }
        if (c < 5) {
            this.c = 4;
        }
        this.screen = new char[r][c];
        generateScreen();
    }

    /**
     * Sets the character sets for drawing on the screen.
     *
     * @param symbol The `Symbol` enum representing the character set to be used.
     */
    protected void setCharSets(Symbol symbol) {
        charSets = CharSets.getInstance(symbol);
    }

    /**
     * Sets the character set to use box drawing characters and generates the screen layout.
     */
    public void useBoxSet() {
        setCharSets(Symbol.BOX_DRAWING);
        generateScreen();
    }

    /**
     * Sets the dimensions of the screen.
     *
     * @param r The number of rows in the screen.
     * @param c The number of columns in the screen.
     */
    public void setDimension(int r, int c) {
        this.r = r;
        this.c = c;
    }

    /**
     * Sets the title of the screen at the specified position.
     *
     * @param title The title to be set on the screen.
     */
    public void setTitle(String title) {
        clearTitle();
        addTitle(title, Position.START);
    }

    /**
     * Sets the position of the title on the screen.
     *
     * @param pos The `Position` enum representing the position of the title.
     */
    public void setTitlePosition(Position pos) {
        clearTitle();
        addTitle(this.title, pos);
    }

    /**
     * Adds a title to the screen at the specified position.
     *
     * @param title The title to be added to the screen.
     * @param pos   The `Position` enum representing the position of the title.
     */
    public void addTitle(String title, Position pos) {
        clearTitle();
        this.title = title;
        int start = 0;
        int end = 0;
        if (screen[0].length - 4 < this.title.length()) {
            this.title = this.title.substring(0, screen[0].length - 2);
        }
        if (pos == Position.START) {
            start = 1;
            end = this.title.length() + 1;
        } else if (pos == Position.CENTER) {
            start = Math.abs(((screen[0].length - this.title.length()) / 2) - 2);
            end = start + this.title.length();
        } else if (pos == Position.END) {
            start = (screen[0].length - this.title.length()) - 1;
            end = start + this.title.length();
        }
        for (int i = start, j = 0; i < end; i++) {
            screen[1][i] = this.title.charAt(j++);
        }
    }

    /**
     * Clears the title from the screen.
     */
    private void clearTitle() {
        for (int i = 1; i < screen[0].length - 1; i++) {
            screen[1][i] = ' ';
        }
    }

    /**
     * Generates the initial layout of the screen, including borders if specified.
     */
    public void generateScreen() {
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[i].length; j++) {
                screen[i][j] = ' ';
                if (i == 0 || i == screen.length - 1) {
                    screen[i][j] = charSets.horizontal;
                } else {
                    if (j == 0 || j == screen[i].length - 1) {
                        screen[i][j] = charSets.vertical;
                    }
                }

                // Inner border
                if (hasBorder) {
                    if (i == 2 || i == screen.length - 2) {
                        if (j > 0 && j < screen[i].length - 1) {
                            screen[i][j] = charSets.horizontal;
                        }
                    } else {
                        if (i > 1 && i < screen.length - 1) {
                            if (j == 1 || j == screen[i].length - 2) {
                                screen[i][j] = charSets.vertical;
                            }
                        }
                    }
                }
            }
        }

        // Corners
        screen[0][0] = charSets.corners[0];
        screen[0][screen[0].length - 1] = charSets.corners[1];
        screen[screen.length - 1][0] = charSets.corners[2];
        screen[screen.length - 1][screen[0].length - 1] = charSets.corners[3];

        if (hasBorder) {
            // Inner corners
            screen[2][1] = charSets.corners[0];
            screen[2][screen[0].length - 2] = charSets.corners[1];
            screen[screen.length - 2][1] = charSets.corners[2];
            screen[screen.length - 2][screen[0].length - 2] = charSets.corners[3];
        }
    }

    /**
     * Displays the screen by printing its content to the console.
     */
    public void display() {
        for (char[] chars : screen) {
            for (char aChar : chars) {
                charSets.printChar(aChar);
            }
            System.out.println();
        }
    }
}
