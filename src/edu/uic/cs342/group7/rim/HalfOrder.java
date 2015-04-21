package edu.uic.cs342.group7.rim;

import java.util.ArrayList;
import java.util.Iterator;

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
		ArrayList<DishIngredient> newIngredients = new ArrayList<DishIngredient>();
		Iterator<DishIngredient> itr = listOfIngredients.iterator();
		while(itr.hasNext()) {
		  DishIngredient ingredient = new DishIngredient();
		  DishIngredient temp = itr.next();
		  
		  ingredient.setIngredient(temp.getIngredient());
		  ingredient.setQuantity((int)Math.ceil(((double)temp.getQuantity())/2));
		  newIngredients.add(ingredient);
		}

		return newIngredients;
	}
}
