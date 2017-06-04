package registrationScheduler.util;

import java.util.List;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import registrationScheduler.objectPool.Course;
import registrationScheduler.objectPool.Student;
import registrationScheduler.objectPool.ObjectPool;

public class Scheduler{
	
	String line = null, studName;
	Course cs;
	int noOfCoursesToAddDrop;
	Student addDropStud = new Student();
	
	
	/**Constructor of this class.
	 *
	 * @param	csIn			Course class object
	 * @return  none
	 */
	public Scheduler(Course csIn)
	{
		Logger.writeMessage("In Scheduler, String parameter constructor", Logger.DebugLevel.CONSTRUCTOR);
		cs = csIn;
	}
	
	/**Constructor of this class.
	 *
	 * @param	lineIn			String to process
	 * @return  Student	Student class object
	 */
	public synchronized Student schedule(String lineIn, int type){
		line = lineIn;
		Student results = null;
		if(0==type)
		{
			arrangePref(line);
			
			for(int i=0; i<ObjectPool.getSize(); i++)
			{
				Student curStud = ObjectPool.borrowObject().get(i);
				
				if(curStud.name.equals(studName))
				{
					for(int j=0; j<5; j++)
					{
						if(0 < cs.courseMap.get(curStud.prefer.get(j)))
						{
							//allocate requested course
							cs.courseMap.put(curStud.prefer.get(j), cs.courseMap.get(curStud.prefer.get(j))-1);
							curStud.allocated.add(curStud.prefer.get(j));
							curStud.pref_score = curStud.pref_score + (6 - j);
						}
						else
						{
							//allocate any course
							for (Map.Entry<String, Integer> element : cs.courseMap.entrySet())
							{
								if(0 < element.getValue())
								{
									//check already exists
									if(curStud.allocated.contains(element.getKey()))
									{
										//								
									}
									else
									{
										cs.courseMap.put(element.getKey(), element.getValue()-1);
										curStud.allocated.add(element.getKey());
										curStud.pref_score = curStud.pref_score + 1;
										break;
									}
								}
							}
						}
					}
					
					results = curStud;
					break;
				}
			}//end of courses for loop
			/*for (Map.Entry<String, Integer> element : cs.courseMap.entrySet())
			{
				System.out.println(element.getKey() + " : " + element.getValue());
			}*/
			
					
		}
		else
		{
			
			// code for add drop file
			int addORdrop = arrangeAddDrop(line);
			
			for(int i=0; i<ObjectPool.getSize(); i++)
			{
				
				Student curStud = ObjectPool.borrowObject().get(i);
				if(curStud.name.equals(studName))
				{
					for(int j=0; j<noOfCoursesToAddDrop; j++)
					{
						if(0==addORdrop)
						{
							if(curStud.allocated.contains(addDropStud.prefer.get(j)))
							{
								curStud.allocated.remove(addDropStud.prefer.get(j));
								cs.courseMap.put(curStud.prefer.get(j), cs.courseMap.get(curStud.prefer.get(j))+1);
							}
						}
						else// add course
						{
							if(0 < cs.courseMap.get(addDropStud.prefer.get(j)))
							{
								if(curStud.allocated.contains(addDropStud.prefer.get(j)))
								{
									//
								}
								else
								{
									curStud.allocated.add(addDropStud.prefer.get(j));
									cs.courseMap.put(curStud.prefer.get(j), cs.courseMap.get(curStud.prefer.get(j))-1);
								}
							}
						}
					}
					
					//System.out.println("hello: " + curStud.name);
					results = curStud;
					break;
				}
			}
			
			/*for (Map.Entry<String, Integer> element : cs.courseMap.entrySet())
			{
				System.out.println(element.getKey() + " : " + element.getValue());
			}*/
			
		}
		return results;	
	}
	
	
	/**Arrange the string as needed
	 *
	 * @param	line			Line to process
	 * @return  none
	 */
	public void arrangePref(String line)
	{
		try
		{
			StringTokenizer token = new StringTokenizer(line, " ");
			studName = token.nextToken();
			
			Student t = new Student (studName, token.nextToken(), token.nextToken(), token.nextToken(), token.nextToken(), token.nextToken());
			ObjectPool.addObject(t);
			//System.out.println("yo: ");
			
		}
		catch(NoSuchElementException nse)
		{
			//
		}
	}

	/**Arrange the string as needed
	 *
	 * @param	line			Line to process
	 * @return  int 	indicates whether to add or drop the course
	 */
	public int arrangeAddDrop(String line)
	{
		int addORdrop=0;
		try
		{
			
			StringTokenizer token = new StringTokenizer(line, " ");
			noOfCoursesToAddDrop = token.countTokens()-2;			
			studName = token.nextToken();			
			Student tempStud = new Student();			
			tempStud.name = studName;			
			addORdrop = Integer.parseInt(token.nextToken());
			for(int i=0; i<noOfCoursesToAddDrop; i++)
			{
				tempStud.prefer.add(token.nextToken());
			}
			addDropStud = tempStud;
			
			//stud.add(new Student (studName, token.nextToken(), token.nextToken(), token.nextToken(), token.nextToken(), token.nextToken()));
			
		}
		catch(NoSuchElementException nse)
		{
			//
		}
				
		return addORdrop;
	}
}