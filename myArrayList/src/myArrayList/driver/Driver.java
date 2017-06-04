package myArrayList.driver;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;

public class Driver {

	public static FileProcessor file, file1, outFile;
	public static String outputFileName;
	static List<Integer> inputList = new ArrayList<Integer>();
	static int debugVal;
	static int len;
	public static MyArrayList myArrObj = new MyArrayList();
	public static Results res;

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
			res= new Results(outFile);
			try 
			{
				inputList = file.readFile();
				len = file1.getLength();
				/*debugVal = Integer.parseInt(args[2]);
				if(0<=debugVal && 4>=debugVal)
				{
					Logger.setDebugValue(debugVal);
				}
				else
				{
					throw new ArrayIndexOutOfBoundsException();
				}*/
				
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
				
			System.out.println("Initial Input: " + inputList);
			for(int i =0; i<inputList.size(); i++)
			{
				myArrObj.insertSorted(inputList.get(i));
			}
			//myArrObj.removeValue(1234);
			MyArrayListTest test =new MyArrayListTest();
			test.testMe(myArrObj, res);
			
			
/*			System.out.println(myArrObj.size());
			System.out.println(myArrObj.toString());*/
			res.writeToStdout("The sum of all the values in the array list is: "+myArrObj.sum());
			res.writeToFile("The sum of all the values in the array list is: "+myArrObj.sum());
		}
	}
}