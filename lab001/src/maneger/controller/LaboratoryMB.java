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
import javax.servlet.http.HttpServletRequest;

import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;

import AAA.Entity.Aauser;
import AAA.ServiceInterface.UserWebService;
import Entity.Laboratory;
import baseService.JPAOp;
import common.JSFHelper;
import common.baseManagedBeanController;
import common.exception.gException;
import maneger.ServiceInteerface.LaboratoryUCService;
import test.filecreat;

@ManagedBean(name = "LaboratoryMB")
@SessionScoped

public class LaboratoryMB extends baseManagedBeanController<Laboratory> implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5925275597609889676L;
	
	
	public LaboratoryMB() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Autowired
	private LaboratoryUCService labservice;
	
	@Autowired
	private UserWebService user;
	
	public List<Aauser> user_findAll()
	{
		return user.FindAll("id", JPAOp.Asc);
	}
	
	
	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();

		// new Base Object 
		baseEntity = new Laboratory();

		
		// new other Objects and set them into Base object
		
		
		// refresh Lists
		baseEntityList = labservice.FindAll("id", JPAOp.Asc);
	}
	
	//Add---Edit
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
	            
			    File result1 = new File(extContext.getRealPath("//resources//images//Laboratory//" + file.getFileName()));
			    
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
			
//				moveWithFileNIO(filename);
			}
			if (isedit)
				labservice.Edit(baseEntity);
			else
				result = labservice.Add(baseEntity);

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
	public void Remove(Laboratory baseEntity)
	{
		try
		{
			labservice.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		}
		
		catch (Exception ex)
		{
			System.out.println("catch");
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