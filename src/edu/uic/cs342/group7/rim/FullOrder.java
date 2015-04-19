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

// A class that inherits from dishSize that will result the list of ingredients and their quantities needed for a full order
public class FullOrder implements DishSize {

	// This method is inherited from DishSize and will return the preset quantites for an ingredient, it will not be changed
	public ArrayList<DishIngredient> getIngredients(ArrayList<DishIngredient> listOfIngredients){
		return listOfIngredients;
	}

}
