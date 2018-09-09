package AAA.common;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

public class ProfileUIModel 
{
	private String name;
	private String family;
	private String type;
	private String username;
	private String password;
	private String lastlogindate;
	private String logincount;
	
	
	@Email (message="مقدار ایمیل را درست وارد نمایید")
	private String email;
	
	@Pattern(regexp="(^$|[0-9]{11})")
	private String mobile;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	private String mellicode;
	
	@Pattern(regexp="(^$|[0-9]{9})")
	private String stdcode;
	
	
	//=======================================================Setter && Getter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getLastlogindate() {
		return lastlogindate;
	}

	public void setLastlogindate(String lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	public String getMellicode() {
		return mellicode;
	}

	public void setMellicode(String mellicode) {
		this.mellicode = mellicode;
	}

	public String getStdcode() {
		return stdcode;
	}

	public void setStdcode(String stdcode) {
		this.stdcode = stdcode;
	}

	public String getLogincount() {
		return logincount;
	}

	public void setLogincount(String logincount) {
		this.logincount = logincount;
	}
	
}