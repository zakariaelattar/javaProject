package Model;

public class Order_product {
	int id;
	Order order= new Order();
	Product product;
	int qtt_missing;
	
	/**
	 * getters and setters
	 */
	
	public Order_product()
	{
		
	}
	
	public Order_product(int id, Order order, Product product, int qtt_missing) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.qtt_missing = qtt_missing;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQtt_missing() {
		return qtt_missing;
	}
	public void setQtt_missing(int qtt_missing) {
		this.qtt_missing = qtt_missing;
	}

	//HashMap<Product,int[]> product_qtt = new HashMap<Product,int[]>(); //associative array containnig products and missing qtt for order

	
	
	
	


}
