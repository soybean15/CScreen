import cscreen.classes.Position;
import cscreen.components.*;


public class Main{


    public static void main(String[] args){


      String[][] arr = {{"Marilyn Monroe", "21", "March", "1993"},
              {"Robert De Niro", "22", "August", "1945"},
              {"Malcolm X", "23", "June", "1944"},
              {"Mohammad Ali", "24", "March", "1970"}
      };


      CTable table = new CTable(null,arr,Position.START);
      table.display();


      String[] header = {"Name", "Id", "Month", "Year"};

      CTable table2 = new CTable(header,arr,Position.START);
      table2.hasSeparator(true);
      table2.setAlignment(Position.CENTER);
      table2.display();




    }
}