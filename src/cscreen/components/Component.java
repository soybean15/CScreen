package cscreen.components;

import cscreen.classes.CharSets;
import cscreen.classes.Symbol;

abstract class Components{

    protected int r;
    protected int c;

    protected CharSets charSets;

    Components() {

    }



//    protected char horizontal = '┈';
//    protected char vertical = '│';
//
//    char[] corners = {'╭','╮','╰','╯'};

//    protected char horizontal = '-';
//    protected char vertical = '|';
//
//    char[] corners = {'+','+','+','+'};


    abstract void place(Screen screen);
}

