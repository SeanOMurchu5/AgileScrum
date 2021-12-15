package demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
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
<<<<<<< HEAD
			id++;
            item.setId(id);
			itemList.add(item);
=======
		id++;
		item.setId(id);
		itemList.add(item);

>>>>>>> origin
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

	//method to check if the item is currently expired
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
class Box{
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
class ItemDimensions{
	private double weight;
	private double width;
	private double length;
	private double depth;
	private double totalArea;
	
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
	
	public double getTotalArea() {
		return totalArea;
	}
}

class SortbyArea implements Comparator<Box>
{
    
    public int compare(Box a, Box b)
    {
    	
        return (int) (a.getTotalArea() - b.getTotalArea());
    }
    
  
}


class SortbyItemArea implements Comparator<ItemDimensions>
{
    
    public int compare(ItemDimensions a, ItemDimensions b)
    {
    	
        return (int) (a.getTotalArea() - b.getTotalArea());
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
    
    public int getNum(){
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
