package edu.uic.cs342.group7.rim;

import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

public class Api {
	private Observer observer;
	private OrderingSystem orderingSystem = new OrderingSystem();
	private InventoryManager inventory = new InventoryManager(new ArrayList<Ingredient>());// Newing with empty list to avoid null pointer exception
	private Date currentDate = new Date();
	private Calendar c =  Calendar.getInstance();
	
	public boolean orderDish(String dishName){
		return orderingSystem.orderDish(dishName);
	}
	
	public void addItemsToInventory(ArrayList<Ingredient> items) {
		inventory.addItems(items);
	}
	
	public void updateDate(){
		c.setTime(currentDate);
		c.add(Calendar.DATE, 1);
		currentDate = c.getTime();		
	}
	
}
