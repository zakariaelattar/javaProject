package Controller;

import java.sql.SQLException;

import Class.DatabaseConnection;
import Exception.DaoException;
import Model.Product;
import dao.DAO;
import dao.ProductDAO;

public class productController extends Controller {
	  public boolean create(Product obj) throws ClassNotFoundException, SQLException {
		  
		  DAO<Product> productDAO = new ProductDAO(DatabaseConnection.getInstance());
	        try
	        {
	        	productDAO.create(obj);
	        	
	        }
	        catch(DaoException e)
	        {
	        	e.getMessage();
	        }
		    return false;
		  }

		  public boolean delete(Product obj) throws ClassNotFoundException, SQLException {
			  DAO<Product> productDAO = new ProductDAO(DatabaseConnection.getInstance());
		        try
		        {
		        	productDAO.delete(obj);
		        	
		        }
		        catch(DaoException e)
		        {
		        	e.getMessage();
		        }
		    return false;
		  }
		   
		  public boolean update(Product obj) throws ClassNotFoundException, SQLException {
			  DAO<Product> productDAO = new ProductDAO(DatabaseConnection.getInstance());
		        try
		        {
		        	productDAO.update(obj);
		        	
		        }
		        catch(DaoException e)
		        {
		        	e.getMessage();
		        }
		        
		        //then redender the home view with success message
				
		        
		    return false;
		  }
		   
		  public Product find(int id) throws ClassNotFoundException, SQLException 
		  {
			  DAO<Product> productDAO = new ProductDAO(DatabaseConnection.getInstance());
			 Product product = new Product();
		      try
		        {
		        	productDAO.find(id);
		        	
		        	
		        }
		        catch(DaoException e)
		        {
		        	e.getMessage();
		        }
		      return product;
		        
		  }

}
