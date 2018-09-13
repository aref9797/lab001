
package  AAA.Service;

import java.util.List;

import  AAA.common.AAATools;
import  AAA.ServiceInterface.UserWebService;
import  baseService.baseUCServiceImpl;
import common.SendEmail;
import  common.exception.gException;
import  AAA.Entity.Aauser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends baseUCServiceImpl<Aauser> implements UserWebService
{

	Aauser user = new Aauser();
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public String Add(Aauser user) throws Exception, gException
	{
	
		// check the unique of username
		List<Aauser> users = (List<Aauser>) em.createNamedQuery("Aauser.findbyUsername")
					.setParameter("username", user.getUsername()).getResultList();
		if (users.size() > 0)
			throw new gException("نام کاربری قبلا در سیستم ثبت شده است، لطفا از نام کاربری دیگری استفاده کنید.");
		
		if(user.getUsername().length() < 3 || user.getUsername().length() >10)
			throw new gException("تعداد کاراکتر نام کاربری باید بین 3 تا 10 باشد.");
		
		
		//check the unique of email
		List<Aauser> lu = (List<Aauser>) em.createNamedQuery("Aauser.findbyEmail").setParameter("email", user.getEmail()).getResultList();
		if(lu.size() > 0)
			throw new gException("ایمیل مورد نظر قبلا در سیستم ثبت شده است، لطفا از ایمیل دیگری استفاده کنید.");
		
		String hit = AAATools.getRandomPassword();
		user.setHit(hit);
		String body = "رمز مورد نیاز برای تایید ایمیل و تکمیل فرآیند ثبت نام : " + hit + "\n\n" + "رمز مورد نظر را در قسمت مربوطه در سایت وارد کنید.";
		
		@SuppressWarnings("unused")
		SendEmail em = new SendEmail(user.getEmail(), "آزمایشگاه مرکزی دانشگاه بناب", body);
		
		//Convert to HPassword
		String newHPassword = AAATools.getHashed(user.getHpassword());
		user.setHpassword(newHPassword);
		
		if(user.getAarole().getId() == 4)
			user.setType("student");
		if(user.getAarole().getId() == 5)
		{
			user.setType("profesor");
			user.setCharge(0);
		}
		if(user.getAarole().getId() == 6)
			user.setType("guest");
			
		user.setIsActive(false);
		
		return super.Add(user);
	}

	@Override
	@Transactional
	public Aauser Edit(Aauser user) throws Exception, gException
	{
		// check the unique of username
		Aauser tempUser = em.find(Aauser.class, user.getId());
		user.setUsername(tempUser.getUsername());

		super.Edit(user);
		return null;
	}
	
	//============================================================Select Guest and Student and Professor

	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Aauser> find_guest() {

		List<Aauser> lr = (List<Aauser>) em.createQuery("from Aauser a where a.type = 'guest' ").getResultList();
		return lr;
	}

	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Aauser> find_student() {

		List<Aauser> ld = (List<Aauser>) em.createQuery("from Aauser a where a.type = 'student' ").getResultList();
		return ld;
	}
	
	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Aauser> find_accstudent() {

		List<Aauser> ld = (List<Aauser>) em.createQuery("from Aauser a where a.type = 'student' and a.isaccept = 'false' ").getResultList();
		return ld;
	}

	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Aauser> find_professor() {
		
		List<Aauser> lo = (List<Aauser>) em.createQuery("from Aauser a where a.type = 'profesor' ").getResultList();
		return lo;
	}
	
	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Aauser> find_accprofessor() {
		
		List<Aauser> lo = (List<Aauser>) em.createQuery("from Aauser a where a.type = 'profesor' and a.isaccept = 'false' ").getResultList();
		return lo;
	}
	
	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Aauser> find_acceptprofessor() {
		
		List<Aauser> lo = (List<Aauser>) em.createQuery("from Aauser a where a.type = 'profesor' and a.isaccept = 'true' ").getResultList();
		return lo;
	}
	
	
	//===================================================================ProfessorCharge
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Aauser> accept_professor() 
	{
		List<Aauser> ch = (List<Aauser>) em.createQuery("from Aauser a where a.type = 'profesor' and a.isaccept = 'true' ").getResultList();
		return ch;
	}
	
	
	@Override
	@Transactional
	public void Professor_Charge(Aauser user , Integer charg) 
	{
		user.setCharge(charg);
		
		try
		{
			super.Edit(user);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	//===================================================================UserAcception

	@Override
	@Transactional
	public void UserACC(Aauser user) 
	{
		user.setIsaccept(true);
		
		try 
		{
			super.Edit(user);
		} 
		catch (gException ex)
		{
			ex.printStackTrace();
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	//===================================================================

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Aauser> find_user_exp() 
	{
		List<Aauser> query = em.createQuery("Select a from Aauser a where a.isaccept='true' and a.isActive='true' " + 
						"and(a.id IN (select p from Experiment p))").getResultList();
		return query;
	}


}