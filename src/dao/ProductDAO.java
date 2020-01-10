package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Exception.DaoException;
import Model.Product;
import Model.User;
import libs.SqlQueryBuilder;

public class ProductDAO extends DAO<Product> {
	  public ProductDAO(Connection conn) {
		    super(conn);
		  }

	  public boolean create(Product obj) throws SQLException, DaoException 
	  {
		  
		  
		  Statement stmt = this.connect.createStatement();
		  
		  
			SqlQueryBuilder builder = new SqlQueryBuilder(); //query builder
			String query = builder.insertInto("products")
					.value("id", 0)
					.value("ref",obj.getRef())
					.value("designation",obj.getDesignation())
					.value("price",obj.getPrice())
					.value("qtt",obj.getQtt())
					.query();
			
			int state = stmt.executeUpdate(query);
			if(state == 0) throw new DaoException("create");
			
				
		
	
	    return true;
	  }

	  
	  public boolean delete(Product obj) throws SQLException, DaoException {
		  
		  
		  
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
	   
	  public boolean update(Product obj) throws DaoException, SQLException {
		  
		  
		  Statement stmt = this.connect.createStatement();
		  SqlQueryBuilder builder = new SqlQueryBuilder();
		  String query = builder
		      .update("products")
		      .set("FirstName", "John")
		      .set("Age", 21)
		      .whereEqual("id", obj.getId())
		      .query();
			int state = stmt.executeUpdate(query);
			if(state == 0) throw new DaoException("update");
				
		
	    return false;
	  }
	   
	  public Product find(int id) {
		  Product product = new Product();    
		  SqlQueryBuilder builder = new SqlQueryBuilder();
		  String query = builder
				  .select()
				  .from("products")
				  .whereEqual("id", id)
				  .query();				      
	      
	    try {
	      ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery(query);
	      if(result.first())
	      {
	    	  
	    	
	    
	    	 String ref = result.getString("ref");
	    	 String designation = result.getString("designation");
	    	 float price =  result.getFloat("price");
	    	 int qtt = result.getInt("qtt");

	    	 
	    	  product = new Product( id,ref,designation,price,qtt);         
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return product;
	  }

}
