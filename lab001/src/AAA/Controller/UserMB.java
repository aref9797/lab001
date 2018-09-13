package  AAA.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import  AAA.ServiceInterface.RoleWebService;
import  AAA.ServiceInterface.UserWebService;
import  baseService.JPAOp;
import common.JSFHelper;
//import  common.JSFHelper;
//import  common.exception.gException;
import  common.baseManagedBean;
import  AAA.Entity.Aarole;
import  AAA.Entity.Aauser;

import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "UserMB")
@SessionScoped

public class UserMB extends baseManagedBean implements Serializable
{
	private static final long serialVersionUID = 123434643565L;

	public UserMB()
	{
		
	}

	@Override
	public void init()
	{
		super.init();
		userList = userService.FindAll("aarole.name", JPAOp.Asc, "username", JPAOp.Asc);
	}

	//base Object (to Add/Edit/Remove)
	private Aauser user;
	//base Object List (to Data Table)
	private List<Aauser> userList;


	//base Object and List (1-* objects)
	private Aarole role;

	public List<Aarole> FindAll_Aarole()
	{
		return roleService.FindAll();
	}
	
	

	@Autowired
	private UserWebService userService;
	@Autowired
	private RoleWebService roleService;

	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();
		user = new Aauser();
		role = new Aarole();
		user.setAarole(role);
	}
	
	//=======================================================User and Student and Professor Lists
	
	public List<Aauser> FindAllGuest()
	{
		return userService.find_guest();
	}
	
	public List<Aauser> FindAllStudent()
	{
		return userService.find_student();
	}
	
	public List<Aauser> FindACCStudent()
	{
		return userService.find_accstudent();
	}
	
	public List<Aauser> FindAllProfessor()
	{
		return userService.find_professor();
	}
	
	public List<Aauser> FindACCProfessor()
	{
		return userService.find_accprofessor();
	}
	
	public List<Aauser> AcceptProfessor()
	{
		return userService.accept_professor();
	}
	
	//=========================================================ProfessorCharge
	
	public List<Aauser> AcceptProfessorCharge()
	{
		return userService.find_acceptprofessor();
	}
	
	public void ProfessorCharge(Aauser user , Integer charg)
	{
		try 
		{
			userService.Professor_Charge(user, charg);
		} 
		catch (Exception ex) 
		{
			CallCatch(ex);
		}
	}
	
	//=========================================================
	
	public void userAccept(Aauser user)
	{
		try 
		{
			userService.UserACC(user);
		} 
		catch (Exception ex) 
		{
			CallCatch(ex);
		}
		
	}
	
	//UC: Add/Edit
	public String AddEdit()
	{
//		String s = "";
		try
		{
//			if (isedit)
//				userService.Edit(user);
//			else
			userService.Add(user);

			ResetBaseObject();
			userList = userService.FindAll("aarole.name", JPAOp.Asc, "username", JPAOp.Asc);
//			if (s.length() >= 1)
//				JSFHelper.addInfoMessage(s);
//			else
			return "HitPass";
			
		}
		
		catch (Exception ex)
		{
			CallCatch(ex);
		}
		
		return "Register";
	}

	//UC: Remove
	public void Remove(Aauser user)
	{
		try
		{
			userService.Remove(user);
//			userList = userService.FindAll("username", JPAOp.Asc);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد");
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}
	}

	//========================================= for Data Table 
	
//	public void setSelectedRow(Aauser selectedrow)
//	{
//		this.user = selectedrow; // set selected row to base Object
//		isedit = true; // set editable to true
//	}



	//========================================= Setter & Getter

	public Aauser getUser()
	{
		return user;
	}

	public void setUser(Aauser user)
	{
		this.user = user;
	}

	public List<Aauser> getUserList()
	{
		return userList;
	}

	public void setUserList(List<Aauser> userList)
	{
		this.userList = userList;
	}

	public Aarole getRole()
	{
		return role;
	}

	public void setRole(Aarole role)
	{
		this.role = role;
	}

}