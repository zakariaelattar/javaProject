package Controller;

import java.sql.SQLException;

import Class.DatabaseConnection;
import Exception.DaoException;
import Model.Sale;
import dao.DAO;
import dao.SaleDAO;

public class saleController extends Controller {
	
	public boolean Create(Sale obj) throws ClassNotFoundException, SQLException
	{
		DAO<Sale> saleDAO = new SaleDAO(DatabaseConnection.getInstance());
        try
        {
        	saleDAO.create(obj);
        	
        }
        catch(DaoException e)
        {
        	e.getMessage();
        }
        
        //then redender the home view with success message
		
		
		return false;
	}
	public boolean Update(Sale obj) throws ClassNotFoundException, SQLException
	{
		DAO<Sale> saleDAO = new SaleDAO(DatabaseConnection.getInstance());
        try
        {
        	saleDAO.update(obj);
        	
        }
        catch(DaoException e)
        {
        	e.getMessage();
        }
        
        //then redender the home view with success message
		
		
		return false;
	}
	public boolean find(int id) throws ClassNotFoundException, SQLException
	{
		DAO<Sale> saleDAO = new SaleDAO(DatabaseConnection.getInstance());
        try
        {
        	saleDAO.find(id);
        	
        }
        catch(DaoException e)
        {
        	e.getMessage();
        }
        
        //then redender the home view with success message
		
		
		return false;
	}

}
