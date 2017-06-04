package myArrayList.test;


import myArrayList.MyArrayList;
import myArrayList.util.Results;

public class MyArrayListTest {

	MyArrayList myArrayListObj;
	public void testMe(MyArrayList myArrayListObjIn, Results results)
	{
		myArrayListObj = myArrayListObjIn;
		testToMakeSize75();
		testToPrintArray();
		testToDeleteElement();
	}
	
	public void testToPrintArray()
	{
		System.out.println(myArrayListObj.toString());
	}
	
	
	public void testToDeleteElement()
	{
		myArrayListObj.removeValue(123);
		System.out.println("After deleting 123: "+myArrayListObj.toString());
	}
	
	public void testToMakeSize75()
	{
		try
		{
			for(int i=0; i<69; i++)
			{
				myArrayListObj.insertSorted(i+1);
			}
			System.out.println("Adding 69 elements: Test Passed");
		}
		catch(Exception e)
		{
			System.err.println("Adding 69 elements: Test Failed");
			e.printStackTrace();
		}
		
	}
	
	public void testToAdd51Elements()
	{
		try
		{
			for(int i=0; i<51; i++)
			{
				myArrayListObj.insertSorted(i+1);
			}
			System.out.println("Adding 51 elements: Test Passed");
		}
		catch(Exception e)
		{
			System.err.println("Adding 51 elements: Test Failed");
			e.printStackTrace();
		}
		
	}
}
