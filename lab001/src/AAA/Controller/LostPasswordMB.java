package  AAA.Controller;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import  AAA.ServiceInterface.AAAWebService;
import  common.JSFHelper;
import  common.baseManagedBean;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "LostPasswordMB")
@RequestScoped

public class LostPasswordMB extends baseManagedBean implements Serializable
{
	private static final long serialVersionUID = -4211268661573721974L;

	private String email;

	@Autowired
	private AAAWebService aaaService;


	public String LostPassword()
	{
		try
		{
			aaaService.LostPassword(email);
			JSFHelper.addInfoMessage("رمز جدید  با موفقیت به ایمیل شما ارسال شد.");
			return "LostPassword";
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}
		return "LostPassword";
	}

	//========================================= Setter & Getter

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

}