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

//A class that inherits from dishSize that will return the list of ingredients and their quantities needed for a half order
public class HalfOrder implements DishSize {

	// This function will modify the quantity of ingredients needed for a dish by half
	public ArrayList<DishIngredient> getIngredients(ArrayList<DishIngredient> listOfIngredients){		
		for(int i = 0; i < listOfIngredients.size(); i++){
		  DishIngredient ingredient = listOfIngredients.get(i);
		  ingredient.setQuantity(ingredient.getQuantity()/2);	  
		}
		return listOfIngredients;
	}
}
