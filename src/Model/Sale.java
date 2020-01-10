package Model;

import java.util.HashMap;

/*
 * class handling the sales
 * */
public class Sale {
	
	int id;
	User seller = new User();
	String sale_date;
	HashMap<Product,int[]> product_qtt = new HashMap<Product,int[]>();
	

	public Sale(int id, User seller, String sale_date) {
		super();
		this.id = id;
		this.setSeller(seller);
		this.sale_date = sale_date;
	}


	public Sale()
	{
		
	}


	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public User getSeller() {
		return seller;
	}


	public void setSeller(User seller) {
		this.seller = seller;
	}
	
	
	public String getSale_date() {
		return sale_date;
	}
	
	
	public void setSale_date(String sale_date) {
		this.sale_date = sale_date;
	}
	
	public HashMap<Product, int[]> getProduct_qtt() {
		return product_qtt;
	}


	public void setProduct_qtt(HashMap<Product, int[]> product_qtt) {
		this.product_qtt = product_qtt;
	}


	

}
