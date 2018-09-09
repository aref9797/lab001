package enduser.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import AAA.common.AAATools;
import Entity.Operator;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import enduser.ServiceInteerface.OperatorUCService;

@Service
public class OperatorServiceImpl extends baseUCServiceImpl<Operator> implements OperatorUCService
{
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public String Add(Operator entity) throws Exception, gException 
	{
		
		if(entity.getName().length() < 4)
			throw new gException("نام مسئول باید بیشتر از 3 کاراکتر باشد");
		
		if(entity.getFamily().length()<4)
			throw new gException("نام خانوادگی باید بیشتر از 3 کاراکتر باشد");
		
		if(entity.getUsername().length()<3)
			throw new gException("نام کاربری باید بیشتر از 2 کاراکتر باشد");
		
		List<Operator> ol = em.createNamedQuery("Operator.findbyusername").setParameter("username", entity.getUsername()).getResultList();
		if(ol.size()>0)
			throw new gException("نام کاربری مورد نظر قبلا در سیستم ثبت شده است");
		
		List<Operator> oe = em.createNamedQuery("Operator.findbyemail").setParameter("email", entity.getEmail()).getResultList();
		if(oe.size()>0)
			throw new gException("ایمیل مورد نظر قبلا در سیستم ثبت شده است");
		
		String Hpass = AAATools.getHashed(entity.getPassword());
		entity.setPassword(Hpass);
		
		return super.Add(entity);
	}
	
	@Override
	@Transactional
	public Operator Edit(Operator entity) throws Exception, gException {
		
		if(entity.getName().length() < 4)
			throw new gException("نام مسئول باید بیشتر از 3 کاراکتر باشد");
		
		if(entity.getFamily().length()<4)
			throw new gException("نام خانوادگی باید بیشتر از 3 کاراکتر باشد");
		
		if(entity.getUsername().length()<3)
			throw new gException("نام کاربری باید بیشتر از 2 کاراکتر باشد");
		
		return super.Edit(entity);
	}
	
	@Override
	@Transactional
	public void Remove(Operator entity) throws Exception, gException {
		
		super.Remove(entity);
	}

}
