package cscreen.components;

import cscreen.classes.Position;

public class Screen {
    //char[][] screen = new char[20][40];
    char[][] screen;
    private boolean hasBorder;

    private String title="";

    public Screen() {
    }

    public Screen(int r, int c) {
        generateScreen(r, c);
    }

    public Screen(int r, int c, boolean hasBorder) {
        this.hasBorder = hasBorder;
        generateScreen(r, c);
    }

    public void setDimension(int r, int c){
        generateScreen(r, c);
    }



    public  void setTitle(String title){
        clearTitle();
        addTitle(title, Position.START);
    }
    public void setTitlePosition(Position pos){
        clearTitle();
        addTitle(this.title, pos);
    }
    public void addTitle(String title, Position pos){
        clearTitle();
        this.title = title;
        int start = 0;
        int end = 0;

        if(screen[0].length-4 < this.title.length()){
            this.title = this.title.substring(0,  screen[0].length-2);
        }

        if (pos == Position.START) {

            start = 1;
            end =this.title.length()+1;

        }else if(pos == Position.CENTER) {

            start = Math.abs(((screen[0].length - this.title.length()) / 2)- 2);

            System.out.println(this.title);
            end = start+this.title.length();


        }else if(pos == Position.END){
            start = (screen[0].length-this.title.length())-1;
            end = start+this.title.length();
        }



        for (int i = start, j=0; i<end;i++){

            screen[1][i]=this.title.charAt(j++);
        }

    }

    private void clearTitle(){
        for(int i =1; i<screen[0].length-1; i++){
            screen[1][i]=' ';
        }
    }

    public void generateScreen(int r, int c) {
        if(r<4){
            r=3;
        }
        if(c<5){
            c=4;
        }
        this.screen = new char[r][c];

        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[i].length; j++) {
                screen[i][j] = ' ';

                //outer border
                if (i == 0 || i == screen.length - 1) {

                        //screen[i][j] = '┄';
                    screen[i][j] = '-';


                } else {
                    if (j == 0 || j == screen[i].length - 1) {
                        //screen[i][j] = '│';
                        screen[i][j] = '|';
                    }
                }

                //inner border

                if (hasBorder) {
                    if (i == 2 || i == screen.length - 2) {
                        if (j > 0 && j < screen[i].length - 1) {
                               // screen[i][j] = '┄';
                            screen[i][j] = '-';

                        }


                    } else {
                        if (i > 1 && i < screen.length - 1) {
                            if (j == 1 || j == screen[i].length - 2) {
                                //screen[i][j] = '┊';
                                screen[i][j] = '|';
                            }
                        }

                    }

                }


            }
        }

//        //corners
//        screen[0][0] ='╭';
//        screen[0][screen[0].length-1] = '╮';
//        screen[screen.length-1][0]='╰';
//        screen[screen.length-1][screen[0].length-1] = '╯';
//
//        if(hasBorder){
//            //corners
//            screen[2][1] ='╭';
//            screen[2][screen[0].length-2] = '╮';
//            screen[screen.length-2][1]='╰';
//            screen[screen.length-2][screen[0].length-2] = '╯';
//        }

        screen[0][0] ='+';
        screen[0][screen[0].length-1] = '+';
        screen[screen.length-1][0]='+';
        screen[screen.length-1][screen[0].length-1] = '+';

        if(hasBorder){
            //corners
            screen[2][1] ='+';
            screen[2][screen[0].length-2] = '+';
            screen[screen.length-2][1]='+';
            screen[screen.length-2][screen[0].length-2] = '+';
        }


    }

    void clearScreen(){
        for(int i=2; i<screen.length-1; i++){
            for(int j=2; j<screen[i].length-1; j++){
                screen[i][j]=' ';
            }
        }
    }

    public void display(){
        for (char[] chars : screen) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

}



