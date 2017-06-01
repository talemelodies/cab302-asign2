package asgn2GUIs;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;

import org.junit.experimental.theories.Theories;

import asgn2Customers.Customer;
import asgn2Exceptions.CustomerException;
import asgn2Exceptions.LogHandlerException;
import asgn2Exceptions.PizzaException;
import asgn2Pizzas.Pizza;
import asgn2Restaurant.PizzaRestaurant;

import java.awt.*;
import javax.swing.*;


/**
 * This class is the graphical user interface for the rest of the system.
 * Currently it is a ���mmy��蕭 class which extends JFrame and implements Runnable and ActionLister.
 * It should contain an instance of an asgn2Restaurant.PizzaRestaurant object which you can use to
 * interact with the rest of the system. You may choose to implement this class as you like, including changing
 * its class signature ��蕭 as long as it  maintains its core responsibility of acting as a GUI for the rest of the system.
 * You can also use this class and asgn2Wizards.PizzaWizard to test your system as a whole
 *
 *
 * @author Person A and Person B
 *
 */
public class PizzaGUI extends javax.swing.JFrame implements Runnable, ActionListener {


	private PizzaRestaurant restaurant;
	
	private static final long serialVersionUID = 7031008862559936404L;
	
	private javax.swing.JButton browseBtn;
	private javax.swing.JButton clearInfoBtn;
	private javax.swing.JButton displayDisance;
	private javax.swing.JButton displayInfoBtn;
	private javax.swing.JButton displayProfit;
	private javax.swing.JLabel distance;
	private javax.swing.JTextField distancefield;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane customerScrollPane;
	private javax.swing.JScrollPane pizzaScrollPane;
	private javax.swing.JTable customerTable;
	private javax.swing.JTable pizzaTable;
	private javax.swing.JTextField logFilename;
	private javax.swing.JLabel profitLabel;
	private javax.swing.JTextField profitTestField;
	private javax.swing.JLabel selectFilelabel;
	

	JFileChooser chooser = new JFileChooser(new File("logs"));
	

	

	
	/**
	 * Creates a new Pizza GUI with the specified title
	 * @param title - The title for the supertype JFrame
	 */
	public PizzaGUI(String title) {
		// TO DO
		super(title);
		
		setupGUI();

		
	}
	
	private void setupGUI(){
		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		restaurant = new PizzaRestaurant();

		logFilename = new javax.swing.JTextField();
		browseBtn = new javax.swing.JButton();
		displayInfoBtn = new javax.swing.JButton();
		clearInfoBtn = new javax.swing.JButton();
		selectFilelabel = new javax.swing.JLabel();
		distance = new javax.swing.JLabel();
		distancefield = new javax.swing.JTextField();
		displayDisance = new javax.swing.JButton();
		profitTestField = new javax.swing.JTextField();
		profitLabel = new javax.swing.JLabel();
		displayProfit = new javax.swing.JButton();
		customerScrollPane = new javax.swing.JScrollPane();
		customerTable = new javax.swing.JTable();
		pizzaScrollPane = new javax.swing.JScrollPane();
		pizzaTable = new javax.swing.JTable();
		
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
        
		jPanel1.setBackground(new java.awt.Color(102, 102, 102));
		jPanel1.setForeground(new java.awt.Color(102, 102, 102));

		jPanel2.setForeground(new java.awt.Color(255, 255, 255));
		
        logFilename.setText("Log your file...");
		
        

		selectFilelabel.setText("Select File");
		

		browseBtn.setText("Browse");
		
		browseBtn.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent act){
			browseBtnfunctionPerform(act);
			}
		});

		displayInfoBtn.setBackground(new Color(0, 255, 255));
        displayInfoBtn.setFont(new Font("Arial Rounded MT Bold", 0, 16)); 
        displayInfoBtn.setForeground(new Color(102, 102, 0));
		displayInfoBtn.setText("Display Information");
		displayInfoBtn.setEnabled(false);
		displayInfoBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent act) {
				displayInfoBtnActionPerformed(act);
			}
		});
		
		clearInfoBtn.setBackground(new Color(153, 255, 153));
		clearInfoBtn.setFont(new Font("Tempus Sans ITC", 0, 16)); 
        clearInfoBtn.setForeground(new Color(51, 0, 255));
		clearInfoBtn.setText("Clear Information");
		clearInfoBtn.setEnabled(false);
		clearInfoBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent act) {
				clearInfoBtnActionPerformed(act);
			}
		});
		
		profitLabel.setText("Total Profit");

		displayProfit.setText("Display");
		displayProfit.setEnabled(false);
		displayProfit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent act) {
				displayProfitActionPerformed(act);
			}
		});
		
		distance.setText("Total Distance");

		displayDisance.setText("Display");
		displayDisance.setEnabled(false);
		displayDisance.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent act) {
				displayDisanceActionPerformed(act);
			}
		});

		customerScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Customerdetail"));

		customerTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Customer Name", "Mobile Number", "Customer Type", "X and Y Location",
				"Distance from Restaurant" }));
		customerScrollPane.setViewportView(customerTable);

		pizzaScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder("Pizzadetail "));

		pizzaTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Pizza Type", "Quantity", "Order Price", "Order Cost", "Order Profit" }));
		pizzaScrollPane.setViewportView(pizzaTable);
		
		// Panel 2 
		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(selectFilelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(distance, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addComponent(profitLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(profitTestField, javax.swing.GroupLayout.DEFAULT_SIZE, 151,
										Short.MAX_VALUE)
								.addComponent(logFilename).addComponent(distancefield))
						.addGap(31, 31, 31)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(browseBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(displayDisance, javax.swing.GroupLayout.DEFAULT_SIZE, 164,
										Short.MAX_VALUE)
								.addComponent(displayProfit, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addComponent(displayInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 158,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(48, 48, 48).addComponent(clearInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(35, Short.MAX_VALUE)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup().addGap(30, 30, 30)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(selectFilelabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(clearInfoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
								.addComponent(displayInfoBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(browseBtn, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(logFilename))
						.addGap(18, 18, 18)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(distance, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(distancefield).addComponent(displayDisance,
										javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(profitTestField)
								.addComponent(profitLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(displayProfit, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
						.addContainerGap()));
		// Panel 1
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jPanel2,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(customerScrollPane).addComponent(pizzaScrollPane));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18)
						.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
						.addComponent(customerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 116,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18).addComponent(pizzaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 129,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(38, 38, 38)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
		
		
		
		

		}
	
	private void browseBtnfunctionPerform(java.awt.event.ActionEvent act){
		browseBtn.setEnabled(false);
		clearInfoBtn.setEnabled(true);
		displayInfoBtn.setEnabled(true);
		chooser.showOpenDialog(null);
		File data = chooser.getSelectedFile();
		String filename = data.getAbsolutePath();
		logFilename.setText(filename);
	}
	
	private void displayInfoBtnActionPerformed(java.awt.event.ActionEvent act){
		displayInfoBtn.setEnabled(false);
		displayProfit.setEnabled(true);
		displayDisance.setEnabled(true);

		DefaultTableModel customerModel = (DefaultTableModel) customerTable.getModel();
		DefaultTableModel pizzaModel = (DefaultTableModel) pizzaTable.getModel();

		try {
			restaurant.processLog(String.valueOf(logFilename.getText()));

			for (int index = 0; index < restaurant.getNumCustomerOrders(); index++) {
				Object customerData[] = new Object[5];
				customerData[0] = restaurant.getCustomerByIndex(index).getName();
				customerData[1] = restaurant.getCustomerByIndex(index).getMobileNumber();
				customerData[2] = restaurant.getCustomerByIndex(index).getCustomerType();
				customerData[3] = restaurant.getCustomerByIndex(index).getLocationX() + " , "
						+ restaurant.getCustomerByIndex(index).getLocationY();
				customerData[4] = restaurant.getCustomerByIndex(index).getDeliveryDistance();
				customerModel.addRow(customerData);
			}

			for (int index = 0; index < restaurant.getNumPizzaOrders(); index++) {
				Object pizzaData[] = new Object[5];
				pizzaData[0] = restaurant.getPizzaByIndex(index).getPizzaType();
				pizzaData[1] = restaurant.getPizzaByIndex(index).getQuantity();
				pizzaData[2] = restaurant.getPizzaByIndex(index).getOrderPrice();
				pizzaData[3] = restaurant.getPizzaByIndex(index).getOrderCost();
				pizzaData[4] = restaurant.getPizzaByIndex(index).getOrderProfit();
				pizzaModel.addRow(pizzaData);
			}

		} catch (CustomerException | PizzaException | LogHandlerException e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	private void clearInfoBtnActionPerformed(java.awt.event.ActionEvent act){
		customerTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {}, new String[] {
				"Customer Name", "Mobile Number", "Customer Type", "X and Y Location", "Distance from Restaurant" }));
		pizzaTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {},
				new String[] { "Pizza Type", "Quantity", "Order Price", "Order Cost", "Order Profit" }));
		jPanel2.add(browseBtn);
		jPanel2.add(displayInfoBtn);
		jPanel2.add(displayDisance);
		jPanel2.add(displayProfit);
		logFilename.setText(null);
		distancefield.setText(null);
		profitTestField.setText(null);
		browseBtn.setEnabled(true);
		clearInfoBtn.setEnabled(false);
		displayProfit.setEnabled(false);
		displayDisance.setEnabled(false);
		restaurant.resetDetails();
	}
	
	private void displayProfitActionPerformed(java.awt.event.ActionEvent act){
		displayProfit.setEnabled(false);
		try {
			restaurant.processLog(String.valueOf(logFilename.getText()));
			profitTestField.setText(String.valueOf(restaurant.getTotalProfit()));
		} catch (CustomerException | PizzaException | LogHandlerException e) {
			JOptionPane.showMessageDialog(null, e);
			profitTestField.setText(null);
		}
	}
	
	private void displayDisanceActionPerformed(java.awt.event.ActionEvent act){
		displayDisance.setEnabled(false);
		try {
			restaurant.processLog(String.valueOf(logFilename.getText()));
			distancefield.setText(String.valueOf(restaurant.getTotalDeliveryDistance()));
		} catch (CustomerException | PizzaException | LogHandlerException e) {
			JOptionPane.showMessageDialog(null, e);
			distancefield.setText(null);
		}
	}
	
	
        
		
        

        
        
        public static void main(String[] args) {
        	JFrame.setDefaultLookAndFeelDecorated(true);
            SwingUtilities.invokeLater(new PizzaGUI("Pizaa place"));
    	}
	
	
	@Override
	public void run() {
		// TO DO
		setupGUI();
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PizzaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PizzaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PizzaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PizzaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PizzaGUI("Pizza hut").setVisible(true);
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}






	

}
