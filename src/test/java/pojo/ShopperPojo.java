package pojo;

public class ShopperPojo {
	private String email;
	private String role;
	private String password;
	
	
	//constructor
	public ShopperPojo(String email,  String password,String role) {
		super();
		this.email = email;
		this.role = role;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
