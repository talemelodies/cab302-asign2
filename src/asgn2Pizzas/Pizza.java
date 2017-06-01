package asgn2Pizzas;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import asgn2Exceptions.PizzaException;


/**
 * An abstract class that represents pizzas sold at the Pizza Palace restaurant. 
 * The Pizza class is used as a base class of VegetarianPizza, MargheritaPizza and MeatLoversPizza. 
 * Each of these subclasses have a different set of toppings. A description of the class's fields
 * and their constraints is provided in Section 5.1 of the Assignment Specification. 
 * 
 * @author Person A
 *
 */
public abstract class Pizza  {
	
	private int quantity;
	private String pizzaType;
	private double pizzaPrice;
	private double pizzaCost;
	private double totalPrice;
	private boolean includedTopping;
	protected LocalTime orderTime;
	protected LocalTime deliveryTime;
	protected LocalTime openTime = LocalTime.of(19, 00);
	protected LocalTime closeTime = LocalTime.of(23, 00);

	
	protected ArrayList<PizzaTopping> Topping;
	
	/**
	 *  This class represents a pizza produced at the Pizza Palace restaurant.  A detailed description of the class's fields
	 *  and parameters is provided in the Assignment Specification, in particular in Section 5.1. 
	 *  A PizzaException is thrown if the any of the constraints listed in Section 5.1 of the Assignment Specification
	 *  are violated. 
     *
     *  PRE: TRUE
	 *  POST: All field values except cost per pizza are set
	 * 
	 * @param quantity - The number of pizzas ordered 
	 * @param orderTime - The time that the pizza order was made and sent to the kitchen 
	 * @param deliveryTime - The time that the pizza was delivered to the customer
	 * @param type -  A human understandable description of this Pizza type
	 * @param price - The price that the pizza is sold to the customer
	 * @throws PizzaException if supplied parameters are invalid 
	 * 
	 */
	public Pizza(int quantity, LocalTime orderTime, LocalTime deliveryTime, String type, double price) throws PizzaException{
		
		int orderedTime = orderTime.getHour();
		int deliverTime = deliveryTime.getHour();
		
		long minutesDifference = ChronoUnit.MINUTES.between(orderTime, deliveryTime);
		
		if (quantity < 1 ){
			throw new PizzaException("the minimum number of ordered pizza is 1");
		}
		
		if (quantity > 10) {
			throw new PizzaException("the maximum number of ordered pizza is 10");
		}
		
		if (orderedTime < 19 || orderedTime > 23){
			throw new PizzaException("Invalid order time");
		}
		
		if (orderTime.isBefore(openTime)){
			throw new PizzaException("we have not opened");
		}
		
		if(orderTime.isAfter(closeTime)){
			throw new PizzaException("Shop closed");
		}
		
		if (deliverTime < 19) {		
			throw new PizzaException("Invalid delivery time");
		}
		if( minutesDifference < 10){
			throw new PizzaException("we need to cook pizza at least for 10 minutes");
		}
		if( minutesDifference >60){
			throw new PizzaException("Your Pizza been throwed out");
		}
		
		if(!(type.equals("Margherita") || type.equals("Vegetarian") || type.equals("Meat Lovers"))){
			throw new PizzaException("Invalid pizza type");
		}
		if (minutesDifference<10){
			throw new PizzaException("At least 10 minutes");
		}
		
		
		this.quantity = quantity;
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
		this.pizzaType = type;
		this.pizzaPrice = price;
		this.totalPrice = this.pizzaPrice * this.quantity;
	}

	/**
	 * Calculates how much a pizza would cost to make calculated from its toppings.
	 *  
     * <P> PRE: TRUE
	 * <P> POST: The cost field is set to sum of the Pizzas's toppings
	 */
	public final void calculateCostPerPizza(){
		this.pizzaCost = 0;

		for (int i = 0; i < Topping.size(); i++){
			this.pizzaCost += Topping.get(i).getCost();

		}
	}
	
	/**
	 * Returns the amount that an individual pizza costs to make.
	 * @return The amount that an individual pizza costs to make.
	 */
	public final double getCostPerPizza(){
		
		calculateCostPerPizza();
		return pizzaCost;
	}

	/**
	 * Returns the amount that an individual pizza is sold to the customer.
	 * @return The amount that an individual pizza is sold to the customer.
	 */
	public final double getPricePerPizza(){
		
		return pizzaPrice;
	}

	/**
	 * Returns the amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order costs to make, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderCost(){
		
		this.calculateCostPerPizza();
		return this.pizzaCost * this.quantity;
	}
	
	/**
	 * Returns the amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 * @return The amount that the entire order is sold to the customer, taking into account the type and quantity of pizzas. 
	 */
	public final double getOrderPrice(){
		
		return this.totalPrice;
	}
	
	
	/**
	 * Returns the profit made by the restaurant on the order which is the order price minus the order cost. 
	 * @return  Returns the profit made by the restaurant on the order which is the order price minus the order cost.
	 */
	public final double getOrderProfit(){
		
		return this.totalPrice - this.getOrderCost();
	}
	

	/**
	 * Indicates if the pizza contains the specified pizza topping or not. 
	 * @param topping -  A topping as specified in the enumeration PizzaTopping
	 * @return Returns  true if the instance of Pizza contains the specified topping and false otherwise.
	 */
	public final boolean containsTopping(PizzaTopping topping){

		if (Topping.contains(topping) == true) {
			includedTopping = true;
		} else {
			includedTopping = false;
		}
		return includedTopping;

	}
	
	/**
	 * Returns the quantity of pizzas ordered. 
	 * @return the quantity of pizzas ordered. 
	 */
	public final int getQuantity(){
		
		return this.quantity;
	}

	/**
	 * Returns a human understandable description of the Pizza's type. 
	 * The valid alternatives are listed in Section 5.1 of the Assignment Specification. 
	 * @return A human understandable description of the Pizza's type.
	 */
	public final String getPizzaType(){
		
		return this.pizzaType;
	}


	/**
	 * Compares *this* Pizza object with an instance of an *other* Pizza object and returns true if  
	 * if the two objects are equivalent, that is, if the values exposed by public methods are equal.
	 * You do not need to test this method.
	 *  
	 * @return true if *this* Pizza object and the *other* Pizza object have the same values returned for 	
	 * getCostPerPizza(), getOrderCost(), getOrderPrice(), getOrderProfit(), getPizzaType(), getPricePerPizza() 
	 * and getQuantity().
	 *   
	 */
	@Override
	public boolean equals(Object other){
		Pizza otherPizza = (Pizza) other;
		return ((this.getCostPerPizza()) == (otherPizza.getCostPerPizza()) &&
			(this.getOrderCost()) == (otherPizza.getOrderCost())) &&				
			(this.getOrderPrice()) == (otherPizza.getOrderPrice()) &&
			(this.getOrderProfit()) == (otherPizza.getOrderProfit()) &&
			(this.getPizzaType() == (otherPizza.getPizzaType()) &&
			(this.getPricePerPizza()) == (otherPizza.getPricePerPizza()) &&
			(this.getQuantity()) == (otherPizza.getQuantity()));
	}

	
}
