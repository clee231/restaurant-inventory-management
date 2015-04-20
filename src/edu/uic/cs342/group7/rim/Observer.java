package edu.uic.cs342.group7.rim;
import java.util.ArrayList;

public class Observer {
	private ArrayList<Dish> dishesOrdered;
	
	public void updateList(Dish dish){
		dishesOrdered.add(dish);
	}
	
	public void resetList(){
		dishesOrdered.clear();
	}
	
	public Dish removeLastAdded() {
	  int size = dishesOrdered.size();
	  return dishesOrdered.remove(size - 1);
	}
	
	public ArrayList<Dish> getDishesOrdered(){
		return dishesOrdered;
	}
	
}
