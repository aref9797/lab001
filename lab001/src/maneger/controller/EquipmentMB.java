package maneger.controller;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

import Entity.Equipment;
import Entity.Laboratory;
import baseService.JPAOp;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;
import maneger.ServiceInteerface.EquipmentUCService;
import maneger.ServiceInteerface.LaboratoryUCService;
import test.filecreat;

@ManagedBean(name = "EquipmentMB")
@SessionScoped

public class EquipmentMB extends baseManagedBeanController<Equipment> implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4291245504728705554L;

	public EquipmentMB() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Autowired
	private EquipmentUCService equservice;
	
	@Autowired
	private LaboratoryUCService labuc;
	
	public List<Laboratory> lab_findAll()
	{
		return labuc.FindAll("id", JPAOp.Asc);
	}
	
	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();

		// new Base Object 
		baseEntity = new Equipment();

		
		// new other Objects and set them into Base object
		
		
		// refresh Lists
		baseEntityList = equservice.FindAll("id", JPAOp.Asc);
	}
	
	@SuppressWarnings("unused")
	public void AddEdit() throws gException
	{
		
		String result = "";
		
		try
		{
			if(file!=null)
			{
				String filename=file.getFileName();
				baseEntity.setPhoto(file.getFileName());
				
				filecreat file=new filecreat();
				File f=file.creat(filename);
			}
			if (isedit)
				equservice.Edit(baseEntity);
			else
				result = equservice.Add(baseEntity);

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
	public void Remove(Equipment baseEntity)
	{
		try
		{
			equservice.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		}
		
		catch (Exception ex)
		{
			CallCatch(ex);
		}
	}
	
	//================================================================
		private UploadedFile file;
		 
	    public UploadedFile getFile() {
	        return file;
	    }
	 
	    public void setFile(UploadedFile file) {
	        this.file = file;
	    }

}