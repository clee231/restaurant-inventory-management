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

//A class that inherits from dishSize that will result the list of ingredients and their quantities needed for a super size order
public class SuperSizeOrder implements DishSize {

	// This method will double the quanitites needed for an ingredient
	public ArrayList<DishIngredient> getIngredients(ArrayList<DishIngredient> listOfIngredients){	
		ArrayList<DishIngredient> newIngredients = new ArrayList<DishIngredient>();
		for(int i = 0; i < listOfIngredients.size(); i++){
		  DishIngredient ingredient = new DishIngredient();
		  ingredient.setQuantity(listOfIngredients.get(i).getQuantity()*2);
		  ingredient.setIngredient(listOfIngredients.get(i).getIngredient());
		  newIngredients.add(ingredient);
		}
		return listOfIngredients;
	}

}
