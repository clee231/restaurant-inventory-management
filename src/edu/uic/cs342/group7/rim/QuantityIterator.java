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
public class QuantityIterator implements NonJavaIterator{
  private ArrayList<Quantity> list;
  private int position = 0;

  /**
   * Iterator Class Constructor
   * @param list quantity list for iterator instance to iterate through
   */
  public QuantityIterator(ArrayList<Quantity> list) {
    this.list = list;
  }
  
  
  /**
   * Returns true is iterator has a next item. Otherwise, returns false.
   */
  public boolean hasNext() {
    boolean returnValue = false;
    
    if(position < list.size()) {
      returnValue = true;
    }
    
    return returnValue;
  }
  
  
  /**
   * Returns iterator's next item
   */
  public Quantity next() {
    Quantity returnValue = list.get(position);
    return returnValue;
  }
  
  /**
   * Removes last returned quantity from iterator's associated list 
   */
  public void remove() {
    list.remove(position);
  }
}
