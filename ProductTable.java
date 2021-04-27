package JDBC_Assignments;
import java.sql.*;
import java.util.*;
public class ProductTable 
{
  static Scanner sc=new Scanner (System.in);
  public static void main(String[] args) throws Exception
  {
	String url="jdbc:mysql://localhost:3306/ibm_2021";
	String username="root";
	String password="1234";
	
	Connection con= DriverManager.getConnection(url,username,password);
	PreparedStatement ps=null;
	if(con.getCatalog().equalsIgnoreCase("products"))
	{
	  ps=con.prepareStatement("create table PRODUCTS(PROD_CODE int, PROD_NAME varchar(40), PROD_PRICE int, PROD_CATG varchar(15), primary key(PROD_CODE))");
	}
	else
	{
		System.out.println("Table already contains");
		System.exit(0);
	}
	ps.executeUpdate();
	
	for(int i=0; i<5; i++)
	{
		ps=con.prepareStatement("insert into products(PROD_CODE,PROD_NAME,PROD_PRICE,PROD_CATG) values (?,?,?,?)");
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
		
		ps.setInt(1, code);
		ps.setString(2, name);
		ps.setInt(3, price);
		ps.setString(4, product);
		ps.execute();
		
		ps.close();
	}
  }
}
