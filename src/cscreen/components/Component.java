package cscreen.components;

abstract class Components{

    protected int r;
    protected int c;

    protected char horizontal = '┈';
    protected char vertical = '│';

    char[] corners = {'╭','╮','╰','╯'};


    abstract void place(Screen screen);
}

