package myArrayList.util;

public class Results implements FileDisplayInterface, StdoutDisplayInterface{

	FileProcessor f;
	public Results(FileProcessor outFile)
	{
		f = outFile;
	}
	@Override
	public void writeToStdout(String s) {
		System.out.println(s);
		
	}

	@Override
	public void writeToFile(String s)  {
		try
		{
			f.writeFile(s);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
