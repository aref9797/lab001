
package AAA.ServiceInterface;

import AAA.common.ProfileUIModel;
import common.exception.gException;

public interface AAAWebService
{
	public void Login(String Username, String Password) throws Exception, gException;

	public void Logout();

	public void ChangePassword(String username, String oldPassword, String newPassword) throws gException;

	public void ChangeProfile(ProfileUIModel profileUIModel);

	public ProfileUIModel getProfile();

	public void LostPassword(String email) throws gException;

	public void Hit_Register(String hit) throws Exception, gException;

}