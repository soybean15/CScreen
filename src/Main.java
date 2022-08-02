import cscreen.classes.Position;
import cscreen.components.*;


public class Main{


    public static void main(String[] args){

        Screen screen = new Screen(20,40, true);
        screen.displayScreen();

        Button button = new Button(4,2,"Button");
        button.place(screen);

        Box box  = new Box(7,2,20,5);
        box.place(screen);

        TextBox textBox = new TextBox(12,2,20,5);
        textBox.place(screen);


        screen.displayScreen();

    }
}