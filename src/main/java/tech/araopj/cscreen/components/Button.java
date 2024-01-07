package tech.araopj.cscreen.components;

/**
 * The `Button` class represents a button component on a screen.
 * It extends the `Components` class and implements the `Resizable` interface.
 */
public class Button extends Components implements Resizable {

    // Properties specific to the Button class
    private String text = ""; // Text displayed on the button
    private int width; // Width of the button
    private int height; // Height of the button (not used in the current implementation)

    /**
     * Constructs a `Button` with specified row, column, and text.
     *
     * @param r    The row position of the button.
     * @param c    The column position of the button.
     * @param text The text to be displayed on the button.
     */
    public Button(int r, int c, String text) {
        super(); // Call the superclass constructor
        this.r = r; // Set the row position
        this.c = c; // Set the column position
        this.text = text; // Set the text
    }

    /**
     * Constructs a `Button` with specified row and column positions.
     *
     * @param r The row position of the button.
     * @param c The column position of the button.
     */
    public Button(int r, int c) {
        super(); // Call the superclass constructor
        this.r = r; // Set the row position
        this.c = c; // Set the column position
    }

    /**
     * Sets the text to be displayed on the button.
     *
     * @param text The new text to be set.
     */
    public void setText(String text) {
        this.text = text; // Set the text
    }

    /**
     * Gets the text currently displayed on the button.
     *
     * @return The text displayed on the button.
     */
    public String getText() {
        return this.text; // Get the text
    }

    /**
     * Overrides the `place` method from the `Components` class.
     * Places the button on the provided screen.
     *
     * @param sc The `Screen` object on which the button is placed.
     */
    @Override
    public void place(Screen sc) {
        char[][] screen = sc.screen;
        charSets = sc.charSets;

        int start = c;
        int end = 0;
        if (this.width == 0) {
            end = (c + text.length()) + 2;
        } else {
            if (width < text.length()) {
                text = text.substring(0, width);
            }
            end = (c + width) + 2;
        }

        for (int i = r; i < r + 3; i++) {
            for (int j = start, k = 0; j < end; j++) {
                if (i == r || i == (r + 2)) {
                    screen[i][j] = charSets.horizontal; // Draw horizontal lines for top and bottom borders
                }
                if (i == (r + 1)) {
                    if (j > start && j < end - 1) {
                        if (this.text.length() > 0) {
                            if (k >= text.length()) {
                                continue;
                            }
                            screen[i][j] = text.charAt(k++); // Draw the text on the button
                        }
                    } else {
                        screen[i][j] = charSets.vertical; // Draw vertical lines for left and right borders
                    }
                }
            }
        }

        // Draw corners of the button
        screen[r][start] = charSets.corners[0];
        screen[r][end - 1] = charSets.corners[1];
        screen[r + 2][start] = charSets.corners[2];
        screen[r + 2][end - 1] = charSets.corners[3];
    }

    /**
     * Overrides the `setWidth` method from the `Resizable` interface.
     * Sets the width of the button.
     *
     * @param width The new width of the button.
     */
    @Override
    public void setWidth(int width) {
        this.width = width; // Set the width
    }

    /**
     * Overrides the `setHeight` method from the `Resizable` interface.
     * Sets the height of the button (not used in the current implementation).
     *
     * @param height The new height of the button.
     */
    @Override
    public void setHeight(int height) {
        this.height = height; // Set the height
    }

}
