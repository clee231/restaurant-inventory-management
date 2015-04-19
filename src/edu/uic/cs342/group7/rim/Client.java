/**
 * Restaurant Inventory Management
 * Group 7
 */
package edu.uic.cs342.group7.rim;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
//Java 8 routines
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @authors
 * Adrian Pasciak,
 * Chase Lee,
 * Christopher Schultz,
 * Nerijus Gelezinis (no-show),
 * Patrick Tam
 *
 */
public class Client {
	static ArrayList<Ingredient> ingreds = new ArrayList<Ingredient>();
	static ArrayList<Dish> dishes = new ArrayList<Dish>();
	static Api connection = new Api();
	static HashMap<String, String> dishSizes = new HashMap<String, String>();
	

	/**
	 * Constructor Stub
	 */
	public Client() {
		// TODO Auto-generated constructor stub
		// TODO We should create an instance of the RIM API in this class.
	}

	/**
	 * This function will print out the menu for the user to select from.
	 * There are no arguments for this function.
	 */
	private static void printMenu() {
		printHeader("Menu");
		System.out.println("1. Order Dish");
		System.out.println("2. Add Items to Inventory");
		System.out.println("3. End Day");
		System.out.println("4. Forecast Shopping List");
		System.out.println("5. Load Dishes from file");
		System.out.println("q. Quit");
	}
	/**
	 * This function wll print out a header for a given text string.
	 * @param text - A string to place within the header flag.
	 */
	public static void printHeader(String text) {
		int count = text.length();
		String dash = "-";
		for (int i = 0; i < count-1; i++) {
			dash = dash.concat("-");
		}
		System.out.println("+" + dash + "+");
		System.out.println("+" + text + "+");
		System.out.println("+" + dash + "+");
	}
	
	/**
	 * This will determine if a ingredient is in the larger list of ingredients, identified by name.
	 * @param haystack - The list of all ingredients
	 * @param needle - The string you are looking for, identifying the ingredient
	 * @return - true if the ingredient is found, false if not.
	 */
	public static boolean ingredientExists(ArrayList<Ingredient> haystack, String needle) {
		for (Ingredient item : haystack) {
			if (item.getName().equalsIgnoreCase(needle)) {
				return true;
			}
		}
		return false;
	}
	
	public static Ingredient getIngredient(ArrayList<Ingredient> haystack, String needle) {
		for (Ingredient item : haystack) {
			if (item.getName().equalsIgnoreCase(needle)) {
				return item;
			}
		}
		return null;
	}
	/**
	 * This function is the main driver and client for the our project.  This
	 * main function will handle all the interface logic with the user.
	 * @param args - This parameter is not used.
	 */
	public static void main(String[] args) {
		String version = "1.00";
		System.out.println("+------------------------------------------------------------------------------+");
		System.out.format("+                    Restaurant Inventory Management                     v%s +\n", version);
		System.out.println("+       Authors: Adrian Pasciak, Chase Lee, Christopher Schultz,               +");
		System.out.println("+                Nerijus Gelezinis (no-show), Patrick Tam                      +");
		System.out.println("+------------------------------------------------------------------------------+");
		dishSizes.put("F", "Full Size Order");
		dishSizes.put("S", "Super Size Order");
		dishSizes.put("H", "Half Size Order");
		System.out.println("Current Status: NOT IMPLEMENTED");
		printMenu();
		System.out.println("\nSelect a menu option: ");
		boolean runflag = true;
		int count = 0;
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		
		while (!("q".equalsIgnoreCase(input))) {
			switch(Integer.parseInt(input)) {
			case 1:
				printHeader("Order Dish");
				System.out.println("Please select the dish you would like to order:");
				count = 0;
				for(Dish item : dishes) {
					System.out.println(count +") "+ item.getName());
					count++;
				}
				input = s.nextLine();
				int getDish = Integer.parseInt(input);
				System.out.println("Please select a dish size:");
				System.out.println("S) Super Size Order");
				System.out.println("F) Full Size Order (Normal)");
				System.out.println("H) Half Size Order");
				input = s.nextLine();
				String dSize = input;
				boolean result = connection.orderDish(dishes.get(getDish).getName(), dishSizes.get(dSize.substring(0, 1)));
				if (result) {
					System.out.println(dishSizes.get(dSize.substring(0, 1)) + " of " + dishes.get(getDish).getName() + " ordered successfully.");
				}else {
					System.out.println(dishSizes.get(dSize.substring(0, 1)) + " of " + dishes.get(getDish).getName() + " order failed.");
				}
				break;
			case 2:
				printHeader("Add Items to Inventory Quantity");
				count = 0;
				for(Ingredient item : ingreds) {
					System.out.println(count + ") " + item.getName() + " - " + item.getTotalQuantityOfIngredient());
					count++;
				}
				System.out.println("Please select the ingredient you would like to add quantity to:");
				int ingredientToAdd = s.nextInt();
				while(ingredientToAdd > ingreds.size() || ingredientToAdd < 0) {
					System.out.println("Invalid option, try again:");
					ingredientToAdd = s.nextInt();
				}
				System.out.println("How many would you like to add?:");
				int quantityToAdd = s.nextInt();
				while(quantityToAdd < 0) {
					System.out.println("Invalid quantity, try again:");
					quantityToAdd = s.nextInt();
				}
				input =  s.nextLine(); // Eat up new line.
				System.out.println("When is the expiration?: yy/mm/dd");
				input =  s.nextLine();
				String[] ymd = input.split("/");
				ArrayList<Ingredient> toBeAdded = new ArrayList<Ingredient>();
				Ingredient ingredientStaged = ingreds.get(ingredientToAdd);
				Quantity newQuantity = new Quantity();
				newQuantity.setCount(quantityToAdd);
				newQuantity.setDate(new GregorianCalendar(Integer.parseInt(ymd[0]),Integer.parseInt(ymd[1]),Integer.parseInt(ymd[2])).getTime());
				ingredientStaged.addQuantity(newQuantity);
				toBeAdded.add(ingredientStaged);
				connection.addItemsToInventory(toBeAdded);
				System.out.println(toBeAdded.size() + " " + ingreds.get(ingredientToAdd).getName() + " have been added to the inventory!");
				break;
			case 3:
				printHeader("End Day");
				connection.updateDate();
				break;
			case 4:
				printHeader("Forecast Shopping List");
				ArrayList<Ingredient> shoplist = connection.getShoppingList();
				System.out.println("We are below a threshold on these ingredients. Here are the current quantities:");
				for (Ingredient item : shoplist) {
					System.out.format("%d : %s\n", item.getTotalQuantityOfIngredient(), item.getName());
				}
				break;
			case 5:
				printHeader("Load Dishes from file");
				System.out.println("Please specify a file name to load: ");
				input = s.nextLine();
				// This is Java 8... 5 lines to read the file...
//				try {
//					Files.lines(Paths.get(input), StandardCharsets.UTF_8).forEach(System.out::println);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				BufferedReader br = null;
				String line = null;
				try {
					 
					br = new BufferedReader(new FileReader(input));
					while ((line = br.readLine()) != null) {
						if (line.startsWith("#")) {
							continue; // Comment detection
						}
						String[] elements = line.split(",");
						ArrayList<DishIngredient> dishRecipe = new ArrayList<DishIngredient>();
						
						/**
						 * For each line:
						 * - Add an Ingredient if not exists in array
						 * - Make a dishIngredient and append to list
						 * - Create a Dish
						 * - Add dish to dishArray
						 */
						for (int i = 1; i < elements.length; i++) {
							String[] elemquant = elements[i].split(":");
							Ingredient currentIngredient = new Ingredient(elemquant[0]);
							if(!ingredientExists(ingreds, elemquant[0])) {
								ingreds.add(currentIngredient);
								System.out.println("Added " + currentIngredient.getName());
							}else {
								System.out.println("Skipping ingredient.");
							}
							DishIngredient currentDishIngredient = new DishIngredient(getIngredient(ingreds, elemquant[0]), Integer.parseInt(elemquant[1]));
							dishRecipe.add(currentDishIngredient);
						}
						Dish currentDish = new Dish(dishRecipe, elements[0]);
						dishes.add(currentDish);
					}
			 
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (br != null) {
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				connection.loadIngredients(ingreds);
				connection.loadDishes(dishes);

				break;
			case 6:
				printHeader("Load Ingredient Quantities from file");
				
				break;
			default:
				System.out.println("***Incorrect input, try again.***");
				break;
			}
			printMenu();
			System.out.println("\nSelect a menu option: ");
			input = s.nextLine();
		}
	}

}
