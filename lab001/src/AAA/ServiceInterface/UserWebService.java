
package AAA.ServiceInterface;

import baseService.baseUCService;

import java.util.List;

import AAA.Entity.Aauser;

public interface UserWebService extends baseUCService<Aauser>
{
	public List<Aauser> find_guest();
	public List<Aauser> find_student();
	public List<Aauser> find_professor();
	public List<Aauser> find_accstudent();
	public List<Aauser> find_accprofessor();
	public List<Aauser> accept_professor();
	public void UserACC(Aauser user);
	public List<Aauser> find_user_exp();
//	public List<Aauser> find_acceptprofessor();
	public void Professor_Charge(Aauser user , Integer charg);
}