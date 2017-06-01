package asgn2Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.LogHandler;

/** A class that tests the methods relating to the creation of Pizza objects in the asgn2Restaurant.LogHander class.
* 
* @author Person B
* 
*/
public class LogHandlerPizzaTests {
	ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

	@Before
	public void inputData() throws PizzaException, LogHandlerException{
		pizzas = LogHandler.populatePizzaDataset(".//logs/20170101.txt");
	}
	
	@Test
	public void getPizzaTypeFunctionTest(){
		assertEquals(pizzas.get(0).getPizzaType(), "Vegetarian");
	}
	
	@Test
	public void getOrderCostFunctionTest(){
		assertEquals(11.0,pizzas.get(0).getOrderCost(), 0.001);
	}
	@Test
	public void getOrderPriceFunctionTest(){
		assertEquals(20, pizzas.get(0).getOrderPrice(),0.001);
	}
	@Test
	public void getPricePerFunctionTest(){
		assertEquals(10.0, pizzas.get(0).getPricePerPizza(),0.001);
	}
	@Test
	public void getOrderProfitFunctionTest(){
		assertEquals(9.0, pizzas.get(0).getOrderProfit(),0.001);
	}
	@Test
	public void getQuantityFunctionTest(){
		assertEquals(2, pizzas.get(0).getQuantity());
	}
}
