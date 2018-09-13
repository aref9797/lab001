package maneger.Service;

import org.springframework.stereotype.Service;

import Entity.Chargelist;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import maneger.ServiceInteerface.ChargeListUCService;

@Service
public class ChargeListServiceImpl extends baseUCServiceImpl<Chargelist> implements ChargeListUCService
{
	
	@Override
	public String Add(Chargelist entity) throws Exception, gException
	{
		
		return super.Add(entity);
	}
}
