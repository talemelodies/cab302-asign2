package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that tests the methods relating to the handling of Pizza objects in the asgn2Restaurant.PizzaRestaurant class as well as
 * processLog and resetDetails.
 * 
 * @author Person B
 *
 */
public class RestaurantPizzaTests {
	PizzaRestaurant restaurant = new PizzaRestaurant();
	@Before
	public void inputData() throws CustomerException, PizzaException, LogHandlerException{
		restaurant.processLog(".//logs/20170101.txt");
	}
	@Test
	public void logFileInput() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant logFileInput = new PizzaRestaurant();
		assert(logFileInput.processLog(".//logs/20170101.txt"));
	}
	@Test (expected = LogHandlerException.class)
	public void logFileNullInput() throws CustomerException, PizzaException, LogHandlerException{
		PizzaRestaurant emptyLogFile = new PizzaRestaurant();
		emptyLogFile.processLog("");
	}
	// test PizzaIndex 
	public void getPizzaIndex() throws PizzaException{
		assertEquals("Vegetarian", restaurant.getPizzaByIndex(0).getPizzaType());
	}
	// invalid index
	@Test(expected=PizzaException.class)
	public void getPizzaIndexWithNumberBiggerThanIndex() throws PizzaException{
		restaurant.getPizzaByIndex(10);
	}
	
	@Test
	public void getNumOfPizzaOrdersFromLogFile(){
		assertEquals(3, restaurant.getNumPizzaOrders());
	}
	@Test
	public void getTotalProfitFromLogFile(){
		assertEquals(36.5, restaurant.getTotalProfit(),0.001);
	}
	@Test
	public void Resetfunction(){
		restaurant.resetDetails();
		assert(restaurant.getNumPizzaOrders() == 0);
	}
	
	
}
