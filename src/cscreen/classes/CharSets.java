package cscreen.classes;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class CharSets {


    private static CharSets charSetsInstance =null;
    private CharSets(){}

    public  char horizontal;
    public  char vertical;
    public  char[] corners ;
    public  char[] sideConnectors ;

    private boolean isBox;
    private PrintStream out = new PrintStream(System.out,true, StandardCharsets.UTF_8);

    private  void normalSets(){
        horizontal = '-';
        vertical = '|';
        corners = new char[]{'+', '+', '+', '+'};
        sideConnectors= new char[]{'+', '+', '+', '+', '+'};
    }

    private  void boxSets(){
        horizontal = '┈';
        vertical = '│';
        corners = new char[]{'╭', '╮', '╰', '╯'};
        sideConnectors= new char[]{'├', '┤','┬','┴','┼'};
    }

    public void printChar(char c){
        if(isBox){
           out.print(c);
        }else {

            System.out.print(c);
        }
    }

    public static CharSets getInstance(Symbol symbol){

            if (symbol == Symbol.NORMAL){

                return normalSetInstance();
            } else if (symbol==Symbol.BOXDRAWING) {
                return boxSetInstance();
            }



        return normalSetInstance();
    }


    private static CharSets normalSetInstance(){

        if(charSetsInstance==null){

            charSetsInstance = new CharSets();

        }
        charSetsInstance.isBox =false;
        charSetsInstance.normalSets();

        return charSetsInstance;

    }

    private static CharSets boxSetInstance(){


        if(charSetsInstance==null){

            charSetsInstance = new CharSets();

        }
        charSetsInstance.isBox =true;
        charSetsInstance.boxSets();

        return charSetsInstance;

    }
}
