package maneger.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entity.Chargelist;
import common.baseManagedBeanController;

@ManagedBean(name = "ChargeListMB")
@SessionScoped
public class ChargeListMB extends baseManagedBeanController<Chargelist> implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6776403095429089444L;
	
	
	public ChargeListMB() {
		// TODO Auto-generated constructor stub
	}
	
}
