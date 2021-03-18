import javax.swing.*;
import java.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductGUI extends JFrame {
// Number of products available.
	int availableProducts = 5;

	int selected;

	// creating a list of products to be displayed, initialisation.
	Product[] product = new Product[10];

	// Making an array of item, initialisation.
	String[] itemString = new String[10];

	// All Tabs initialised.
	JTabbedPane tabbedPane = new JTabbedPane();

	// All panels initialised.
	JPanel restock_Panel = new JPanel(new FlowLayout());
	JPanel setprice_Panel = new JPanel();
	JPanel sell_Panel = new JPanel();
	JPanel add_Panel = new JPanel();

// First panel (Re-stock) Labels, Button & ComboBox initialised.
	JButton updateStock_button = new JButton("Update Stock Level");
	JLabel labelStocklevelQuantity_restock = new JLabel("Stock Level Quantity:");
	JLabel labelNewStock_restock = new JLabel("Enter New Stock:");
	JLabel labelcomboBox_restock = new JLabel("Select item from the list below");
	JComboBox comboBox_restock = new JComboBox();
	// First panel (Re-stock) Text initialised.	
	JTextField textStocklevelQuantity_restock = new JTextField();
	JTextField textNewStock_restock = new JTextField();

// Second panel (Set Price) labels, Button  & ComboBox initialised.	
	JButton setPrice_button = new JButton("Set New Price");
	JLabel labelActualPrice_setprice = new JLabel("Actual Price:");
	JLabel labelNewPrice_setprice = new JLabel("Enter New Price:");
	JLabel labelcomboBox_setprice = new JLabel("Select item from the list below");
	JComboBox comboBox_setprice = new JComboBox();
	// Second panel (Set Price) Text initialised.	
	JTextField textActualPrice_setprice = new JTextField();
	JTextField textNewPrice_setprice = new JTextField();

// Third panel (Sell) labels, Button & ComboBox initialised.	
	JButton calculatePrice_button = new JButton("Calculate Price");
	JButton sell_button = new JButton("Sell");
	JLabel labelCurrentStock_sell = new JLabel("Current Stock:");
	JLabel labelQuantitytoBuy_sell = new JLabel("Enter Quantity to Buy:");
	JLabel labelPrice_sell = new JLabel("Price Per Item:");
	JLabel labeltotal_sell = new JLabel("Total:");	
	JLabel labelcomboBox_sell = new JLabel("Select item from the list below");
	JComboBox comboBox_sell = new JComboBox();
	// Third panel (Sell) Text initialised.
	JTextField textCurrentStock_sell = new JTextField();
	JTextField textQuantitytoBuy_sell = new JTextField();
	JTextField textPrice_sell = new JTextField();
	JTextField texttotal_sell = new JTextField();

// Fourth panel (Add) labels, Button & ComboBox initialised.	
	JButton addProduct_button = new JButton("Add Product");
	JLabel labelStocklevelQuantity_add = new JLabel("Enter New Stock Level Quantity:");
	JLabel labelNewProductName_add = new JLabel("Enter New Product Name:");
	JLabel labelPrice_add = new JLabel("Enter Price:");
	// Fourth panel (Add) Text initialised.
	JTextField textStocklevelQuantity_add = new JTextField();
	JTextField textNewProductName_add = new JTextField();
	JTextField textPrice_add = new JTextField();


	public void UpdateComboBox() 
	{
		String itemString2;
		// For same products to be updated in all comboBoxes.
		for (int i = 0; i < availableProducts; i++) 
		{
			itemString2 = product[i].getName();
			comboBox_restock.addItem(itemString2);
			comboBox_setprice.addItem(itemString2);
			comboBox_sell.addItem(itemString2);
		}
	}

	// Adding Product.
	public void AddProducts() 
	{
		product[0] = new Product("Samsung", 10, 100);
		product[1] = new Product("iPhone", 15, 120);
		product[2] = new Product("Nokia", 20, 140);
		product[3] = new Product("Huawei", 25, 160);
		product[4] = new Product("Sony", 30, 180);
	}

	public ProductGUI() 
	{
		//Adding products and updating/refreshing combo box		
		AddProducts();
		UpdateComboBox();

		// Frame setup details
		setTitle("Roheel Islam, 1925979");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600,400);
		setLocation(600,250);
		setVisible(true);

// First panel (Re-stock) labels, text & ComboBox sizes initialised.	
		restock_Panel.setLayout(null);
		updateStock_button.setBounds(200, 250, 150, 40);
		labelStocklevelQuantity_restock.setBounds(300, 20, 120, 50);
		textStocklevelQuantity_restock.setBounds(430, 30, 100, 30);
		textStocklevelQuantity_restock.setEditable(false);		// Not edit it all.
		labelNewStock_restock.setBounds(300, 120, 120, 50);
		textNewStock_restock.setBounds(430, 130, 100, 30);
		labelcomboBox_restock.setBounds(55, 20, 175, 50);
		comboBox_restock.setBounds(90, 60, 100, 30);
		// Adding Button.
		restock_Panel.add(updateStock_button);
		// Adding Label
		restock_Panel.add(labelStocklevelQuantity_restock);
		restock_Panel.add(labelNewStock_restock);
		// Adding Text				
		restock_Panel.add(textStocklevelQuantity_restock);
		restock_Panel.add(textNewStock_restock);
		// Adding ComboBox			
		restock_Panel.add(comboBox_restock);
		restock_Panel.add(labelcomboBox_restock); 
		// Testing a Combo box performing action.
		comboBox_restock.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					selected = comboBox_restock.getSelectedIndex();
				}
				
				catch(Exception ee) 
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});

// Second panel (Set Price) labels & text sizes initialised.	
		setprice_Panel.setLayout(null);
		setPrice_button.setBounds(200, 250, 150, 40);
		labelActualPrice_setprice.setBounds(300, 20, 120, 50);
		textActualPrice_setprice.setBounds(430, 30, 100, 30);
		labelNewPrice_setprice.setBounds(300, 120, 120, 50);
		textNewPrice_setprice.setBounds(430, 130, 100, 30);
		textActualPrice_setprice.setEditable(false);		// Not edit it all.
		labelcomboBox_setprice.setBounds(55, 20, 175, 50);
		comboBox_setprice.setBounds(90, 60, 100, 30);
		// Adding Button		
		setprice_Panel.add(setPrice_button);
		// Adding Label
		setprice_Panel.add(labelActualPrice_setprice);
		setprice_Panel.add(labelNewPrice_setprice);
		// Adding Text
		setprice_Panel.add(textActualPrice_setprice);
		setprice_Panel.add(textNewPrice_setprice);
		// Adding Combo Box			
		setprice_Panel.add(comboBox_setprice);
		setprice_Panel.add(labelcomboBox_setprice);

// Third panel (Sell) labels & text sizes initialised.		
		sell_Panel.setLayout(null);
		calculatePrice_button.setBounds(200, 200, 150, 40);
		sell_button.setBounds(200, 250, 150, 40);
		labelCurrentStock_sell.setBounds(300, 20, 120, 50);		
		textCurrentStock_sell.setBounds(430, 30, 100, 30);
		textCurrentStock_sell.setEditable(false);			// Not edit it all.
		labelQuantitytoBuy_sell.setBounds(300, 70, 130, 50);
		textQuantitytoBuy_sell.setBounds(430, 80, 100, 30);
		labelPrice_sell.setBounds(300, 120, 85, 50);
		textPrice_sell.setBounds(430, 130, 100, 30);
		textPrice_sell.setEditable(false);					// Not edit it all.		
		labeltotal_sell.setBounds(40, 120, 50, 50);
		texttotal_sell.setBounds(90, 130, 100, 30);
		texttotal_sell.setEditable(false);					// Not edit it all.	
		labelcomboBox_sell.setBounds(55, 20, 175, 50);
		comboBox_sell.setBounds(90, 60, 100, 30);
		// Adding Button			
		sell_Panel.add(sell_button);
		sell_Panel.add(calculatePrice_button);
		// Adding Label
		sell_Panel.add(labelCurrentStock_sell);
		sell_Panel.add(labelQuantitytoBuy_sell);
		sell_Panel.add(labelPrice_sell);
		sell_Panel.add(labeltotal_sell);
		// Adding Text
		sell_Panel.add(textCurrentStock_sell);
		sell_Panel.add(textQuantitytoBuy_sell);
		sell_Panel.add(textPrice_sell);
		sell_Panel.add(texttotal_sell);
		// Adding Combo Box			
		sell_Panel.add(comboBox_sell);
		sell_Panel.add(labelcomboBox_sell);

// Fourth panel (Add) labels & text sizes initialised.				
		add_Panel.setLayout(null);
		addProduct_button.setBounds(200, 250, 150, 40);
		labelStocklevelQuantity_add.setBounds(240, 20, 180, 50);
		textStocklevelQuantity_add.setBounds(430, 30, 100, 30);
		labelNewProductName_add.setBounds(240, 70, 180, 50);
		textNewProductName_add.setBounds(430, 80, 100, 30);
		labelPrice_add.setBounds(240, 120, 180, 50);
		textPrice_add.setBounds(430, 130, 100, 30);
		// Adding Button			
		add_Panel.add(addProduct_button);
		// Adding Label	
		add_Panel.add(labelStocklevelQuantity_add);
		add_Panel.add(labelNewProductName_add);
		add_Panel.add(labelPrice_add);
		// Adding Text
		add_Panel.add(textStocklevelQuantity_add);
		add_Panel.add(textNewProductName_add);
		add_Panel.add(textPrice_add);

		//Adding Tab panels	
		tabbedPane.add("Re-Stock", restock_Panel);
		tabbedPane.add("Set Price", setprice_Panel);
		tabbedPane.add("Sell", sell_Panel);
		tabbedPane.add("Add", add_Panel);
		add(tabbedPane);





// First panel (Re-stock) ComboBox is changing each item and producing relevant result. 
		comboBox_restock.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent arg0) 
			{
				try 
				{
					Object item = comboBox_restock.getSelectedItem();
					String stock = item.toString();												//converting item data type to string.
					int stock1 = 0;
					
					for (int i = 0; i < availableProducts; i++) 
					{																			//iterating on each product to get stock level.
						if (product[i].getName().equals(stock)) 
						{
							stock1 = product[i].getStockLevel();
							break;
						}
					}
					
					textStocklevelQuantity_restock.setText(String.valueOf(stock1));				//setting the stock level quantity by converting the integer to string.
					validate();																	//checking the validity of method arguments
					repaint();																	// clears/repaints/refresh the window.
				}
				catch(Exception ee) 
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});

// First panel (Re-stock) adding "Update Stock Level" buttons action listener.
		updateStock_button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					char[] ch = textNewStock_restock.getText().toString().trim().toCharArray();
					int len= ch.length;																		// checking if there is any alphabets in set price.
					int len2=0;
					
					for (int i=0; i<len; i++)
					{
						if (Character.isDigit(ch[i]))														// i is indexing in each character on array ch.
						{
							len2++;	
						}	
					}
					
					char[] ch2= textStocklevelQuantity_restock.getText().toString().trim().toCharArray();  //checking each character in the box.
					int len22= ch2.length;
					int len222=0;
					
					for (int i=0; i<len22; i++)
					{	
						if (Character.isDigit(ch2[i]))
						{
							len222++;	
						}	
					}

					int emp=0;																				// if the box is empty than show error message dialogue box.

					if (textNewStock_restock.getText().toString().trim().equals("") || textStocklevelQuantity_restock.getText().toString().trim().equals(""))
					{
						emp++;
					}

					if (!(len2==len) || !(len22==len222) || !(emp==0))
					{
						JOptionPane.showMessageDialog(null, "Incorrect Values Entered! \n" 
								+ "Select an item or Enter Numbers Only!" );
					}

					else
					{
						int s = Integer.parseInt(textNewStock_restock.getText().toString().trim());   	// to convert string to int and double used "parseInt/double"
						JOptionPane.showMessageDialog(null, "New Stock Level " + s + " has been updated successfully.");
						product[selected].reStock(Integer.parseInt(textNewStock_restock.getText()));
						textStocklevelQuantity_restock.setText(String.valueOf(product[selected].getStockLevel()));
					}
				}
				
				catch(Exception ee) 
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});


// Second panel (Set Price) ComboBox is changing each item and producing relevant result. 
		comboBox_setprice.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent arg0) 
			{
				try 
				{
					Object item = comboBox_setprice.getSelectedItem(); 							//Getting selected items from java comboBox.
					String s = item.toString();
					double st2 = 0;
					
					for (int i = 0; i < availableProducts; i++) 
					{
						if (product[i].getName().equals(s)) 
						{
							st2 = product[i].getPrice(); 										// To get price from each item.
							break;
						}
					}
					
					textActualPrice_setprice.setText(String.valueOf(st2)); 						//setting the actualPrice quantity by converting the integer to string.
					validate();
					repaint();
				}
				
				catch(Exception ee) 
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});

// Second panel (Set Price) adding "Set New Price" buttons action listener.
		setPrice_button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					char[] ch = textNewPrice_setprice.getText().toString().trim().toCharArray();
					int len= ch.length; 							// checking if there is any alphabets in set price.
					int len2=0;
					int point=0;									// checking if there any unusual decimal while setting the price only 1 or 0 decimal is allowed.
					
					for (int i =0;i<len;i++)
					{
						if (Character.isDigit(ch[i]))   			 // i is indexing in each character on array ch.
						{
							len2++;	
						}	

						else if (ch[i]=='.')						// checking if there is any decimal in set price.
						{point++;}
					}

					if (len2>0 && point ==1)
					{
						len2++;
					}

					char[] ch2= textActualPrice_setprice.getText().toString().trim().toCharArray();
					int len22= ch2.length;
					int len222=1;
					
					for (int i =0; i<len22; i++)
					{
						if (Character.isDigit(ch2[i]))
						{
							len222++;	
						}	
					}	

					int emp=0;

					if (textNewPrice_setprice.getText().toString().trim().equals("")||textActualPrice_setprice.getText().toString().trim().equals(""))
					{
						emp++;
					}
					
					if (!(len2==len) || !(len22==len222)|| !(emp==0))
					{
						JOptionPane.showMessageDialog(null, "Incorrect Values Entered! \n" 
								+ "Select an item or Enter Numbers only!" );
					}		
					
					else
					{	
						Object item = comboBox_setprice.getSelectedItem();
						double p= Double.parseDouble(textNewPrice_setprice.getText().toString().trim()); 	// Converting it to double and getting text
						
						String s = item.toString();
						double st = 0;
						
						for (int i = 0; i < availableProducts; i++)
						{
							if (product[i].getName().equals(s))
							{
								product[i].setPrice(p);
								break;
							}
						}
						
						JOptionPane.showMessageDialog(null, "The New price " + p + " has been set successfully.");
						textActualPrice_setprice.setText(String.valueOf(p));
						validate();
						repaint();
					}
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});


// Third panel (Sell) ComboBox is changing each item and producing relevant result. 
		comboBox_sell.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent arg0)
			{
				try 
				{
					Object item = comboBox_sell.getSelectedItem(); 		            //ComboBox picking up the clicked item.
					String s = item.toString();
					int st = 0;
					double st2 = 0;
					
					for (int i = 0; i < availableProducts; i++)
					{
						if (product[i].getName().equals(s))
						{
							st = product[i].getStockLevel();
							st2 = product[i].getPrice();
							break;
						}
					}
					
					textCurrentStock_sell.setText(String.valueOf(st));
					textPrice_sell.setText(String.valueOf(st2));
					validate();
					repaint();
				}
				
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});

// Third panel (Sell) adding "Calculate Price" buttons action listener.
		calculatePrice_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					char[] ch = textQuantitytoBuy_sell.getText().toString().trim().toCharArray();

					int len= ch.length;
					int len2=0;
					
					for (int i =0;i<len;i++)
					{
						if (Character.isDigit(ch[i]))
						{
							len2++;	
						}	
					}
					
					char[] ch2= textPrice_sell.getText().toString().trim().toCharArray();
					int len22= ch2.length;
					int len222=1;
					
					for (int i =0;i<len22;i++)
					{
						if (Character.isDigit(ch2[i]))
						{
							len222++;	
						}	
					}
					
					int emp=0; 	
					
					if (textQuantitytoBuy_sell.getText().toString().trim().equals("")||textPrice_sell.getText().toString().trim().equals(""))
					{
						emp++;
					}

					if (!(len2==len) || !(len22==len222)|| !(emp==0))
					{
						JOptionPane.showMessageDialog(null, "Incorrect Values Entered! \n" 
								+ "Select an item or Enter Numbers only!" );
					}
					
					else {

						String item2 = textQuantitytoBuy_sell.getText().toString().trim();
						JOptionPane.showMessageDialog(null, "Showing the Total Price for " + item2 +" Items.");
						String s = item2.toString();
						Object item = comboBox_sell.getSelectedItem();
						String s2 = item.toString();
						double st = 0;
						
						for (int i = 0; i < availableProducts; i++)
						{
							if (product[i].getName().equals(s2))
							{
								st = product[i].getPrice();
								break;
							}
						}
						
						double newPrice = Integer.parseInt(item2) * st;
						texttotal_sell.setText(String.valueOf(newPrice));
						validate();
						repaint();
					}
				}
				
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});

// Third panel (Sell) adding "Sell" buttons action listener.
		sell_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					char[] ch = textQuantitytoBuy_sell.getText().toString().trim().toCharArray();
					int len= ch.length;
					int len2=0;
					
					for (int i =0;i<len;i++)
					{
						if (Character.isDigit(ch[i]))
						{
							len2++;	
						}	
					}

					int check=0;
					int emp=0;

					if (textQuantitytoBuy_sell.getText().toString().trim().equals("")||textCurrentStock_sell.getText().toString().trim().equals("")
							||textPrice_sell.getText().toString().trim().equals(""))
					{
						emp++;
						check=1;
					}
					
					if (emp==0 && (len2==len))
					{
						int QTB=Integer.parseInt(textQuantitytoBuy_sell.getText().toString().trim());
						int CS= Integer.parseInt(textCurrentStock_sell.getText().toString().trim());

						if (CS < QTB)
						{
							JOptionPane.showMessageDialog(null, "The Current Stock cannot be less than the Quantity to buy!\n"
									+ "                       Enter the valid Quantity to Buy." );
							check=1;				
						}
					}

					char[] ch2= textPrice_sell.getText().toString().trim().toCharArray();	//textPrice_sell
					int len22= ch2.length;
					int len222=1;
					
					for (int i =0;i<len22;i++)
					{				
						if (Character.isDigit(ch2[i]))
						{
							len222++;	
						}	
					}
					
					char[] ch3= textCurrentStock_sell.getText().toString().trim().toCharArray();
					int len2222= ch3.length;
					int len22222=0;
					
					for (int i =0;i<len2222;i++)
					{				
						if (Character.isDigit(ch3[i]))
						{
							len22222++;	
						}	
					}

					if (!(len2==len) || !(len22==len222)  || !(len2222==len22222) || !(emp==0))
					{
						JOptionPane.showMessageDialog(null, "Incorrect Values Entered! \n" 
								+ "Select an item or Enter Numbers only!" );
					}
					
					else if (check==1) 
					{	
						//Do nothing 
					}
					
					else
					{
						Object item = comboBox_sell.getSelectedItem();
						String s3 = item.toString();
						int s = Integer.parseInt(textQuantitytoBuy_sell.getText().toString().trim());   //setting the text quality by converting the integer to string.
						int s2 =0;
						double st = 0;
						int k=0;
						
						for (int i = 0; i < availableProducts; i++) 
						{
							if (product[i].getName().equals(s3)) 
							{

								s2=product[i].getStockLevel();
								k=i;
								break;
							}
						}
						
						double newPrice = Double.parseDouble(textPrice_sell.getText().toString().trim())*s;
						texttotal_sell.setText(String.valueOf(newPrice)); 								// to convert in int and double in string use value of stock.				
						JOptionPane.showMessageDialog(null,"Quantity Sold " + s + "." +  "\nDeducting " 
						+ s +" from the Current stock " + s2 + "." + "\nTotal Cost £" + newPrice);		// null is used to keep it independent from any frame.
						s=0-s;																			// converting stock value in minus.
						textCurrentStock_sell.setText(String.valueOf(s2+s)); 							//setting the current stock to the remaining value.
						product[k].reStock(s);															// re-stocking the minus value in the stock to add in re-stock function.
						validate();
						repaint();
					}
				}
				
				catch(Exception ee) 
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});


// Fourth panel (Add) adding "Add Product" buttons action listener
		addProduct_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					int emp=0;
					
					if (textPrice_add.getText().toString().trim().equals("")||textStocklevelQuantity_add.getText().toString().trim().equals("")
							||textNewProductName_add.getText().toString().trim().equals(""))
					{
						emp++;
					}

					char[] ch = textPrice_add.getText().toString().trim().toCharArray();
					int len= ch.length;
					int len2=0;
					int point=0;
					
					for (int i =0;i<len;i++)
					{
						if (Character.isDigit(ch[i]))
						{
							len2++;	
						}	
						else if (ch[i]=='.')
						{point++;}
					}

					if (len2>0 && point ==1)
					{
						len2++;
					}	
					
					char[] ch2= textStocklevelQuantity_add.getText().toString().trim().toCharArray();
					int len22= ch2.length;
					int len222=0;
					
					for (int i =0;i<len22;i++)
					{
						if (Character.isDigit(ch2[i]))
						{
							len222++;	
						}	
					}
					
					String newNameString = textNewProductName_add.getText().toString().trim();
					int pr=0;
					
					for (int i =0; i<availableProducts; i++)
					{
						if (product[i].getName().equals(newNameString))
						{
							JOptionPane.showMessageDialog(null,"Product already present");
							pr++;
						}		
					}

					if (!(len2==len) || !(len22==len222)|| !(emp==0)|| !(pr==0))
					{
						JOptionPane.showMessageDialog(null,"Incorrect Values Entered! \n" 
								+ "Enter Numbers only for New Stock Level Quantity and Price.");
					}

					else
					{
						if (availableProducts < 10)
						{
							int newStocklevel = Integer.parseInt(textStocklevelQuantity_add.getText().toString().trim());
							Double newPrice = Double.parseDouble(textPrice_add.getText().toString().trim());
							product[availableProducts] = new Product(newNameString, newStocklevel, newPrice);	// adding a new product in the list of already available products
							availableProducts++; 																// incrementing the number of products available
							
							JOptionPane.showMessageDialog(null, "PRODUCT NAME: " + newNameString + "\nQUANTITY: "+ newStocklevel 
									+ "\nPRICE: " + newPrice +" has been Sucessfully added.");
							
							comboBox_restock.addItem(newNameString);
							comboBox_setprice.addItem(newNameString);
							comboBox_sell.addItem(newNameString);
							validate();
							repaint();
						} 
						
						else
						{
							// this Checks if the number of products reach 10 , it cannot add further products.
							JOptionPane.showMessageDialog(null, "The Products list is full and reached to its maximum limit.");
						}
					}
				}
				
				catch(Exception ee) 
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});
	}

	public static void main(String[] args)
	{
		try
		{
			new ProductGUI();	
		}
		
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}	
}