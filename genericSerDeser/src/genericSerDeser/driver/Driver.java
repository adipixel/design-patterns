package genericSerDeser.driver;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import genericSerDeser.fileOperations.FileProcessor;
import genericSerDeser.strategy.SerStrategy;
import genericSerDeser.util.DPML;
import genericSerDeser.util.First;
import genericSerDeser.util.Logger;
import genericSerDeser.util.PopulateObjects;

public class Driver {
	
	public static FileProcessor file, file1, outFile;
	public static String outputFileName;
	static List<String> inputList = new ArrayList<String>();
	static int debugVal;
	static int len;
	static List<Object> objectList;
	static List<String> outStr, out;
	static Object returnObj;
	static DPML dpml = new DPML();
	static SerStrategy dpmlStrategy= new DPML();
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if(3 != args.length)
		{
			System.out.println("Invalid Number of Arguments");
			System.exit(0);
		}
		else
		{
			file = new FileProcessor(args[0]);
			file1 = new FileProcessor(args[0]);
			outFile = new FileProcessor(args[1]);
			try 
			{
				inputList = file.readFile();
				len = file1.getLength();
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
				System.err.println("Invalid debug value");
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
			if(debugVal == 1)
			{
				System.out.println("Strated deserealizing objects...");
			}
			PopulateObjects popObj = new PopulateObjects();
			for(int i = 0; i<len; i++)
			{
				String input = inputList.get(i);	
				StringTokenizer token = new StringTokenizer(input,":");
				String tempToken = token.nextToken();
				
				if("<fqn".equals(tempToken))
				{
					String className =token.nextToken();
					List<String> objData = new ArrayList<String>();
					objData.add(className);
					//popObj.denserObjects(className,"");
					while(true)
					{
						String nextLine = inputList.get(i+1);
						StringTokenizer strtoken = new StringTokenizer(nextLine,":");
						String tempToken1 = strtoken.nextToken();
						if("</fqn".equals(tempToken1))
						{
							break;
						}
						objData.add(nextLine);
						i++;
					}
					popObj.denserObjects(objData);
					
				}//end of if
			}// end of for
			if(debugVal == 1)
			{
				//popObj.printSets();
				System.out.println("Objects created!");
				System.out.println();
				System.out.println("Serealizing objects into DPML format...");
			}
			objectList = popObj.getObjectList();
			outStr = new ArrayList<String>();
			for(int i=0; i<objectList.size(); i++)
			{
				out = dpmlStrategy.serializeObjects(objectList.get(i), new DPML());
				for(int j=0; j<out.size();j++)
				{
					outStr.add(out.get(j));
				}
			}
			
			try {
				outFile.writeFile(outStr);
				if(debugVal == 1)
				{
					System.out.println("Output is ready in the "+ args[1] + " file");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		Logger.writeMessage("Program executed sucessfully!", Logger.DebugLevel.RELEASE);
	}
}