package cscreen.components;

public class TextBox extends Box{
    String text="";
    public TextBox(int r, int c, int width, int height) {
        super(r, c, width, height);
    }

    public TextBox(int r, int c) {
        super(r, c);
    }


    public void setText(String text){
        this.text = text;
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
        for(int i=r; i<r+3; i++ ){

            for(int j=start, k=0; j<end; j++){

                if(i==r || i==(r+2)){
                        screen[i][j] = '-';

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
}
