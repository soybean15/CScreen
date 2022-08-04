**C-screen** is a text-base UI on java console, you can now easily design your console program using c-screen with the help of several components.

_download here:_ https://github.com/soybean15/CScreen/tree/master/CScreen_jar

_Update as of August 4 2022, 1:20pm
_Since there are some conflict using _Box-window_ on some OS I added a method where you can choose between normal character and box-window character

**Normal Characters:**
```java
    //normal character
    Screen screen = new Screen(20,40,true);
    //screen.useBoxSet();
    screen.addTitle("Sample Screen",Position.START);
    screen.display();
    
    /*
    sample output
    +--------------------------------------+
    |Sample Screen                         |
    |+------------------------------------+|
    */
```
**Box-Window Characters:**
```java
    //box-window character
    Screen screen = new Screen(20,40,true);
    screen.useBoxSet();
    screen.addTitle("Sample Screen",Position.START);
    screen.display();
    
    /*
    sample output
    ╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮
    │Sample Screen                         │
    │╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮│

    */
```

**C-Screen features:

**1. Screen**: a framelike interface where you can put multiple components.
        
**Sample code:**

```java
        
        
        Screen screen = new Screen(20,40,true);
        screen.addTitle("Sample Screen",Position.START);
        screen.display();
        
        
        /*the 3 parameters on the constructor are the following:
        -width - width of screen
        -height - height of screen
        -hasBorder - add inner border if true
        */
```
                
**Sample output:**
        
![image](https://user-images.githubusercontent.com/75112014/182511031-ec59293c-8cd0-4297-8e9a-47abb9dfba84.png)




**2. Box:** a rectangular component you can Put inside the Screen.

**Sample code:**


```java
      Screen screen = new Screen(20,40,true);
      screen.addTitle("Sample Screen",Position.START);     

      Box box = new Box(3,3);
      box.setHeight(5);
      box.setWidth(30);
      
      //place component inside the screen
      box.place(screen);
      
      //display screen
      screen.display();
      
```
      
**Sample output:**

![image](https://user-images.githubusercontent.com/75112014/182512062-a3f041f9-9071-47e0-a934-bdf03e145f27.png)


**3.TextBox:** A box component with String inside

**Sample code:**

```java
        
      Screen screen = new Screen(20,40,true);
      screen.addTitle("Sample Screen",Position.START);


      TextBox textBox = new TextBox(3,3);
      textBox.setText("Sample text");
      textBox.setHeight(5);
      textBox.setWidth(30);

      //place component inside the screen
      textBox.place(screen);

      //display screen
      screen.display();
      
```


**Sample output:**
  
  
![image](https://user-images.githubusercontent.com/75112014/182512666-f2a78982-07ca-43b7-baee-4b997efb1afc.png)

      
      
      
      
**4. Label** : String you can put inside the screen.

**Sample code:**

```java

      Screen screen = new Screen(20,40,true);
      screen.addTitle("Sample Screen",Position.START);


      Label label = new Label(3,3);
      label.setText("Sample Label");

      //place component inside the screen
      label.place(screen);

      //display screen
      screen.display();
      
 ```
  
  
**Sample output:**


![image](https://user-images.githubusercontent.com/75112014/182512590-daee429e-7923-496c-9374-8b92a2e0f0e4.png)






**5. Button:** Buttonlike component which is good to have if you have multiple option in your code.

**Sample code:**


```java
      Screen screen = new Screen(20,40,true);
      screen.addTitle("Sample Screen",Position.START);


      Button button1 = new Button(3,3);
      button1.setText("Button1");
      //place component inside the screen
      button1.place(screen);
      
      Button button2 = new Button(6,3, "Button2");
      //place component inside the screen
      button2.place(screen);

      //display screen
      screen.display();
      
```
      
      
**Sample output:**


![image](https://user-images.githubusercontent.com/75112014/182513091-be1fa938-c97b-4975-b293-65a8ae5c2654.png)






**6. CList**: component to help your list looks more neat


**Sample code:**


```java
      String[] list1 = {"Banana", "Apple", "Potato", "Orange"};

      CList cList1 = new CList(list1, 30);
      cList1.setTitle("Fruits",Position.CENTER);
      cList1.display();


      String[] list2 = {"Apple Button jeans boots with a fur", "Apple", "Potato", "Orange"};
      CList cList2 = new CList(list2, 0);
      cList2.setTitle("Fruits",Position.START);
      cList2.display();


```

**Sample output:**


![image](https://user-images.githubusercontent.com/75112014/182513912-44e21a6e-f15f-4d87-b86d-621d3dbe6637.png)





**7. CTable**: easiest way to show your data on console, just pass your 2d array then BAAAM!!! instant table.

**Sample code:**

```java

      String[][] arr = {{"Marilyn Monroe", "21", "March", "1993"},
              {"Robert De Niro", "22", "August", "1945"},
              {"Malcolm X", "23", "June", "1944"},
              {"Mohammad Ali", "24", "March", "1970"}
      };


      CTable table = new CTable(null,arr);
      table.display();


      String[] header = {"Name", "Id", "Month", "Year"};

      CTable table2 = new CTable(header,arr);
      table2.hasSeparator(true);
      table2.setAlignment(Position.CENTER);
      table2.display();
      
```


**Sample output:**


![image](https://user-images.githubusercontent.com/75112014/182514176-64f2a6d9-5bac-402d-8d7d-18e5bf9192a1.png)



_Hope you like it..enjoy._












        
        
        



        
