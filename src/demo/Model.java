package demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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
	
	public Box() {
		
	}
	
	public Box(double w, double l, double d) {
		this.width = w;
		this.length = l;
		this.depth = d;
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
	

	
}

class ItemDimensions{
	private double weight;
	private double width;
	private double length;
	private double depth;
	
	public ItemDimensions() {
		
	}
	
	public ItemDimensions(double weight,double width, double l, double d) {
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
}

//Cart Class
class cart{
	   
    private Map<String, CartItem> items = new HashMap<String, CartItem>();
    private int num;
    private float price;

    
    public Map<String, CartItem> getItems() {
        return items;
    }
    
    public int getNum() {
        num = 0;
        for(Map.Entry<String, CartItem> me:items.entrySet()){
            num += me.getValue().getNum();
        }
        return num;
    }

    public float getPrice() {
        price = 0;
        for(Map.Entry<String, CartItem> me:items.entrySet()){
            price += me.getValue().getPrice();
        }
        return price;
    }


    public void addCart(Book book) {
        if(items.containsKey(book.getId())){
            
            CartItem item = items.get(book.getId());
            item.setNum(item.getNum() + 1);
       }else{
           
            CartItem item = new CartItem();
            item.setBook(book);
            item.setNum(1);
           items.put(book.getId(), item);
        }
    }

    
    public void deleteCartByBook(String bookId) {
        CartItem item = items.get(bookId);
        if (item.getNum() > 1) {
            item.setNum(item.getNum() - 1);
	 }else {
            items.remove(bookId);
        }
   }
}
