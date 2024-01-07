package tech.araopj.cscreen.components;

public class Button extends Components implements Resizable {

    private String text = "";
    private int width;
    private int height;

    public Button(int r, int c, String text) {
        super();
        this.r = r;
        this.c = c;
        this.text = text;
    }

    public Button(int r, int c) {
        super();
        this.r = r;
        this.c = c;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

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
                    screen[i][j] = charSets.horizontal;
                }
                if (i == (r + 1)) {
                    if (j > start && j < end - 1) {
                        if (this.text.length() > 0) {
                            if (k >= text.length()) {
                                continue;
                            }
                            screen[i][j] = text.charAt(k++);
                        }
                    } else {
                        screen[i][j] = charSets.vertical;
                    }
                }
            }
        }
        //corners
        screen[r][start] = charSets.corners[0];
        screen[r][end - 1] = charSets.corners[1];
        screen[r + 2][start] = charSets.corners[2];
        screen[r + 2][end - 1] = charSets.corners[3];
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

}


