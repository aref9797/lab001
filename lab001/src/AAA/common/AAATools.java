package AAA.common;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.apache.commons.codec.digest.*;

public class AAATools
{
	public static String getHashed(String input)
	{
		return DigestUtils.sha512Hex(input);
	}	
	
	public static String getRandomPassword()
	{
		SecureRandom random = new SecureRandom();
		return new BigInteger(50, random).toString(32);
	}
	
}