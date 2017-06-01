package asgn2Tests;

import java.time.LocalTime;

import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;

/** 
 * A class that tests the asgn2Pizzas.PizzaFactory class.
 * 
 * @author Person B 
 * 
 */
public class PizzaFactoryTests {
	// TO DO
	private LocalTime orderTime;
	private LocalTime deliveryTime;	
	
	@Test(expected = PizzaException.class)
	public void testGetMargheritaPizza() throws PizzaException{
		orderTime = LocalTime.of(21, 22);
		deliveryTime = LocalTime.of(20, 23);
		PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
	}
	@Test(expected = PizzaException.class)
	public void testGetVegetarianPizza() throws PizzaException{
		orderTime = LocalTime.of(21, 22);
		deliveryTime = LocalTime.of(20, 23);
		PizzaFactory.getPizza("PZV", 3, orderTime, deliveryTime);
	}
	@Test(expected = PizzaException.class)
	public void testGetMeatLoversPizza() throws PizzaException{
		orderTime = LocalTime.of(21, 22);
		deliveryTime = LocalTime.of(20, 23);
		PizzaFactory.getPizza("PZL", 1, orderTime, deliveryTime);
	}
	@Test(expected = PizzaException.class)
	public void testInvalidPizzaCode() throws PizzaException{
		orderTime = LocalTime.of(21, 22);
		deliveryTime = LocalTime.of(20, 23);
		PizzaFactory.getPizza("DDD", 5, orderTime, deliveryTime);
	}
	
	//test exception for Order and Delivery in the same time 
	@Test(expected = PizzaException.class)
	public void orderAndDeliveryInSameTimePizzaMargherita() throws PizzaException {
		orderTime = LocalTime.of(20, 00);
		deliveryTime = LocalTime.of(20, 00);
		PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
	}
	@Test(expected = PizzaException.class)
	public void orderAndDeliveryInSameTimePizzaVegetarian() throws PizzaException {
		orderTime = LocalTime.of(20, 00);
		deliveryTime = LocalTime.of(20, 00);
		PizzaFactory.getPizza("PZV", 1, orderTime, deliveryTime);
	}
	@Test(expected = PizzaException.class)
	public void orderAndDeliveryInSameTimePizzaMeatLovers() throws PizzaException {
		orderTime = LocalTime.of(20, 00);
		deliveryTime = LocalTime.of(20, 00);
		PizzaFactory.getPizza("PZL", 1, orderTime, deliveryTime);
	}
	
	// test Delivery time earlier than order time
	
	@Test(expected = PizzaException.class)
	public void DeliveryTimeOverOrderTimeInMargherita() throws PizzaException {
		orderTime = LocalTime.of(20, 30);
		deliveryTime = LocalTime.of(20, 00);
		PizzaFactory.getPizza("PZM", 1, orderTime, deliveryTime);
	}
	@Test(expected = PizzaException.class)
	public void DeliveryTimeOverOrderTimeInVegetarian() throws PizzaException {
		orderTime = LocalTime.of(20, 30);
		deliveryTime = LocalTime.of(20, 00);
		PizzaFactory.getPizza("PZV", 1, orderTime, deliveryTime);
	}
	@Test(expected = PizzaException.class)
	public void DeliveryTimeOverOrderTimeInMeatLovers() throws PizzaException {
		orderTime = LocalTime.of(20, 30);
		deliveryTime = LocalTime.of(20, 00);
		PizzaFactory.getPizza("PZL", 1, orderTime, deliveryTime);
	}
	
	// test pizza with quantity 0 
	@Test(expected = PizzaException.class)
	public void orderPizzaWith0MeatLoversPizza() throws PizzaException {
		orderTime = LocalTime.of(20, 00);
		deliveryTime = LocalTime.of(20, 30);
		PizzaFactory.getPizza("PZL", 0, orderTime, deliveryTime);
	}
	@Test(expected = PizzaException.class)
	public void orderPizzaWith0VegetarianPizza() throws PizzaException {
		orderTime = LocalTime.of(20, 00);
		deliveryTime = LocalTime.of(20, 30);
		PizzaFactory.getPizza("PZV", 0, orderTime, deliveryTime);
	}
	@Test(expected = PizzaException.class)
	public void orderPizzaWith0MargheritaPizza() throws PizzaException {
		orderTime = LocalTime.of(20, 00);
		deliveryTime = LocalTime.of(20, 30);
		PizzaFactory.getPizza("PZM", 0, orderTime, deliveryTime);
	}
	
	// order pizza more than 10 quantity
	@Test(expected = PizzaException.class)
	public void orderPizzaWithMoreThan10MargheritaPizza() throws PizzaException {
		orderTime = LocalTime.of(20, 00);
		deliveryTime = LocalTime.of(20, 30);
		PizzaFactory.getPizza("PZM", 12, orderTime, deliveryTime);
	}
	@Test(expected = PizzaException.class)
	public void orderPizzaWithMoreThan10VegetarianPizza() throws PizzaException {
		orderTime = LocalTime.of(20, 00);
		deliveryTime = LocalTime.of(20, 30);
		PizzaFactory.getPizza("PZV", 12, orderTime, deliveryTime);
	}
	
	

}
