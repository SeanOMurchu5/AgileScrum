package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Font;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class View {

	public View() {

	}

	// JPanels and Frames ..etc
	JPanel homePanel = new JPanel(new MigLayout());
	JPanel StockControlPanel = new JPanel(new MigLayout());
	JPanel addItemsPanel = new JPanel(new MigLayout("debug", "fill"));
	JPanel viewItemsPanel = new JPanel(new MigLayout());
	JPanel ShoppingBasketPanel = new JPanel(new MigLayout("fill"));
	JPanel ChangeCalculatorPanel = new JPanel(new MigLayout("fill"));
	JPanel ItemPackingPanel = new JPanel(new MigLayout());
	JPanel addBoxPanel = new JPanel(new MigLayout());
	JPanel itemDimensionsPanel = new JPanel(new MigLayout());

	JPanel topBar = new JPanel(new MigLayout("fill"));
	JSplitPane sp = new JSplitPane(SwingConstants.HORIZONTAL, topBar, homePanel);
	JButton homePanelBTN = new JButton("Home");
	JButton stockControlButton = new JButton("Stock Control");
	JButton shoppingBasketButton = new JButton("Shopping Basket");
	JButton changeCalculatorButton = new JButton("Change Calculator");
	JButton itemPackingButton = new JButton("Item Packing");

	
	//Home Panel
	JLabel HomePageLabel = new JLabel("Home Page");
	JLabel HomeDescLabel = new JLabel("This is a generic home page for a Business");

	// Stock Control Panel
	JButton addItemsBTN = new JButton("Add item");
	JButton viewItemsBTN = new JButton("View all items");

	// add items panel
	String itemTypeArr[] = { "Luxury", "Essential", "Gift" };
	JLabel itemNameHeader = new JLabel("Item Name");
	JTextField itemNameTF = new JTextField(20);
	JLabel itemTypeHeader = new JLabel("Item Type");
	JComboBox itemTypeCB = new JComboBox(itemTypeArr);
	JLabel expirationDateHeader = new JLabel("Expiration date");
	JLabel yearHeader = new JLabel("year");
	JLabel monthHeader = new JLabel("month");
	JLabel dayHeader = new JLabel("day");
	JTextField yearTF = new JTextField(4);
	JTextField monthTF = new JTextField(2);
	JTextField dayTF = new JTextField(2);
	JButton submitItemBTN = new JButton("add");
	JButton returnToItemsBTN = new JButton("return");

	// View items panel
	ArrayList<String> itemListArr = new ArrayList<String>();
	JComboBox itemListCB = new JComboBox(itemListArr.toArray());
	JButton removeItemBTN = new JButton("Remove");
	JButton refreshListBTN = new JButton("Refresh");

	// Item packaging panel
	JLabel boxesDimensionsLabel = new JLabel("Box Dimensions");
	JLabel itemDimensionsLabel = new JLabel("Item Dimensions");
	JLabel numItemsLabel = new JLabel("Number of items");
	JButton boxDimensionsBTN = new JButton("Enter Box Dimensions");
	JButton itemDimensionsBTN = new JButton("Enter Item Dimensions");
	JSpinner numItemsSpinner = new JSpinner();

	// addBox panel
	JLabel boxHeader = new JLabel("Add the dimensions and weight of the new box");
	JLabel weightLabel = new JLabel("Weight (cm):");
	JLabel lengthLabel = new JLabel("Length (cm):");
	JLabel widthLabel = new JLabel("Width (cm):");
	JLabel depthLabel = new JLabel("Depth (cm):");
	JSpinner weightSpinner = new JSpinner();
	JSpinner lengthSpinner = new JSpinner();
	JSpinner widthSpinner = new JSpinner();
	JSpinner depthSpinner = new JSpinner();
	JButton addBoxBTN = new JButton("Add Box");

	// Customer registration table
	JLabel orderHPage = new JLabel("Order History");
	
	
	//ItemDimensions Panel
	JLabel ItemDimensionsHeader = new JLabel("Item Dimensions");
	JLabel enterDimensionsHeader = new JLabel("Enter Dimensions:");
	Object[] columns = { "Item","Width", "Length", "Depth" ,"weight"};
	DefaultTableModel dtmodel = new DefaultTableModel();
	JTable table = new JTable();
	JButton itemsSubmitBTN = new JButton("Submit");
	JLabel numBoxesLabel = new JLabel("Number of boxes required for these items: ");
	JLabel numBoxesNumberLabel = new JLabel("0");
	
	
	//Calculator Panel
	 JLabel calcLabel = new JLabel("Calcualtor");
	 JLabel totalLabel = new JLabel("Enter basket total: € ");
	 JLabel amountLabel = new JLabel("Enter amount paid: €");
	 JTextField	basketTextField = new JTextField();
	 JTextField amountTextField  = new JTextField();	 
     JLabel headingLabel = new JLabel("Calculator Page");
	 JTextField calculateTextField = new JTextField();
	 JButton calculateButton = new JButton("Calculate");
	 JButton clearButton = new JButton("Clear All");
	 JLabel JL50 = new JLabel("Number of 50s:");
	 JLabel JL20 = new JLabel("Number of 20s:");
	 JLabel JL10 = new JLabel("Number of 10s:");
	 JLabel JL5 = new JLabel("Number of 5s:");
	 JLabel JL1 = new JLabel("Number of 1s:");
	 JLabel JL50c = new JLabel("Number of .50s:");
	 JLabel JL20c = new JLabel("Number of .20s:");
	 JLabel JL10c= new JLabel("Number of .10cs:");
	 JLabel JL5c = new JLabel("Number of .05cs:");
	 JLabel JL1c = new JLabel("Number of .01cs:");

	 JTextField TF50 = new JTextField("");
	 JTextField TF20 = new JTextField("");
	 JTextField TF10 = new JTextField("");
	 JTextField TF5 = new JTextField("");
	 JTextField TF1 = new JTextField("");
	 JTextField TF50c = new JTextField("");
	 JTextField TF20c = new JTextField("");
	 JTextField TF10c= new JTextField("");
	 JTextField TF5c = new JTextField("");
	 JTextField TF1c = new JTextField("");





	 
	 //Shopping Basket Panel
     String[] items = {"Luxury", "Essential", "Gift"};
     String[] quantity = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

     JLabel headerLabel = new JLabel("Shopping Basket");
	 JLabel itemLabel = new JLabel("Enter an item you wish to purchase: ");
	 JButton submitButton = new JButton("SUBMIT");;
	 ImageIcon imageIcon = new ImageIcon();
	 
	 JButton basketButton  = new JButton("Add to basket");

	 JLabel imageLabel = new JLabel(imageIcon);
	String imageString = "cart.jpg";
		
	// event e = new event();
	// tax t = new tax();
	 JLabel quantityLabel = new JLabel("Enter Quantity: ");
	 JComboBox itemComboBox  = new JComboBox(items);
	 JComboBox quantityComboBox = new JComboBox(quantity);
	 JTextArea textarea = new JTextArea("", 5, 30);
	 JLabel textAreaLabel;
     JButton shoppingCalculateButton;

	public void projectView() {
		String systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();

		try {
			UIManager.setLookAndFeel(systemLookAndFeelClassName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// JFrame
		JFrame frame = new JFrame("main");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new MigLayout("fill"));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		topBar.setBackground(Color.BLACK);

		topBar.add(homePanelBTN,"grow");
		topBar.add(stockControlButton, "grow");
		topBar.add(shoppingBasketButton, "grow");
		topBar.add(changeCalculatorButton, "grow");
		topBar.add(itemPackingButton, "span 3, grow");

		//home panel
		homePanel.setBackground(Color.GREEN);

		homePanel.add(HomePageLabel,"wrap");
		homePanel.add(HomeDescLabel);

		
		// Stock Control Panel
		StockControlPanel.setBackground(Color.GREEN);

		StockControlPanel.add(addItemsBTN);
		StockControlPanel.add(viewItemsBTN);

		// Add items Panel
		addItemsPanel.setBackground(Color.GREEN);

		addItemsPanel.add(itemNameHeader);
		addItemsPanel.add(itemNameTF);
		addItemsPanel.add(itemTypeHeader);
		addItemsPanel.add(itemTypeCB, "wrap");
		addItemsPanel.add(expirationDateHeader, "span,split 7");
		addItemsPanel.add(dayHeader);
		addItemsPanel.add(dayTF);

		addItemsPanel.add(monthHeader);
		addItemsPanel.add(monthTF);

		addItemsPanel.add(yearHeader);
		addItemsPanel.add(yearTF, "wrap");
		addItemsPanel.add(submitItemBTN);
		addItemsPanel.add(returnToItemsBTN);

		// ViewItemsPanel
		viewItemsPanel.setBackground(Color.GREEN);
		viewItemsPanel.add(itemListCB);
		viewItemsPanel.add(removeItemBTN);
		
		//ShoppingBasketPanel
		JComboBox comboBox;
		viewItemsPanel.add(refreshListBTN);

		// ItemPackingPanel
		
		JComponent numItemField = ((JSpinner.DefaultEditor) numItemsSpinner.getEditor());
		Dimension itemPrefSize = numItemField.getPreferredSize();
		itemPrefSize = new Dimension(100, itemPrefSize.height);
		numItemField.setPreferredSize(itemPrefSize);
		ItemPackingPanel.setBackground(Color.GREEN);

		ItemPackingPanel.add(boxesDimensionsLabel);
		ItemPackingPanel.add(boxDimensionsBTN, "grow,wrap");
		ItemPackingPanel.add(numItemsLabel);
		ItemPackingPanel.add(numItemsSpinner,"grow,wrap");
		ItemPackingPanel.add(itemDimensionsLabel);
		ItemPackingPanel.add(itemDimensionsBTN, "grow,wrap");
		
		// addBoxPanel

		JComponent weightfield = ((JSpinner.DefaultEditor) weightSpinner.getEditor());
		Dimension prefSize = weightfield.getPreferredSize();
		prefSize = new Dimension(100, prefSize.height);
		weightfield.setPreferredSize(prefSize);


		JComponent lengthField = ((JSpinner.DefaultEditor) lengthSpinner.getEditor());
		JComponent widthField = ((JSpinner.DefaultEditor) widthSpinner.getEditor());
		JComponent depthField = ((JSpinner.DefaultEditor) depthSpinner.getEditor());
		lengthField.setPreferredSize(prefSize);
		widthField.setPreferredSize(prefSize);
		depthField.setPreferredSize(prefSize);
		addBoxPanel.setBackground(Color.GREEN);

		addBoxPanel.add(boxHeader, "wrap");
		addBoxPanel.add(weightLabel);
		addBoxPanel.add(weightSpinner, "wrap");
		addBoxPanel.add(lengthLabel);
		addBoxPanel.add(lengthSpinner, "wrap");
		addBoxPanel.add(widthLabel);
		addBoxPanel.add(widthSpinner, "wrap");
		addBoxPanel.add(depthLabel);
		addBoxPanel.add(depthSpinner,"wrap");
		addBoxPanel.add(addBoxBTN,"span,align right");
		
		//ItemDimensionsPanel
		itemDimensionsPanel.setBackground(Color.GREEN);

		dtmodel.setColumnIdentifiers(columns);
		table.setModel(dtmodel);
		table.setRowHeight(30);
		itemDimensionsPanel.add(ItemDimensionsHeader, "wrap");
		itemDimensionsPanel.add(enterDimensionsHeader, "wrap");
		itemDimensionsPanel.add(table);
		itemDimensionsPanel.add(new JScrollPane(table));
		itemDimensionsPanel.add(numBoxesLabel);
		itemDimensionsPanel.add(numBoxesNumberLabel,"wrap");
		itemDimensionsPanel.add(itemsSubmitBTN,"span 1, align right");
		
		//CalculatorPanel
		ChangeCalculatorPanel.setBackground(Color.GREEN);
		ChangeCalculatorPanel.setLayout(new MigLayout(""));	
		headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		basketTextField.setColumns(10);
		amountTextField.setColumns(10);
		ChangeCalculatorPanel.add(headingLabel, "wrap");
		ChangeCalculatorPanel.add(totalLabel, "");
		ChangeCalculatorPanel.add(basketTextField, "wrap");
		
		ChangeCalculatorPanel.add(amountLabel, "");
		ChangeCalculatorPanel.add(amountTextField, "wrap");
		ChangeCalculatorPanel.add(clearButton);
		ChangeCalculatorPanel.add(calculateButton, "wrap");	
		
		ChangeCalculatorPanel.add(JL50,"");
		ChangeCalculatorPanel.add(TF50,"grow,wrap");

		ChangeCalculatorPanel.add(JL20,"");
		ChangeCalculatorPanel.add(TF20,"grow,wrap");

		ChangeCalculatorPanel.add(JL10,"");
		ChangeCalculatorPanel.add(TF10,"grow,wrap");

		ChangeCalculatorPanel.add(JL5,"");
		ChangeCalculatorPanel.add(TF5,"grow,wrap");

		ChangeCalculatorPanel.add(JL1,"");
		ChangeCalculatorPanel.add(TF1,"grow,wrap");

		ChangeCalculatorPanel.add(JL50c,"");
		ChangeCalculatorPanel.add(TF50c,"grow,wrap");

		ChangeCalculatorPanel.add(JL20c,"");
		ChangeCalculatorPanel.add(TF20c,"grow,wrap");

		ChangeCalculatorPanel.add(JL10c,"");
		ChangeCalculatorPanel.add(TF10c,"grow,wrap");

		ChangeCalculatorPanel.add(JL5c,"");
		ChangeCalculatorPanel.add(TF5c,"grow,wrap");

		ChangeCalculatorPanel.add(JL1c,"");
		ChangeCalculatorPanel.add(TF1c,"grow,wrap");






		
		
		//Basket Panel
		imageIcon =  new ImageIcon(
				new ImageIcon(imageString).getImage().getScaledInstance(200, 300, Image.SCALE_DEFAULT));
		imageLabel.setIcon(imageIcon);
		ShoppingBasketPanel.setBackground(Color.GREEN);
		ShoppingBasketPanel.setLayout(new MigLayout(""));
		headerLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ShoppingBasketPanel.add(headerLabel, "wrap");	
		ShoppingBasketPanel.add(itemLabel, "");	
		//itemComboBox.addActionListener(this);
		ShoppingBasketPanel.add(itemComboBox, "wrap");
		ShoppingBasketPanel.add(quantityLabel , " ");
		ShoppingBasketPanel.add(quantityComboBox , " wrap");
		ShoppingBasketPanel.add(submitButton, "wrap");
		ShoppingBasketPanel.add(textarea, "grow,wrap");

		ShoppingBasketPanel.add(imageLabel);
		

		
		// Frame
		frame.add(sp, "grow");
		frame.pack();
		frame.setSize(800, 600);
		frame.setResizable(false);
	}
}
