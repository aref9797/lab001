package maneger.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

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

				baseEntity.setPhoto(file.getFileName());
				ExternalContext extContext=FacesContext.getCurrentInstance().getExternalContext();
	            
			    File result1 = new File(extContext.getRealPath("//resources//images//Equipment//" + file.getFileName()));
			    
			    try {
			        FileOutputStream fileOutputStream = new FileOutputStream(result1);

			        byte[] buffer = new byte[10240 * 10240];

			        int bulk;
			        InputStream inputStream = file.getInputstream();
			        while (true) {
			               bulk = inputStream.read(buffer);
			               if (bulk < 0) {
			                   break;
			                }
			               fileOutputStream.write(buffer, 0, bulk);
			               fileOutputStream.flush();
			         }

			        fileOutputStream.close();
			        inputStream.close();


			        } catch (IOException e) {
			            e.printStackTrace();
			     }    
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
			JSFHelper.addInfoMessage("ط¹ظ…ظ„غŒط§طھ ط­ط°ظپ ط§ط·ظ„ط§ط¹ط§طھ ط¨ط§ ظ…ظˆظپظ‚غŒطھ ط§ظ†ط¬ط§ظ… ط´ط¯.");
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