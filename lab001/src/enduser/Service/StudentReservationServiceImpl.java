package enduser.Service;

import enduser.ServiceInteerface.StudentReservationUCService;
import Entity.StudentReservation;
import baseService.baseUCServiceImpl;
import common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StudentReservationServiceImpl extends baseUCServiceImpl<StudentReservation> implements StudentReservationUCService
{

	@Override
	@Transactional
	public String Add(StudentReservation entity) throws Exception, gException 
	{
		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public StudentReservation Edit(StudentReservation entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(StudentReservation entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
