
package AAA.ServiceInterface;

import baseService.baseUCService;
import AAA.Entity.Aapagevisit;

public interface PageVisitWebService extends baseUCService<Aapagevisit>
{
	public void Add(long PageId, long SessionId);
}
