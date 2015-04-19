package edu.uic.cs342.group7.rim;

import java.util.ArrayList;

/**
 * @author
 * Adrian Pasciak,
 * Chase Lee,
 * Christopher Schultz,
 * Nerijus Gelezinis (no-show),
 * Patrick Tam 
 *
 */

// This is an interface that will help us implement the strategy pattern that will determine the amount of ingredients needed for a certain dish
public interface DishSize {
	
	// This is the method that takes an ArrayList<DishIngredients> and modifies it accordingly
	public ArrayList<DishIngredient> getIngredients(ArrayList<DishIngredient> listOfIngredients);
}
