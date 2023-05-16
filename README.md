# OOP_FW9

## Kenneth Lay- 2602119272



#### A large company with locations in different cities has taken an OOP approach in creating an administration program that manages all aspects of its business. These aspects include:

#### - the sale of all the different products that the company manages

#### - the salaries for managers, office staff and sales personnel.



## 1. 

### (a) **By making use of an example from the above scenario, distinguish between a class and an instantiation of a class.**

***Class***: A class serves as a blueprint or template for the characteristics and actions of objects. It includes information and procedures that outline the typical traits and behaviors connected to a given notion or thing. In this instance, the "Product" class would provide the shared characteristics and actions shared by all of the company's goods. It could also provide methods for calculating total cost, updating inventory, or displaying product information, as well as attributes like product name, price, and quantity.

***Instantiation of a class***: Instation of a class sometimes referred to as an object, is a particular instance of that class. It is constructed using the blueprint for the class and represents a unique entity with its own set of values for the class's characteristics.




### The different modules in the program each open a graphical user interface (GUI). Each GUI has a similar design but contains differences specific to each module.

### (b) **By giving two examples, explain how the principles of inheritance can be incorporated into the design of this administration program.**

***Inheritance***: Inheritance is when a new class is derived or inherit from another class, here are two examples:

- Employee as super class in inheritance, which you can make multiple class with it like staff, manager, CEO and so on
- A user interface element that extends from the parent GUI class may employ inheritance. You may modify the required property to be categorised as a button when trying to build a button in the user interface by extending the GUI class.



### (c) **Describe how the use of libraries can facilitate the development of programs like this company’s administration program.**

Libraries can be a way to help company develope their programs much faster and will be less costly, because, creating and developing everything from scratch is time consuming, takes alot of effort and may be costly. But with libraries as there is already pre existing methods we don't need to spend a lot of time on methods like math, making a linked list and etc.

### **2. The company employs several sales personnel to sell its products to different retailers. Each branch of the company keeps track of its own sales with a suite of programs that include the two classes SalesPerson and Sales.**

```JAVA
public class SalesPerson {

	// each object contains details of one salesperson

	private String id;

	private Sales[] salesHistory; // details of the different sales

	private int count = 0; // number of sales made



	//constructor for a new salesperson

	public SalesPerson(String id){

	// code missing

	}

 

	// constructor for a salesperson transferred (together with their sales details) from another branch

	public SalesPerson(String id, Sales[] s, int c){

	// code missing

	}

 

	public int getCount(){return count;}

	public String getId() {return id;}

	public void setSalesHistory(Sales s){

	salesHistory[count] = s;

	count = count +1;

	}

 

	public double calcTotalSales(){

	// calculates total sales for the salesperson

	// code missing

	}

 

	public Sales largestSale(){

	// calculates the sale with the largest value

	// code missing

	}

}
```



### **Each instance variable is initialized when a SalesPerson object is instantiated.**

### (a) **Complete the constructor public SalesPerson(String id), from the SalesPerson class.**

```java
public SalesPerson(String id) {
    this.id = id;
    this.salesHistory = new Sales[100]; 
    this.count = 0;
}
```





### (b) **Explain why accessor methods are necessary for the SalesPerson class. (3 points)**

Accessor methods, or getter methods, are important in the SalesPerson class to allow controlled access to its private variables. They enable other classes or methods to retrieve the values of these variables without directly accessing them.



```java
public class Sales {

	// each object contains details of one sale

	private String itemId;     // id of the item

	private double value;      // the price of one item

	private int quantity;      // the number of the items sold

	// constructor missing

	public double getValue() {
        return value;
    }

	public int getQuantity() {
        return quantity;
    }
    
}
```



### (c) (i) **Construct unified modelling language (UML) diagrams to clearly show the relationship between the SalesPerson and Sales classes.**

### Note: There is no need to include mutator or accessor methods or a constructor.




### (c) **(ii) Outline a negative effect that a future change in the design of the Sales object might have on this suite of programs.**

Compatibility problems or inconsistent data might result from a future change in the design of the Sales object for this group of apps. Modifying the Sales object's design, such as altering the itemId, value, or quantity data types, might result in bugs or inaccurate results in applications already in use that rely on the original design.



### **The company employs several sales personnel. The different salesPerson objects are held in the array salesPeople. The Driver class contains various methods that operate on the SalesPerson and Sales classes. The Driver class contains the following code:**

```java
public static void main(String[] args){

    SalesPerson[] salesPeople = new SalesPerson[6];

    salesPeople[0] = new SalesPerson("100");

    salesPeople[1] = new SalesPerson("101");

    salesPeople[2] = new SalesPerson("102");

    salesPeople[0].setSalesHistory(new Sales("A100",300.00,10));

    salesPeople[0].setSalesHistory(new Sales("A200",1000.00,2));

    salesPeople[1].setSalesHistory(new Sales("A300",2550.40,10));

    System.out.println(salesPeople[2].getId());

    System.out.println(salesPeople[0].getCount());

    System.out.println(salesPeople[1].getSalesHistory(0).getValue());

    System.out.println(salesPeople[0].calcTotalSales());

 }
```



### (d) **State the output after running this code.**

```
102
2
2550.4
5000.0
```



### (e) **Construct the method calcTotalSales(), in the SalesPerson class that calculates the total value of the sales for a specific SalesPerson object.**

```java
public double calcTotalSales() {
    double totalSales = 0.0;
    for (int i = 0; i < count; i++) {
        totalSales += salesHistory[i].getValue() * salesHistory[i].getQuantity();
    }
    return totalSales;
}

```



### **The salesPeople array contains 100 instantiated objects. The company wishes to reward the salesperson whose sales have the largest total value.**

### (f) **By making use of any previously written methods, construct the method highest(), that returns the ID of the salesperson whose sales have the largest total value.**

```java
public static String highest(SalesPerson[] salesPeople) {
    double maxTotalSales = 0.0;
    String salesPersonId = "";
    for (SalesPerson salesPerson : salesPeople) {
        double totalSales = salesPerson.calcTotalSales();
        if (totalSales > maxTotalSales) {
            maxTotalSales = totalSales;
            salesPersonId = salesPerson.getId();
        }
    }
    return salesPersonId;
}
```





### (g) **Construct the method addSales(Sales s, String id), in the Driver class, that will add a new Sales object s, to the salesperson with a specified ID.**

##### Note: You can assume that the ID is a valid one.

```java
public static void addSales(Sales s, String id, SalesPerson[] salesPeople) {
    for (SalesPerson salesPerson : salesPeople) {
        if (salesPerson.getId().equals(id)) {
            salesPerson.setSalesHistory(s);
            break;
        }
    }
}

```



### A further class in this suite of programs is the Payroll class. This class is run at the end of each month to calculate each salesperson’s salary, which is based on the sales that have been made during that month.

### (h) Suggest changes that must be made to the SalesPerson class and/or the Sales class to allow these calculations to be made.

We can add in the missing setters for the class Sales and SalesPerson, and we can also add another method that can calculate the total revenue for a given time.

### (i) **Discuss the use of polymorphism that occurs in this suite of programs.**

This collection of programs makes use of polymorphism through method overriding and inheritance. It enables more generic coding by allowing SalesPerson objects to be treated as Sales objects. By using method overriding, the SalesPerson class may give its own version of the calcTotalSales() function, giving the collection of programs more adaptability and customisation.
