package edu.uic.cs342.group7.rim;

/**
 * @author
 * Adrian Pasciak,
 * Chase Lee,
 * Christopher Schultz,
 * Nerijus Gelezinis (no-show),
 * Patrick Tam
 *
 */
public interface NonJavaIterator {
  boolean hasNext();
  Object next();
  void remove();
}
