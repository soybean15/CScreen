package cscreen.components;

import cscreen.classes.Position;

import java.util.Arrays;

public class CTable {
    char[][] screen;

    private String[] list;
    private String[] columnHeader;
    private String title="Sample title";
    Position pos;
    int[] spaces;

    protected char horizontal = '┈';
    protected char vertical = '│';

    protected int width;

    char[] corners = {'╭','╮','╰','╯'};

    public CTable(String[] columnHeader, String[][] arr){

        this.columnHeader =columnHeader;
        int len = arr.length;
        if(columnHeader!=null){
            len = arr.length+3;
        }
        this.list = new String[arr.length+1];

        int colSize = combineRow(arr);
        this.screen = new char[len+2][colSize];

    }

    public void display(){

        generateScreen();

        for (int i = 0; i <screen.length;i++){
            for (int j=0; j<screen[0].length; j++) {
                System.out.print(screen[i][j]);
            }
            System.out.println();
        }
    }


   // void gene
    void printArr(){
        for (String str:list){
         //   if(str!=null){
                System.out.println(str);
           // }

        }
    }

    private int combineRow(String[][] arr){
         spaces = getMaxByColumn(arr);

        int max =0;
        int idx=1;


        if(columnHeader!=null){
            String header ="";

            for (int i =0; i<columnHeader.length;i++){
                String format = "%-"+spaces[i]+"s";
                String fline = String.format(format,columnHeader[i]);
                header = header+fline+" "+this.vertical;

            }
            list[0] = header;


        }



        for (int i =0; i<arr.length;i++){
            String line ="";
            max = Math.max(max,getMax(arr[i]));
            for (int j=0; j<arr[i].length;j++){
                int space = spaces[j];
                  String format = "%-"+space+"s";
                  String fline = String.format(format,arr[i][j]);
                  line = line+fline+" "+this.vertical;


            }

            list[idx]= line;
            idx++;
        }

        return list[1].length();




    }

    void addColumnHeader(String str){

       for (int i = 0,j=0; i<str.length(); i++){
           if(i==0 || i==str.length()-1){
               screen[1][i] =this.vertical;
               if(i==0){
                   screen[2][i] ='├';
               }else {
                   screen[2][i]='┤';
               }

           }else {
               screen[1][i] = str.charAt(j++);
               if(screen[1][i] == this.vertical){
                   screen[2][i]='┼';
                   screen[0][i]='┬';
               }else {
                   screen[2][i]= this.horizontal;
               }

           }



       }
    }

    private void generateScreen(){

        int start =0;
        int end = end= screen.length-1;
        int idx = 1;
        if(columnHeader!=null){
            start = 2;
            end= screen.length-2;

        }

        String str="";
        for (int i = 0; i <screen.length;i++){
            if( i>start && i<end){
                str = list[idx];
                idx++;

            }
            for (int j=0, k=0; j<screen[0].length; j++){
                screen[i][j]=' ';
                if(i==0 || i==screen.length-1){
                    screen[i][j]= this.horizontal;
                    if(i==screen.length-1){
                        if(screen[screen.length-2][j]==this.vertical){
                            screen[i][j] ='┴';
                        }
                    }

                }else{

                    if( j>0){
                        if(k>str.length()-1){
                            continue;
                        }
                        screen[i][j]= str.charAt(k++);

                    }
                    if(j==0 || j==screen[0].length-1){
                        screen[i][j]= this.vertical;
                    }

                }
                if(i==1){
                    if(screen[i][j]==this.vertical){
                        screen[0][j]='┬';
                    }
                }

            }
        }
        //corners
        screen[0][0] ='╭';
        screen[0][screen[0].length-1] = '╮';
        screen[screen.length-1][0]='╰';
        screen[screen.length-1][screen[0].length-1] = '╯';

        if(columnHeader!=null){
            addColumnHeader(list[0]);
        }


    }






    private int getMax(String[] arr){
        int max = arr[0].length();

        for (String str:arr){
            int len = str.length();
            if(max<len){
                max=len;
            }
        }
        return max;
    }

    private int[] getMaxByColumn(String[][] arr) {
        int[] arrMax = new int[arr[0].length];

        for(int j=0; j<arr[0].length;j++){

            String[] temp = new String[arr.length];

            for (int i = 0; i<arr.length;i++){
                 temp[i]=arr[i][j];
            }
            arrMax[j]=getMax(temp);
        }
        return arrMax;
    }

}
