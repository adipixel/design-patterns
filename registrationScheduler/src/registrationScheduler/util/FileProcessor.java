package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class FileProcessor {
	
	public List<String> inputList = new ArrayList<String>();
	String fileName;
	int next =0;
	BufferedReader read = null;
	FileReader fr = null;
	File f = null;
	/**
	 * It is the constructor of this class 
	 *
	 * @param  fileNameIn	name of the file to be read or written 
	 * @return      none
	 */
	public FileProcessor(String fileNameIn) {
		Logger.writeMessage("In FileProcessor, String parameter constructor", Logger.DebugLevel.CONSTRUCTOR);
		fileName = fileNameIn;
	}
	public FileProcessor ()
	{
		Logger.writeMessage("In FileProcessor,  constructor", Logger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * Reads the data from the given filename
	 *
	 * @param  none
	 * @return      ArrayList of the data from the file.
	 * 				Each element contains a line from the file
	 */
	public BufferedReader readFile() throws Exception {
		try {
			f = new File(fileName);
			fr = new FileReader(f);
			read = new BufferedReader(fr);
			String line = null;
			/*while ((line = read.readLine()) != null) {
				inputList.add(line);
			}*/
			
		} catch (IOException io) {
			io.printStackTrace();
			System.err.println("I/O Exception: " + io);
			System.exit(1);
		} catch (NullPointerException nullpointerException) {
			System.err.println("Input file may be empty: " + nullpointerException);
			System.exit(1);
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Out of bound \n");
			e.printStackTrace();
			System.exit(1);
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			//
		}
		return read;
	}
	
	/**
	 * Returns the length of the file
	 *
	 * @param  none
	 * @return  int length  
	 * 				
	 */
	public int getLength()
	{
		int count = 0;
		try {
			File f1 = new File(fileName);
			FileReader fr1 = new FileReader(f1);
			BufferedReader read1 = new BufferedReader(fr1);
			String line = null;
			while ((line = read1.readLine()) != null) {
				inputList.add(line);
				count++;
			}
			if(count == 0)
			{
				throw new NullPointerException();
			}
			
		} catch (IOException io) {
			io.printStackTrace();
			System.err.println("I/O Exception: " + io);
			System.exit(1);
		} catch (NullPointerException nullpointerException) {
			System.err.println("Input file may be empty: " + nullpointerException);
			System.exit(1);
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Out of bound \n");
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			//
		}
		return inputList.size();
	}
	
	/**
	 * Reads the data from the given filename line by line
	 *
	 * @param  none
	 * @return   String   String of the data from the file.
	 */
	public synchronized String readLineFromFile(BufferedReader bf)
	{
		String line=null;
		try
		{
			if((line = bf.readLine()) != null)
			{
				
			}
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		return line;
	}
	
	
	/**
	 * Writes the data from ArrayList to the file
	 *
	 * @param  outStr	ArrayList to be written line by line to the file 
	 * @return      none
	 */
	public void writeFile(List<String> outStr) throws Exception {
		FileWriter writer = null;
		try {
			File file = new File(fileName);
			file.createNewFile();
			writer = new FileWriter(file);
			for (int i = 0; i < outStr.size(); i++) {
				writer.write(outStr.get(i) + "\n");// writing data to file line
													// by line
			}
			writer.close();
		} catch (IOException io) {
			io.printStackTrace();
			System.err.println("I/O Exception: " + io);
			System.exit(1);
		} catch (NullPointerException nullpointerException) {
			System.err.println("Input file may be empty: " + nullpointerException);
			System.exit(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Out of bound \n");
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
}



/*


package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.String;

public class FileProcessor {
	
    private BufferedReader in;
    private String outfilename;
    
    public FileProcessor(BufferedReader bufReaderIn){
	Logger.writeMessage("In FileProcessor, BufferedReader constructor", Logger.DebugLevel.CONSTRUCTOR);
	// code to handle argument
    }
    public FileProcessor(String outFileNameIn){
	Logger.writeMessage("In FileProcessor, String Parameter constructor", Logger.DebugLevel.CONSTRUCTOR);
	// code to handle argument
    }
    
    
    public synchronized String readLineFromFile(){
	// Code to read file line by line
	return null;
    }
    
    // similarly a method to writeLineToFile().
    // other helper methods
}


*/