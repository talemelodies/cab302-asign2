package asgn2Tests;



import static org.junit.Assert.*;

import java.awt.Window.Type;
import java.nio.channels.NonWritableChannelException;

import javax.swing.GroupLayout;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.DriverDeliveryCustomer;
import asgn2Customers.DroneDeliveryCustomer;
import asgn2Customers.PickUpCustomer;
import asgn2Exceptions.CustomerException;

/**
 * A class that tests the that tests the asgn2Customers.PickUpCustomer, asgn2Customers.DriverDeliveryCustomer,
 * asgn2Customers.DroneDeliveryCustomer classes. Note that an instance of asgn2Customers.DriverDeliveryCustomer 
 * should be used to test the functionality of the  asgn2Customers.Customer abstract class. 
 * 
 * @author Person A
 * 
 *
 */
public class CustomerTests {
	//delta - the maximum delta between expected and actual for which both numbers are still considered equal.
	private final double DELTA = 1e-15;
	PickUpCustomer Evelynn;
	DriverDeliveryCustomer Frank;
	DroneDeliveryCustomer Galio;

	@Test@Before
	public void testConstructor() throws CustomerException{
		Evelynn = new PickUpCustomer("Evelynn", "0486934519", 0, 0);
		Frank = new DriverDeliveryCustomer("Frank", "0385182440", 5, 8);
		Galio = new DroneDeliveryCustomer("Galio", "0632147853", 3, 7);
	}
	@Test
	public void testPickUpCustomer() throws CustomerException{
		assertEquals("Evelynn", Evelynn.getName());
		assertEquals("0486934519", Evelynn.getMobileNumber());
		assertEquals(0, Evelynn.getLocationX());
		assertEquals(0, Evelynn.getLocationY());
		assertEquals("Pick Up", Evelynn.getCustomerType());
	}
	@Test
	public void testDriverDelieveryCustomer() throws CustomerException{
		assertEquals("Frank", Frank.getName());
		assertEquals("0385182440", Frank.getMobileNumber());
		assertEquals(5, Frank.getLocationX());
		assertEquals(8, Frank.getLocationY());
		assertEquals("Driver Delivery", Frank.getCustomerType());
	}
	@Test
	public void testDroneDeliveryCustomer() throws CustomerException{
		assertEquals("Galio", Galio.getName());
		assertEquals("0632147853", Galio.getMobileNumber());
		assertEquals(3, Galio.getLocationX());
		assertEquals(7, Galio.getLocationY());
		assertEquals("Drone Delivery", Galio.getCustomerType());
	}
	@Test
	public void testCustomerType() throws CustomerException{
		assertEquals("Pick Up", Evelynn.getCustomerType());
		assertEquals("Driver Delivery", Frank.getCustomerType());
		assertEquals("Drone Delivery", Galio.getCustomerType());
	}
	@Test
	public void testCustomerNameLength() throws CustomerException{
		assertEquals("Evelynn", Evelynn.getName());
		assertEquals("Frank", Frank.getName());
		assertEquals("Galio", Galio.getName());
	}

	//Test Invalid Name Which is NameLength > 20
	@Test(expected = CustomerException.class)
	public void testInvalidNameWithMoreThan20Charater() throws CustomerException{
		Frank = new DriverDeliveryCustomer("abcdefghijklmnopqrstuvw", "0451003138", 5, 5);
	}
	@Test
	public void testMobileNumber() throws CustomerException{
		assertEquals("0632147853", Galio.getMobileNumber());
	}
	//Test Invalid Mobile Number(chartAt != 0)
	@Test(expected = CustomerException.class)
	public void testInvalidMobileNumber1() throws CustomerException{
		Frank  = new DriverDeliveryCustomer("Jayce", "7815390000", 6, 8);
	}
	//Test Invalid Mobile Number(length > 10)
	@Test(expected = CustomerException.class)
	public void testInvalidMobileNumber2() throws CustomerException{
		Frank  = new DriverDeliveryCustomer("Kled", "12345678901", 0, 0);
	}
	@Test
	public void testLocationXandYforPickUpCustomer() throws CustomerException{
		assertEquals(0, Evelynn.getLocationX());
		assertEquals(0, Evelynn.getLocationY());
	}
	@Test(expected = CustomerException.class)
	public void testInvalidLocationXandYforPickUpCustomer() throws CustomerException{
		Evelynn = new PickUpCustomer("Evelynn", "0302465789", 2, 5);
	}
	@Test
	public void testLocationXandYforDriverDeliveryCustomer() throws CustomerException{
		assertEquals(5, Frank.getLocationX());
		assertEquals(8, Frank.getLocationY());
	}
	@Test(expected = CustomerException.class)
	public void testInvalidLocationXandYforDriverDeliveryCustomer() throws CustomerException{
		Frank = new DriverDeliveryCustomer("Frank", "0678987567", 12, -14);
	}
	@Test
	public void testLocationXandYforDroneDeliveryCustomer() throws CustomerException{
		Galio = new DroneDeliveryCustomer("Galio", "0478901567", -3, -5);
		assertEquals(-3, Galio.getLocationX());
		assertEquals(-5, Galio.getLocationY());
	}
	@Test(expected = CustomerException.class)
	public void testInvalidLocationXandYforDroneDeliveryCustomer() throws CustomerException{
		Frank = new DriverDeliveryCustomer("Nami", "0587456234", -15, -12);
	}
	@Test
	public void testGetName() throws CustomerException{
		assertEquals("Frank", Frank.getName());
	}
	@Test
	public void testGetMobileNumber() throws CustomerException{
		assertEquals("0385182440", Frank.getMobileNumber());
	}
	@Test
	public void testGetCustomerType() throws CustomerException{
		assertEquals("Driver Delivery", Frank.getCustomerType());
	}
	@Test
	public void testGetLocationX() throws CustomerException{
		assertEquals(5, Frank.getLocationX());
	}
	@Test
	public void testGetLocationY() throws CustomerException{
		assertEquals(8, Frank.getLocationY());
	}
	@Test
	public void testGetPickUpDistance() throws CustomerException{
		assertEquals(0, Evelynn.getDeliveryDistance(), DELTA);
	}
	@Test
	public void testGetDriverDeliveryDistance() throws CustomerException{
		assertEquals(13, Frank.getDeliveryDistance(), DELTA);
	}
	public void testGetDroneDeliveryDistance() throws CustomerException{
		assertEquals(10, Galio.getDeliveryDistance(), DELTA);
	}
}