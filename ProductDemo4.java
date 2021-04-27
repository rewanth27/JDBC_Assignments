package JDBC_Assignments;
import java.sql.*;
public class ProductDemo4 
{
  static String url="jdbc:mysql://localhost:3306/ibm_2021";
  static String username="root";
  static String password="1234";
  public static void main(String[] args) throws Exception
  {
	Connection con= DriverManager.getConnection(url,username,password);
	PreparedStatement ps=con.prepareStatement("select * from products");
	ResultSet rs=ps.executeQuery();
	while (rs.next())
	{
	   if(rs.getString(4).equalsIgnoreCase("Electronics"))
	   {
		   ps=con.prepareStatement("update products set PROD_PRICE = "+rs.getObject(3)+"+"+"("+rs.getObject(3)+"*"+"?) where PROD_PRICE<?");
		   ps.setObject(1, (10/100));
		   ps.setObject(2, 1000);
		   ps.execute();
	   }
	   if(rs.getString(4).equalsIgnoreCase("Clothing"))
	   {
		   ps=con.prepareStatement("update products set PROD_PRICE = "+rs.getObject(3)+"-"+"("+rs.getObject(3)+"*"+"?) where PROD_PRICE<?");
		   ps.setObject(1, (10/100));
		   ps.setObject(2, 1000);
		   ps.execute();
	   }
	}
	con.close();
	ps.close();
  }
}
