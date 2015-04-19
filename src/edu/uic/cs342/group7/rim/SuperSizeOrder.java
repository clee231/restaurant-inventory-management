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

//A class that inherits from dishSize that will result the list of ingredients and their quantities needed for a super size order
public class SuperSizeOrder implements DishSize {

	// This method will double the quanitites needed for an ingredient
	public ArrayList<DishIngredient> getIngredients(ArrayList<DishIngredient> listOfIngredients){	
		ArrayList<DishIngredient> newIngredients = new ArrayList<DishIngredient>();
		Iterator<DishIngredient> itr = listOfIngredients.iterator();
		while(itr.hasNext()) {
		  DishIngredient ingredient = new DishIngredient();
		  DishIngredient temp = itr.next();
		  
		  ingredient.setIngredient(temp.getIngredient());
		  ingredient.setQuantity(temp.getQuantity()*2);
		  newIngredients.add(ingredient);
		}

		return newIngredients;
	}

}
