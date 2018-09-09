package maneger.Service;

import maneger.ServiceInteerface.MuserUCService;
import Entity.MUser;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MuserServiceImpl extends baseUCServiceImpl<MUser> implements MuserUCService
{

	
	
	
	@Override
	@Transactional
	public String Add(MUser entity) throws Exception, gException 
	{
		//do Business Logic HERE
		
		
		return super.Add(entity);
	}



	@Override
	@Transactional
	public MUser Edit(MUser entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(MUser entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
