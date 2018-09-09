package maneger.Service;

import maneger.ServiceInteerface.LaboratoryUCService;
import Entity.Laboratory;
import baseService.baseUCServiceImpl;
import common.exception.gException;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class LaboratoryServiceImpl extends baseUCServiceImpl<Laboratory> implements LaboratoryUCService
{

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public String Add(Laboratory entity) throws Exception, gException 
	{
		//do Business Logic HERE
		
		if (entity.getName().length() < 4)
			throw new gException("نام آزمایشگاه باید بیشتر از 3 کاراکتر باشد");
		
		else if(entity.getResponsible().length() < 4)
			throw new gException("نام مسئول آزمایشگاه باید بیشتر از 3 کاراکتر باشد");
			
		else if(entity.getDetailes().length() < 4)
			throw new gException("توضیحات آزمایشگاه باید بیشتر از 3 کاراکتر باشد");
		
		List<Laboratory> ln = em.createNamedQuery("Laboratory.findbyname").setParameter("name", entity.getName()).getResultList();
		
		if(ln.size()>0)
			throw new gException("آزمایشگاه با این نام قبلا در سیستم ثبت شده است");
		
//		List<Aauser> au = em.createNamedQuery("Aauser.findbyname").setParameter("name", entity.getResponsible()).getResultList();
//		
//		entity.setMUser(au.get(0));
		
		
		return super.Add(entity);
	}


	@Override
	@Transactional
	public Laboratory Edit(Laboratory entity)  throws Exception,gException
	{

		//do Business Logic HERE
		if (entity.getName().length() < 4)
			throw new gException("نام آزمایشگاه باید بیشتر از 3 کاراکتر باشد");
		
		else if(entity.getResponsible().length() < 4)
			throw new gException("نام مسئول آزمایشگاه باید بیشتر از 3 کاراکتر باشد");
			
		else if(entity.getDetailes().length() < 4)
			throw new gException("توضیحات آزمایشگاه باید بیشتر از 3 کاراکتر باشد");
		
		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Laboratory entity)  throws Exception,gException
	{

		//do Business Logic HERE

		
		super.Remove(entity);
	}


}
