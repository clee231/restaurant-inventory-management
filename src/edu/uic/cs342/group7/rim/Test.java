package edu.uic.cs342.group7.rim;

import java.util.*;

public class Test {
  
  public static void main(String[] args) {
    Api api =  new Api();

    fillWithDishes(api);
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
    System.out.println("");
  }
  
}
