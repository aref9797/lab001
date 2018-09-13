
package  AAA.Controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import  AAA.ServiceInterface.AAAWebService;
import  common.SessionManager;
import  common.baseManagedBean;
import org.springframework.beans.factory.annotation.Autowired;


@ManagedBean(name = "LoginMB")
@SessionScoped

public class LoginMB extends baseManagedBean implements Serializable
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6836324851409380142L;


	public LoginMB()
	{
		
	}

	private String Username;
	private String Password;

	@Autowired
	private AAAWebService aaaService;


	public String Login()
	{
		try
		{
			aaaService.Login(Username, Password);
			return "Profile";
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}


		//if username or password is incorrect
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		return "Login";
	}


	//========================================= Logout	
	public void Logout() throws IOException
	{
		aaaService.Logout();
		FacesContext.getCurrentInstance().getExternalContext().redirect(SessionManager.getRequest().getContextPath() + "/ui/AAA/Login.xhtml");
	}


	//========================================= Setter & Getter
	
	public String getUsername()
	{
		return Username;
	}

	public void setUsername(String username)
	{
		Username = username;
	}

	public String getPassword()
	{
		return Password;
	}

	public void setPassword(String password)
	{
		Password = password;
	}

}