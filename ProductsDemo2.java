package JDBC_Assignments;
import java.sql.*;
import java.util.*;
public class ProductsDemo2 
{
	static String url="jdbc:mysql://localhost:3306/ibm_2021";
	static String username="root";
	static String password="1234";
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws Exception
	{
      	  System.out.println("Enter the product code to search");
      	  int pcode=sc.nextInt();
      	  
      	  Connection con=DriverManager.getConnection(url,username,password);
      	  PreparedStatement ps=con.prepareStatement("select * from products where PROD_CODE= "+pcode);
      	  ResultSet rs=ps.executeQuery();
      	  
      	 System.out.println("Product details: ");
      	 while (rs.next())
      	 {
      		 System.out.println("Code: "+rs.getObject(1));
      		 System.out.println("Name: "+rs.getObject(2));
      		 System.out.println("Price: "+rs.getObject(3));
      		 System.out.println("Category: "+rs.getObject(4));
      	 }
      	 con.close();
      	 ps.close();
	}

}
