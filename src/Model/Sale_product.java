package Model;

import java.util.ArrayList;

public class Sale_product {
	
	int id;
	Sale sale;
	Product product;
	int qtt;
	
	
	
	public Sale_product(int id, Sale sale, Product product, int qtt) {
		super();
		this.id = id;
		this.sale = sale;
		this.product = product;
		this.qtt = qtt;
	}
	public Sale_product()
	{
		
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Sale getSale() {
		return sale;
	}
	
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public int getQtt() {
		return qtt;
	}
	
	public void setQtt(int qtt) {
		this.qtt = qtt;
	}
	

	
	


}
