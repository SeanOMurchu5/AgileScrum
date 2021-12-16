package demo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;

public class basket extends JFrame implements ActionListener{

	private JLabel headerLabel;
	private JLabel itemLabel;
	private JButton submitButton;
	private ImageIcon image;
	private JLabel imageLabel;
	private JLabel quantityLabel;
	private JComboBox itemComboBox;
	private JComboBox quantityComboBox;
	private JTextArea textarea;
	private JLabel textAreaLabel;
	private JButton basketButton;
	private JButton calculateButton;
	private JLabel comboBoxLabel;
	private JLabel basketLabel;

	String items[];

	public basket() {
		getContentPane().setBackground(Color.YELLOW);
		getContentPane().setLayout(new MigLayout("fillx", "[grow][grow][][][]", "[][][][][][][][][][][][][][][][][][][][][][][][][]"));
		headerLabel = new JLabel("Shopping Basket");
		headerLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		getContentPane().add(headerLabel, "cell 0 0");

		itemLabel = new JLabel("Enter an item you wish to purchase: ");
		getContentPane().add(itemLabel, "cell 0 2");

		//Combo box
		String[] items = {"Luxury", "Essential", "Gift"};

		itemComboBox = new JComboBox(items);
		itemComboBox.addActionListener(this);
		getContentPane().add(itemComboBox, "cell 0 3");

		//Submit Button
		submitButton = new JButton("SUBMIT");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBoxLabel.setText("You selected: " + itemComboBox.getSelectedItem());
			}
		});
		getContentPane().add(submitButton, "cell 0 5");

		//Quantity Button
		String[] quantity = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

		//Label for combo box
		comboBoxLabel = new JLabel("You selected:");
		getContentPane().add(comboBoxLabel, "cell 0 7");

		quantityLabel = new JLabel("Enter Quantity: ");
		getContentPane().add(quantityLabel , "flowx,cell 0 10");

		//Image 
		image = new ImageIcon(getClass().getResource("cart.jpg"));

		//Calculate Button
		calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				itemComboBox.getSelectedItem();

			}
		});
		getContentPane().add(calculateButton, "cell 0 15");

		//Basket Button
		basketButton = new JButton("Add to basket");
		basketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				itemComboBox.getSelectedItem();
				textarea.setText("Item: " + itemComboBox.getSelectedItem()
				+ "  " + "  " +  "Quanitity: " + quantityComboBox.getSelectedItem());
			}
		});
		getContentPane().add(basketButton, "cell 0 17");
		
		basketLabel = new JLabel("Your Basket");
		basketLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(basketLabel, "cell 0 19");

		//Text Area
		textarea = new JTextArea("", 5, 30);
		getContentPane().add(textarea, "cell 0 22");

		imageLabel = new JLabel(image);
		getContentPane().add(imageLabel, "cell 0 24");
		imageLabel.setBounds(50, 50, 10, 10);

		quantityComboBox = new JComboBox(quantity);
		quantityComboBox.addActionListener(this);
		getContentPane().add(quantityComboBox, "cell 0 10");
	}

	public static void main (String args[]) {
		basket basket = new basket();
		basket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		basket.setSize(200,125);
		basket.pack();
		basket.setVisible(true);
		basket.setTitle("Shopping Basket");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==itemComboBox) {
			System.out.println(itemComboBox.getSelectedItem());
			int i;
			for(i = 0; i < items.length; i++) {

			}
		}

	}
}
