package maneger.Service;

import maneger.ServiceInteerface.ExpReservaionUCService;
import Entity.ExpReservaion;
import baseService.baseUCServiceImpl;
import common.SessionManager;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import AAA.Entity.Aasession;


@Service
public class ExpReservaionServiceImpl extends baseUCServiceImpl<ExpReservaion> implements ExpReservaionUCService
{

	@Override
	@Transactional
	public String Add(ExpReservaion entity) throws Exception, gException 
	{
		
		Aasession aasession = em.find(Aasession.class, SessionManager.getSessionId());
		entity.setAauser(aasession.getAauser());
		

		return super.Add(entity);
	}

	@Override
	@Transactional
	public void Remove(ExpReservaion entity)  throws Exception,gException
	{


		super.Remove(entity);
	}

}