package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Exception.DaoException;
import Model.User;
import libs.SqlQueryBuilder;

public class UserDAO extends DAO<User> {

	  public UserDAO(Connection conn) {
		    super(conn);
		  }

		  public boolean create(User obj) throws SQLException, DaoException 
		  {
			  
			  Statement stmt = this.connect.createStatement();
			  
			  
				SqlQueryBuilder builder = new SqlQueryBuilder(); //query builder
				String query = builder.insertInto("users")
						.value("id", 0)
						.value("name",obj.getName())
						.value("f_name",obj.getF_name())
						.value("phone",obj.getPhone())
						.value("flag_id",obj.getFlag_id())
						.value("salary",obj.getSalary())
						.value("cne",obj.getCne())
						.value("recru_date", obj.getRecru_date())
						.value("leave_hours",obj.getLeave_hours())
						.value("adress",obj.getAdress())
						.value("work_hour",obj.getWork_hour())
						.value("mail",obj.getMail())
						.value("password", "111").query();
				
				int state = stmt.executeUpdate(query);
				if(state == 0) throw new DaoException("create");
				
					
			
		
		    return true;
		  }

		  
		  public boolean delete(User obj) throws SQLException, DaoException {
			  
			  
			  
			  Statement stmt = this.connect.createStatement();
			  SqlQueryBuilder builder = new SqlQueryBuilder();
			  
			  String query = builder
			      .delete("users")
			      .whereEquals("id", obj.getId())
			      .query();
			  
				int state = stmt.executeUpdate(query);
				if(state == 0) throw new DaoException("delete");
					
			
		    return false;
		  }
		   
		  public boolean update(User obj) throws DaoException, SQLException {
			  
			  
			  Statement stmt = this.connect.createStatement();
			  SqlQueryBuilder builder = new SqlQueryBuilder();
			  String query = builder
			      .update("users")
			      .set("FirstName", "John")
			      .set("Age", 21)
			      .whereEqual("id", obj.getId())
			      .query();
				int state = stmt.executeUpdate(query);
				if(state == 0) throw new DaoException("update");
					
			
		    return false;
		  }
		   
		  public User find(int id) {
			  User user = new User();    
			  SqlQueryBuilder builder = new SqlQueryBuilder();
			  String query = builder
					  .select()
					  .from("users")
					  .whereEqual("id", id)
					  .query();				      
		      
		    try {
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(query);
		      if(result.first())
		      {
		    	  
		    	
		    	 String name = result.getString("name") ;
		    	 String f_name = result.getString("f_name");
		    	 String phone =  result.getString("phone");
		    	 String cne = result.getString("cne");
		    	 float salary = result.getFloat("salary");
		    	 String adress =  result.getString("adress");
		    	  String mail =  result.getString("mail");
		    	  String password = result.getString("password");
		    	 int flag_id = result.getInt("flag_id");
		    	 int work_hour = result.getInt("work_hour");
		    	 String recru_date = result.getDate("recru_date").toString();
		    	 int leave_hours = result.getInt("leave_hours");
		    	 
		    	  user = new User( id,  name,  f_name,  phone,  flag_id,  salary,cne, recru_date,  leave_hours,  adress,  work_hour,  mail,password);         
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return user;
		  }
		  public User findByMail(String email) {
			  User user=null;    
			  SqlQueryBuilder builder = new SqlQueryBuilder();
			  String query = builder
					  .select()
					  .from("users")
					  .whereEqual("mail", email)
					  .query();				      
		      
		    try {
		      ResultSet result = this.connect.createStatement(
		        ResultSet.TYPE_SCROLL_INSENSITIVE,
		        ResultSet.CONCUR_READ_ONLY).executeQuery(query);
		      if(result.first())
		      {
		    	  
		    	 int id= result.getInt("id");
		    	 String name = result.getString("name") ;
		    	 String f_name = result.getString("f_name");
		    	 String phone =  result.getString("phone");
		    	 String cne = result.getString("cne");
		    	 float salary = result.getFloat("salary");
		    	 String adress =  result.getString("adress");
		    	  String mail =  result.getString("mail");
		    	  String password= result.getString("password");
		    	 int flag_id = result.getInt("flag_id");
		    	 int work_hour = result.getInt("work_hour");
		    	 String recru_date = result.getDate("recru_date").toString();
		    	 int leave_hours = result.getInt("leave_hours");
		    	 
		    	  user = new User( id,  name,  f_name,  phone,  flag_id,  salary,cne, recru_date,  leave_hours,  adress,  work_hour,  mail,password);         
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return user;
		  }
		 
		  
		  

}
