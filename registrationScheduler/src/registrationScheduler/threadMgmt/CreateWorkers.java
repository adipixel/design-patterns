
package registrationScheduler.threadMgmt;

import java.io.BufferedReader;
import java.text.DecimalFormat;

import registrationScheduler.objectPool.Course;
import registrationScheduler.objectPool.ObjectPool;
import registrationScheduler.store.Results;
import registrationScheduler.store.StoragePool;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class CreateWorkers  {

	 int NUM_THREADS, DEBUG_VALUE,len,type;
	 BufferedReader inFile;
	 String outputFile;
	 Course cs;
	 Results res = new Results();
	 
	 /**Constructor of this class.
	 *
	 * @param	inFile 			Object of the file to process
	 * 			typeIn			Type of the file
	 * 			outputFileIn	Name of the output file
	 * 			NUM_THREADSIn	number of threads
	 * 			DEBUG_VALUEIn	this is the debug level
	 * 			csIn			Course class object
	 * 			lenIn			length of the file to process.
	 * @return  none
	 */
	public CreateWorkers(BufferedReader inFileIn, int typeIn, String outputFileIn, int NUM_THREADSIn, int DEBUG_VALUEIn, Course csIn, int lenIn)
	{
		Logger.writeMessage("In CreateWorkers, parameterized constructor", Logger.DebugLevel.CONSTRUCTOR);
		inFile = inFileIn;
		outputFile = outputFileIn;
		NUM_THREADS = NUM_THREADSIn;
		DEBUG_VALUE = DEBUG_VALUEIn;
		cs= csIn;
		len= lenIn;
		type= typeIn;
	}

	/**
	 * starts the threads
	 *
	 * @param  none
	 * @return      int size of the list
	 */
    public void startWorkers(){

    	Thread[] t = new Thread[NUM_THREADS];
		
		for (int i=0; i<NUM_THREADS; i++)
		{
			WorkerThread worker = new WorkerThread(inFile, type, outputFile, cs, NUM_THREADS,len, res);
			t[i] = new Thread(worker);
			t[i].start();
		}
    
		for (int i=0; i<NUM_THREADS; i++)
		{
			try{
				t[i].join();
			}
			catch(InterruptedException ie)
			{
				ie.printStackTrace();
				System.exit(1);
			}
		}
			
    }
}
