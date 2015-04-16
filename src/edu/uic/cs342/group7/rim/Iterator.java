package edu.uic.cs342.group7.rim;

public interface Iterator {
  void add(Quantity q);
  boolean hasNext();
  Quantity next();
  void remove();
}
