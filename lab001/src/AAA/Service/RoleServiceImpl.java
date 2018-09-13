
package AAA.Service;

import baseService.baseUCServiceImpl;
import common.exception.gException;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import AAA.Entity.Aarole;
import AAA.ServiceInterface.RoleWebService;

@Service
public class RoleServiceImpl extends baseUCServiceImpl<Aarole> implements RoleWebService
{
	
	@Override
	@Transactional
	public String Add(Aarole entity) throws Exception, gException {
		// TODO Auto-generated method stub
		return super.Add(entity);
	}
	
	
	@Override
	@Transactional
	public Aarole Edit(Aarole entity) throws Exception, gException {
		// TODO Auto-generated method stub
		return super.Edit(entity);
	}
	
	@Override
	@Transactional
	public void Remove(Aarole entity) throws Exception, gException {
		// TODO Auto-generated method stub
		super.Remove(entity);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Aarole> FindAll() {
		
		List<Aarole> rm=(List<Aarole>)em.createNamedQuery("Aarole.findAll").getResultList();
		return rm;
	}
}
