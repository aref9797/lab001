package enduser.Service;

import enduser.ServiceInteerface.GuestUCService;
import Entity.Enduser;
import Entity.Guest;
import baseService.baseUCServiceImpl;
import common.exception.gException;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GuestServiceImpl extends baseUCServiceImpl<Guest> implements GuestUCService
{
	
	Enduser end;
	
	
	
	@Override
	@Transactional
	public String Add(Guest entity) throws Exception, gException 
	{
		
		
		
		return super.Add(entity);
	}



	@Override
	@Transactional
	public Guest Edit(Guest entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Guest entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
