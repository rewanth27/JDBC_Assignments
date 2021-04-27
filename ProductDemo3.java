package JDBC_Assignments;
import java.util.*;
import java.sql.*;
public class ProductDemo3 
{
  static String url="jdbc:mysql://localhost:3306/ibm_2021";
  static String username="root";
  static String password="1234";
  static Scanner sc=new Scanner(System.in);
  public static void main(String[] args) throws Exception
  {
	System.out.println("Enter how many products you want to add----");
	int size=sc.nextInt();
	
	ArrayList<Product>al=new ArrayList<Product>();
	for(int i=0; i<size; i++)
	{
		System.out.println("Enter the product code");
		int code=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the product name");
		String name=sc.nextLine();
		System.out.println("Enter the product price");
		int price=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the category of product");
		String product=sc.nextLine();
		
		Product p=new Product(code, name, price, product);
		al.add(p);
	}
	
    Connection con=DriverManager.getConnection(url,username,password);
    for(int i=0; i<al.size(); i++)
    {
    	PreparedStatement ps=con.prepareStatement("insert into products(PROD_CODE,PROD_NAME,PROD_PRICE,PROD_CATG) values (?,?,?,?)");
    	ps.setObject(1, al.get(i).getPro_id());
    	ps.setObject(2, al.get(i).getPro_name());
    	ps.setObject(3, al.get(i).getPro_price());
    	ps.setObject(4, al.get(i).getPro_cat());
    	ps.execute();
    }
    System.out.println("All Products inserted");
    con.close();
  }

}
