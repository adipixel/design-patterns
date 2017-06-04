package spreadsheetUpdates.driver;

import java.util.ArrayList;
import java.util.List;
import spreadsheetUpdates.util.Logger;
import spreadsheetUpdates.util.FileProcessor;
import spreadsheetUpdates.util.Sheet;

public class Driver {
	static FileProcessor file,file1,fileOut;
	static List<String> inputList = new ArrayList<String>();
	static Sheet sheet = new Sheet();
	static String outFileName;
	static int debugVal;
	
	public static void main(String[] args) {
		if(3 != args.length)
		{
			System.out.println("Invalid Number of Arguments");
			System.exit(0);
		}
		else
		{
			file = new FileProcessor(args[0]);
			file1 = new FileProcessor(args[0]);
			try 
			{
				inputList = file.readFile();
				int len = file1.getLength();
				outFileName = args[1];
				debugVal = Integer.parseInt(args[2]);
				if(0<=debugVal && 4>=debugVal)
				{
					Logger.setDebugValue(debugVal);
				}
				else
				{
					throw new ArrayIndexOutOfBoundsException();
				}
				
				
			}catch(IllegalArgumentException ex){
				System.err.println("Invalid number of arguments.");
				ex.printStackTrace();
				System.exit(1);
			}
			catch(ArrayIndexOutOfBoundsException ex){
				System.err.println("NumberFormatException-Cannot parse to integer.");
				ex.printStackTrace();
				System.exit(1);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{
				//
			}
			
			
			sheet.setDefaultData();
			//
			for(int i=0; i<inputList.size();i++)
			{
				String data = inputList.get(i);
				sheet.setData(data);
				
			}

			sheet.refreshMatrix();
			if(3==debugVal)
			{
				sheet.printMatrix();				
			}
			sheet.totaltMatrix();
			sheet.writeSchedulesToFile(outFileName);


		}
	}
}

