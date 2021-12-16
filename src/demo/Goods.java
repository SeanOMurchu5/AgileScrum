public class Goods {
private
String name ; //Name
private
int num; //Quantity
private
double price;//Single Price
private
double totalPrice ;// Total Price
Scanner reader=new Scanner (System.in):
public GoodsOf
system.out.println〔“Enter Products Name：")；
this.name=reader.nextO);
system.out.printin("Enter Quantity，")；
this.num= reader.nextInt():
System.out.printin（"Enter Single Price：")：
this.price=reader.nextDouble();
this.totalPrice=this.num*this.price;
1
public double getPrice0//
{
 return totalPrice；
}
public String getname() { return name; }
public double getdPrice0) {
return price:
public int getNum) { return num;｝