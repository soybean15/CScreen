import cscreen.classes.Position;
import cscreen.components.*;


public class Main{


    public static void main(String[] args){

        Screen screen = new Screen();
        screen.setDimension(20,40);
        screen.setTitle("Sample");
        screen.setTitlePosition(Position.END);

        TextBox textBox1 = new TextBox(2,10);
        textBox1.setText("Sample text1");
        textBox1.setHeight(4);
        textBox1.setWidth(25);

        Label label1 = new Label(3,3);
        label1.setText("Fname:");
        label1.place(screen);

        TextBox textBox2 = new TextBox(5,10);
        textBox2.setText("Sample Text2");
        textBox2.setHeight(4);
        textBox2.setWidth(25);

        Label label2 = new Label(6,3);
        label2.setText("Lname:");
        label2.place(screen);

        Button button1 = new Button(8,10);
        button1.setText("  [S]ave");
        button1.setWidth(10);
        button1.place(screen);

        Button button2 = new Button(8,25);
        button2.setText("[C]ancel");
        button2.setWidth(10);
        button2.place(screen);

        textBox1.place(screen);
        textBox2.place(screen);


        screen.displayScreen();

    }
}