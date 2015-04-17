package edu.uic.cs342.group7.rim;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Api {
	private Observer observer = new Observer();
	private OrderingSystem orderingSystem = new OrderingSystem();
	private InventoryManager inventory = new InventoryManager(new ArrayList<Ingredient>());// Newing with empty list to avoid null pointer exception
	private Date currentDate = new Date();
	private Calendar calendar =  Calendar.getInstance();
	private DishSize size;
	
	
	public Api(){
		orderingSystem.addObserver(observer);
	}
	
	
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
		return orderingSystem.orderDish(dishName, size);
	}
	
	
	public void addItemsToInventory(ArrayList<Ingredient> items) {
		inventory.addItems(items);
	}
	
	
	public ArrayList<Ingredient> getShoppingList(){
		ArrayList<Dish> dishHistory = observer.getDishesOrdered();
		return inventory.forecast(dishHistory);
	}

	
	public void updateDate(){
		calendar.setTime(currentDate);
		calendar.add(Calendar.DATE, 1);
		currentDate = calendar.getTime();		
	}
	
}
