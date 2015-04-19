/**
 * Restaurant Inventory Management
 * Group 7
 */

package edu.uic.cs342.group7.rim;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

/**
 * @authors
 * Adrian Pasciak,
 * Chase Lee,
 * Christopher Schultz,
 * Nerijus Gelezinis (no-show),
 * Patrick Tam
 *
 */

// This will be our Api class that will interact with the client and the inventory manager as well as the ordering system
public class Api {
	private Observer observer = new Observer();
	private OrderingSystem orderingSystem = new OrderingSystem();
	private InventoryManager inventory;
	private Date currentDate = new Date();
	private Calendar calendar =  Calendar.getInstance();
	private DishSize size;
	private Dish dish = new Dish();
	
	// When new instance of Api is created an observer will be added to keep track of dishes ordered
	public Api(){
		orderingSystem.addObserver(observer);
	}
	
	
	//This will receive a dish name and dish size from the user and will create a new instance of dishSize
    // Depending on what the user entered and then pass the dish name and dish size to the ordering system
	public boolean orderDish(String dishName, String dishSize){
		if(dishSize.equals("Full order")){
			size = new FullOrder();
			orderingSystem.setDishSize(size);
		}
		else if(dishSize.equals("Super size order")){
			size = new SuperSizeOrder();
			orderingSystem.setDishSize(size);
		}
		else if(dishSize.equals("Half order")){
			size = new HalfOrder();
			orderingSystem.setDishSize(size);
		}
		else{
			//Will return false if dish size was entered incorrectly
			return false;
		}
		//Will return true if dish can be created or false if it cannot
		dish = orderingSystem.orderDish(dishName);
		if(dish == null){
			System.out.println("Dish does not exist");
			return false; 
		}
		return inventory.getIngredientsForDish(dish);
	}
	
	
	//This will receive a an arrayList of ingredients from the client and pass it to the inventory manager
	public void addItemsToInventory(ArrayList<Ingredient> items) {
		inventory.addItems(items);
	}
	
	
	//This function will receive an arrayList of Dish from the ordering system to pass it to the inventory manager
	//Then it will receive an arrayList of Ingredient from the inventory manager and return that to the client
	public ArrayList<Ingredient> getShoppingList(){
		ArrayList<Dish> dishHistory = observer.getDishesOrdered();
		return inventory.forecast(dishHistory);
	}

	
	//This function will receive an arrayList of Dish from client and pass it to ordering system
	public void loadDishes(ArrayList<Dish> dishList){
		orderingSystem.setDishes(dishList);
	}
	
	
	//This function will receive an arrayList of Ingredient from client and pass it to ordering system
	public void loadIngredients(ArrayList<Ingredient> listOfIngredients){
		 inventory = new InventoryManager(listOfIngredients);
	}
	
	
	//This function will update the date by 1 day
	public void updateDate(){
		calendar.setTime(currentDate);
		calendar.add(Calendar.DATE, 1);
		currentDate = calendar.getTime();		
	}
	
}
