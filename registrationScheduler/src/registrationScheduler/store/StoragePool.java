package registrationScheduler.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import registrationScheduler.objectPool.ObjectPool;
import registrationScheduler.objectPool.Student;
import registrationScheduler.util.Logger;

public class StoragePool {
	private Map<String, String> outMap = new HashMap<String, String>();
	public String totalPrefScore;
	private static StoragePool unique;
	//constructor
	public StoragePool()
	{
		Logger.writeMessage("In StoragePool, constructor", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	public static synchronized void addToStore(String name, String courses)
	{
		if(unique == null)
		{
			unique = new StoragePool();
		}
		unique.outMap.put(name, courses);
	}
	
	public static synchronized Map<String, String> borrowStore()
	{
		if(unique == null)
		{
			unique = new StoragePool();
		}
		return unique.outMap;
	}
	
	public static synchronized int getSize()
	{
		if(unique == null)
		{
			unique = new StoragePool();
		}
		return unique.outMap.size();
		
	}
	public static synchronized String getAvgPrefScore()
	{
		if(unique == null)
		{
			unique = new StoragePool();
		}
		return unique.totalPrefScore;
		
	}
	public static synchronized void setAvgPrefScore(String score)
	{
		if(unique == null)
		{
			unique = new StoragePool();
		}
		unique.totalPrefScore = score;
		
	}
}
