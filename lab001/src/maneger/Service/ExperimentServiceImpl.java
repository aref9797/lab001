package maneger.Service;

import maneger.ServiceInteerface.ExperimentUCService;
import Entity.Experiment;
import baseService.baseUCServiceImpl;
import common.exception.gException;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ExperimentServiceImpl extends baseUCServiceImpl<Experiment> implements ExperimentUCService
{
	
	Experiment eexp = new Experiment();
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public String Add(Experiment entity) throws Exception, gException 
	{
		//do Business Logic HERE
		if (entity.getName().length() < 3)
			throw new gException("نام آزمایش باید بیشتر از 2 کاراکتر باشد");
		
		else if(entity.getDetails().length() < 4)
			throw new gException("توضیحات آزمایش باید بیشتر از 3 کاراکتر باشد");
		
		List<Experiment> le = em.createNamedQuery("Experiment.findbyname").setParameter("name", entity.getName()).getResultList();
		
		if(le.size() > 0 )
			throw new gException("آزمایش با این نام قبلا در سیستم ثبت شده است");
		
		if(entity.getPrice() <= 0)
			throw new gException("قیمت آزمایش نمی تواند صفر یا کمتر از صفر باشد");
		
//		List<Laboratory> ll = em.createNamedQuery("Laboratory.findbyname").setParameter("labname", entity.getLaboratory().getName()).getResultList();
//		
//		entity.getLaboratory().setId(ll.get(0).getId());
//		System.out.println(ll.get(0).getId() + "");

		return super.Add(entity);
	}


	@Override
	@Transactional
	public Experiment Edit(Experiment entity)  throws Exception,gException
	{

		//do Business Logic HERE
		if (entity.getName().length() < 3)
			throw new gException("نام آزمایش باید بیشتر از 2 کاراکتر باشد");
		
		else if(entity.getDetails().length() < 4)
			throw new gException("توضیحات آزمایش باید بیشتر از 3 کاراکتر باشد");
		
		if(entity.getPrice() <= 0)
			throw new gException("قیمت آزمایش نمی تواند صفر یا کمتر از صفر باشد");

		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Experiment entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Experiment> exp_status() 
	{
		List<Experiment> lr = (List<Experiment>) em.createQuery("from Experiment a where a.status = 'false' ").getResultList();
		return lr;
	}


	@Override
	@Transactional
	public void Exp_Confirm(Experiment exp) {
		
		exp.setStatus(true);
		try 
		{
			super.Edit(exp);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
		
	}
	
}
