
package registrationScheduler.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import registrationScheduler.objectPool.ObjectPool;
import registrationScheduler.objectPool.Student;
import registrationScheduler.util.FileDisplayInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.StdoutDisplayInterface;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {
	
	/**
	 * Writes data to standard output
	 *
	 * @param  none
	 * @return      none
	 */
    public void writeScheduleToStdout() {
	//    	Logger.writeMessage(??, Logger.DebugLevel.??;
    	Logger.writeMessage("Contents of the data structure in the store", Logger.DebugLevel.FROM_RESULTS);
    	
    	for (Map.Entry<String, String> element : StoragePool.borrowStore().entrySet())
    	{
    		System.out.println(element.getKey() + " " + element.getValue());
    	}
    }
    
    
    /**
	 * Writes data to file
	 *
	 * @param  outFileName ouput file name
	 * @return      none
	 */
    @Override
    public void writeSchedulesToFile(String outFileName){
    	List<String> writeOut = new ArrayList<String>();
    	FileProcessor fp = new FileProcessor(outFileName);
    	for (Map.Entry<String, String> element : StoragePool.borrowStore().entrySet())
    	{
    		writeOut.add(element.getKey() + " " + element.getValue());
    	}
    	writeOut.add(StoragePool.getAvgPrefScore());
    	try {
			fp.writeFile(writeOut);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    /**
	 * Writes data to the data structure
	 *
	 * @param  stud	Student object
	 * 		   type	Type of the file
	 * @return      none
	 */
	public synchronized void addToList(Student stud, int type)
	{
		Logger.writeMessage("Entry is added to the Result data structure", Logger.DebugLevel.IN_RESULTS);
		String courseList = "";
		for(int i=0; i<stud.allocated.size();i++)
		{
			courseList = courseList + stud.allocated.get(i) + " ";
		}
		if(StoragePool.borrowStore().containsKey(stud.name))
		{
			StoragePool.borrowStore().remove(stud.name);
			StoragePool.borrowStore().put(stud.name, courseList);
		}
		else
		{
			StoragePool.borrowStore().put(stud.name, courseList);
		}
		
	}
    // other methods
}
