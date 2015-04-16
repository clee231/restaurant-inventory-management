package edu.uic.cs342.group7.rim;
import java.util.ArrayList;

public class Dish {
	private String name;
	private ArrayList<DishIngredient> ingredients;
	
	public String getName(){
		return name;
	}
	
	public ArrayList<DishIngredient> getIngredients(){
		return ingredients;
	}
	
}
