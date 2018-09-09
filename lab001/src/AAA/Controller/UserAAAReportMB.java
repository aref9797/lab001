
package  AAA.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import  AAA.ServiceInterface.PageVisitWebService;
import  AAA.ServiceInterface.SessionWebService;
import  baseService.JPAOp;
import  common.baseManagedBean;
import  AAA.Entity.Aapagevisit;
import  AAA.Entity.Aasession;
import  AAA.Entity.Aauser;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "UserAAAReportMB")
@ViewScoped

public class UserAAAReportMB extends baseManagedBean implements Serializable
{
	private static final long serialVersionUID = 1688315815404924568L;

	public UserAAAReportMB()
	{
		
	}

	private Aauser user = new Aauser();
	private Aasession session;


	//Services
	@Autowired
	private SessionWebService sessionService;
	@Autowired
	private PageVisitWebService pagevisitService;


	private List<Aasession> sessionList;

	@Override
	public void init()
	{
		super.init();
		//sessionList=sessionService.FindAllSessions();
	}


	public void getUserReport()
	{
		try
		{
			sessionList = sessionService.FindAllSessions(user.getUsername());
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}
	}


	//UC: report user sessions
	public List<Aasession> FindAllSessions()
	{
		return sessionList;
	}

	public List<Aapagevisit> FindAllPageVisits()
	{
		if (null == session)
			return new ArrayList<Aapagevisit>(); //pagevisitService.FindAll();
		else
			return pagevisitService.FindbyFields("aasession.id", JPAOp.Eq, session.getId(), "indate", JPAOp.Desc);
	}


	public void setSelectedRow(Aasession selectedrow)
	{
		this.session = selectedrow; // set selected row to base Object
	}



	//========================================= Setter & Getter

	public Aauser getUser()
	{
		return user;
	}

	public void setUser(Aauser user)
	{
		this.user = user;
	}


}
