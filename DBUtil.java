package JDBC_Assignments;
import java.sql.*;
public class DBUtil
{
  static String url="jdbc:mysql://localhost:3306/ibm_2021";
  static String username="root";
  static String password="1234";
  public static Connection getConnection() throws Exception
  {
	  Connection con=DriverManager.getConnection(url,username,password);
	  return con;
  }
}
