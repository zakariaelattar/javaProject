package Model;

public class Product {
	int id;
	String ref;
	String designation;
	float price;
	int qtt;
	
	
	public Product(int id, String ref, String designation, float price, int qtt) {
		super();
		this.id = id;
		this.ref = ref;
		this.designation = designation;
		this.price = price;
		this.qtt = qtt;
	}

	public Product()
	{
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public float getPrice() {
		return price;
	}
	public void setP_u(float price) {
		this.price = price;
	}
	public int getQtt() {
		return qtt;
	}
	public void setQtt(int qtt) {
		this.qtt = qtt;
	}
}



