package JDBC_Assignments;

import java.io.Serializable;

public class Product implements Serializable
{
	private int pro_id;
	private String pro_name;
	private int pro_price;
	private String pro_cat;
	public Product()
	{
		
	}
	@Override
	public String toString()
	{
	  return pro_id+" "+pro_name+" "+pro_price+" "+pro_cat;
	}
	public Product(int pro_id, String pro_name, int pro_price, String pro_cat) {
		super();
		this.pro_id = pro_id;
		this.pro_name = pro_name;
		this.pro_price = pro_price;
		this.pro_cat = pro_cat;
	}
	public int getPro_id() {
		return pro_id;
	}
	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public String getPro_cat() {
		return pro_cat;
	}
	public void setPro_cat(String pro_cat) {
		this.pro_cat = pro_cat;
	}

}
