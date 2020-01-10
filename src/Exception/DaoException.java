package Exception;

public  class DaoException extends Exception {
	
	public DaoException(String type)
	{
		System.out.println("Cannot execute query type:"+type);
	}

}
