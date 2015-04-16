package edu.uic.cs342.group7.rim;

public interface Iterator {
  boolean hasNext();
  Quantity next();
  void remove();
}
