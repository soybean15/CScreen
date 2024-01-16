# CScreen

## Text-based UI on Console

![GitHub Issues](https://img.shields.io/github/issues/pitzzahh/CScreen)
![Forks](https://img.shields.io/github/forks/pitzzahh/CScreen)
![Stars](https://img.shields.io/github/stars/pitzzahh/CScreen)
![License](https://img.shields.io/github/license/pitzzahh/CScreen)

## Table of Contents

1. [How to use](#how-to-use)
2. [C-Screen](#c-screen)
3. [Box-window and normal char](#normal-characters)
4. [Components](#c-screen-components)
    - [Screen](#screen)
    - [Box](#box)
    - [TextBox](#text-box)
    - [Label](#label)
    - [Button](#button)
5. [CList](#clist)
6. [CTable](#ctable)

## How to use
### Add Maven Dependency
![maven-central](https://img.shields.io/maven-central/v/me.araopj/cscreen?color=blue)

If you use Maven or Gradle, add the following configuration to your project's `pom.xml` | `build.gradle` <br>

Be sure to replace the **VERSION** key below with the one of the versions shown above

```xml
<dependencies>

    <!-- other dependencies are there -->
    <dependency>
        <groupId>me.araopj</groupId>
        <artifactId>cscreen</artifactId>
        <version>VERSION</version>
    </dependency>
    <!-- other dependencies are there -->

</dependencies>
```

## For Gradle

```groovy
compile group: 'me.araopj', name: 'cscreen', version: 'VERSION'
```

---

step1: download jar file on this link.

_download here:_ https://github.com/soybean15/CScreen/releases/latest

step2: Add jar file on your project.

step3: Import the library. ```import cscreen.components.*;```

step4: Finally create your first console UI. Enjoy!

## C-Screen

**C-screen** is A text-base UI library on java console, you can now easily design your console program using c-screen
with the help of cscreen components.

_Update as of August 4, 2022, 1:20pm_

_Since Box-window is not working on default on some OS, I added a method where you can choose between normal character
and box-window character_

### Normal Characters

```java
//normal character
import me.araopj.cscreen.classes.Position;
import me.araopj.cscreen.components.Screen;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen(20, 40, true);
        //screen.useBoxSet();
        screen.addTitle("Sample Screen", Position.START);
        screen.display();
    }
}

/*
sample output
+--------------------------------------+
|Sample Screen                         |
|+------------------------------------+|
*/
```

#### Box-Window Characters

```java
//box-window character
import me.araopj.cscreen.classes.Position;
import me.araopj.cscreen.components.Screen;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen(20, 40, true);
        screen.useBoxSet();
        screen.addTitle("Sample Screen", Position.START);
        screen.display();
    }
}

/*
sample output
╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮
│Sample Screen                         │
│╭┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈┈╮│

*/
```

## C-Screen components:

### Screen
A frame-like interface where you can put multiple components.

***Sample code:***

```java
import me.araopj.cscreen.classes.Position;
import me.araopj.cscreen.components.Screen;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen(20, 40, true);
        screen.addTitle("Sample Screen", Position.START);
        screen.display();
    }
}

/*the 3 parameters on the constructor are the following:
-width - width of screen
-height - height of screen
-hasBorder - add inner border if true
*/
```

**Sample output:**

![image](https://user-images.githubusercontent.com/75112014/182511031-ec59293c-8cd0-4297-8e9a-47abb9dfba84.png)

### Box
A rectangular component you can Put inside the Screen.

***Sample code:***

```java
import me.araopj.cscreen.classes.Position;
import me.araopj.cscreen.components.Box;
import me.araopj.cscreen.components.Screen;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen(20, 40, true);
        screen.addTitle("Sample Screen", Position.START);

        Box box = new Box(3, 3);
        box.setHeight(5);
        box.setWidth(30);

        //place component inside the screen
        box.place(screen);

        //display screen
        screen.display();
    }
}
```

**Sample output:**

![image](https://user-images.githubusercontent.com/75112014/182512062-a3f041f9-9071-47e0-a934-bdf03e145f27.png)


### Text Box
A box component with text inside

***Sample code:***

```java
import me.araopj.cscreen.classes.Position;
import me.araopj.cscreen.components.Screen;
import me.araopj.cscreen.components.TextBox;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen(20, 40, true);
        screen.addTitle("Sample Screen", Position.START);

        TextBox textBox = new TextBox(3, 3);
        textBox.setText("Sample text");
        textBox.setHeight(5);
        textBox.setWidth(30);

        //place component inside the screen
        textBox.place(screen);

        //display screen
        screen.display();
    }
}
```

**Sample output:**

![image](https://user-images.githubusercontent.com/75112014/182512666-f2a78982-07ca-43b7-baee-4b997efb1afc.png)

### Label
Text you can put inside the screen.

***Sample code:***

```java
import me.araopj.cscreen.classes.Position;
import me.araopj.cscreen.components.Label;
import me.araopj.cscreen.components.Screen;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen(20, 40, true);
        screen.addTitle("Sample Screen", Position.START);

        Label label = new Label(3, 3);
        label.setText("Sample Label");

        //place component inside the screen
        label.place(screen);

        //display screen
        screen.display();
    }
}
```

**Sample output:**

![image](https://user-images.githubusercontent.com/75112014/182512590-daee429e-7923-496c-9374-8b92a2e0f0e4.png)

### Button
Button-like component which is good to have if you have multiple option in your code.

**Sample code:**

```java
import me.araopj.cscreen.classes.Position;
import me.araopj.cscreen.components.Button;
import me.araopj.cscreen.components.Screen;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen(20, 40, true);
        screen.addTitle("Sample Screen", Position.START);

        Button button1 = new Button(3, 3);
        button1.setText("Button1");
        //place component inside the screen
        button1.place(screen);

        Button button2 = new Button(6, 3, "Button2");
        //place component inside the screen
        button2.place(screen);

        //display screen
        screen.display();
    }
}
```

**Sample output:**

![image](https://user-images.githubusercontent.com/75112014/182513091-be1fa938-c97b-4975-b293-65a8ae5c2654.png)

## CList

<a name="clist"></a>

**CList**: component to help your list looks more presentable

**Sample code:**

```java
import me.araopj.cscreen.classes.Position;
import me.araopj.cscreen.components.CList;

public class Main {
    public static void main(String[] args) {
        CList list = new CList();
        list.useBoxSet();
        list.setWidth(20);
        list.setTitle("Fruits", Position.CENTER);

        list.addItem("Apple");
        list.addItem("Banana");
        list.addItem("Mango");
        list.addItem("Banana");

        list.display();
    }
}
```

**Sample output:**

![image](https://user-images.githubusercontent.com/75112014/182986520-7f5b1a4c-d022-417d-bf77-bb85eef9d985.png)

**CList Functions**

| Function                               | Description                                                                                                                          |
|----------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| `setWidth(int width)`                  | Set the width of the rectangular border of the list. If not set, it will be based on the longest size of the String inside the list. |
| `setTitle(String title, Position pos)` | Add a title to the list with three available positions: `Position.START`, `Position.CENTER`, `Position.END`.                         |
| `addItem(String item)`                 | Add an item to the list.                                                                                                             |
| `getItem(int index)`                   | Get an item from the list by index.                                                                                                  |
| `remove(int index)`                    | Remove an item from the list by index.                                                                                               |
| `set(int index, String item)`          | Edit/update an item by index.                                                                                                        |

# CTable

<a name="ctable"></a>

**CTable**: easiest way to output your data on console, just pass your 2d array and you got yourself a neat and instant
table.

**Sample code:**

```java
import me.araopj.cscreen.classes.Position;
import me.araopj.cscreen.components.CTable;

public class Main {
    public static void main(String[] args) {
        String[] header = {"Id", "Product Name", "Quantity", "Price"};
        //can also add 2d array/list on argument ex: new CTable(your2dArrayOrList, Header);
        CTable table = new CTable(header);
        table.useBoxSet();
        table.hasSeparator(true);

        //add row
        table.addRow("f011", "Fries", "10", "70.00");
        table.addRow("b212", "Burger", "10", "30.00");
        table.addRow("fc11", "Fried Chicken", "10", "110.50");
        table.addRow("f011", "Fries", "10", "70.00");
        table.addRow("s930", "Sundae", "10", "30.00");

        //center third column
        table.setColumnAlignment(2, Position.CENTER);
        //Aligned End fourth column
        table.setColumnAlignment(3, Position.END);

        //print table
        table.display();

        //get total of third column in int
        int quantityTotal = table.getTotal(2);
        //get total of fourth column in float
        double priceTotal = table.getFloatTotal(3);

        System.out.println("Total Qty: " + quantityTotal);
        System.out.println("Total Price: " + priceTotal);
    }
}
```

**Sample output:**

![image](https://user-images.githubusercontent.com/75112014/183237756-a8ac0d03-fb91-4257-b388-3505bd1547ae.png)

**CTable Functions**

| Function                                                 | Description                                                                                                                  |
|----------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|
| `addList(List<List<String>> arr)`                        | Add 2D array to CTable.                                                                                                      |
| `addRow(String[] row)`                                   | Add a row inside the table.                                                                                                  |
| `getRow(int index)`                                      | Get all the values of the selected row; index is the position of the desired row.                                            |
| `getColumn(int index)`                                   | Get all the values of the selected column; index is the position of the desired column.                                      |
| `removeRow(int index)`                                   | Remove the selected row by index.                                                                                            |
| `getCell(int row, int column)`                           | Get the cell item inside the table.                                                                                          |
| `setCell(int row, int column, String str)`               | Edit/update the selected cell in the table.                                                                                  |
| `setColumnAlignment(int columnIndex, Position position)` | Set column position by column index. Positions available: `Position.START`, `Position.CENTER`, `Position.END`.               |
| `getIntTotal(int columnIndex)`                           | Get the integer total value of a column.                                                                                     |
| `getFloatTotal(int columnIndex)`                         | Get the float total value of a column.                                                                                       |
| `findRows(int column, String text)`                      | Find multiple rows inside the table. Example: `List<List<String>> findRows = tableName.findRows(column, "item to search");`. |

_Hope you like it….enjoy._
