public class Customer {
private
String name;
private
Goods goods[ ];
private
double total;//
Scanner reader=new Scanner(System.in):
int n=2:
public Customer( )
System.out.println("Enter customer nam：")：
this.name=reader.next();
goods=new Goods[1];
goods[0]=new Goods();
total=goods[0].getPrice();
while (true){
System.out.println("Do you need buy more?Enter n to quit,press any key to continue. ")

String s=reader.next( );
if(s.equals("n") )break;
goods= Arrays.copy0f(goods, n) ;
goods[n-1]=new Goods( );
total=total+goods[n-1].getPrice( );
n=n+1;
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
