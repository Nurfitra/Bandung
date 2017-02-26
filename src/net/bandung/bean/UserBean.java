package net.bandung.bean;

public class UserBean {

    private int id;
    private String Uname;
    private String Email;
    private String Pass;
    public boolean valid;
        
    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String Uname) {
		this.Uname = Uname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}	
	public String getPass() {
		return Pass;
	}
	public void setPass(String Pass) {
		this.Pass = Pass;
	}	
    public boolean isValid() {
        return valid;
	}
    public void setValid(boolean newValid) {
        valid = newValid;
	}	
}