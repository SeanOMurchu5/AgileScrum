package demo;

import java.util.ArrayList;
import java.util.Calendar;

public class Model {
	Model m;
	Controller con;
	int id = 0;

	ArrayList<Item> itemList = new ArrayList<Item>();
	ArrayList<Box> boxList = new ArrayList<Box>();
	
	Object[] row = new Object[4];


	public Model() {

	}

	public void addItem(Item item) {
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


class Box{
	private double width;
	private double length;
	private double depth;
	private double height;
	
	public Box() {
		
	}
	
	public Box(double w, double l, double d, double h) {
		this.width = w;
		this.length = l;
		this.depth = d;
		this.height = h;
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
	
	public double getHeight(){
		return height;
	}
	
	
}
