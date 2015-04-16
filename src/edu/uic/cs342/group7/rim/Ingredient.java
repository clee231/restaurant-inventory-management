package edu.uic.cs342.group7.rim;

import java.util.*;

/**
 * @author
 * Adrian Pasciak,
 * Chase Lee,
 * Christopher Schultz,
 * Nerijus Gelezinis (no-show),
 * Patrick Tam
 */
public class Ingredient {
  private String name;
  private ArrayList<Quantity> list = new ArrayList<Quantity>();
  
  
  public Ingredient(String ingredientName) {
    this.name = ingredientName;
  }
  
  
  public String getName() {
    return this.name;
  }
  
  
  public QuantityIterator createIterator() {
    return new QuantityIterator(list);
  }
  
  
  public void addQuantity(Quantity q) {
    int size = list.size();
    boolean beenAdded = false;
    Date date = q.getDate();
    
    for(int i = 0; i < size && !beenAdded; i++) {
      if(list.get(i).getDate().compareTo(date) >= 0) {
        list.add(i, q);
        beenAdded = true;
      }
    }
    
    if(!beenAdded) {
      list.add(q);
    }
  }
  
  
  
}
