package maneger.Service;

import maneger.ServiceInteerface.ExprementStatuseUCService;
import Entity.ExprementStatuse;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ExprementStatuseServiceImpl extends baseUCServiceImpl<ExprementStatuse> implements ExprementStatuseUCService
{

	@Override
	@Transactional
	public String Add(ExprementStatuse entity) throws Exception, gException 
	{
		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public ExprementStatuse Edit(ExprementStatuse entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(ExprementStatuse entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
