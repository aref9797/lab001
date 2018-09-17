package maneger.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import Entity.ExpReservaion;
import Entity.Experiment;
import baseService.JPAOp;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;
import maneger.ServiceInteerface.ExpReservaionUCService;

@ManagedBean(name = "ExpReservationMB")
@SessionScoped
public class ExpReservationMB extends baseManagedBeanController<ExpReservaion> implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2283794620804833608L;
	
	public ExpReservationMB() 
	{
		
	}
	
	@Autowired
	private ExpReservaionUCService expreservuc;
	
	private Experiment exp;
	
	
	@Override
	protected void ResetBaseObject() 
	{
		super.ResetBaseObject();
		
		baseEntity = new ExpReservaion();
		
		exp = new Experiment();
		baseEntity.setExperiment(exp);
		
		baseEntityList = expreservuc.FindAll("id", JPAOp.Asc);
	}
	
	//========================================================================Add
	
	public void Add() throws gException
	{
		try
		{
			expreservuc.Add(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات با موفقیت انجام شد");
		} 
		catch (Exception ex) 
		{
			CallCatch(ex);
		}
	}
	
	//========================================================================Setter and Getter
	
	public Experiment getExp() {
		return exp;
	}

	public void setExp(Experiment exp) {
		this.exp = exp;
	}

}