package demo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
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
    JPanel customerRegistration = new JPanel(new MigLayout("filly"));
	JPanel topBar = new JPanel(new MigLayout("wrap 1"));
	JSplitPane sp = new JSplitPane(SwingConstants.HORIZONTAL, topBar, home);
	JButton homeButton = new JButton("Home");
	JButton customersButton = new JButton("Menu");
	
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
		
		JFrame frame = new JFrame("main");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new MigLayout("fillx"));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		topBar.add(homeButton, "span, align center");
		topBar.add(customersButton, "grow");
	
		
		dtmodel.setColumnIdentifiers(columns);
		table.setModel(dtmodel);
		table.setRowHeight(30);
		customerRegistration.add(orderHPage, "wrap");
		customerRegistration.add(table);
		customerRegistration.add(new JScrollPane(table));
	}
}
