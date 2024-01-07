package io.github.pitzzahh.cscreen.components;

public class Box extends Components implements Resizable {

    protected int width;
    protected int height;

    public Box(int r, int c, int width, int height) {
        super();
        this.r = r;
        this.c = c;
        this.width = width;
        this.height = height;
    }

    public Box(int r, int c) {

        super();

        this.r = r;
        this.c = c;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void place(Screen sc) {

        char[][] screen = sc.screen;
        charSets = sc.charSets;
        int start = c;
        int end = (c + width) + 2;

        for (int i = r; i < r + height; i++) {
            for (int j = start; j < end; j++) {
                if (i == r || i == (r + (height - 1))) {
                    screen[i][j] = charSets.horizontal;
                } else {
                    if (j == start || j == end - 1) {
                        screen[i][j] = charSets.vertical;
                    }
                }
            }
        }
        //corners
        screen[r][start] = charSets.corners[0];
        screen[r][end - 1] = charSets.corners[1];
        screen[r + (height - 1)][start] = charSets.corners[2];
        screen[r + (height - 1)][end - 1] = charSets.corners[3];
    }
}
