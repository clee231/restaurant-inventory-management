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
  HashMap<String, Ingredient> database;
  
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
}