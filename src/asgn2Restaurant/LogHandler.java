package asgn2Restaurant;


import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalTime;
import java.util.ArrayList;
import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/**
 *
 * A class that contains methods that use the information in the log file to return Pizza 
 * and Customer object - either as an individual Pizza/Customer object or as an
 * ArrayList of Pizza/Customer objects.
 * 
 * @author Person A and Person B
 *
 */
public class LogHandler {
	


	/**
	 * Returns an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file.
	 * @param filename The file name of the log file
	 * @return an ArrayList of Customer objects from the information contained in the log file ordered as they appear in the log file. 
	 * @throws CustomerException If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Customer> populateCustomerDataset(String filename) throws CustomerException, LogHandlerException{
	
		String logFile = ".//logs/" + filename;
		String line = "";
		
		ArrayList<Customer> Customers = new ArrayList<Customer>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			 
			while((line = br.readLine()) != null) {	
				try{
			    Customers.add(createCustomer(line));
				} catch (CustomerException | LogHandlerException e) {
					// handle exception
					throw e;
				}
			}
			
			return Customers;
		} catch (Exception ex) {
			//Auto-generated catch block
			throw new LogHandlerException("There is a problem with the log file:" + ex);
		}
	}		

	/**
	 * Returns an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @param filename The file name of the log file
	 * @return an ArrayList of Pizza objects from the information contained in the log file ordered as they appear in the log file. .
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException If there was a problem with the log file not related to the semantic errors above
	 * 
	 */
	public static ArrayList<Pizza> populatePizzaDataset(String filename) throws PizzaException, LogHandlerException{
	
		String logFile = ".//logs/" + filename;
		String line = "";
		
		ArrayList<Pizza> Pizzas = new ArrayList<Pizza>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
			 
			while((line = br.readLine()) != null) {	
				try{
			    Pizzas.add(createPizza(line));
				} catch (PizzaException | LogHandlerException e) {
					// handle exception
					throw e;
				}
			}
			
			return Pizzas;
		} catch (Exception ex) {
			// Auto-generated catch block
			throw new LogHandlerException("There is a problem with the log file:" + ex);
		}
	}		

	
	/**
	 * Creates a Customer object by parsing the  information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Customer object containing the information from the line in the log file
	 * @throws CustomerException - If the log file contains semantic errors leading that violate the customer constraints listed in Section 5.3 of the Assignment Specification or contain an invalid customer code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Customer createCustomer(String line) throws CustomerException, LogHandlerException{
	
		String[] customerInformation;
		try {
			customerInformation = line.split(",");
		} catch (Exception e) {
			throw new LogHandlerException("There was a problem parsing the line from the log file:" + e);
			// handle exception
		}
		try {
			return CustomerFactory.getCustomer(customerInformation[4], customerInformation[2], customerInformation[3], Integer.parseInt(customerInformation[5]), Integer.parseInt(customerInformation[6]));
		} catch (CustomerException e) {
			throw e;
			// handle exception
		}
		
	}
	
	/**
	 * Creates a Pizza object by parsing the information contained in a single line of the log file. The format of 
	 * each line is outlined in Section 5.3 of the Assignment Specification.  
	 * @param line - A line from the log file
	 * @return- A Pizza object containing the information from the line in the log file
	 * @throws PizzaException If the log file contains semantic errors leading that violate the pizza constraints listed in Section 5.3 of the Assignment Specification or contain an invalid pizza code (passed by another class).
	 * @throws LogHandlerException - If there was a problem parsing the line from the log file.
	 */
	public static Pizza createPizza(String line) throws PizzaException, LogHandlerException{
				
		LocalTime orderTime, deliveryTime;
		int numberOfPizzas;
		String[] pizzaInformation;
		String code;
		
		try {
			pizzaInformation = line.split(",");
		} catch (Exception e) {
			throw new LogHandlerException("There was a problem parsing the line from the log file:" + e);
			// handle exception
		}
		
		//Input value into variables
		orderTime = LocalTime.parse(pizzaInformation[0]);
		deliveryTime = LocalTime.parse(pizzaInformation[1]);
		numberOfPizzas = Integer.parseInt(pizzaInformation[8]);
		code = pizzaInformation[7];
		

		try {
			return PizzaFactory.getPizza(code, numberOfPizzas, orderTime, deliveryTime);
		} catch (PizzaException e) {
			// handle exception
			throw e;
		}
	}

}
