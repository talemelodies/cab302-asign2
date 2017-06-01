package asgn2Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import asgn2Customers.Customer;
import asgn2Customers.CustomerFactory;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Restaurant.LogHandler;

/**
 * A class that tests the methods relating to the creation of Customer objects in the asgn2Restaurant.LogHander class.
 *
 * @author Person A
 */
public class LogHandlerCustomerTests {
	
	ArrayList<Customer> customers = new ArrayList<Customer>();

	@Before
	public void inputData() throws CustomerException, LogHandlerException{
			customers = LogHandler.populateCustomerDataset(".//logs/20170101.txt");
	}
	
	@Test
	public void getNameFromIndex0(){		
		assertEquals(customers.get(0).getName(), "Casey Jones");
	}
	
	@Test
	public void getCustomerTypeFromIndex0(){		
		assertEquals(customers.get(0).getCustomerType(), "Driver Delivery");
	}
	
	@Test
	public void getLocationXFromIndex0(){		
		assertEquals(customers.get(0).getLocationX(), 5);
	}
	
	@Test
	public void getLocationYFromIndex0(){		
		assertEquals(customers.get(0).getLocationX(), 5);
	}
	
	@Test
	public void getMobileNumberFromIndex0(){		
		assertEquals(customers.get(0).getMobileNumber(), "0123456789");
	}
	
	@Test(expected = LogHandlerException.class)
	public void inputinvalidFile() throws CustomerException, LogHandlerException{
		ArrayList<Customer> invalidFile = new ArrayList<Customer>();
		invalidFile = LogHandler.populateCustomerDataset("");
	}
	
	@Test(expected = LogHandlerException.class)
	public void inputNullFile() throws CustomerException, LogHandlerException{
		ArrayList<Customer> nullFile = new ArrayList<Customer>();
		nullFile.add(LogHandler.createCustomer(null));
	}
}
