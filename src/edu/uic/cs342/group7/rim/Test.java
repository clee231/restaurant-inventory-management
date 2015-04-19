package edu.uic.cs342.group7.rim;

import java.util.*;

public class Test {
  
  public static void main(String[] args) {
    Api api =  new Api();

    fillWithDishes(api);
    addIngredients(api);
    orderDishes(api);
  }
  
  public static void fillWithDishes(Api api) {
    Dish d1 = new Dish();
    Dish d2 = new Dish();
    Dish d3 = new Dish();
    
    Iterator<DishIngredient> itr;
    
    Ingredient ing1 = new Ingredient("Tomato");
    Ingredient ing2 = new Ingredient("Flour");
    Ingredient ing3 = new Ingredient("Sugar");
    
    DishIngredient ding1_1 = new DishIngredient();
    DishIngredient ding2_1 = new DishIngredient();
    DishIngredient ding2_2 = new DishIngredient();
    DishIngredient ding3_1 = new DishIngredient();
    DishIngredient ding3_2 = new DishIngredient();
    DishIngredient ding3_3 = new DishIngredient();
    
    ArrayList<DishIngredient> ding1 = new ArrayList<DishIngredient>();
    ArrayList<DishIngredient> ding2 = new ArrayList<DishIngredient>();
    ArrayList<DishIngredient> ding3 = new ArrayList<DishIngredient>();
    
    //Set Name
    d1.setName("Tomato Soup");
    d2.setName("Tomato Pie");
    d3.setName("Tomato Cookie");
    
    //Set Dish Ingredients
    ding1_1.setIngredient(ing1);
    ding1_1.setQuantity(2);
    ding2_1.setIngredient(ing1);
    ding2_1.setQuantity(2);
    ding2_2.setIngredient(ing2);
    ding2_2.setQuantity(2);
    ding3_1.setIngredient(ing1);
    ding3_1.setQuantity(2);
    ding3_2.setIngredient(ing2);
    ding3_2.setQuantity(4);
    ding3_3.setIngredient(ing3);
    ding3_3.setQuantity(5);
    
    //Add Dish Ings to Arrays
    ding1.add(ding1_1);
    ding2.add(ding2_1);
    ding2.add(ding2_2);
    ding3.add(ding3_1);
    ding3.add(ding3_2);
    ding3.add(ding3_3);
    
    d1.setDishIngredients(ding1);
    d2.setDishIngredients(ding2);
    d3.setDishIngredients(ding3);
    
    System.out.println("******* Creating Dishes ********");
    //Final Dish 1 Test
    System.out.print("Dish 1 Info: " + d1.getName() + " Ingredients: ");
    itr = d1.getIngredients().iterator();
    while(itr.hasNext()) {
      DishIngredient temp = itr.next();
      System.out.print(temp.getIngredient() + ", " + temp.getQuantity() + "; ");
    }
    System.out.println("");
    
    //Final Dish 2 Test
    System.out.print("Dish 2 Info: " + d2.getName() + " Ingredients: ");
    itr = d2.getIngredients().iterator();
    while(itr.hasNext()) {
      DishIngredient temp = itr.next();
      System.out.print(temp.getIngredient() + ", " + temp.getQuantity() + "; ");
    }
    System.out.println("");
    
    //Final Dish 3 Test
    System.out.print("Dish 3 Info: " + d3.getName() + " Ingredients: ");
    itr = d3.getIngredients().iterator();
    while(itr.hasNext()) {
      DishIngredient temp = itr.next();
      System.out.print(temp.getIngredient() + ", " + temp.getQuantity() + "; ");
    }
    System.out.println("\n");
    
    System.out.println("****** Adding Dishes to API ********\n");
    ArrayList<Dish> dishes = new ArrayList<Dish>();
    dishes.add(d1);
    dishes.add(d2);
    dishes.add(d3);
    api.loadDishes(dishes);
  }
  
  public static void addIngredients(Api api) {
    Ingredient ing1 = new Ingredient("Tomato");
    Ingredient ing2 = new Ingredient("Flour");
    Ingredient ing3 = new Ingredient("Sugar");
    
    Quantity q1_1 = new Quantity();
    Quantity q1_2 = new Quantity();
    Quantity q2_1 = new Quantity();
    Quantity q3_1 = new Quantity();
    Quantity q3_2 = new Quantity();
    Quantity q3_3 = new Quantity();
    
    q1_1.setCount(4);
    q1_2.setCount(6);
    q2_1.setCount(10);
    q3_1.setCount(4);
    q3_2.setCount(2);
    q3_3.setCount(1);
    
    Calendar date1_1 = new GregorianCalendar();
    Calendar date1_2 = new GregorianCalendar();
    Calendar date2_1 = new GregorianCalendar();
    Calendar date3_1 = new GregorianCalendar();
    Calendar date3_2 = new GregorianCalendar();
    Calendar date3_3 = new GregorianCalendar();
    
    date1_1.set(15, 4, 19);
    date1_2.set(15, 4, 20);
    date2_1.set(15, 5, 15);
    date3_1.set(15, 4, 17);
    date3_2.set(15, 4, 19);
    date3_3.set(15, 4, 20);
    
    q1_1.setDate(date1_1.getTime());
    q1_2.setDate(date1_2.getTime());
    q2_1.setDate(date2_1.getTime());
    q3_1.setDate(date3_1.getTime());
    q3_2.setDate(date3_2.getTime());
    q3_3.setDate(date3_3.getTime());
    
    ing1.addQuantity(q1_1);
    ing1.addQuantity(q1_2);
    ing2.addQuantity(q2_1);
    ing3.addQuantity(q3_1);
    ing3.addQuantity(q3_2);
    ing3.addQuantity(q3_3);
    
    System.out.println("******* Create Ingredients *********");
    //Final Ing 1 Test
    Iterator<Quantity> itr;
    System.out.print("Ing 1 Info: " + ing1.getName() + " Quantity: ");
    itr = ing1.createIterator();
    while(itr.hasNext()) {
      Quantity temp = itr.next();
      System.out.print(temp.getCount() + ", " + temp.getDate() + "; ");
    }
    System.out.println("");
    
    //Final Ing 2 Test
    System.out.print("Ing 2 Info: " + ing2.getName() + " Quantity: ");
    itr = ing2.createIterator();
    while(itr.hasNext()) {
      Quantity temp = itr.next();
      System.out.print(temp.getCount() + ", " + temp.getDate() + "; ");
    }
    System.out.println("");
    
    //Final Ing 3 Test
    System.out.print("Ing 3 Info: " + ing3.getName() + " Quantity: ");
    itr = ing3.createIterator();
    while(itr.hasNext()) {
      Quantity temp = itr.next();
      System.out.print(temp.getCount() + ", " + temp.getDate() + "; ");
    }
    System.out.println("\n");
    
    ArrayList<Ingredient> ingrds = new ArrayList<Ingredient>();
    ingrds.add(ing1);
    ingrds.add(ing2);
    ingrds.add(ing3);
    System.out.println("******** Add Ingredients to System *********\n");
    api.addItemsToInventory(ingrds);
  }
  
  public static void orderDishes(Api api) {
    String dish1 = "Tomato Soup";
    String dish2 = "Tomato Pie";
    String dish3 = "Tomato Cookie";
    
    String size1 = "Full order";
    String size2 = "Super size order";
    String size3 = "Half order";
    
    
    System.out.println("******** Ordering Dishes **********");
    System.out.println("Ordering: " + dish1 + " Size: " + size1);
    System.out.println("Outcome: " + api.orderDish(dish1, size1));
  }
  
}
