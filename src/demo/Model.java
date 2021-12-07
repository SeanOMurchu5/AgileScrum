package demo;

import java.util.ArrayList;
import java.util.Calendar;

public class Model {
	Model m;
	Controller con;
	Object[] row = new Object[4];
	int id = 0;

	ArrayList<Item> itemList = new ArrayList<Item>();
	public Model() {
		
	}
	
	public void addItem(Item item) {
			id++;
            item.setId(id);
			itemList.add(item);
			
		
	}
	
	public void removeItem(Model m,Item item) {
		for(int i = 0; i < m.itemList.size(); i++) {
			if(item.getName().equals(m.itemList.get(i).getName())) {
				m.itemList.remove(i);
			}
		}
	}
	
	
}

class Item{
	private int id;
	private String name;
	private String itemType;
	private int year;
	private int month;
	private int day;
	private int quantity=0;
	private boolean expired=false;
	
	public Item() {
		
	}
	
	public Item(String name, String itemType,int day,int month, int year) {
		this.name = name;
		this.itemType = itemType;
		this.day = day;
		this.year = year;
		this.month = month;
	}
	
	public String getName() {
		return name;
	}
	
	public void setId(int i){
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
	public boolean checkIfExpired(){
		Calendar c = Calendar.getInstance();
		if(year > c.get(Calendar.YEAR)) {
			expired = true;
		}else if((month > c.get(Calendar.MONTH))&&(year == c.get(Calendar.YEAR))){
			expired = true;
		}else if((day > c.get(Calendar.DATE))&&(month == c.get(Calendar.MONTH))&&(year == c.get(Calendar.YEAR))){
			expired = true;
		}
		
		return expired;
	}
	
	
	}
	

