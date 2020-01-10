package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Exception.DaoException;

/*
 * class handling connection with database
 * */

public abstract class DAO<T> {
	 protected Connection connect = null;

	 
	   
	  public DAO(Connection conn){
	    this.connect = conn;
	  }
	   
	  /**
	  * Méthode de création
	  * @param obj
	  * @return boolean 
	 * @throws DaoException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	  */
	  public abstract boolean create(T obj) throws DaoException, SQLException, ClassNotFoundException;

	  /**
	  * Méthode pour effacer
	  * @param obj
	  * @return boolean 
	 * @throws SQLException 
	  */
	  public abstract boolean delete(T obj) throws DaoException, SQLException;

	  /**
	  * Méthode de mise à jour
	  * @param obj
	  * @return boolean
	 * @throws DaoException 
	 * @throws SQLException 
	  */
	  public abstract boolean update(T obj) throws DaoException, SQLException;

	  /**
	  * Méthode de recherche des informations
	  * @param id
	  * @return T
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	  */
	  public abstract T find(int id) throws DaoException, ClassNotFoundException, SQLException;
	 
}
