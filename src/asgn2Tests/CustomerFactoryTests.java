package asgn2Tests;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;

/**
 * A class the that tests the asgn2Customers.CustomerFactory class.
 * 
 * @author Person A
 *
 */
public class CustomerFactoryTests {
	
	private final String PICKUP = "PUC";
	private final String DELIVERY = "DVC";
	private final String DRONE = "DNC";
	private final String invaidType = "IVD";
	
	@Test(expected = CustomerException.class)
	public void CustomerWithInvalidCustomerType() throws CustomerException {
		CustomerFactory.getCustomer(invaidType, "fekhjf", "0123456789", 0, 0);
	}
	@Test(expected = CustomerException.class)
	public void CustomerWithNullCustomerType() throws CustomerException {
		CustomerFactory.getCustomer(null, "fekhjf", "0123456789", 0, 0);
	}
	// Test for pick up
	@Test
	public void CustomerPickUpFunction() throws CustomerException {
		 CustomerFactory.getCustomer(PICKUP, "name", "0123456789", 0, 0);
	}
	
	@Test(expected = CustomerException.class)
	public void PickUpTypeWithInvaidXLocation() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "fekhjf", "126161565", 1, 0);
	}
	@Test(expected = CustomerException.class)
	public void PickUpTypeWithInvaidYLocation() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "fekhjf", "126161565", 0, 1);
	}
	@Test(expected = CustomerException.class)
	public void PickUpTypeWithInvaidMobileNumber() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "fekhjf", "126161565", 0, 0);
	}
	@Test(expected = CustomerException.class)
	public void PickUpTypeWithNullName() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, null, "0123456789", 0, 0);
	}
	@Test(expected = CustomerException.class)
	public void PickUPTypeWithEmptyNameOrLengthSmallThan1() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "", "0123456789", 0, 0);
	}
	@Test(expected = CustomerException.class)
	public void PickUpTypeWithNameOverLength() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "sdfsdfsdfsdewfwfwffdsfaefef", "0123456789", 0, 0);
	}
	@Test(expected = CustomerException.class)
	public void PickUpTypeWithEmptyMobileNumber() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "fekhjf", "", 0, 0);
	}
	@Test(expected = CustomerException.class)
	public void PickUpTypeWithWrongMobileNumberFirstCharIsNot0() throws CustomerException {
		CustomerFactory.getCustomer(PICKUP, "fekhjf", "1123456789", 0, 0 );
	}
	
	// Test delivery
	@Test
	public void TestCreateDeliveryType() throws CustomerException {
		 CustomerFactory.getCustomer(DELIVERY, "dfdsf", "0123456789", 0, 0);
	}
	@Test(expected = CustomerException.class)
	public void DeliveryTypeWithInvaidYLocationNegativeNumberSmallerThan10() throws CustomerException {
		CustomerFactory.getCustomer(DELIVERY, "fefds", "0123456789", 8, -11);
	}
	
	@Test(expected = CustomerException.class)
	public void DeliveryTypeWithInvaidYLocationOver10() throws CustomerException {
		CustomerFactory.getCustomer(DELIVERY, "fefds", "0123456789", 2, 11);
	}
	@Test(expected = CustomerException.class)
	public void DeliveryTypeWithInvaidLocationXLocationOver10() throws CustomerException {
		CustomerFactory.getCustomer(DELIVERY, "fefds", "0123456789", 20, 5);
	}
	@Test(expected = CustomerException.class)
	public void DeliveryTypeWithInvaidLocationXLocationWithNegativeNumberSmallerThan10() throws CustomerException {
		CustomerFactory.getCustomer(DELIVERY, "fefds", "0123456789", -11, 5);
	}
	
	//Test drone delivery
	
	@Test
	public void TestCreateDroneDelivery() throws CustomerException {
		 CustomerFactory.getCustomer(DRONE, "dskhfk", "0123456789", 0, 0);
	}
	@Test(expected = CustomerException.class)
	public void DroneDeliveryTypeWithInvaidYLocation() throws CustomerException {
		CustomerFactory.getCustomer(DRONE, "dnfek", "0123456789", 2, 11);
	}
	@Test(expected = CustomerException.class)
	public void DroneDeliveryTypeWithNegativeYlocationSmallerThan10() throws CustomerException {
		CustomerFactory.getCustomer(DRONE, "dnfek", "0123456789", 2, -11);
	}
	@Test(expected = CustomerException.class)
	public void DroneDeliveryTypeWithInvaidxLocation() throws CustomerException {
		CustomerFactory.getCustomer(DRONE, "dnfek", "0123456789", 11, 2);
	}
	@Test(expected = CustomerException.class)
	public void DroneDeliveryTypeWithNegativexlocationSmallerThan10() throws CustomerException {
		CustomerFactory.getCustomer(DRONE, "dnfek", "0123456789", -11, 2);
	}
	@Test(expected = CustomerException.class)
	public void DroneDeliveryTypeWithWrongMobileNumber() throws CustomerException {
		CustomerFactory.getCustomer(DRONE, "dnfek", "1123456789", 5, 2);
	}
	

}
