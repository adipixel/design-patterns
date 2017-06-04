package registrationScheduler.objectPool;

import java.util.HashMap;
import java.util.Map;

public class Course
{
	public Map<String, Integer> courseMap = new HashMap<String, Integer>();
	
	public void addCourses(String[] courseNames, int size)
	{
		for(int i=0;i<courseNames.length; i++)
		{
			courseMap.put(courseNames[i], size);
		}
	}
	
}