package bookstore.model;

public class User
{
	private int id;
	private String name;
    private String password;
    private String password1;
    private String email;
    
	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
 
    public String getName()
    {
        return name;
    }
 
    public void setName(String name)
    {
        this.name = name;
    }
 
    public String getPassword()
    {
        return password;
    }
 
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public void setEmail(String email)
    {
    	this.email = email;
    }
    
    public String getEmail()
    {
        return email;
    }
 
}

