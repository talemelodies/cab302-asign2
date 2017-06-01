package asgn2Tests;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.PizzaException;
import asgn2Pizzas.MargheritaPizza;
import asgn2Pizzas.MeatLoversPizza;
import asgn2Pizzas.Pizza;
import asgn2Pizzas.PizzaFactory;
import asgn2Pizzas.PizzaTopping;
import asgn2Pizzas.VegetarianPizza;

/**
 * A class that that tests the asgn2Pizzas.MargheritaPizza, asgn2Pizzas.VegetarianPizza, asgn2Pizzas.MeatLoversPizza classes. 
 * Note that an instance of asgn2Pizzas.MeatLoversPizza should be used to test the functionality of the 
 * asgn2Pizzas.Pizza abstract class. 
 * 
 * @author Person B
 *
 */
public class PizzaTests {
	// TO DO
	private final double DELTA = 1e-15;
	MargheritaPizza Olaf;
	VegetarianPizza Pantheon;
	MeatLoversPizza Quinn;
	private LocalTime orderTime;
	private LocalTime deliveryTime;
	
	@Before @Test
	public void testConstructor() throws PizzaException{
		orderTime = LocalTime.of(20,20);
		deliveryTime = LocalTime.of(20, 40);
		Olaf = new MargheritaPizza(2, orderTime, deliveryTime);
		Pantheon = new VegetarianPizza(6, orderTime, deliveryTime);
		Quinn = new MeatLoversPizza(8, orderTime, deliveryTime);
	}
	@Test
	public void testPizzaQuantity() throws PizzaException{
		assertEquals(2, Olaf.getQuantity());
	}
	//Test Invalid Pizza Quantity(quanlity > 10)
	@Test(expected = PizzaException.class)
	public void testInvaidPizzaQuantity1() throws PizzaException{
		Quinn = new MeatLoversPizza(11, orderTime, deliveryTime);
	}
	//Test Invalid Pizza Quantity(quanlity < 1)
	@Test(expected = PizzaException.class)
	public void testInvalidPizzaQuantity2() throws PizzaException{
		Quinn = new MeatLoversPizza(-1, orderTime, deliveryTime);
	}
	@Test
	public void testOrderTime() throws PizzaException{
		orderTime = LocalTime.of(20,20);
		deliveryTime = LocalTime.of(20, 40);
		Olaf = new MargheritaPizza(2, orderTime, deliveryTime);
	}
	//Test Invalid Order Time(ordertime < 19)
	@Test(expected = PizzaException.class)
	public void testInvalidOrderTime1() throws PizzaException{
		orderTime = LocalTime.of(15,00);
		deliveryTime = LocalTime.of(20, 40);
		Olaf = new MargheritaPizza(2, orderTime, deliveryTime);
	}
	//Test Invalid Order Time(ordertime > 23)
	@Test(expected = PizzaException.class)
	public void testInvalidOrderTime2() throws PizzaException{
		orderTime = LocalTime.of(01, 12);
		deliveryTime = LocalTime.of(21, 40);
		Olaf = new MargheritaPizza(2, orderTime, deliveryTime);
	}
	@Test
	public void testPizzaType(){
		assertEquals("Margherita", Olaf.getPizzaType());
		assertEquals("Vegetarian", Pantheon.getPizzaType());
		assertEquals("Meat Lovers", Quinn.getPizzaType());
	}
	@Test(expected = PizzaException.class)
	public void testInvalidPizzaType() throws PizzaException{
		PizzaFactory.getPizza("DDDD", 3, orderTime, deliveryTime);
	}
	@Test
	public void testPizzaToppingCost() throws PizzaException{
		assertEquals(1, PizzaTopping.CHEESE.getCost(),DELTA);
		assertEquals(0.5, PizzaTopping.TOMATO.getCost(),DELTA);	
		assertEquals(1.5, PizzaTopping.BACON.getCost(),DELTA);
		assertEquals(1, PizzaTopping.SALAMI.getCost(),DELTA);
		assertEquals(1,PizzaTopping.PEPPERONI.getCost(),DELTA);
		assertEquals(1.2, PizzaTopping.CAPSICUM.getCost(),DELTA);
		assertEquals(2, PizzaTopping.MUSHROOM.getCost(),DELTA);
		assertEquals(0.8, PizzaTopping.EGGPLANT.getCost(),DELTA);
	}
	@Test
	public void testCalculateGetCostPerPizza() throws PizzaException{
		assertEquals(1.5, Olaf.getCostPerPizza(),DELTA);
		assertEquals(5.5, Pantheon.getCostPerPizza(),DELTA);
		assertEquals(5, Quinn.getCostPerPizza(),DELTA);
	}
	@Test
	public void testGetOrderCost() throws PizzaException{
		assertEquals(3, Olaf.getOrderCost(),DELTA);
		assertEquals(33, Pantheon.getOrderCost(),DELTA);
		assertEquals(40, Quinn.getOrderCost(),DELTA);
	}
	@Test
	public void testGetOrderProfit() throws PizzaException{
		assertEquals(13, Olaf.getOrderProfit(),DELTA);
		assertEquals(27, Pantheon.getOrderProfit(),DELTA);
		assertEquals(56, Quinn.getOrderProfit(),DELTA);
	}
	@Test
	public void testPizzaContainsToppingForMargheritaPizza() throws PizzaException{
		assertEquals(true, Olaf.containsTopping(PizzaTopping.TOMATO));
		assertEquals(true, Olaf.containsTopping(PizzaTopping.CHEESE));
	}
	@Test
	public void testPizzaNotContainsToppingForMargheritaPizza() throws PizzaException{
		assertEquals(false, Olaf.containsTopping(PizzaTopping.BACON));
		assertEquals(false, Olaf.containsTopping(PizzaTopping.SALAMI));
		assertEquals(false, Olaf.containsTopping(PizzaTopping.PEPPERONI));
		assertEquals(false, Olaf.containsTopping(PizzaTopping.CAPSICUM));
		assertEquals(false, Olaf.containsTopping(PizzaTopping.MUSHROOM));
		assertEquals(false, Olaf.containsTopping(PizzaTopping.EGGPLANT));
	}
	@Test
	public void testPizzaContainsToppingForVegetarianPizza() throws PizzaException{
		assertEquals(true, Pantheon.containsTopping(PizzaTopping.TOMATO));
		assertEquals(true, Pantheon.containsTopping(PizzaTopping.CHEESE));
		assertEquals(true, Pantheon.containsTopping(PizzaTopping.EGGPLANT));
		assertEquals(true, Pantheon.containsTopping(PizzaTopping.MUSHROOM));
		assertEquals(true, Pantheon.containsTopping(PizzaTopping.CAPSICUM));
	}
	@Test
	public void testPizzaNotContainsToppingForVegetarianPizza() throws PizzaException{
		assertEquals(false, Pantheon.containsTopping(PizzaTopping.BACON));
		assertEquals(false, Pantheon.containsTopping(PizzaTopping.SALAMI));
		assertEquals(false, Pantheon.containsTopping(PizzaTopping.PEPPERONI));
	}
	@Test
	public void testPizzaContainsToppingForMeatLoversPizza() throws PizzaException{
		assertEquals(true, Quinn.containsTopping(PizzaTopping.TOMATO));
		assertEquals(true, Quinn.containsTopping(PizzaTopping.CHEESE));
		assertEquals(true, Quinn.containsTopping(PizzaTopping.BACON));
		assertEquals(true, Quinn.containsTopping(PizzaTopping.PEPPERONI));
		assertEquals(true, Quinn.containsTopping(PizzaTopping.SALAMI));
	}
	@Test
	public void testPizzaNotContainsToppingForMeatLoversPizza() throws PizzaException{
		assertEquals(false, Quinn.containsTopping(PizzaTopping.CAPSICUM));
		assertEquals(false, Quinn.containsTopping(PizzaTopping.MUSHROOM));
		assertEquals(false, Quinn.containsTopping(PizzaTopping.EGGPLANT));
	}
	@Test
	public void testGetQuantity() throws PizzaException{
		Olaf = new MargheritaPizza(5, orderTime, deliveryTime);
		Pantheon = new VegetarianPizza(5, orderTime, deliveryTime);
		Quinn = new MeatLoversPizza(5, orderTime, deliveryTime);
	}

}
