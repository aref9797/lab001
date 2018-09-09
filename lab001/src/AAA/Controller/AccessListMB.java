
package AAA.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import AAA.ServiceInterface.AccessListWebService;
import AAA.ServiceInterface.PageWebService;
import AAA.ServiceInterface.RoleWebService;
import baseService.JPAOp;
import common.JSFHelper;
import common.baseManagedBean;
import AAA.Entity.Aaaccesslist;
import AAA.Entity.Aapage;
import AAA.Entity.Aarole;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "AccessListMB")
@SessionScoped

public class AccessListMB extends baseManagedBean implements Serializable
{
	private static final long serialVersionUID = -2120581101403943346L;

	public AccessListMB()
	{
		
	}

	@Override
	public void init()
	{
		super.init();
		roleList = roleService.FindAll("id", JPAOp.Asc);
		pageList = pageService.FindAll("aapagecat.orders", JPAOp.Asc, "orders", JPAOp.Asc);
		selectedRole = roleService.FindbyId(1);
		roleId = roleList.get(0).getId();
		loadAccessList(roleId);
	}


	//base Object (to Add/Edit/Remove)
	private Aarole selectedRole;
	//base Object List (to Data Table)
	private List<Aarole> roleList;
	private List<Aapage> pageList;
	private long selectedpageList[];
	private long roleId;


	@Autowired
	private RoleWebService roleService;
	@Autowired
	private PageWebService pageService;
	@Autowired
	private AccessListWebService accesslistService;



	private void loadAccessList(long id)
	{
		roleId = id;
		List<Aaaccesslist> temp;
		temp = accesslistService.FindbyFields("aarole.id", JPAOp.Eq, roleId);
		selectedpageList = new long[temp.size()];
		int cA = 0;
		for (Aaaccesslist aaa : temp)
		{
			selectedpageList[cA++] = aaa.getAapage().getId();
		}
	}

	// change event
	public void RoleChange(ValueChangeEvent event)
	{
		loadAccessList((long) event.getNewValue());
	}


	public void Save()
	{
		try
		{
			accesslistService.Add(roleId, selectedpageList);
			JSFHelper.addInfoMessage("عملیات ثبت / ویرایش اطلاعات با موفقیت انجام شد");
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}
	}


	//========================================= Setter & Getter

	public List<Aarole> getRoleList()
	{
		return roleList;
	}

	public void setRoleList(List<Aarole> roleList)
	{
		this.roleList = roleList;
	}

	public List<Aapage> getPageList()
	{
		return pageList;
	}

	public void setPageList(List<Aapage> pageList)
	{
		this.pageList = pageList;
	}


	public long[] getSelectedpageList()
	{
		return selectedpageList;
	}

	public void setSelectedpageList(long[] selectedpageList)
	{
		this.selectedpageList = selectedpageList;
	}

	public Aarole getSelectedRole()
	{
		return selectedRole;
	}

	public void setSelectedRole(Aarole selectedRole)
	{
		this.selectedRole = selectedRole;
	}



}
