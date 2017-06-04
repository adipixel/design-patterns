package myArrayList;

import java.util.Arrays;

public class MyArrayList{
	private int[] arr;
	private int arrPtr;
	private int arrSize;
	
	public MyArrayList()
	{

		arr = new int[50];
		arrPtr = 0;
		arrSize = 50;
	}
	
	public void insertSorted(int newValue)
	{
		int size = arr.length;
		if(50 == arrPtr)
		{
			int[] arrTemp = arr;
			arr = new int[75];
			//arr = arrTemp;
			for(int i=0;i<50;i++)
			{
				arr[i]=arrTemp[i];
			}
			Arrays.sort(arr);
			arrSize = 75;
			System.out.println("Array is now 75");
		}
		
		arr[0] = newValue;
		Arrays.sort(arr);	
		arrPtr = arrPtr + 1;
	
	}
	
	public void removeValue(int value)
	{
		for(int i=0; i<arr.length; i++)
		{
			if(value==arr[i])
			{
				int[] arrTemp = arr;
				arr = new int[arrSize];
				int k=0;
				for(int j=0; j<arrTemp.length; j++)
				{
					if(arrTemp[j]==value)
					{
						//skip element
					}
					else
					{
						arr[k] = arrTemp[j];
						k++;
					}
				}
			}
		}
		Arrays.sort(arr);
	}
	
	public int indexOf(int value)
	{
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i] == value)
			{
				return i;
			}
			
		}
		return -1;
	}
	
	public int size()
	{
		return arr.length;
	}
	
	public int sum()
	{
		int sum=0;
		for(int i=0; i<arr.length; i++)
		{
			sum = sum + arr[i];
		}
		return sum;
	}

	@Override
	public String toString() {
		String str = null;
		str= "MyArray: [";
		for(int i=0;i<arrPtr;i++)
		{
			str = str + arr[i+(arrSize-arrPtr)] + " ";
		}
		str = str + "]";
		
		return str;
		//return "MyArrayList [arr=" + Arrays.toString(arr) + "]";
	}

	public void clear()
	{
		arr = new int[50];
		arrSize=50;
		arrPtr =0;
	}
	
}