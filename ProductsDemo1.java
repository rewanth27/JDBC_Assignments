package JDBC_Assignments;
import java.sql.*;
public class ProductsDemo1 
{
	public static void main(String[] args) throws Exception
	{
      String url="jdbc:mysql://localhost:3306/ibm_2021";
      String username="root";
      String password="1234";
      
      Connection con= DriverManager.getConnection(url,username,password);
      PreparedStatement ps=con.prepareStatement("select * from products");
      ResultSet rs=ps.executeQuery();
      while(rs.next())
      {
    	  System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t "+rs.getInt(3)+"\t\t "+rs.getString(4));
      }
      
      ps.close();
      rs.close();
      con.close();
	}

}
