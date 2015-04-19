package edu.uic.cs342.group7.rim;
import java.util.ArrayList;

public class OrderingSystem {
	private ArrayList<Observer> listOfObserver;
	private ArrayList<Dish> dishes;
	private DishSize dishSize;
	
	public boolean orderDish(String dishName){
		boolean dishExists = false;
		Dish dish = new Dish();
		
		//first: get all available dishes
		ArrayList<Dish> dishes = availableDishes();
		for(Dish d : dishes){
			if(d.getName() == dishName){
				dishExists = true;
				dish = d;
				break;
			}
		}

		if(dishExists == false){
			return false;
		}

		//second: get dish sizes
		ArrayList<DishIngredient> ingredients = dishSize.getIngredients(dish.getIngredients());
		  
		//third: check if ingredients are available for quantity and if it exists
		for(DishIngredient ing : ingredients){
			if(ing.getIngredient().isIngredientAvail(ing.getQuantity()) == false){
				return false;
			}
			/*if(ing.getQuantity() > ing.getIngredient().getTotalQuantityOfIngredient()){
				return false;
			}*/
		}
		
		//here it means for sure all the ingredients are available... can now get them
		for(DishIngredient ing : ingredients){
			//ing.getIngredient() -> returns Ingredient.getIngredient(ing.getQuantity()) -> passes to Ingredient class to subtract number
			ing.getIngredient().getIngredient(ing.getQuantity());
		}
		  
		 
		
		return true;
	}
	
	public void addObserver(Observer o){
		listOfObserver.add(o);
	}
	
	public ArrayList<Dish> availableDishes(){
		return dishes;
	}
	
	public void setDishes(ArrayList<Dish> dishList){
		dishes = dishList;
	}
	
	public void setDishSize(DishSize size){
		dishSize = size;
	}
}
