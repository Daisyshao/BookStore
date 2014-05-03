package bookstore.model;

import java.sql.Date;

public class Cart {

	private String id;
	private int user_id;
	private Date dt;
	private String state;
	
	public Cart(){}
	
	public String getId()
	{
		return this.id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	
	public int getUserId()
	{
		return this.user_id;
	}
	public void setUserId(int userId)
	{
		this.user_id = userId;
	}
	
	public Date getDate()
	{
		return this.dt;
	}
	public void setDate(Date d)
	{
		this.dt = d;
	}
	
	public String getState()
	{
		return this.state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
}
