import cscreen.classes.Position;
import cscreen.components.*;


public class Main{


    public static void main(String[] args){


     Screen screen = new Screen(18,40);

     Box box = new Box(3,5);
     box.setWidth(28);
     box.setHeight(5);

     Label label = new Label(4,6);
     label.setText("      WELCOME TO KFC");
     label.place(screen);

      Label label2 = new Label(6,6);
      label2.setText("    How can I help you?");
      label2.place(screen);

      Button button1 = new Button(8,13,"[V]iew Menu");
      button1.place(screen);

      Button button2 = new Button(11,13,"  [O]rder  ");
      button2.place(screen);

      Button button3 = new Button(14,13,"  [E]xit   ");
      button3.place(screen);


      box.place(screen);

      screen.display();


      String[][] menu = {
              {"f011","Fries","10","70.00"},
              {"b212","Burger","10","30.00"},
              {"sp01","Spagetti","30","60.00"},
              {"fc11","Fried Chicken","10","110.00"},
              {"s930","Sundae","10","30.00"},
      };

      String[] header = {"Id","Product","QTY","Price"};

      CTable table = new CTable(header, menu);

      table.display();

    }
}