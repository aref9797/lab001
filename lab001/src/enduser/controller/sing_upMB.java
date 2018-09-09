//package enduser.controller;
//
//import java.io.Serializable;
//import java.util.List;
//
//import javax.faces.bean.ManagedBean;
//
//import AAA.Entity.Aarole;
//import AAA.Entity.Aauser;
//import AAA.ServiceInterface.RoleWebService;
//import AAA.ServiceInterface.UserWebService;
//import Entity.Enduser;
//import Entity.Guest;
//import baseService.JPAOp;
//import common.JSFHelper;
//import common.exception.gException;
//import enduser.ServiceInteerface.EnduserUCService;
//import enduser.ServiceInteerface.GuestUCService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import common.baseManagedBean;
//
//@ManagedBean(name ="sing_upMB")
//
//
//public class sing_upMB extends baseManagedBean implements Serializable
//{
//
//	private static final long serialVersionUID = 123434643565L;
//
//	public sing_upMB() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	@Override
//	public void init()
//	{
//		super.init();
//		userList = userServics.FindAll("aarole.name", JPAOp.Asc, "username", JPAOp.Asc);
//	}
//
//
//	//base Object (to Add/Edit/Remove)
//	private Guest guest;
//	
//	private Aauser Aauser;
//	
//	private Enduser enduser;
//	
//	
//	//base Object List (to Data Table)
//	private List<Aauser> userList;
//
//
//	//base Object and List (1-* objects)
//	private Aarole role;
//
//	public List<Aarole> FindAll_Aarole()
//	{
//		return roleService.FindAll();
//	}
//
//
//	@Autowired
//	private GuestUCService guestServics;
//	@Autowired
//	private RoleWebService roleService;
//
//	@Autowired
//	private EnduserUCService endServics;
//	
//	private UserWebService userServics;
//	
//	@Override
//	protected void ResetBaseObject()
//	{
//		super.ResetBaseObject();
//		guest = new Guest();
//		role = new Aarole();
//		Aauser.setAarole(role);
//		enduser.setAauser(Aauser);
//		guest.setEnduser(enduser);
//	}
//
//
//	//UC: Add/Edit
//	public void AddEdit() throws gException
//	{
//		String s = "";
//		try
//		{
//			
//			userServics.Add(Aauser);
//			
//			
//			enduser.setAauser(Aauser);
//			enduser.setHitpass((long) 45645);
//			enduser.setIsactive(true);
//			
//			endServics.Add(enduser);
//			
//			
//			guest.setEnduser(enduser);
//			guestServics.Add(guest);
//			
//			ResetBaseObject();
//			userList = userServics.FindAll("aarole.name", JPAOp.Asc, "username", JPAOp.Asc);
//			if (s.length() >= 1)
//				JSFHelper.addInfoMessage(s);
//			else
//				JSFHelper.addInfoMessage("عملیات ثبت / ویرایش اطلاعات با موفقیت انجام شد");
//		}
//		catch (Exception ex)
//		{
//			CallCatch(ex);
//		}
//
//	}
//
//	public Guest getGuest() {
//		return guest;
//	}
//
//	public void setGuest(Guest guest) {
//		this.guest = guest;
//	}
//
//	public Aauser getAauser() {
//		return Aauser;
//	}
//
//	public void setAauser(Aauser aauser) {
//		Aauser = aauser;
//	}
//
//	public Enduser getEnduser() {
//		return enduser;
//	}
//
//	public void setEnduser(Enduser enduser) {
//		this.enduser = enduser;
//	}
//
//	public List<Aauser> getUserList() {
//		return userList;
//	}
//
//	public void setUserList(List<Aauser> userList) {
//		this.userList = userList;
//	}
//
//	public Aarole getRole() {
//		return role;
//	}
//
//	public void setRole(Aarole role) {
//		this.role = role;
//	}
//
//	//UC: Remove
////	public void Remove(Aauser user)
////	{
////		try
////		{
////			userService.Remove(user);
////			userList = userService.FindAll("aarole.name", JPAOp.Asc, "username", JPAOp.Asc);
////			ResetBaseObject();
////			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد");
////		}
////		catch (Exception ex)
////		{
////			CallCatch(ex);
////		}
////	}
////
////
////
////	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    for Data Table 
////	public void setSelectedRow(Aauser selectedrow)
////	{
////		this.user = selectedrow; // set selected row to base Object
////		isedit = true; // set editable to true
////	}
//
//
//
//	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ setter & getter
//
//	
//
//
//
//
//	
//	
//}
