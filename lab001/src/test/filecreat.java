package test;

import java.io.File;
import java.io.IOException;


public  class filecreat {
	
	public File creat(String filename)
	{

		File f=new File("D://"+filename);
		try 
		{
			f.createNewFile();
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		return f;
	}
}