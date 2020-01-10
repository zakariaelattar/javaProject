package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import Class.DatabaseConnection;
import Exception.DaoException;
import Model.Order;
import Model.Product;
import Model.Sale;
import Model.Sale_product;
import Model.User;
import libs.SqlQueryBuilder;

public class SaleDAO extends DAO<Sale> 
{

	  public SaleDAO(Connection conn) {
		    super(conn);
		  }


	  public boolean create(Sale obj) throws SQLException, DaoException, ClassNotFoundException 
	  {
		  HashMap<Product,int[]> products_qtt = new HashMap<Product,int[]>();
		  products_qtt = obj.getProduct_qtt();
		
			DAO<Sale_product> saleDAO = null;
			try {
				saleDAO = new Sale_productDAO(DatabaseConnection.getInstance());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Sale_product sales_products = new Sale_product();
		  
		  Statement stmt = this.connect.createStatement();
		  
		  
			SqlQueryBuilder builder = new SqlQueryBuilder(); //query builder
		
				String query = builder.insertInto("sales")
						.value("id", 0)
						.value("seller_id",obj.getSeller().getId())
						.value("sale_date",obj.getSale_date())
						.query();
				
				
				int state = stmt.executeUpdate(query);
				if(state == 0) throw new DaoException("create");
				/*
				 * create orders_products enrty
				 * */
				for(Product current_product : products_qtt.keySet())
				{
					sales_products.setSale(obj);
					sales_products.setProduct(current_product);
					sales_products.setQtt(products_qtt.get(current_product)[0]);
					/*
					 * send request
					 * */
					try
					{
						saleDAO.create(sales_products);
						
					}
					catch(DaoException e)
					{
						e.getMessage();
					}
				}
			

	
	    return true;
	  }

	  /*
	   * 
	   * */
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
	  /*
	   * 
	   * */
	   
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
	  /*
	   * 
	   * */
	   
	  public Sale find(int id) throws SQLException, DaoException, ClassNotFoundException
	  {
		  DAO<User> userDAO = new UserDAO(DatabaseConnection.getInstance());
		  Sale sale = new Sale();    
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

	    	 
	    	  sale = new Sale(id,seller,sale_date);         
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return sale;
	  }


	@Override
	public boolean delete(Sale obj) throws DaoException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(Sale obj) throws DaoException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
