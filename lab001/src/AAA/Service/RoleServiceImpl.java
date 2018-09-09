
package AAA.Service;

import baseService.baseUCServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import AAA.Entity.Aarole;
import AAA.ServiceInterface.RoleWebService;

@Service
public class RoleServiceImpl extends baseUCServiceImpl<Aarole> implements RoleWebService
{
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Aarole> FindAll() {
		
		List<Aarole> rm=(List<Aarole>)em.createNamedQuery("Aarole.findAll").getResultList();
		return rm;
	}
}
