
package AAA.ServiceInterface;

import java.util.List;

import baseService.baseUCService;
import common.exception.gException;
import AAA.Entity.Aasession;

public interface SessionWebService extends baseUCService<Aasession>
{
	public List<Aasession> FindAllSessions();

	public List<Aasession> FindAllSessions(String username) throws gException, Exception;
}

