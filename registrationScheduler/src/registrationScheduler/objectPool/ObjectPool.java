package registrationScheduler.objectPool;

import java.util.ArrayList;
import java.util.List;

import registrationScheduler.util.Logger;

public class ObjectPool{
	private  List<Student> stud = new ArrayList<Student>();
	private static ObjectPool unique;
		
	
	//constructor
	public ObjectPool()
	{
		Logger.writeMessage("In ObjectPool, constructor", Logger.DebugLevel.CONSTRUCTOR);
		
	}
	
	public static synchronized void addObject(Student curStudent)
	{
		if(unique == null)
		{
			unique = new ObjectPool();
		}
		unique.stud.add(curStudent);
	}
	
	public static synchronized List<Student> borrowObject()
	{
		if(unique == null)
		{
			unique = new ObjectPool();
		}
		return unique.stud;
	}
	
	public static synchronized int getSize()
	{
		if(unique == null)
		{
			unique = new ObjectPool();
		}
		return unique.stud.size();
		
	}
	
	public Object returnObject(Object obj)
	{
		return obj;
	}
	
	public void setFactory()
	{
		
	}
	
	public void clear()
	{
		
	}
	
	public void close()
	{
		
	}
	
	public int getNumActive()
	{
		return 1;
	}
	
	public int getNumIdle()
	{
		return 1;
	}
	
	public void invalidateObject(Object obj)
	{
		
	}
	
}