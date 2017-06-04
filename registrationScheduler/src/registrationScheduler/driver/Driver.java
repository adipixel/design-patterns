
package registrationScheduler.driver;

import java.io.BufferedReader;
import java.lang.IllegalArgumentException;
import java.text.DecimalFormat;

import registrationScheduler.util.Logger;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.objectPool.Course;
import registrationScheduler.objectPool.CoursePool;
import registrationScheduler.objectPool.ObjectPool;
import registrationScheduler.store.Results;
import registrationScheduler.store.StoragePool;
import registrationScheduler.threadMgmt.CreateWorkers;

public class Driver{

	static int NUM_THREADS, DEBUG_VALUE;
	static int[] len = new int[2];
	static FileProcessor prefFile, addDropFile;
	static String outputFile;
	static Course cs;
	static BufferedReader bf_pref, bf_addDrop;
	static Results res = new Results();
	static double totalPrefScore = 0.00;
	static final DecimalFormat format1 = new DecimalFormat(".#");
	 
	/**
	 * It is the main method of the class which drives the program.
	 *
	 * @param  args	arguments provided by user from commandline
	 * @return      none
	 */
	public static void main(String args[]) throws Exception {
		
		setup();
		Driver dr = new Driver();
		dr.validateArgs(args);
		
	    CreateWorkers cw_pref = new CreateWorkers(bf_pref, 0, outputFile, NUM_THREADS, DEBUG_VALUE, cs, len[0]);
	    cw_pref.startWorkers();
	    CreateWorkers cw_addDrop = new CreateWorkers(bf_addDrop, 1, outputFile, NUM_THREADS, DEBUG_VALUE, cs, len[1]);
	    cw_addDrop.startWorkers();
	    
	    int score = 0;
		for(int i=0; i<ObjectPool.getSize();i++)
		{
			score = score + ObjectPool.borrowObject().get(i).pref_score;
		}
		totalPrefScore = score/ObjectPool.getSize();
		Logger.writeMessage("The average preference score is "+totalPrefScore, Logger.DebugLevel.RELEASE);
		StoragePool.setAvgPrefScore("total_preference_score: " + totalPrefScore);
		
		if(1==DEBUG_VALUE)
		{
			res.writeScheduleToStdout(); 
		}
    	res.writeSchedulesToFile(outputFile);

	} // end main(...)
	
	
	/**
	 * It validates the arguments.
	 *
	 * @param  args	arguments provided by user from commandline
	 * @return      none
	 */
	
	private void validateArgs(String args[])throws Exception{
		//validate number of arguments
		if(args.length==5){
		    // get file names

			try{
				prefFile = new FileProcessor(args[0]);
				bf_pref = prefFile.readFile();
				len[0] = prefFile.getLength();
				addDropFile = new FileProcessor(args[1]);
				bf_addDrop = addDropFile.readFile();
				len[1] = addDropFile.getLength();
				outputFile = args[2];
				
				NUM_THREADS = Integer.parseInt(args[3]);
				if(0<NUM_THREADS && 4>NUM_THREADS)
				{
					//
				}
				else
				{
					System.err.println("Invalid number of threads.");
					System.exit(1);
				}
				
				DEBUG_VALUE = Integer.parseInt(args[4]);
				if(0<=DEBUG_VALUE && 4>=DEBUG_VALUE)
				{
					Logger.setDebugValue(DEBUG_VALUE);
				}
				else
				{
					throw new ArrayIndexOutOfBoundsException();
				}
			    // Set the Logger level
				
			    // return 

			}catch(IllegalArgumentException ex){
				System.err.println("Invalid number of arguments.");
				ex.printStackTrace();
				System.exit(1);
			}
			catch(ArrayIndexOutOfBoundsException ex){
				System.err.println("NumberFormatException-Cannot parse to integer.");
				ex.printStackTrace();
				System.exit(1);
			}
			finally
			{
				//
			}
		}else{
			System.err.println("Invalid number of arguments.");
			System.exit(1);
		}
	}

	/**
	 * This method setups the courses and number of seats.
	 *
	 * @param  none
	 * @return      none
	 */
	public static void setup()
	{
		String[] courseNames = {"A", "B", "C", "D", "E", "F", "G", "H"};
		int size = 60; //size of each class
		cs = new Course();
		cs.addCourses(courseNames, size);
	}
    

} // end public class Driver

