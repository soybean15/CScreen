import cscreen.classes.Position;
import cscreen.components.*;


public class Main{


    public static void main(String[] args){

      String[] arr ={"123456789","21","1321","13123123"};

      System.out.println("With width and title");
      CList list = new CList(arr,30);
      list.addCounter();
      list.setTitle("Sample title",Position.CENTER);
      list.display();

      String[] arr2 ={"Hello there","Come with me if you want to live","Meow","Are you lookin at me?","You shall not passA"};
      System.out.println("No width and title");
      CList list2 = new CList(arr2,0);
      list2.display();



    }
}