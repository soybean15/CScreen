package cscreen.components;

import cscreen.classes.Position;

public class CList {
    protected char[][] screen;

    protected String[] list;

    private String title="";
    Position pos;
  ///  protected char horizontal = '┈';
//    protected char vertical = '│';
//
//    protected int width;
//
//
//    char[] corners = {'╭','╮','╰','╯'};


    protected char horizontal = '-';
    protected char vertical = '|';

    protected int width;


    char[] corners = {'+','+','+','+'};


    public CList(String[] arr, int width) {
        list = arr;

       this.width=width;


    }

    protected CList() {

    }

    private void generateScreen(){


        int start =0;
        if(width>getMax(this.list)){
            width=width+2;
        }else {
            width= getMax(this.list)+2;
        }



        int r = this.list.length+2;
        if(title.length()>0){

            r+=2;
            start =2;

        }
        this.screen = new char[r][width];


        int idx = 0;

        String str="";
        for (int i = 0; i <screen.length;i++){
            if( i>start && i<screen.length-1){
                str = list[idx];
                idx++;

            }
            for (int j=0, k=0; j<width; j++){
                screen[i][j]=' ';
                if(i==0 || i==screen.length-1){
                    screen[i][j]= this.horizontal;
                }else{
                    if(j==0 || j==width-1){
                        screen[i][j]= this.vertical;
                    }

                    if( j>0){
                        if(k>str.length()-1){
                            continue;
                        }
                        screen[i][j]= str.charAt(k++);

                    }
                }
            }
        }
        //corners
        screen[0][0] ='+';
        screen[0][screen[0].length-1] = '+';
        screen[screen.length-1][0]='+';
        screen[screen.length-1][screen[0].length-1] = '+';
        if(title.length()>0) addTitle();
    }

    public void setTitle(String title,Position pos){
        this.title=title;
        this.pos =pos;

    }

    private void addTitle(){
        int start = 0;
        int end =0;
        if(this.title.length()>0){
            if(width-4 < this.title.length()){
                this.title = this.title.substring(0,  screen[0].length-2);
            }

            if (pos == Position.START) {

                start = 1;
                end =this.title.length()+1;

            }else if(pos == Position.CENTER) {
                start = Math.abs(((screen[0].length - this.title.length()) / 2)- 2)+1;

                if(this.title.length()>screen[0].length){
                    start = Math.abs(((screen[0].length - this.title.length()) / 2)- 2);
                }



                end = start+this.title.length();


            }else if(pos == Position.END){
                start = (screen[0].length-this.title.length())-1;
                end = start+this.title.length();
            }

            for(int i=start, j=0; i<end;i++){
                screen[1][i]=this.title.charAt(j++);

            }
            //├┤
            for(int i=1; i<width-1;i++){
                screen[2][i]=this.horizontal;
            }
            screen[2][0]='+';
            screen[2][width-1]='+';


        }
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

    protected int getMax(String[] arr){
        int max = arr[0].length();

        for (String str:arr){
            int len = str.length();
            if(max<len){
                max=len;
            }
        }
        return max;
    }

    public void addCounter(){
        int count = 1;
        for (int i =0 ; i<list.length;i++){
            this.list[i] = String.valueOf(count)+"."+this.list[i];
            count++;
        }
    }
}
