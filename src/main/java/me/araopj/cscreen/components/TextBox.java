package me.araopj.cscreen.components;

/**
 * The `TextBox` class represents a box containing text that can be displayed on a screen.
 * It extends the `Box` class and includes methods for setting and clearing text.
 */
public class TextBox extends Box {

    // Properties of the TextBox class
    String text = "";
    Screen sc;
    char[][] screen;

    // ┌,┐,└,┘

    private int height = 3;

    /**
     * Constructs a `TextBox` with the specified position.
     *
     * @param r The row position of the TextBox.
     * @param c The column position of the TextBox.
     */
    public TextBox(int r, int c) {
        super(r, c);
    }

    /**
     * Sets the text content of the TextBox.
     *
     * @param text The text to be set in the TextBox.
     */
    public void setText(String text) {
        this.text = text;
        if (sc != null) {
            clear();
            place(sc);
        }
    }

    /**
     * Sets the height of the TextBox.
     *
     * @param height The height to be set for the TextBox.
     */
    @Override
    public void setHeight(int height) {
        if (height < 4) {
            height = 3;
        }
        this.height = height;
    }

    /**
     * Clears the text content of the TextBox.
     */
    public void clear() {
        int start = c;
        int end;
        if (this.width == 0) {
            end = (c + text.length()) + 2;
        } else {
            if (width < text.length()) {
                text = text.substring(0, width);
            }
            end = (c + width) + 2;
        }
        if (screen != null) {
            for (int i = start + 1; i < end - 1; i++) {
                screen[r + 1][i] = ' ';
            }
        }
    }

    /**
     * Places the TextBox on the specified screen.
     *
     * @param sc The Screen on which the TextBox is to be placed.
     */
    @Override
    public void place(Screen sc) {
        this.sc = sc;
        screen = sc.screen;

        //noinspection DuplicatedCode
        charSets = sc.charSets;

        int start = c;
        int end;
        if (this.width == 0) {
            end = (c + text.length()) + 2;
        } else {
            if (width < text.length()) {
                text = text.substring(0, width);
            }
            end = (c + width) + 2;
        }

        for (int i = r; i < r + height; i++) {
            for (int j = start, k = 0; j < end; j++) {
                if (i == r || i == r + (height - 1)) {
                    screen[i][j] = charSets.horizontal;
                } else {
                    if (j == start || j == end - 1) {
                        screen[i][j] = charSets.vertical;
                    }
                }
                if (i == (r + 1)) {
                    if (j > start && j < end - 1) {
                        if (!this.text.isEmpty()) {
                            if (k >= text.length()) {
                                continue;
                            }
                            screen[i][j] = text.charAt(k++);
                        }
                    }
                }
            }
        }
        // Corners
        //noinspection DuplicatedCode
        screen[r][start] = charSets.corners[0];
        screen[r][end - 1] = charSets.corners[1];
        screen[r + (height - 1)][start] = charSets.corners[2];
        screen[r + (height - 1)][end - 1] = charSets.corners[3];
    }
}
