package AAA.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import AAA.ServiceInterface.AAAWebService;
import common.baseManagedBean;

@ManagedBean(name = "HitRegisterMB")
@SessionScoped

public class HitRegisterMB extends baseManagedBean implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5495225442183065014L;
	
	private String hit;
	
	@Autowired
	private AAAWebService aaaService;
	
	public String HitRegister(String hit)
	{
		try 
		{
			aaaService.Hit_Register(hit);
			return "Login";
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}
		
		//if incorrect
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		return "HitPass";
	}
	
	//========================================= Setter & Getter
	
	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}
	
}