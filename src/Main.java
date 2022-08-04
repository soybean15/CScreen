import cscreen.classes.Position;

import cscreen.components.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {


    public static void main(String[] args) {

        List<List<String>> arr = new ArrayList<>();
        arr.add(Arrays.asList("Marilyn Monroe", "21", "March", "1993"));
        arr.add(Arrays.asList("Robert De Niro", "22", "August", "1945"));
        arr.add(Arrays.asList("Malcolm X", "23", "June", "1944"));
        arr.add(Arrays.asList("Mohammad Ali", "24", "March", "1970"));

        String[] header = {"Name", "Id", "Month", "Year"};
        CTable table = new CTable(header, arr);
        table.addRow(new String[]{"Mike Tyson", "25", "April", ""});
        table.display();

        //String[] header2 = {"Name","Id", "Month"};
        CTable table2 = new CTable(null);
        table2.addList(arr);
        table2.useBoxSet();
        table2.hasSeparator(true);

        table2.addRow(new String[]{"Mike Tyson", "25", "April", "1980"});

        System.out.println(table2.getCell(0,0));//print marilyn
        table2.setCell(0,0,"Betty White");// change marilyn to betty
        table2.removeRow(1); // remove Robert De Niro
        table2.setAlignment(Position.CENTER);
        table2.display();

//        String[] list1 = {"Banana", "Apple", "Potato", "Orange"};
//
//        CList cList1 = new CList();
//        cList1.setTitle("Fruitserwerr",Position.CENTER);
//
//        cList1.display();
//        cList1.addItem("Strawberry");
//        cList1.addItem("Dragon Fruit34234");
//
//        cList1.remove(0);
//        cList1.set(0,"Mango");
//        cList1.display();

        //System.out.println(cList1.getItem(0));





    }
}