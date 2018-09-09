package enduser.Service;

import enduser.ServiceInteerface.EnduserUCService;
import Entity.Enduser;
import baseService.baseUCServiceImpl;
import common.exception.gException;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import AAA.Entity.Aauser;



@Service
public class EnduserServiceImpl extends baseUCServiceImpl<Enduser> implements EnduserUCService
{

	Aauser aauser;
	
	
	
	
	@Override
	@Transactional
	public String Add(Enduser entity) throws Exception, gException 
	{
	
		return super.Add(entity);
	}



	@Override
	@Transactional
	public Enduser Edit(Enduser entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Enduser entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
