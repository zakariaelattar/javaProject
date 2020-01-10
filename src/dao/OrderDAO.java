package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Class.DatabaseConnection;
import Exception.DaoException;
import Model.Order;
import Model.Order_product;
import Model.Product;
import Model.Sale;
import Model.User;
import libs.SqlQueryBuilder;

public class OrderDAO extends DAO<Order> {
	  public OrderDAO(Connection conn) {
		    super(conn);
		  }
/*
 *  DAO receive from view a HashMap Array of product and yyy
 * 
 * */

	  public boolean create(Order obj) throws SQLException, DaoException, ClassNotFoundException 
	  {
		  HashMap<Product,int[]> products_qtt = new HashMap<Product,int[]>();
		  products_qtt = obj.getProduct_qtt();
		  
		  
		 
		  
		  
			DAO<Order_product> orderDAO = null;
			try {
				orderDAO = new Order_productDAO(DatabaseConnection.getInstance());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Order_product orders_products = new Order_product();
		  
		  Statement stmt = this.connect.createStatement();
		  
		  
			SqlQueryBuilder builder = new SqlQueryBuilder(); //query builder
		
				String query = builder.insertInto("orders")
						.value("id", 0)
						.value("date_order",obj.getSeller().getId())
						.value("id_seller",obj.getSeller().getId())
						.query();
				
				
				int state = stmt.executeUpdate(query);
				if(state == 0) throw new DaoException("create");
				/*
				 * create orders_products enrty
				 * */
				for(Product current_product : products_qtt.keySet())
				{
					orders_products.setOrder(obj);
					orders_products.setProduct(current_product);
					orders_products.setQtt_missing(products_qtt.get(current_product)[0]);
					/*
					 * send request
					 * */
					try
					{
						orderDAO.create(orders_products);
						
					}
					catch(DaoException e)
					{
						e.getMessage();
					}
				}
			

			
			
				
		
	
	    return true;
	  }

	  
	  public boolean delete(Order obj) throws SQLException, DaoException {
		  
		  
		  
		  Statement stmt = this.connect.createStatement();
		  SqlQueryBuilder builder = new SqlQueryBuilder();
		  
		  String query = builder
		      .delete("orders")
		      .whereEquals("id", obj.getId())
		      .query();
		  
			int state = stmt.executeUpdate(query);
			if(state == 0) throw new DaoException("delete");
				
		
	    return false;
	  }
	   
	  public boolean update(Order obj) throws DaoException, SQLException {
		  
		  
		  Statement stmt = this.connect.createStatement();
		  SqlQueryBuilder builder = new SqlQueryBuilder();
		  String query = builder
		      .update("orders")
		      .set("FirstName", "John")
		      .set("Age", 21)
		      .whereEqual("id", obj.getId())
		      .query();
			int state = stmt.executeUpdate(query);
			if(state == 0) throw new DaoException("update");
				
		
	    return false;
	  }
	   
	  public Order find(int id) throws SQLException, DaoException, ClassNotFoundException
	  {
		  DAO<User> userDAO = new UserDAO(DatabaseConnection.getInstance());
		  Order order = new Order();    
		  SqlQueryBuilder builder = new SqlQueryBuilder();
		  String query = builder
				  .select()
				  .from("orders")
				  .whereEqual("id", id)
				  .query();				      
	      
	    try {
	      ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery(query);
	      if(result.first())
	      {

	   
	    	 int seller_id = result.getInt("seller_id");
	    	 User seller = userDAO.find(seller_id);
	    	 String sale_date = result.getDate("sale_date").toString();

	    	 
	    	  order = new Order(id,sale_date,seller);         
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return order;
	  }

}
