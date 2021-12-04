package demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	
	//Jpanels and Frames ..etc
	JPanel home = new JPanel(new MigLayout("filly"));
    JPanel StockControlPanel = new JPanel(new MigLayout());
    JPanel addItemsPanel = new JPanel(new MigLayout("debug","fill"));
    JPanel viewItemsPanel = new JPanel(new MigLayout("filly"));
    JPanel ShoppingBasketPanel = new JPanel(new MigLayout("fill"));
    JPanel ChangeCalculatorPanel = new JPanel(new MigLayout("filly"));
    JPanel ItemPackingPanel = new JPanel(new MigLayout("filly"));

	JPanel topBar = new JPanel(new MigLayout());
	JSplitPane sp = new JSplitPane(SwingConstants.HORIZONTAL, topBar, home);
	JButton homeButton = new JButton("Home");
	JButton stockControlButton = new JButton("Stock Control");
	JButton shoppingBasketButton = new JButton("Shopping Basket");
	JButton changeCalculatorButton = new JButton("Change Calculator");
	JButton itemPackingButton = new JButton("Item Packing");


    //Stock Control Panel
	JButton addItemsBTN = new JButton("Add item");
	JButton viewItemsBTN = new JButton("View all items");
	
	//add items panel
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

	
	//View items panel
	

	
	//Customer registration table
	JLabel orderHPage = new JLabel("Order History");
	Object[] columns = { "OrderNo.", "Burger", "Side", "Drink" };
	DefaultTableModel dtmodel = new DefaultTableModel();
	JTable table = new JTable();

	public void projectView() {
		String systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();

		try {
			UIManager.setLookAndFeel(systemLookAndFeelClassName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//JFrame
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

       //Stock Control Panel
		StockControlPanel.add(addItemsBTN);
		StockControlPanel.add(viewItemsBTN);
		
		//Add items Panel
		addItemsPanel.add(itemNameHeader);
		addItemsPanel.add(itemNameTF);
		addItemsPanel.add(itemTypeHeader);
		addItemsPanel.add(itemTypeCB,"wrap");
		addItemsPanel.add(expirationDateHeader,"span,split 7");
		addItemsPanel.add(yearHeader);
		addItemsPanel.add(yearTF);
		addItemsPanel.add(monthHeader);
		addItemsPanel.add(monthTF);
		addItemsPanel.add(dayHeader);
		addItemsPanel.add(dayTF,"wrap");
		addItemsPanel.add(submitItemBTN);
		addItemsPanel.add(returnToItemsBTN);


		// Frame
		frame.add(sp, "grow");
		frame.pack();
		frame.setSize(800, 600);
		frame.setResizable(false);
	}
}
