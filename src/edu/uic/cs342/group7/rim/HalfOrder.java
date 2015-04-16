package edu.uic.cs342.group7.rim;

import java.util.ArrayList;

public class HalfOrder implements DishSize {

	public ArrayList<DishIngredient> getIngredients(ArrayList<DishIngredient> listOfIngredients){		
		for(int i = 0; i < listOfIngredients.size(); i++){
		  DishIngredient ingredient = listOfIngredients.get(i);
		  ingredient.setQuantity(ingredient.getQuantity()/2);	  
		}
		return listOfIngredients;
	}
}
