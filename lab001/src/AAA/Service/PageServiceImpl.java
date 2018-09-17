
package  AAA.Service;

import  AAA.ServiceInterface.PageWebService;
import  baseService.baseUCServiceImpl;
import common.exception.gException;
import  AAA.Entity.Aapage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PageServiceImpl extends baseUCServiceImpl<Aapage> implements PageWebService
{
	@Override
	@Transactional
	public String Add(Aapage entity) throws Exception, gException 
	{
		return super.Add(entity);
	}
	
	@Override
	@Transactional
	public Aapage Edit(Aapage entity) throws Exception, gException 
	{
		return super.Edit(entity);
	}
	
	@Override
	@Transactional
	public void Remove(Aapage entity) throws Exception, gException 
	{
		super.Remove(entity);
	}

}
