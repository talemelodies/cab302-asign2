package asgn2Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Restaurant.PizzaRestaurant;

/**
 * A class that that tests the methods relating to the handling of Customer objects in the asgn2Restaurant.PizzaRestaurant
 * class as well as processLog and resetDetails.
 * 
 * @author Person A
 */
public class RestaurantCustomerTests {
	PizzaRestaurant restaurant = new PizzaRestaurant();
	
	
	@Before
	public void inputData() throws CustomerException, PizzaException, LogHandlerException{
			restaurant.processLog(".//logs/20170101.txt");
	}

	@Test
	public void testGetCustomerByIndex() throws CustomerException{
		assertEquals("Casey Jones", restaurant.getCustomerByIndex(0).getName());
	}
	
	@Test
	public void numofCusotmerOrders() throws CustomerException{
		assertEquals(3,restaurant.getNumCustomerOrders() );
	}
	
	@Test
	public void getTotaldeliverdistance()throws CustomerException{
		double distance = 10 + 0 + Math.sqrt((Math.pow(0 - 3, 2) + (Math.pow((0-4), 2))));
		assert(distance == restaurant.getTotalDeliveryDistance());
	}
	
	@Test(expected = CustomerException.class)
	public void getCustomerWithInvalidIndexSize() throws CustomerException{
		restaurant.getCustomerByIndex(10);
	}
}
