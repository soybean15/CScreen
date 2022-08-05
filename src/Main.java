import cscreen.classes.Position;

import cscreen.classes.Symbol;
import cscreen.components.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//
//        Screen screen = new Screen(20, 40, true);//20 rows, 40column, hasBorder
//        screen.useBoxSet();//use box-window char
//        screen.setTitle("Student Info");
//
//        Label label1 = new Label(4,3);
//        label1.setText("FirstName:");
//        label1.place(screen);
//
//        TextBox txtFirstName = new TextBox(3,13);
//        txtFirstName.setWidth(23);
//        txtFirstName.place(screen);
//
//        Label label2 = new Label(7,3);
//        label2.setText("LastName:");
//        label2.place(screen);
//
//        TextBox txtLastName = new TextBox(6,13);
//        txtLastName.setWidth(23);
//        txtLastName.place(screen);
//
//        Label label3 = new Label(10,3);
//        label3.setText("DOB:");
//        label3.place(screen);
//
//        TextBox txtDOB = new TextBox(9,13);
//        txtDOB.setWidth(23);
//        txtDOB.place(screen);
//
//        Label label4 = new Label(13,3);
//        label4.setText("Age:");
//        label4.place(screen);
//
//        TextBox txtAge = new TextBox(12,13);
//        txtAge.setWidth(23);
//        txtAge.place(screen);
//
//        Label label5 = new Label(16,3);
//        label5.setText("Course:");
//        label5.place(screen);
//
//        TextBox txtCourse = new TextBox(15,13);
//        txtCourse.setWidth(23);
//        txtCourse.place(screen);
//
//screen.display();
//
//        CTable table = new CTable(new String[]{"Full Name","DOB","Age","Course"});
//        table.useBoxSet();
//
//
//        while (true){
//            //clear textbox
//            txtFirstName.clear();
//            txtLastName.clear();
//            txtAge.clear();
//            txtDOB.clear();
//            txtCourse.clear();
//
//
//            System.out.println("FirstName:");
//            String firstname = sc.nextLine();
//            txtFirstName.setText(firstname);
//            screen.display();
//
//            System.out.println("LastName:");
//            String lastname = sc.nextLine();
//            txtLastName.setText(lastname);
//            screen.display();
//
//            System.out.println("DOB:");
//            String dob = sc.nextLine();
//            txtDOB.setText(dob);
//            screen.display();
//
//            System.out.println("LastName:");
//            String age = sc.nextLine();
//            txtAge.setText(age);
//            screen.display();
//
//            System.out.println("LastName:");
//            String course = sc.nextLine();
//            txtCourse.setText(course);
//            screen.display();
//
//            table.addRow(new String[]{firstname+" "+lastname,dob,age,course});
//            table.display();
//
//
//
//        }


        String[][] menu = {
                {"f011", "Fries", "10", "70.00"},
                {"b212", "Burger", "10", "30.00"},
                {"sp01", "Spagetti", "30", "60.00"},
                {"fc11", "Fried Chicken", "10", "110.00"},
                {"s930", "Sundae", "10", "30.00"},
                {"s930", "Sundae", "10", "30.00"},
        };
        System.out.println("View Menu:");

//        String[] header = {"Id", "Product Name", "Quantity", "Price"};
//
//        CTable table = new CTable(header);
//        table.useBoxSet();
//        table.setAlignment(Position.CENTER);
//        table.hasSeparator(true);
//        table.addRow(new String[]{"f011", "Fries", "10", "70.00"});
//        table.addRow(new String[]{"b212", "Burger", "10", "30.00"});
//        table.addRow(new String[]{"fc11", "Fried Chicken", "10", "110.00"});
//        table.addRow(new String[]{"f011", "Fries", "10", "70.00"});
//        table.addRow(new String[]{"s930", "Sundae", "10", "30.00"});
//
//        table.display();
//
//
//        List<String> productName =table.getColumn(1);
//        System.out.println(productName);
//        List<String> friedChicken =table.getRow(2);
//        System.out.println(friedChicken);
//
//        //uupdate or pass a new 2d array

        CList list = new CList();
        list.useBoxSet();
        list.setWidth(20);
        list.setTitle("Fruits",Position.CENTER);

        list.addItem("Apple");
        list.addItem("Banana");
        list.addItem("Mango");
        list.addItem("Banana");

        list.display();


    }
}