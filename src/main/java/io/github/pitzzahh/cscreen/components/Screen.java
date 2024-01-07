package io.github.pitzzahh.cscreen.components;

import io.github.pitzzahh.cscreen.classes.CharSets;
import io.github.pitzzahh.cscreen.classes.Position;
import io.github.pitzzahh.cscreen.classes.Symbol;

public class Screen {
    char[][] screen;
    private int c;
    private int r;
    private boolean hasBorder;
    private String title = "";
    CharSets charSets;

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

    protected void setCharSets(Symbol symbol) {
        charSets = CharSets.getInstance(symbol);
    }

    public void useBoxSet() {
        setCharSets(Symbol.BOX_DRAWING);
        generateScreen();
    }

    public void setDimension(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public void setTitle(String title) {
        clearTitle();
        addTitle(title, Position.START);
    }

    public void setTitlePosition(Position pos) {
        clearTitle();
        addTitle(this.title, pos);
    }

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
            System.out.println(this.title);
            end = start + this.title.length();
        } else if (pos == Position.END) {
            start = (screen[0].length - this.title.length()) - 1;
            end = start + this.title.length();
        }
        for (int i = start, j = 0; i < end; i++) {
            screen[1][i] = this.title.charAt(j++);
        }

    }

    private void clearTitle() {
        for (int i = 1; i < screen[0].length - 1; i++) {
            screen[1][i] = ' ';
        }
    }

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

                //inner border
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

        screen[0][0] = charSets.corners[0];
        screen[0][screen[0].length - 1] = charSets.corners[1];
        screen[screen.length - 1][0] = charSets.corners[2];
        screen[screen.length - 1][screen[0].length - 1] = charSets.corners[3];

        if (hasBorder) {
            //corners
            screen[2][1] = charSets.corners[0];
            screen[2][screen[0].length - 2] = charSets.corners[1];
            screen[screen.length - 2][1] = charSets.corners[2];
            screen[screen.length - 2][screen[0].length - 2] = charSets.corners[3];
        }
    }

    public void display() {
        for (char[] chars : screen) {
            for (char aChar : chars) {
                charSets.printChar(aChar);
            }
            System.out.println();
        }
    }

}



