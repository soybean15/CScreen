package cscreen.components;

public class Box extends Components implements Resizable{

    int width;
    private int height;
    public Box(int r, int c, int width, int height){
        this.r = r;
        this.c=c;
        this.width = width;
        this.height = height;
    }

    public Box(int r, int c){
        this.r = r;
        this.c=c;
    }

    @Override
    public void setWidth(int width){
        this.width = width;
    }

    @Override
    public void  setHeight(int height){
        this.height = height;
    }

    @Override
    public void place(Screen sc){
        char[][] screen = sc.screen;

        int start = c;
        int end = (c+width)+2;

        for(int i=r; i<r+height; i++ ){

            for(int j=start, k=0; j<end; j++){

                if(i==r || i==(r+(height-1))){

                    if(j==start || j ==end-1){
                        screen[i][j] = '+';
                    }else{
                        screen[i][j] = '-';
                    }
                }else{
                    if(j==start || j ==end-1){
                        screen[i][j] = '|';
                    }
                }
            }
        }

    }

}
