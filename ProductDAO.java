package JDBC_Assignments;
import java.sql.*;
public class ProductDAO 
{
	static Connection con=null;
	static PreparedStatement ps=null;
	public boolean insertProduct(Product prod) throws Exception
	{
	    con=DBUtil.getConnection();
		ps=con.prepareStatement("insert into products values (?,?,?,?)");
		ps.setObject(1, prod.getPro_id());
		ps.setObject(2, prod.getPro_name());
		ps.setObject(3, prod.getPro_price());
		ps.setObject(4, prod.getPro_cat());
		
		boolean b=ps.execute();
		
		if(b)
			return true;
		else
			return false;
		
	}
	
	public Product getProduct(int prodCode) throws Exception
	{
	  con=DBUtil.getConnection();
	  ps=con.prepareStatement("select * from products where PROD_CODE=?");
	  ps.setInt(1,prodCode);
	  ResultSet rs=ps.executeQuery();
	  
	  Product p=new Product();
      while (rs.next())
      {
    	  if(rs.getInt(1)==prodCode)
    	  {
    		 p.setPro_id(rs.getInt(1));
    		 p.setPro_name(rs.getString(2));
    		 p.setPro_price(rs.getInt(3));
    		 p.setPro_cat(rs.getString(4));
    	  }
      }
      return p;
	}
	
	

}
