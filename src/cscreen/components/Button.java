package cscreen.components;

public class Button extends Components implements Resizable{

    private String text="";
    private int width;
    private int height;

    public Button(int r, int c, String text){
        this.r = r;
        this.c=c;
        this.text = text;
    }
    public Button(int r, int c){
        this.r = r;
        this.c=c;

    }

    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }

    @Override
    public void place(Screen sc){
        char[][] screen = sc.screen;

        int start = c;
        int end = 0;
        if(this.width ==0){
            end = (c+text.length())+2;
        }else {
            if(width<text.length()){
                text = text.substring(0, width);

            }
            end = (c+width)+2;
        }

        //int end = (c+text.length())+2;


        for(int i=r; i<r+3; i++ ){

            for(int j=start, k=0; j<end; j++){

                if(i==r || i==(r+2)){

                    if(j==start || j ==end-1){
                        screen[i][j] = '+';
                    }else{
                        screen[i][j] = '-';
                    }
                }
                if(i==(r+1)){

                    if(j>start && j<end-1){
                        if(this.text.length()>0){
                            if(k >=text.length()){
                                continue;
                            }

                            screen[i][j] = text.charAt(k++);

                        }

                    }else{
                        screen[i][j]= '|';
                    }

                }
            }
        }

    }


    @Override
    public void setWidth(int width) {
        this.width=width;
    }

    @Override
    public void setHeight(int height) {
        this.height=height;
    }


}


