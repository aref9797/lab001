
package  AAA.Service;

import java.util.List;

import  AAA.ServiceInterface.SessionWebService;
import  baseService.JPAOp;
import  baseService.baseUCServiceImpl;
import  common.SessionManager;
import  common.exception.gException;
import  AAA.Entity.Aasession;
import  AAA.Entity.Aauser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SessionServiceImpl extends baseUCServiceImpl<Aasession> implements SessionWebService
{

	@Override
	@Transactional
	public List<Aasession> FindAllSessions()
	{
		Aasession session = em.find(Aasession.class, SessionManager.getSessionId());
		return this.FindbyFields("aauser.id", JPAOp.Eq, session.getAauser().getId(), "logindate", JPAOp.Desc);
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Aasession> FindAllSessions(String username) throws gException, Exception
	{
		List<Aauser> userList = (List<Aauser>) em.createNamedQuery("Aauser.findbyUsername").setParameter("username", username)
					.getResultList();

		if (userList.size() <= 0)
			throw new gException("نام کاربری وارد شده در سیستم وجود ندارد.");

		Aauser user = userList.get(0);
		return this.FindbyFields("aauser.id", JPAOp.Eq, user.getId(), "logindate", JPAOp.Desc);
	}

}


