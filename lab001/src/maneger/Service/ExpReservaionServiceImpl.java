package maneger.Service;

import maneger.ServiceInteerface.ExpReservaionUCService;
import Entity.ExpReservaion;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ExpReservaionServiceImpl extends baseUCServiceImpl<ExpReservaion> implements ExpReservaionUCService
{

	@Override
	@Transactional
	public String Add(ExpReservaion entity) throws Exception, gException 
	{
		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public ExpReservaion Edit(ExpReservaion entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(ExpReservaion entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
