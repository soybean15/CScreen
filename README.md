# CScreen
## Text-based UI on Console

![GitHub Issues](https://img.shields.io/github/issues/pitzzahh/CScreen)
![Forks](https://img.shields.io/github/forks/pitzzahh/CScreen)
![Stars](https://img.shields.io/github/stars/pitzzahh/CScreen)
![License](https://img.shields.io/github/license/pitzzahh/CScreen)

## Table of Contents
[How to use](#how to use)<br/>
[C-Screen](#cscreen)<br/>
[Box-window and normal char](#box win)<br/>
[Components](#components)
- [Screen](#screen)
- [Box](#box)
- [TextBox](#text box)
- [Label](#label)
- [Button](#button)

[CList](#clist)<br/>
[CTable](#ctable)<br/>


## How to use

### Add Maven Dependency

![maven-central](https://img.shields.io/maven-central/v/io.github.pitzzahh/CScreen?color=blue)

If you use Maven or Gradle, add the following configuration to your project's `pom.xml` | `build.gradle` <br>

Be sure to replace the **VERSION** key below with the one of the versions shown above

```maven
<dependencies>

    <!-- other dependencies are there -->
    <dependency>
        <groupId>io.github.pitzzahh</groupId>
        <artifactId>CScreen</artifactId>
        <version>VERSION</version>
    </dependency>
    <!-- other dependencies are there -->

</dependencies>
```
## For Gradle
```gradle
compile group: 'io.github.pitzzahh', name: 'CScreen', version: 'VERSION'
```
---

<a name="how to use"></a>
step1: download jar file on this link.

_download here:_ https://github.com/soybean15/CScreen/releases

step2: Add jar file on your project.

step3: Import the library. ```import cscreen.components.*;```

step4: Finally create your first console UI. Enjoy!


## C-Screen
<a name="cscreen"></a>

**C-screen** is a text-base UI library on java console, you can now easily design your console program using c-screen with the help of cscreen components.


_Update as of August 4, 2022, 1:20pm_

_Since Box-window is not working on default on some OS, I added a method where you can choose between normal character and box-window character_

<a name="box win"></a>

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
    ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
    ???Sample Screen                         ???
    ????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????

    */
```

### C-Screen components:

<a name="components"></a>
<a name="screen"></a>

**1. Screen**: a frame-like interface where you can put multiple components.
        
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



<a name="box"></a>

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

<a name="text box"></a>

**3.TextBox:** A box component with text inside

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

      
      
      
<a name="label"></a> 

**4. Label** : Text you can put inside the screen.

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





<a name="button"></a>

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




## CList
<a name="clist"></a>

**CList**: component to help your list looks more presentable


**Sample code:**


```java
CList list = new CList();
list.useBoxSet();
list.setWidth(20);
list.setTitle("Fruits",Position.CENTER);

list.addItem("Apple");
list.addItem("Banana");
list.addItem("Mango");
list.addItem("Banana");

list.display();


```

**Sample output:**


![image](https://user-images.githubusercontent.com/75112014/182986520-7f5b1a4c-d022-417d-bf77-bb85eef9d985.png)


**CList Functions**


>   **setWidth(int width)** - setting width of rectangular border of list. If not set, it will base on the longest size of the String inside the list.
>
>   **setTitle(String title,Position pos)** - Add title on the list, there are three available positions ```Position.START, Position.CENTER, Position.END```.
>
>   **addItem(String item)** - add item on the list.
>
>   **getItem(int index)** - get item on the list by index.
>
>   **remove(int index)** - remove item on the list by index.
>
>   **set(int index, String item)** - edit/update item by index.



# CTable
<a name="ctable"></a>

**CTable**: easiest way to output your data on console, just pass your 2d array and you got yourself a neat and instant table.

**Sample code:**

```java
String[] header = {"Id", "Product Name", "Quantity", "Price"};

CTable table = new CTable(header);//can also add 2d array/list on argument ex: new CTable(your2dArrayOrList, Header);
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
int quantityTotal = table.getIntTotal(2);
//get total of fourth column in float
float priceTotal = table.getFloatTotal(3);

System.out.println("Total Qty: "+ quantityTotal);
System.out.println("Total Price: "+ priceTotal);


```


**Sample output:**


![image](https://user-images.githubusercontent.com/75112014/183237756-a8ac0d03-fb91-4257-b388-3505bd1547ae.png)



**CTable Functions**


>**addList(List<List<String>> arr)** - Add 2d array on CTable.
>    
>**addRow(String[] row)** - Add row inside the table.
>    
>**getRow(int index)** - get all the value of selected row, index is the position of desired row.
>    
>**getColumn(int index)** - get all the value of selected column, index is the position of desired column.
>    
>**removeRow(int index)** - remove selected row by index
>    
>**getCell(int row, int column)** - get cell item inside the table.
>    
>**setCell(int row, int column,String str)** - edit/update the selected cell in the table.
>
>**setColumnAlignment(int columnIndex, Position position)** - set column position by column index. Positions available  ```Position.START,Position.CENTER,Position.END```.
>
>**getIntTotal(int columnIndex)** - get int total value of a column 
>
>**getFloatTotal(int columnIndex)** - get float total value of a column 
>
>**findRows(int column, String text)** - find multiple rows inside the table. ```ex List<List<String>> findRows = tableName.findRows(column, "item to search");```

_Hope you like it..enjoy._
