package maneger.Service;

import maneger.ServiceInteerface.ListExpEquUCService;
import Entity.ListExpEqu;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ListExpEquServiceImpl extends baseUCServiceImpl<ListExpEqu> implements ListExpEquUCService
{

	@Override
	@Transactional
	public String Add(ListExpEqu entity) throws Exception, gException 
	{
		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public ListExpEqu Edit(ListExpEqu entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(ListExpEqu entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
