package edu.uic.cs342.group7.rim;

import java.util.*;

/**
 * @author
 * Adrian Pasciak,
 * Chase Lee,
 * Christopher Schultz,
 * Nerijus Gelezinis (no-show),
 * Patrick Tam
 *
 */
public class InventoryManager {
  private HashMap<String, Ingredient> database;
  
  public InventoryManager(ArrayList<Ingredient> list) {
    int size = list.size();
    Ingredient ingredient;
    Iterator<Ingredient> iterator = list.iterator();
    
    database = new HashMap<String, Ingredient>((int)(size*1.33));//gives some extra space in hash
    
    
    while(iterator.hasNext()) {
      ingredient = iterator.next();
      database.put(ingredient.getName(), ingredient);
    }
  }
  
  public boolean getIngredientsForDish(Dish dish) {
    boolean madeDish = false;
    DishIngredient dishIngredient;
    int totalNeeded = 0;
    Ingredient ingredientEntry;
    //Ingredient dishIngredient;
    
    //get Ingredients of dish
    Iterator<DishIngredient> dishIngredients = dish.getIngredients().iterator();
    
    //parse through list and check that all ingredients are available
    while(dishIngredients.hasNext()) {
      dishIngredient = dishIngredients.next();
      totalNeeded = dishIngredient.getQuantity();
      
      ingredientEntry = database.get(dishIngredient.getIngredient().getName());
      if(!ingredientEntry.isIngredientAvail(totalNeeded)) {
        return madeDish;
      }
    }
    
    //If all available, remove ingredients
    dishIngredients = dish.getIngredients().iterator(); // reset iterator
    while(dishIngredients.hasNext()) {
      dishIngredient = dishIngredients.next();
      totalNeeded = dishIngredient.getQuantity();
      
      ingredientEntry = database.get(dishIngredient.getIngredient().getName());
      
    }
    madeDish = true;
    
    return madeDish;
  }
  
  public int removedSpoiledIngredients(Date date) {
    Iterator<Map.Entry<String, Ingredient>> entries = database.entrySet().iterator();
    Map.Entry<String, Ingredient> entry;
    Ingredient ingredient;
    int totalRemoved = 0;
    
    while(entries.hasNext()) {
      entry = entries.next();
      ingredient = entry.getValue();
      totalRemoved += ingredient.removedSpoiledQuantity(date);
    }
    
    return totalRemoved;
  }
  
  
}