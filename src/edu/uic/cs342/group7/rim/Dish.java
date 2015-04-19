package edu.uic.cs342.group7.rim;
import java.util.ArrayList;

public class Dish {
	private String name;
	private ArrayList<DishIngredient> ingredients = new ArrayList<DishIngredient>();
	
	public Dish(ArrayList<DishIngredient> dishIngred, String names){
		name = names;
		ingredients = dishIngred;
	}
	
	public Dish(){}
	
	public String getName(){
		return name;
	}
	
	public ArrayList<DishIngredient> getIngredients(){
		return ingredients;
	}
	
	public void setDishes(ArrayList<DishIngredient> dishIngred){
		ingredients = dishIngred;
	}
	
	public void setName(String names){
		name = names;
	}
	
}
