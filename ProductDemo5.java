package JDBC_Assignments;
import java.util.*;
public class ProductDemo5
{
  static Scanner sc=new Scanner (System.in);
  public static void main(String[] args) throws Exception
  {
	  ProductDAO pdao=new ProductDAO();
	  System.out.println("Enter how many products do you want to add");
	  int size=sc.nextInt();
	  
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
			
			Product p=new Product(code,name,price,product);
			pdao.insertProduct(p);
	  }
	  
	  System.out.println("-----------------------------------------------------------------");
	  System.out.println("Enter the prod_id to get that particular product details");
	  int id=sc.nextInt();
	  Product p=pdao.getProduct(id);
	  System.out.println(p);
  }
}
