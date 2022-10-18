package io.github.pitzzahh.cscreen.components;

public class Label extends Components{
    private String text="";

    public Label(int r, int c, String text){
        super();
        this.r = r;
        this.c=c;
        this.text = text;
    }

    public Label(int r, int c){
        super();
        this.r = r;
        this.c=c;
        this.text = text;
    }

    @Override
    public void place(Screen sc){
        char[][] screen = sc.screen;
        for(int i = c, j=0; i<text.length()+c; i++ ){
            screen[r][i]= text.charAt(j++);
        }
    }

    public void setText(String text){
        this.text = text;
    }

    String getText(){
        return this.text;
    }

}

