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
