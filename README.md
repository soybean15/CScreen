# CScreen

Sample code:


        //create Screen
        Screen screen = new Screen();
        screen.setDimension(20,40);
        screen.setTitle("Sample");
        screen.setTitlePosition(Position.END);//positions, START, CENTER, END
  
        //textbox sample param(row, column)
        TextBox textBox1 = new TextBox(2,10);
        textBox1.setText("Sample text1");
        textBox1.setHeight(4);
        textBox1.setWidth(25);
        
        //label sample param(row, column)
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
     
        //sample button param(row, column)
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

        Box box = new Box(12,2,33,7);
        box.place(screen);

        Label label = new Label(13,3);
        label.setText("Sample Label inside Box");
        label.place(screen);

        //display screen
        screen.displayScreen();
        
        
Sample output:
![output](https://user-images.githubusercontent.com/75112014/182064357-d0202675-63c0-48dd-92af-0ecd838ab6c9.png)

        
