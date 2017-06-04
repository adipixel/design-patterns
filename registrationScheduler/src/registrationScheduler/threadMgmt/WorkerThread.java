
package registrationScheduler.threadMgmt;

import java.io.BufferedReader;
import java.io.IOException;

import registrationScheduler.objectPool.Course;
import registrationScheduler.objectPool.CoursePool;
import registrationScheduler.objectPool.Student;
import registrationScheduler.store.Results;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Scheduler;

public class WorkerThread implements Runnable  {

	 BufferedReader inFile;
	 String outputFile;
	 Course cs;
	 Results res;
	 int NUM_THREADS, len, type;
    
	 
	 /**Constructor of this class.
	 *
	 * @param	inFile 			Object of the file to process
	 * 			typeIn			Type of the file
	 * 			outputFileIn	Name of the output file
	 * 			NUM_THREADSIn	number of threads
	 * 			DEBUG_VALUEIn	this is the debug level
	 * 			resIn			Result class object
	 * 			lenIn			length of the file to process.
	 * @return  none
	 */
	 public WorkerThread(BufferedReader inFileIn, int typeIn, String outputFileIn, Course csIn, int NUM_THREADSIn, int lenIn, Results resIn) {
		 Logger.writeMessage("In WorkerThread, parameterized constructor", Logger.DebugLevel.CONSTRUCTOR);
		inFile = inFileIn;
 		outputFile = outputFileIn;
 		cs = csIn;
 		NUM_THREADS = NUM_THREADSIn;
 		len = lenIn;
 		type = typeIn;
 		res = resIn;
     }
    
    
	 /**Program logic for the thread to execute
	 *
	 * @param	none
	 * @return  none
	 */
    public void run() {
    	//System.out.println("Thread running");
    	Logger.writeMessage("Thread running: run() is called.", Logger.DebugLevel.IN_RUN);
    	Scheduler sc = new Scheduler(cs);
    	Student curStud = new Student();
    	FileProcessor f = new FileProcessor();
    	
    	try
    	{
    		for(int i=0; i<len; i++)
        	{
        		//borrow course object from course pool
    			curStud = sc.schedule(f.readLineFromFile(inFile), type);
        		res.addToList(curStud,type);
        		
        	}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		System.exit(1);
    	}
    	
	
    }
    
    
    

}
