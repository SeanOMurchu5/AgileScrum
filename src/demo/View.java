package demo;

import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javafx.scene.text.Font;
import net.miginfocom.swing.MigLayout;

public class View {

	public View() {

	}

	// Jpanels and Frames ..etc
	JPanel home = new JPanel(new MigLayout("filly"));
	JPanel StockControlPanel = new JPanel(new MigLayout());
	JPanel addItemsPanel = new JPanel(new MigLayout("debug", "fill"));
	JPanel viewItemsPanel = new JPanel(new MigLayout());
	JPanel ShoppingBasketPanel = new JPanel(new MigLayout("fill"));
	JPanel ChangeCalculatorPanel = new JPanel(new MigLayout("fill"));
	JPanel ItemPackingPanel = new JPanel(new MigLayout());
	JPanel addBoxPanel = new JPanel(new MigLayout());
	JPanel itemDimensionsPanel = new JPanel(new MigLayout());

	JPanel topBar = new JPanel(new MigLayout("fill"));
	JSplitPane sp = new JSplitPane(SwingConstants.HORIZONTAL, topBar, home);
	JButton homeButton = new JButton("Home");
	JButton stockControlButton = new JButton("Stock Control");
	JButton shoppingBasketButton = new JButton("Shopping Basket");
	JButton changeCalculatorButton = new JButton("Change Calculator");
	JButton itemPackingButton = new JButton("Item Packing");

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
	JLabel heightLabel = new JLabel("Height (cm):");
	JLabel depthLabel = new JLabel("Depth (cm):");
	JSpinner weightSpinner = new JSpinner();
	JSpinner lengthSpinner = new JSpinner();
	JSpinner heightSpinner = new JSpinner();
	JSpinner depthSpinner = new JSpinner();
	JButton addBoxBTN = new JButton("Add Box");

	// Customer registration table
	JLabel orderHPage = new JLabel("Order History");
	
	
	//ItemDimensions Panel
	JLabel ItemDimensionsHeader = new JLabel("Item Dimensions");
	JLabel enterDimensionsHeader = new JLabel("Enter Dimensions:");
	Object[] columns = { "Item","Width", "Length", "Depth", "Height" };
	DefaultTableModel dtmodel = new DefaultTableModel();
	JTable table = new JTable();
	

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
		topBar.add(homeButton, "grow");
		topBar.add(stockControlButton, "grow");
		topBar.add(shoppingBasketButton, "grow");
		topBar.add(changeCalculatorButton, "grow");
		topBar.add(itemPackingButton, "span 3, grow");

		// Stock Control Panel
		StockControlPanel.add(addItemsBTN);
		StockControlPanel.add(viewItemsBTN);

		// Add items Panel
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
		viewItemsPanel.add(itemListCB);
		viewItemsPanel.add(removeItemBTN);
		viewItemsPanel.add(refreshListBTN);

		// ItemPackingPanel
		
		JComponent numItemField = ((JSpinner.DefaultEditor) numItemsSpinner.getEditor());
		Dimension itemPrefSize = numItemField.getPreferredSize();
		itemPrefSize = new Dimension(100, itemPrefSize.height);
		numItemField.setPreferredSize(itemPrefSize);
		
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
		JComponent heightField = ((JSpinner.DefaultEditor) heightSpinner.getEditor());
		JComponent depthField = ((JSpinner.DefaultEditor) depthSpinner.getEditor());
		lengthField.setPreferredSize(prefSize);
		heightField.setPreferredSize(prefSize);
		depthField.setPreferredSize(prefSize);

		addBoxPanel.add(boxHeader, "wrap");
		addBoxPanel.add(weightLabel);
		addBoxPanel.add(weightSpinner, "wrap");
		addBoxPanel.add(lengthLabel);
		addBoxPanel.add(lengthSpinner, "wrap");
		addBoxPanel.add(heightLabel);
		addBoxPanel.add(heightSpinner, "wrap");
		addBoxPanel.add(depthLabel);
		addBoxPanel.add(depthSpinner,"wrap");
		addBoxPanel.add(addBoxBTN,"span,align right");
		
		//ItemDimensionsPanel


		dtmodel.setColumnIdentifiers(columns);
		table.setModel(dtmodel);
		table.setRowHeight(30);
		itemDimensionsPanel.add(ItemDimensionsHeader, "wrap");
		itemDimensionsPanel.add(enterDimensionsHeader, "wrap");
		itemDimensionsPanel.add(table);
		itemDimensionsPanel.add(new JScrollPane(table));
		// Frame
		frame.add(sp, "grow");
		frame.pack();
		frame.setSize(800, 600);
		frame.setResizable(false);
	}
}
