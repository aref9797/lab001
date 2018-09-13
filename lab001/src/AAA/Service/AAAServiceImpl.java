package AAA.Service;

import java.util.List;

import AAA.common.AAATools;
import AAA.common.ProfileUIModel;
import AAA.ServiceInterface.AAAWebService;
import baseService.baseUCServiceImpl;
import common.gCal;
import common.SendEmail;
import common.SessionManager;
import common.exception.gException;
import AAA.Entity.Aaaccesslist;
import AAA.Entity.Aasession;
import AAA.Entity.Aauser;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AAAServiceImpl extends baseUCServiceImpl<Aauser> implements AAAWebService
{



	//UC : Login
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void Login(String Username, String Password) throws Exception, gException
	{
		
		//Syntax Check
		if (Username.length() <= 0 || Username.length() > 100 || Password.length() <= 0 || Password.length() > 100)
			throw new gException("ابتدا نام کاربری یا کلمه عبور را وارد نمایید.");
		
		//Validation 
		String newHPassword = AAATools.getHashed(Password);
		List<Aauser> users = (List<Aauser>) em.createNamedQuery("Aauser.findbyUserPassDeactives").setParameter("username", Username)
					.setParameter("password", newHPassword).getResultList();
		
		
		if (users.size() <= 0)
			throw new gException("نام کاربری یا رمز عبور درست نیست.");
		
		if(!(users.get(0).getIsActive()))
			throw new gException("وضعیت کاربر در حالت غیر فعال قرار دارد . لطفا نسبت به تایید ایمیل خود اقدام نمایید.");


		// Login is OK
		Aauser user = users.get(0);


		//get User Access List to Session		
		List<Aaaccesslist> roleAccessList = (List<Aaaccesslist>) em.createNamedQuery("Aaaccesslist.findRoleAccessList")
					.setParameter("RoleId", user.getAarole().getId()).getResultList();
		SessionManager.setAccessList(roleAccessList);


		// go to Profile
		Aasession aasession = new Aasession();
		aasession.setAauser(user);
		aasession.setLogindate(gCal.getCurrentDateTime());
		aasession.setCilent(SessionManager.getClientInfo());
		aasession.setIsmanuallylogout(false);
		

//		em.merge(user);
		em.persist(aasession);
		em.flush();

		//session info for each user
		SessionManager.setSessionId(aasession.getId());

	}// end of Login




	//UC : Logout
	@Override
	@Transactional
	public void Logout()
	{
		if (!SessionManager.sessionExist())
		{
			SessionManager.Invalidate();
			return;
		}
		Aasession aasession = em.find(Aasession.class, SessionManager.getSessionId());
		aasession.setLogoutdate(gCal.getCurrentDateTime());
		aasession.setIsmanuallylogout(true);

		SessionManager.Invalidate();
	}




	//UC : ChangePassword
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void ChangePassword(String Username, String oldPassword, String newPassword) throws gException
	{
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		//Syntax Check
		if (Username.length() <= 0 || Username.length() > 100 || oldPassword.length() <= 0 || oldPassword.length() > 100
					|| newPassword.length() <= 0 || newPassword.length() > 100)
			throw new gException("ابتدا نام کاربری یا کلمه عبور فعلی و جدید را کامل وارد نمایید.");


		//Username of user itself
		Aasession aasession = em.find(Aasession.class, SessionManager.getSessionId());
		if (!(aasession.getAauser().getUsername().equals(Username)))
			throw new gException("لطفا نام کاربری خودتان را وارد نمایید.");


		//Validation of Username and Password 
		List<Aauser> users = (List<Aauser>) em.createNamedQuery("Aauser.findbyUserPass").setParameter("username", Username)
					.setParameter("password", AAATools.getHashed(oldPassword)).getResultList();
		
		if (users.size() <= 0)
			throw new gException("نام کاربری یا رمز عبور درست نیست.");

		//everything is OK
		aasession.getAauser().setHpassword(AAATools.getHashed(newPassword));
	}




	//UC : ChangeProfile
	@Override
	@Transactional
	public void ChangeProfile(ProfileUIModel profileUIModel)
	{
		//Syntax Check
		//it is done with Bean Validation

		//everything is OK
		Aasession aasession = em.find(Aasession.class, SessionManager.getSessionId());
		aasession.getAauser().setEmail(profileUIModel.getEmail());
		aasession.getAauser().setMobile(profileUIModel.getMobile());
	}


	//UC : getProfile
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ProfileUIModel getProfile()
	{
		ProfileUIModel profileUIModel = new ProfileUIModel();

		Aasession aasession = em.find(Aasession.class, SessionManager.getSessionId());
			
		profileUIModel.setName(aasession.getAauser().getName());
		profileUIModel.setFamily(aasession.getAauser().getFamily());
		profileUIModel.setMobile(aasession.getAauser().getMobile());
		profileUIModel.setMellicode(aasession.getAauser().getMellicode());
		profileUIModel.setUsername(aasession.getAauser().getUsername());
		profileUIModel.setEmail(aasession.getAauser().getEmail());
		profileUIModel.setStdcode(aasession.getAauser().getStdcode());
		
		List<Aasession> sessions = (List<Aasession>) em.createNamedQuery("Aasession.findlastlogin")
					.setParameter("userId", aasession.getAauser().getId()).setParameter("onlinesessionID", aasession.getId())
					.getResultList();
		
		if(sessions.size()== 0)
			profileUIModel.setLogincount((sessions.size()+1) + "");
		else
			profileUIModel.setLogincount(sessions.size() + "");
		
		if (sessions.size() > 0 && sessions.get(0).getLogoutdate() == null)
			profileUIModel.setLastlogindate(sessions.get(0).getLogindate().toString());
		
		else if(sessions.size() == 0)
			profileUIModel.setLastlogindate("اولین ورود شما به سیستم");

		return profileUIModel;
	}


	//UC : LostPassword
	@Override
	@Transactional
	public void LostPassword(String email) throws gException
	{
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		//Validation of username and email
		@SuppressWarnings("unchecked")
		List<Aauser> users = (List<Aauser>) em.createNamedQuery("Aauser.findbyEmail").setParameter("email", email).getResultList();
		if (users.size() <= 0)
			throw new gException("کاربری با این ایمیل در سیستم ثبت نشده است.");

		//Send New Password to user email
		String newpassword = AAATools.getRandomPassword();
		users.get(0).setHpassword(AAATools.getHashed(newpassword));
		String username = users.get(0).getUsername();
		String body = "نام کاربری : " + username + "\n\nرمز عبور جدید: " +  newpassword + "\n\n" + "در صورت تمایل پس از ورود به سیستم می توانید نسبت به تغییر رمز خود اقدام نمایید";
		
		@SuppressWarnings("unused")
		SendEmail em = new SendEmail(email, "آزمایشگاه مرکزی دانشگاه بناب", body);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public void Hit_Register(String hit) throws Exception, gException 
	{
	
		//Email and account confirmation in Register
		List<Aauser> user = (List<Aauser>) em.createNamedQuery("Aauser.findbyHit").setParameter("hit", hit).getResultList();
		if(user.size() <= 0)
			throw new gException("کد وارد شده صحیح نمی باشد");
		
		user.get(0).setIsActive(true);
	}
}