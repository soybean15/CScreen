import cscreen.classes.Position;
import cscreen.components.*;


public class Main{


    public static void main(String[] args){

        Screen screen = new Screen();
        screen.setDimension(20,40);
        screen.setTitle("Sample");
        screen.setTitlePosition(Position.END);
        TextBox textBox = new TextBox(2,1);

        textBox.setText("Hello");
        textBox.setHeight(4);
        textBox.setWidth(5);

        Button button = new Button(5,1);
        button.setWidth(2);
        button.place(screen);

        textBox.place(screen);

        screen.displayScreen();

    }
}