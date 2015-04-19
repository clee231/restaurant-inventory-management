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
  
  
  public boolean isIngredientAvail(int count) {
    boolean isAvailable = false;
    
    if(this.getTotalQuantityOfIngredient() >= count) {
      isAvailable = true;
    }
    
    return isAvailable;
  }
  
  
  public int getIngredient(int count) {
    int totalRetrieved = 0;
    Quantity q;
    int quantityCount = 0;
   
    while(totalRetrieved < count && this.list.size() > 0) {
      q = this.list.get(0); //oldest quantity
      quantityCount = q.getCount();
      
      if(quantityCount >= count) {
        q.setCount(quantityCount - count);
        totalRetrieved += (quantityCount - count);
      }
      else {
        q.setCount(0);
        totalRetrieved += quantityCount;
      }
      
      //remove quantity if it not longer has any count
      if(q.getCount() <= 0) {
        this.list.remove(0);
      }
    }
      
    return totalRetrieved;
  }
  
  
  public int getTotalQuantityOfIngredient() {
    Iterator<Quantity> iterator = this.list.iterator();
    int count = 0;
    
    while(iterator.hasNext()) {
      count += iterator.next().getCount();
    }
    
    return count;
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
  
  
  public int removedSpoiledQuantity(Date date) {
    int numberOfRemoved = 0;
    
    while(true) {
      if(this.list.get(0).getDate().compareTo(date) > 0) {
        this.list.remove(0);
        ++numberOfRemoved;
      }
      else {
        break;
      }
    }
    
    return numberOfRemoved;
  }
  
  public Iterator<Quantity> createIterator() {
    return this.list.iterator();
  }
}
