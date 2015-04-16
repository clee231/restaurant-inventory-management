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
public class QuantityIterator implements Iterator{
  private ArrayList<Quantity> list = new ArrayList<Quantity>();
  
  /**
   * Add instance Quantity q to Iterator Storages. Adds q into in ascending expiration data order
   * @param q
   */
  public void add(Quantity q) {
    int size = list.size();
    boolean beenAdded = false;
    Date date = q.getDate();
        
    for(int i = 0; i < size; i++) {
      if(list.get(i).getDate().compareTo(date) >= 0) {
        list.add(i, q);
        beenAdded = true;
        break;
      }
    }
    
    if(!beenAdded) {
      list.add(q);
    }
  }
}
