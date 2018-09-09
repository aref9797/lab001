package maneger.Service;

import maneger.ServiceInteerface.EquipmentUCService;
import Entity.Equipment;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EquipmentServiceImpl extends baseUCServiceImpl<Equipment> implements EquipmentUCService
{

	@Override
	@Transactional
	public String Add(Equipment entity) throws Exception, gException 
	{
		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public Equipment Edit(Equipment entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Equipment entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
