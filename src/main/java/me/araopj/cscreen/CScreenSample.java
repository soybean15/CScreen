package me.araopj.cscreen;

import me.araopj.cscreen.components.CTable;
import me.araopj.cscreen.components.Label;
import me.araopj.cscreen.components.Screen;
import me.araopj.cscreen.components.TextBox;
import java.util.Scanner;

public class CScreenSample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Screen screen = new Screen(20, 40, true);//20 rows, 40column, hasBorder
        screen.useBoxSet(); //use box-window char
        screen.setTitle("Student Info");

        Label label1 = new Label(4, 3);
        label1.setText("FirstName: ");
        label1.place(screen);

        TextBox txtFirstName = new TextBox(3, 13);
        txtFirstName.setWidth(23);
        txtFirstName.place(screen);

        Label label2 = new Label(7, 3);
        label2.setText("LastName: ");
        label2.place(screen);

        TextBox txtLastName = new TextBox(6, 13);
        txtLastName.setWidth(23);
        txtLastName.place(screen);

        Label label3 = new Label(10, 3);
        label3.setText("DOB: ");
        label3.place(screen);

        TextBox txtDOB = new TextBox(9, 13);
        txtDOB.setWidth(23);
        txtDOB.place(screen);

        Label label4 = new Label(13, 3);
        label4.setText("Age: ");
        label4.place(screen);

        TextBox txtAge = new TextBox(12, 13);
        txtAge.setWidth(23);
        txtAge.place(screen);

        Label label5 = new Label(16, 3);
        label5.setText("Course: ");
        label5.place(screen);

        TextBox txtProgram = new TextBox(15, 13);
        txtProgram.setWidth(23);
        txtProgram.place(screen);

        screen.display();

        CTable table = new CTable("Full Name", "DOB", "Age", "Program");

        //noinspection InfiniteLoopStatement
        while (true) {
            //clear textbox
            txtFirstName.clear();
            txtLastName.clear();
            txtAge.clear();
            txtDOB.clear();
            txtProgram.clear();

            System.out.print("FirstName: ");
            String firstname = sc.nextLine();
            txtFirstName.setText(firstname);
            screen.display();

            System.out.print("LastName: ");
            String lastname = sc.nextLine();
            txtLastName.setText(lastname);
            screen.display();

            System.out.print("DOB: ");
            String dob = sc.nextLine();
            txtDOB.setText(dob);
            screen.display();

            System.out.print("Age: ");
            String age = sc.nextLine();
            txtAge.setText(age);
            screen.display();

            System.out.print("Program: ");
            String program = sc.nextLine();
            txtProgram.setText(program);
            screen.display();

            table.addRow(String.format("%s %s", firstname, lastname), dob, age, program);
            table.display();
        }
    }
}