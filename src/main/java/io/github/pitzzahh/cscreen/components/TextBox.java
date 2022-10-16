package io.github.pitzzahh.cscreen.components;

public class TextBox extends Box{
    String text="";

    Screen sc;

    char[][] screen;

    //┌,┐,└,┘

    private int height = 3;
   // char[] corners ={'┌','┐','└','┘'};
//    public TextBox(int r, int c, int width, int height) {
//        super(r, c, width, height);
//    }

    public TextBox(int r, int c) {
        super(r, c);
    }

    public void setText(String text){

        this.text = text;
        if(sc != null){
            clear();
            place(sc);
        }
    }

    @Override
    public void setHeight(int height){
        if(height<4){
            height=3;
        }
        this.height = height;
    }

    public void clear(){
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

        for (int i =start+1; i<end-1;i++){
            screen[r+1][i]=' ';
        }
    }


    @Override
    public void place(Screen sc){
        this.sc=sc;
        screen = sc.screen;

        charSets =sc.charSets;

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
        for(int i=r; i<r+height; i++ ){

            for(int j=start, k=0; j<end; j++){

                if(i==r || i==r+(height-1)){
                        screen[i][j] = charSets.horizontal;

                }
                else{
                    if(j==start || j ==end-1){
                        screen[i][j]= charSets.vertical;
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

                    }

                }

            }
        }
        //corners
        screen[r][start] = charSets.corners[0];
        screen[r][end-1] = charSets.corners[1];
        screen[r+(height-1)][start]= charSets.corners[2];
        screen[r+(height-1)][end-1] = charSets.corners[3];

    }
}
