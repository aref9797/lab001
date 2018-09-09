package test;

import java.io.File;
import java.io.IOException;

public  class filecreat {
	
	public File creat(String filename)
	{
		File f=new File("D://"+filename);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}
}
