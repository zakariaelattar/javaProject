package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Class.DatabaseConnection;
import Exception.DaoException;
import Model.Order;
import Model.Order_product;
import Model.Product;
import libs.SqlQueryBuilder;

public class Order_productDAO extends DAO<Order_product> {
	
	  public Order_productDAO(Connection conn) {
		    super(conn);
		  }

		  public boolean create(Order_product obj) throws SQLException, DaoException {
			  
			  Statement stmt = this.connect.createStatement();
			  
			  
				SqlQueryBuilder builder = new SqlQueryBuilder(); //query builder
				
					
					String query = builder.insertInto("orders_products")
							.value("id", 0)
							.value("id_product",obj.getProduct().getId())
							.value("qtt_missing",obj.getQtt_missing())
							.value("id_order",obj.getOrder().getId())
							.query();
					
					int state = stmt.executeUpdate(query);
					if(state == 0) throw new DaoException("create");
				
		    return true;
		  }

		  public boolean delete(Order_product obj) throws SQLException, DaoException {
			  
			  
			  Statement stmt = this.connect.createStatement();
			  SqlQueryBuilder builder = new SqlQueryBuilder();
			  
			  String query = builder
			      .delete("products")
			      .whereEquals("id", obj.getId())
			      .query();
			  
				int state = stmt.executeUpdate(query);
				if(state == 0) throw new DaoException("delete");
					
			
		    return false;
		  }
		   
		  public boolean update(Order_product obj) {
		    return false;
		  }
		   
		  public Order_product find(int id) throws SQLException, DaoException, ClassNotFoundException
		  {
			  DAO<Product> productDAO = new ProductDAO(DatabaseConnection.getInstance());
			  DAO<Order> orderDAO = new OrderDAO(DatabaseConnection.getInstance());

			  Order_product order_product = new Order_product();    
			  SqlQueryBuilder builder = new SqlQueryBuilder();
			  String query = builder
					  .select()
					  .from("orders_products")
					  .whereEqual("id", id)
					  .query();				      
		      
		    try {
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(query);
		      if(result.first())
		      {
				  Order order = new Order();
				  Product product = new Product();
		    	  
		    	 order = orderDAO.find(result.getInt("id_order"));
		    	 int id_product = result.getInt("id_product");
		    	 product = productDAO.find(id_product);
		    	 int qtt_missing = result.getInt("qtt_missing");

		    	 
		    	  order_product = new Order_product(id,order,product,qtt_missing);         
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return order_product;
		  }

}
