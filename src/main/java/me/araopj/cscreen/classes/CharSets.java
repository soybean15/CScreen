package me.araopj.cscreen.classes;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class CharSets {


    private static CharSets charSetsInstance = null;

    private CharSets() {
    }

    public char horizontal;
    public char vertical;
    public char[] corners;
    public char[] sideConnectors;

    private boolean isBox;

    private boolean isCalled;
    private final PrintStream out;

    {
        try {
            out = new PrintStream(System.out, true, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private void normalSets() {
        horizontal = '-';
        vertical = '|';
        corners = new char[]{'+', '+', '+', '+'};
        sideConnectors = new char[]{'+', '+', '+', '+', '+'};
    }

    private void boxSets() {
        horizontal = '┈';
        vertical = '│';
        corners = new char[]{'╭', '╮', '╰', '╯'};
        sideConnectors = new char[]{'├', '┤', '┬', '┴', '┼'};
    }

    public void printChar(char c) {
        if (isBox) {
            out.print(c);
        } else {

            System.out.print(c);
        }
    }

    public static CharSets getInstance(Symbol symbol) {

        if (symbol == Symbol.NORMAL) {

            return normalSetInstance();
        } else if (symbol == Symbol.BOX_DRAWING) {

            return boxSetInstance();
        }


        return normalSetInstance();
    }


    private static CharSets normalSetInstance() {

        if (charSetsInstance == null) {

            charSetsInstance = new CharSets();


        }
        if (!charSetsInstance.isCalled) {
            charSetsInstance.isBox = false;
            charSetsInstance.normalSets();

        }


        return charSetsInstance;

    }

    private static CharSets boxSetInstance() {


        if (charSetsInstance == null) {

            charSetsInstance = new CharSets();


        }
        charSetsInstance.isCalled = true;
        charSetsInstance.isBox = true;
        charSetsInstance.boxSets();

        return charSetsInstance;

    }
}
