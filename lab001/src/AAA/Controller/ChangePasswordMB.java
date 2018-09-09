package  AAA.Controller;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import  AAA.ServiceInterface.AAAWebService;
import  common.JSFHelper;
import  common.baseManagedBean;
import org.springframework.beans.factory.annotation.Autowired;


@ManagedBean(name = "ChangePasswordMB")
@SessionScoped

public class ChangePasswordMB extends baseManagedBean implements Serializable
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1293401742964905605L;
	
	private String username;
	private String oldPassword;
	private String newPassword;
	private String newPassword2;

	@Autowired
	private AAAWebService aaaService;

	public String ChangePassword()
	{
		try
		{
			if(newPassword.equals(oldPassword))
				JSFHelper.addErrorMessage("رمز عبور جدید باید با رمز عبور قبلی متفاوت باشد.");
			
			
			if (!(newPassword.equals(newPassword2)))
				JSFHelper.addErrorMessage("رمز عبور با تکرار رمز عبور تطابقت ندارد.");
			
			else
			{
				aaaService.ChangePassword(username, oldPassword, newPassword);
				JSFHelper.addInfoMessage("رمز عبور شما با موفقیت تغییر یافت.");
			}
			
			return "ChangePassword";
		}
		
		catch (Exception ex)
		{
			CallCatch(ex);
		}

		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		return "ChangePassword";
	}

	//========================================= Setter & Getter

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getOldPassword()
	{
		return oldPassword;
	}

	public void setOldPassword(String oldPassword)
	{
		this.oldPassword = oldPassword;
	}

	public String getNewPassword()
	{
		return newPassword;
	}

	public void setNewPassword(String newPassword)
	{
		this.newPassword = newPassword;
	}

	public String getNewPassword2()
	{
		return newPassword2;
	}

	public void setNewPassword2(String newPassword2)
	{
		this.newPassword2 = newPassword2;
	}

}