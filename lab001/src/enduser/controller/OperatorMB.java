package enduser.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import Entity.Operator;
import baseService.JPAOp;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;
import enduser.ServiceInteerface.OperatorUCService;

@ManagedBean(name = "OperatorMB")
@SessionScoped
public class OperatorMB extends baseManagedBeanController<Operator> implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1363073333816782772L;
	
	public OperatorMB() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private OperatorUCService opservice;
	
	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();

		// new Base Object 
		baseEntity = new Operator();

		
		// new other Objects and set them into Base object
		
		
		// refresh Lists
		baseEntityList = opservice.FindAll("id", JPAOp.Asc);
	}
	
	public void AddEdit() throws gException
	{
		
		String result = "";
		try
		{
			if (isedit)
				opservice.Edit(baseEntity);
			else
				result = opservice.Add(baseEntity);

			ResetBaseObject();


			if (result.length() >= 1)
				JSFHelper.addInfoMessage(result);
			else
				JSFHelper.addInfoMessage("عملیات ثبت / ویرایش اطلاعات با موفقیت انجام شد");
		}
		
		catch (Exception ex)
		{
			CallCatch(ex);
		}

	}
	
	
	//Remove
	public void Remove(Operator baseEntity)
	{
		try
		{
			opservice.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		}
		
		catch (Exception ex)
		{
			CallCatch(ex);
		}
	}
	
	//=================================================================FindAll
	
	public List<Operator> find_all_operator()
	{
		return opservice.FindAll();
	}

}
