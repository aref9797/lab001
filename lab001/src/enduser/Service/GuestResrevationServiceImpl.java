package enduser.Service;

import enduser.ServiceInteerface.GuestResrevationUCService;
import Entity.GuestResrevation;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GuestResrevationServiceImpl extends baseUCServiceImpl<GuestResrevation> implements GuestResrevationUCService
{

	@Override
	@Transactional
	public String Add(GuestResrevation entity) throws Exception, gException 
	{
		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public GuestResrevation Edit(GuestResrevation entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(GuestResrevation entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
