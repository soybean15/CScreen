package tech.araopj.cscreen.components;

/**
 * The `Label` class represents a simple label component that displays text on a screen.
 * It extends the `Components` class to inherit basic component functionality.
 */
public class Label extends Components {

    // Property specific to Label
    private String text = "";

    /**
     * Constructs a `Label` with the specified row, column, and text.
     *
     * @param r    The row position of the label on the screen.
     * @param c    The column position of the label on the screen.
     * @param text The text content of the label.
     */
    public Label(int r, int c, String text) {
        super();
        this.r = r;
        this.c = c;
        this.text = text;
    }

    /**
     * Constructs a `Label` with the specified row and column.
     *
     * @param r The row position of the label on the screen.
     * @param c The column position of the label on the screen.
     */
    public Label(int r, int c) {
        super();
        this.r = r;
        this.c = c;
    }

    /**
     * Places the label on the screen by updating the screen array with its text content.
     *
     * @param sc The `Screen` object representing the screen to which the label is being added.
     */
    @Override
    public void place(Screen sc) {
        char[][] screen = sc.screen;
        for (int i = c, j = 0; i < text.length() + c; i++) {
            screen[r][i] = text.charAt(j++);
        }
    }

    /**
     * Sets the text content of the label.
     *
     * @param text The new text content for the label.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Retrieves the current text content of the label.
     *
     * @return The text content of the label.
     */
    public String getText() {
        return this.text;
    }
}
