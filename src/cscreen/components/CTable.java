package cscreen.components;

import cscreen.classes.Position;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;


public class CTable extends CList {

    private final String[] columnHeader;
    Position pos;
    int[] spaces;

    private String[][] list2D;


    private boolean hasSeparator;


    public CTable(String[] columnHeader, String[][] arr) {
        super();

        this.columnHeader = columnHeader;
        this.list2D =arr;

        this.list = new String[arr.length + 1];

    }

    public CTable(String[] columnHeader, String[][] arr, Position pos) {
        super();

        this.columnHeader = columnHeader;
        this.list2D=arr;

        this.pos=pos;
        this.list = new String[arr.length + 1];


    }

    String[][] copy (String[][] arr){
        String[][] newArr = new String[arr.length+1][arr[0].length];

        for(int i = 1; i<newArr.length;i++){
            for (int j = 0;j<newArr[i].length;j++){
                newArr[i][j]=arr[i-1][j];

            }

        }
        newArr[0] = columnHeader;




        return newArr;
    }

    void init(){
        int len = this.list2D.length+2;
        if (columnHeader != null) {
            this.list2D = copy(this.list2D);
            len = this.list2D.length + 3;

        }
        int colSize = combineRow(this.list2D) + 1;
        this.screen = new char[len][colSize];

    }


    public CTable(String[] columnHeader, String[][] arr, Position pos,boolean hasSeparator) {
        super();

        this.columnHeader = columnHeader;

        this.list2D =arr;
        this.hasSeparator =hasSeparator;
        this.pos=pos;
        this.list = new String[arr.length +1 ];


    }

    public void display() {

        generateScreen();
        PrintStream out = new PrintStream(System.out,true, StandardCharsets.UTF_8);

        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[0].length; j++) {
                out.print(screen[i][j]);
            }
            out.println();
        }
    }


    private int combineRow(String[][] arr) {

        char separator = charSets.vertical;
        if(!hasSeparator){
            separator = ' ';
        }
        spaces = getMaxByColumn(arr);

        int max = 0;
        int idx = 0;


        if (columnHeader != null) {
            String header = "";

            for (int i = 0; i < columnHeader.length; i++) {
                int space = spaces[i];

                String fline = alignedString( columnHeader[i],space);
                header = header + fline + separator;

            }
            list[0] = header;


        }


        for (int i = 0; i < arr.length; i++) {
            String line = "";
            max = Math.max(max, getMax(arr[i]));
            for (int j = 0; j < arr[i].length; j++) {
                int space = spaces[j];
                String fline = alignedString(arr[i][j],space);
                line = line + fline +separator;


            }

            list[idx] = line;
            idx++;
        }


        return list[1].length();


    }

    public void hasSeparator(boolean hasSeparator ){
        this.hasSeparator = hasSeparator;
    }


    public void setAlignment(Position pos){
        this.pos = pos;
    }
    void addColumnHeader(String str) {

        for (int i = 0, j = 0; i < str.length(); i++) {
            if (i == 0 || i == str.length() - 1) {
                screen[1][i] = charSets.vertical;
                if (i == 0) {
                    screen[2][i] = charSets.sideConnectors[0];
                } else {
                    screen[2][i] = charSets.sideConnectors[1];
                }

            } else {
                screen[1][i] = str.charAt(j++);
                if (screen[1][i] == charSets.vertical) {
                    screen[2][i] = charSets.sideConnectors[4];
                    screen[0][i] = charSets.sideConnectors[2];
                } else {
                    screen[2][i] = charSets.horizontal;
                }






            }


        }
    }

    private void generateScreen() {
        init();


        int start = 0;
        int end = screen.length - 1;
        int idx = 0;
        if (columnHeader != null) {
            start = 2;
             idx = 1;

        }

        String str = "";
        for (int i = 0; i < screen.length; i++) {
            if (i > start && i < end) {
                str = list[idx];
                idx++;

            }
            for (int j = 0, k = 0; j < screen[0].length; j++) {
                screen[i][j] = ' ';
                if (i == 0 || i == screen.length - 1) {
                    screen[i][j] = charSets.horizontal;
                    if (i == screen.length - 1) {
                        if (screen[screen.length - 2][j] == charSets.vertical) {
                            screen[i][j] = charSets.sideConnectors[3];
                        }
                    }

                } else {

                    if (j > 0) {
                        if (k > str.length() - 1) {
                            continue;
                        }

                        screen[i][j] = str.charAt(k++);

                    }
                    if (j == 0 || j == screen[0].length - 1) {
                        screen[i][j] = charSets.vertical;
                    }

                }
                if (i == 1) {
                    if (screen[i][j] == charSets.vertical) {
                        screen[0][j] =charSets.sideConnectors[2];
                    }
                }

            }
        }
        //corners
        screen[0][0] = charSets.corners[0];
        screen[0][screen[0].length - 1] =  charSets.corners[1];
        screen[screen.length - 1][0] =  charSets.corners[2];
        screen[screen.length - 1][screen[0].length - 1] =  charSets.corners[3];

        if (columnHeader != null) {
            addColumnHeader(list[0] +" ");
        }


    }


    private int[] getMaxByColumn(String[][] arr) {
        int[] arrMax = new int[arr[0].length];

        for (int j = 0; j < arr[0].length; j++) {

            String[] temp = new String[arr.length];

            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i][j];
            }
            arrMax[j] = getMax(temp);
        }
        return arrMax;
    }

    private String start(String str, int len) {
        String format = "%-" + len + "s";
        return String.format(format,str);
    }

    private String end(String str, int len) {
        String format = "%" + len + "s";
        return String.format(format,str);
    }

    private String center(String str, int len) {
        String format = String.format("%" + len + "s%s%" + len + "s", "", str, "");
        float mid = (format.length() / 2f);
        float start = mid - (len / 2f);
        float end = start + len;

        return format.substring((int) start, (int) end);

    }

    String alignedString(String str, int len){
        if(pos == Position.START){
            return start(str,len+2);
        } else if (pos == Position.CENTER) {
            return center(str,len+2);
        } else if (pos == Position.END) {
            return end(str,len+2);
        }

        return start(str,len+2);
    }



}
