package Controller;

import java.sql.SQLException;

import Class.DatabaseConnection;
import Exception.DaoException;
import Model.User;
import dao.DAO;
import dao.UserDAO;

public class UserController extends Controller {
	
	
	public boolean Create(User obj) throws ClassNotFoundException, SQLException
	{
		DAO<User> userDAO = new UserDAO(DatabaseConnection.getInstance());
        try
        {
        	userDAO.create(obj);
        	
        }
        catch(DaoException e)
        {
        	e.getMessage();
        }
        
        
        //then redender the home view with success message
		
		
		return false;
	}
	public boolean Update(User obj) throws ClassNotFoundException, SQLException
	{
		DAO<User> userDAO = new UserDAO(DatabaseConnection.getInstance());
        try
        {
        	userDAO.update(obj);
        	
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
		DAO<User> userDAO = new UserDAO(DatabaseConnection.getInstance());
		
        try
        {
        	userDAO.find(id);
        	
        }
        catch(DaoException e)
        {
        	e.getMessage();
        }
        
        //then redender the home view with success message
		
		
		return false;
	}

	public static User  findByMail(String email) throws ClassNotFoundException, SQLException
	{
		UserDAO userDAO = new UserDAO(DatabaseConnection.getInstance());
		User user=null;
        try
        {
        	user=userDAO.findByMail(email);
        	
        }
        catch(Exception e)
        {
        	e.getMessage();
        }
		return user;
	}
}
