package demo;

import java.util.ArrayList;

public class Model {
	Model m;
	Controller con;
	Object[] row = new Object[4];

	ArrayList itemList = new ArrayList();
	public Model() {
		
	}
	
	public void addItem(Item item) {
		
		itemList.add(item);
	}
	
	
}

class Item{
	String id;
	String itemType;
	String expirationDate;
	int quantity=0;
	
	public Item() {
		
	}
	
	public Item(String id, String itemType,String expirationDate,int quantity) {
		this.id = id;
		this.itemType = itemType;
		this.expirationDate = expirationDate;
		this.quantity += quantity;
	}
	
}
