package maneger.controller;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

import AAA.Entity.Aauser;
import AAA.ServiceInterface.UserWebService;
import Entity.Experiment;
import Entity.Laboratory;
import baseService.JPAOp;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;
import maneger.ServiceInteerface.ExperimentUCService;
import maneger.ServiceInteerface.LaboratoryUCService;
import test.filecreat;

@ManagedBean(name = "ExperimentMB")
@ViewScoped

public class ExperimentMB extends baseManagedBeanController<Experiment> implements Serializable 
{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4648337548545209358L;

	public ExperimentMB() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Autowired
	private ExperimentUCService expservice;
	
	@Autowired
	private LaboratoryUCService labuc;
	
	@Autowired
	private UserWebService useruc;
		
	//========================================================
	
	public List<Laboratory> lab_findAll()
	{
		return labuc.FindAll("id" , JPAOp.Asc);
	}
	
	//=========================================================
	
	public List<Aauser> find_exp_user()
	{
		return useruc.find_user_exp();
	}
	
	//=========================================================
	
	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();

		// new Base Object 
		baseEntity = new Experiment();

		
		// new other Objects and set them into Base object

		
		// refresh Lists
		baseEntityList = expservice.FindAll("id", JPAOp.Asc);
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
				expservice.Edit(baseEntity);
			else
				result = expservice.Add(baseEntity);

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
	public void Remove(Experiment baseEntity)
	{
		try
		{
			expservice.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد");
		}
		
		catch (Exception ex)
		{
			CallCatch(ex);
		}
	}
	
	//===========================================================
	
	private UploadedFile file;
	 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }

}