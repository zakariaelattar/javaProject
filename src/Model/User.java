package Model;

import java.util.Date;

public class User  {
	
	int id;
	String name;
	String f_name;
	String phone;
	int flag_id;
	float salary;
	String cne;
	String recru_date;
	float leave_hours;
	String adress;
	int work_hour;
	String mail;
	String password;

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User()
	{
		
	}
	
	
	public User(int id, String name, String f_name, String phone, int flag_id, float salary, String cne,
		String recru_date, float leave_hours, String adress, int work_hour, String mail, String password) {
		super();
		this.id = id;
		this.name = name;
		this.f_name = f_name;
		this.phone = phone;
		this.flag_id = flag_id;
		this.salary = salary;
		this.cne = cne;
		this.recru_date = recru_date;
		this.leave_hours = leave_hours;
		this.adress = adress;
		this.work_hour = work_hour;
		this.mail = mail;
		this.password=password;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getFlag_id() {
		return flag_id;
	}

	public void setFlag_id(int flag_id) {
		this.flag_id = flag_id;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getWork_out() {
		return work_hour;
	}

	public void setWork_out(int work_hour) {
		this.work_hour = work_hour;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getRecru_date() {
		return recru_date;
	}

	public void setRecru_date(String recru_date) {
		this.recru_date = recru_date;
	}

	public float getLeave_hours() {
		return leave_hours;
	}

	public void setLeave_hours(float leave_hours) {
		this.leave_hours = leave_hours;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getWork_hour() {
		return work_hour;
	}

	public void setWork_hour(int work_hour) {
		this.work_hour = work_hour;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	

	}


