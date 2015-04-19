package edu.uic.cs342.group7.rim;
import java.util.ArrayList;

public class Dish {
	private String name;
	private ArrayList<DishIngredient> ingredients = new ArrayList<DishIngredient>();
	
	//constructor for Dish... takes in all DishIngredients and the name
	public Dish(ArrayList<DishIngredient> dishIngred, String names){
		name = names;
		ingredients = dishIngred;
	}

	//empty constructor
	public Dish(){}
	
	//returns the name of the Dish
	public String getName(){
		return name;
	}
	
	//returns the ingredients the dish requires
	public ArrayList<DishIngredient> getIngredients(){
		return ingredients;
	}
	
	//sets the DishIngredient
	public void setDishIngredients(ArrayList<DishIngredient> dishIngred){
		ingredients = dishIngred;
	}
	
	//sets the name of the Dish
	public void setName(String names){
		name = names;
	}
	
}
