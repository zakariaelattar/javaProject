package Model;

import java.util.Date;
import java.util.HashMap;

public class Order {
	
	int id;
	String date_order;
	User seller = new User();
	HashMap<Product,int[]> product_qtt = new HashMap<Product,int[]>(); //associative array containnig products and missing qtt for order

	


	public Order()
	{
		
	}
	
	public Order(int id, String date_order, User seller){
		super();
		this.id = id;
		this.date_order = date_order;
		this.setSeller(seller);
	
		
	
	}
	public User getSeller() {
		return seller;
	}
	
	public HashMap<Product, int[]> getProduct_qtt() {
		return product_qtt;
	}

	public void setProduct_qtt(HashMap<Product, int[]> product_qtt) {
		this.product_qtt = product_qtt;
	}
	
	
	public void setSeller(User seller) {
		this.seller = seller;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate_order() {
		return date_order;
	}
	public void setDate_order(String date_order) {
		this.date_order = date_order;
	}



	

}
