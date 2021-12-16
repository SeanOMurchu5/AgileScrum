package demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Model {
	Model m;
	Controller con;
	int id = 0;

	ArrayList<Item> itemList = new ArrayList<Item>();
	ArrayList<Box> boxList = new ArrayList<Box>();
	ArrayList<ItemDimensions> itemDimensions = new ArrayList<ItemDimensions>();

	Object[] row = new Object[5];

	public Model() {

	}

	public void addItem(Item item) {
		id++;
		item.setId(id);
		itemList.add(item);
		id++;
		item.setId(id);
		itemList.add(item);

	}

	public void addBox(Box box) {

		boxList.add(box);

	}

	public void removeItem(Model m, Item item) {
		for (int i = 0; i < m.itemList.size(); i++) {
			if (item.getName().equals(m.itemList.get(i).getName())) {
				m.itemList.remove(i);
			}
		}
	}

}

//Item Class with name, type, date, quantity and if its expired.
class Item {
	private int id;
	private String name;
	private String itemType;
	private int year;
	private int month;
	private int day;
	private int quantity = 0;
	private boolean expired = false;

	public Item() {

	}

	public Item(String name, String itemType, int day, int month, int year) {
		this.name = name;
		this.itemType = itemType;
		this.day = day;
		this.year = year;
		this.month = month;
	}

	public String getName() {
		return name;
	}

	public void setId(int i) {
		this.id = i;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	// method to check if the item is currently expired
	public boolean checkIfExpired() {
		Calendar c = Calendar.getInstance();
		if (year > c.get(Calendar.YEAR)) {
			expired = true;
		} else if ((month > c.get(Calendar.MONTH)) && (year == c.get(Calendar.YEAR))) {
			expired = true;
		} else if ((day > c.get(Calendar.DATE)) && (month == c.get(Calendar.MONTH)) && (year == c.get(Calendar.YEAR))) {
			expired = true;
		}

		return expired;
	}

}

//Box class with dimensions and getters and setters.
class Box {
	private double width;
	private double length;
	private double depth;
	private double weight;
	private double totalArea;

	public Box() {

	}

	public Box(double w, double l, double d, double weight) {
		this.width = w;
		this.length = l;
		this.depth = d;
		this.weight = weight;
	}

	public double getWidth() {
		return width;
	}

	public double getLength() {
		return length;
	}

	public double getDepth() {
		return depth;
	}

	public double getWeight() {
		return weight;
	}

	public double getTotalArea() {
		return totalArea;
	}

	public void setArea(double A) {
		this.totalArea = A;
	}

	public void setWeight(double W) {
		this.weight = W;
	}

}

//Item Dimensions class, Able to set a items dimensions.
class ItemDimensions {
	private double weight;
	private double width;
	private double length;
	private double depth;
	private double totalArea;

	public ItemDimensions() {

	}

	public ItemDimensions(double weight, double width, double l, double d) {
		this.weight = weight;
		this.width = width;
		this.length = l;
		this.depth = d;

	}

	public double getWeight() {
		return weight;
	}

	public double getLength() {
		return length;
	}

	public double getDepth() {
		return depth;
	}

	public double getWidth() {
		return width;
	}

	public double getTotalArea() {
		return totalArea;
	}
}

class SortbyArea implements Comparator<Box> {

	public int compare(Box a, Box b) {

		return (int) (a.getTotalArea() - b.getTotalArea());
	}

}

class SortbyItemArea implements Comparator<ItemDimensions> {

	public int compare(ItemDimensions a, ItemDimensions b) {

		return (int) (a.getTotalArea() - b.getTotalArea());
	}
}

class calculator extends JFrame {
	private JTextField basketTextField;
	private JTextField amountTextField;
	private JTextField calculateTextField;
	int amountOfTwenties = 0;
	int amountOfFifties = 0;
	int amountOfTens = 0;
	int amountOfFives = 0;
	int amountOfOne = 0;
	int amountOfTwentiesCent = 0;
	int amountOfFiftyCent = 0;
	int amountOfTenCent = 0;
	int amountOfFiveCent = 0;
	int amountOfOneCent = 0;

	public calculator() {

	}

	public void calculate(double amount) {

		amount = amount;
		amountOfTwenties = 0;
		amountOfFifties = 0;
		amountOfTens = 0;
		amountOfFives = 0;
		amountOfOne = 0;
		amountOfTwentiesCent = 0;
		amountOfFiftyCent = 0;
		amountOfTenCent = 0;
		amountOfFiveCent = 0;
		amountOfOneCent = 0;
	



	       while(amount != 0){
	    	   
	    	   if(amount>=50) {
	    		   amount = amount - 50;
	    		   amountOfFifties++;
	    	   }else if(amount >= 20) {
	    		   amount = amount - 20;
	    		   amountOfTwenties++;
	    	   }else if(amount >= 10) {
	    		   amount = amount - 10;
	    		   amountOfTens++;
	    	   }else if(amount >= 5) {
	    		   amount = amount - 5;
	    		   amountOfFives++;
	    	   }else if(amount >= 1) {
	    		   amount = amount - 1;
	    		   amountOfOne++;
	    	   }else if(amount >= 0.50) {
	    		   amount = amount - .50;
	    		   amountOfFiftyCent++;
	    	   }else if(amount >= 0.20) {
	    		   amount = amount - .20;
	    		   amountOfTwentiesCent++;
	    	   }else if(amount >= 0.10) {
	    		   amount = amount - .10;
	    		   amountOfTenCent++;
	    	   }else if(amount >= 0.05) {
	    		   amount = amount - .05;
	    		   amountOfFiveCent++;
	    	   }else if(amount <= .01) {
	    		   amount = amount - .01;
	    		   amountOfOneCent++;
	    	   }
	    	   
	       }

	}

}
