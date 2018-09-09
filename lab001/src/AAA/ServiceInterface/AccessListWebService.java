
package AAA.ServiceInterface;

import baseService.baseUCService;
import common.exception.gException;
import AAA.Entity.Aaaccesslist;

public interface AccessListWebService extends baseUCService<Aaaccesslist>
{
	public void Add(long RoleId, long Pages[]) throws gException, Exception;
}
