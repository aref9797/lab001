
package  AAA.Service;

import  AAA.ServiceInterface.PageVisitWebService;
import  baseService.baseUCServiceImpl;
import  common.gCal;
import  AAA.Entity.Aapage;
import  AAA.Entity.Aapagevisit;
import  AAA.Entity.Aasession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PageVisitServiceImpl extends baseUCServiceImpl<Aapagevisit> implements PageVisitWebService
{

	@Override
	@Transactional
	public void Add(long PageId, long SessionId)
	{
		Aapage page = em.find(Aapage.class, PageId);
		Aasession session = em.find(Aasession.class, SessionId);

		Aapagevisit aapagevisit = new Aapagevisit();
		aapagevisit.setAapage(page);
		aapagevisit.setAasession(session);
		aapagevisit.setIndate(gCal.getCurrentDateTime());
		em.persist(aapagevisit);
	}

}
