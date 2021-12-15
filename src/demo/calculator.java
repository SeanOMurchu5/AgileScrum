package demo;

import java.awt.Color;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class calculator extends JFrame {
	private JTextField basketTextField;
	private JTextField amountTextField;
	private JTextField calculateTextField;
	
	public calculator() {
		getContentPane().setBackground(Color.GREEN);
		getContentPane().setLayout(new MigLayout("debug, fillx", "[grow][grow][][][][]", "[][][][][][][][][][][][][][][][][][][][][][]"));
		
		JLabel headingLabel = new JLabel("Calculator Page");
		headingLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		getContentPane().add(headingLabel, "cell 1 0");
		
		JLabel totalLabel = new JLabel("Enter basket total: € ");
		getContentPane().add(totalLabel, "cell 0 2,alignx trailing");
		
		basketTextField = new JTextField();
		getContentPane().add(basketTextField, "cell 1 2,growx");
		basketTextField.setColumns(10);
		
		JLabel amountLabel = new JLabel("Enter amount paid: €");
		getContentPane().add(amountLabel, "cell 0 4,alignx trailing");
		
		amountTextField = new JTextField();
		getContentPane().add(amountTextField, "cell 1 4,growx");
		amountTextField.setColumns(10);
		
		JButton clearButton = new JButton("Clear All");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				basketTextField.setText(" ");
				amountTextField.setText(" ");
			}
		});
		getContentPane().add(clearButton, "cell 0 7");
		
		JButton calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				basketTextField.getText();
				amountTextField.getText();
			}
		});
		getContentPane().add(calculateButton, "cell 1 7");
		
		calculateTextField = new JTextField();
		getContentPane().add(calculateTextField, "cell 0 9 2 1,growx");
		calculateTextField.setColumns(10);
	}

	public static void main(String[] args) {
		calculator calculator = new calculator();
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.setSize(200,125);
		calculator.pack();
		calculator.setVisible(true);
		calculator.setTitle("Calculator");
	}

}
