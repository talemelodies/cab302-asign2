package asgn2Pizzas;

import java.time.LocalTime;
import java.util.ArrayList;

import asgn2Exceptions.PizzaException;


/**
 * 
 *  A class that represents a vegetarian pizza made at the Pizza Palace restaurant. 
 *  The vegetarian pizza has certain toppings listed in Section 5.1 of the Assignment Specification Document.  
 *  A description of the class's fields and their constraints is provided in Section 5.1 of the Assignment Specification.
 * 
 * @author PersonA
 *
 */
public class VegetarianPizza extends Pizza {

	/**
	 * 
	 *  This class represents a vegetarian pizza made at the  Pizza Palace restaurant. The vegetarian pizza has certain
	 *  toppings listed in Section 5.1 of the Assignment Specification Document.  A description of the class's
	 *  fields and their constraints is provided in Section 5.1 of the Assignment Specification.
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification are violated. 
	 * 
     * <P> PRE: TRUE
	 * <P> POST: All field values including the cost per pizza are set
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 *
	 */
	public VegetarianPizza(int quantity, LocalTime orderTime, LocalTime deliveryTime) throws PizzaException {

		super(quantity, orderTime, deliveryTime, "Vegetarian", 10.00);
		Topping = new ArrayList<PizzaTopping>();		
		Topping.add(PizzaTopping.TOMATO);
		Topping.add(PizzaTopping.CHEESE);
		Topping.add(PizzaTopping.EGGPLANT);
		Topping.add(PizzaTopping.MUSHROOM);
		Topping.add(PizzaTopping.CAPSICUM);
		calculateCostPerPizza();
		
		// Check quantity between 1 to 10 
		if (quantity >0 && quantity <=10){
		} else {
			throw new PizzaException("Quantity of the pizza should be at least one and at most 10");
		}
	}

}
