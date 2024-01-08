package tech.araopj.cscreen.components;

/**
 * The `Box` class represents a rectangular box on a screen.
 * It extends the `Components` class and implements the `Resizable` interface.
 */
public class Box extends Components implements Resizable {

    // Width and height properties of the box
    protected int width;
    protected int height;

    /**
     * Constructs a `Box` with specified parameters.
     *
     * @param r      The row position of the box.
     * @param c      The column position of the box.
     * @param width  The width of the box.
     * @param height The height of the box.
     */
    public Box(int r, int c, int width, int height) {
        super(); // Call the superclass constructor
        this.r = r; // Set the row position
        this.c = c; // Set the column position
        this.width = width; // Set the width
        this.height = height; // Set the height
    }

    /**
     * Constructs a `Box` with specified row and column positions.
     *
     * @param r The row position of the box.
     * @param c The column position of the box.
     */
    public Box(int r, int c) {
        super(); // Call the superclass constructor
        this.r = r; // Set the row position
        this.c = c; // Set the column position
    }

    /**
     * Overrides the `setWidth` method from the `Resizable` interface.
     *
     * @param width The new width of the box.
     */
    @Override
    public void setWidth(int width) {
        this.width = width; // Set the width
    }

    /**
     * Overrides the `setHeight` method from the `Resizable` interface.
     *
     * @param height The new height of the box.
     */
    @Override
    public void setHeight(int height) {
        this.height = height; // Set the height
    }

    /**
     * Places the box on the provided screen.
     *
     * @param sc The `Screen` object on which the box is placed.
     */
    @Override
    public void place(Screen sc) {

        char[][] screen = sc.screen;
        charSets = sc.charSets;
        int start = c;
        int end = (c + width) + 2;

        // Iterate over rows and columns to draw the box on the screen
        for (int i = r; i < r + height; i++) {
            for (int j = start; j < end; j++) {
                if (i == r || i == (r + (height - 1))) {
                    screen[i][j] = charSets.horizontal; // Draw horizontal lines for top and bottom borders
                } else {
                    if (j == start || j == end - 1) {
                        screen[i][j] = charSets.vertical; // Draw vertical lines for left and right borders
                    }
                }
            }
        }

        // Draw corners of the box
        screen[r][start] = charSets.corners[0];
        screen[r][end - 1] = charSets.corners[1];
        screen[r + (height - 1)][start] = charSets.corners[2];
        screen[r + (height - 1)][end - 1] = charSets.corners[3];
    }
}
