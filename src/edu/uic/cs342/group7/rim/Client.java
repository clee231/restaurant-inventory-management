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
	ArrayList<Ingredient> ingred = null;
	ArrayList<Dish> dish = null;
	Api connection = new Api();
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
		System.out.println("3. Add Dish (Deprecated)");
		System.out.println("4. End Day");
		System.out.println("5. Forecast Shopping List");
		System.out.println("6. Load Data from file");
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

		System.out.println("Current Status: NOT IMPLEMENTED");
		printMenu();
		System.out.println("\nSelect a menu option: ");
		boolean runflag = true;
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		
		while (!("q".equalsIgnoreCase(input))) {
			switch(Integer.parseInt(input)) {
			case 1:
				printHeader("Order Dish");
				//TODO: When the API is done, get a list of all dishes available
				System.out.println("Please select the dish you would like to order:");
				break;
			case 2:
				printHeader("Add Items to Inventory");
				break;
			case 3:
				printHeader("Add Dish");
				System.out.println("Deprecated function");
				break;
			case 4:
				printHeader("End Day");
				break;
			case 5:
				printHeader("Forecast Shopping List");
				break;
			case 6:
				printHeader("Load Data from file");
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
						String[] elements = line.split(",");
						for(String item : elements) {
							System.out.print(item + "*");
						}
						System.out.print("\n");
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
