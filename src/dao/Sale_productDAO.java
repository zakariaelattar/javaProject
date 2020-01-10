package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Class.DatabaseConnection;
import Exception.DaoException;
import Model.Product;
import Model.Sale;
import Model.Sale_product;
import libs.SqlQueryBuilder;


public class Sale_productDAO extends DAO<Sale_product> {
	
	  public Sale_productDAO(Connection conn) {
		    super(conn);
		  }

	  public boolean create(Sale_product obj) throws SQLException, DaoException {
		  
		  Statement stmt = this.connect.createStatement();
		  
		  
			SqlQueryBuilder builder = new SqlQueryBuilder(); //query builder
			
				
				String query = builder.insertInto("sales_products")
						.value("id", 0)
						.value("id_sale",obj.getSale().getId())
						.value("id_product",obj.getProduct().getId())
						.value("qtt",obj.getQtt())
						.query();
				
				int state = stmt.executeUpdate(query);
				if(state == 0) throw new DaoException("create");
			
	    return true;
	  }

	  public boolean delete(Sale_product obj) throws SQLException, DaoException {
		  
		  
		  Statement stmt = this.connect.createStatement();
		  SqlQueryBuilder builder = new SqlQueryBuilder();
		  
		  String query = builder
		      .delete("sales_products")
		      .whereEquals("id", obj.getId())
		      .query();
		  
			int state = stmt.executeUpdate(query);
			if(state == 0) throw new DaoException("delete");
				
		
	    return false;
	  }
	   
	  public boolean update(Sale_product obj) {
	    return false;
	  }
	   
	  public Sale_product find(int id) throws SQLException, DaoException, ClassNotFoundException
	  {
		  DAO<Sale> saleDAO = new SaleDAO(DatabaseConnection.getInstance());
		  DAO<Product> productDAO = new ProductDAO(DatabaseConnection.getInstance());

		  Sale_product sale_product = new Sale_product();    
		  SqlQueryBuilder builder = new SqlQueryBuilder();
		  String query = builder
				  .select()
				  .from("sales_products")
				  .whereEqual("id", id)
				  .query();				      
	      
	    try {
	      ResultSet result = this.connect.createStatement(
	        ResultSet.TYPE_SCROLL_INSENSITIVE,
	        ResultSet.CONCUR_READ_ONLY).executeQuery(query);
	      if(result.first())
	      {
			  Sale sale = new Sale();
			  Product product = new Product();
	    	  
	    	 sale = saleDAO.find(result.getInt("id_sale"));
	    	 int id_product = result.getInt("id_product");
	    	 product = productDAO.find(id_product);
	    	 int qtt = result.getInt("qtt");

	    	 
	    	  sale_product = new Sale_product(id,sale,product,qtt);         
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return sale_product;
	  }

}
