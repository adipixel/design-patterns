package genericSerDeser.fileOperations;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import genericSerDeser.util.Logger;

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
		Logger.writeMessage("File Processor constructor", Logger.DebugLevel.CONSTRUCTOR);
		fileName = fileNameIn;
	}
	public FileProcessor ()
	{
		//this is a blank constructor
	}

	/**
	 * Reads the data from the given filename
	 *
	 * @param  none
	 * @return      ArrayList of the data from the file.
	 * 				Each element contains a line from the file
	 */
	public List<String> readFile() throws Exception {
		try {
			f = new File(fileName);
			fr = new FileReader(f);
			read = new BufferedReader(fr);
			String line = null;
			while ((line = read.readLine()) != null) {
				inputList.add(line);
				if("".equals(line))
				{
					throw new NoSuchElementException();
				}
			}
		} catch(FileNotFoundException fnf){
			System.err.println("File cannot be found: " + fnf);
			fnf.printStackTrace();
			System.exit(1);
		}catch(NoSuchElementException nse){
			System.err.println("File contains blank row: " + nse);
			nse.printStackTrace();
			System.exit(1);
		}catch (IOException io) {
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
		return inputList;
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
				if(line == "")
				{
					throw new NoSuchElementException();
				}
				count++;
			}
			if(count == 0)
			{
				throw new NullPointerException();
			}
			
		}catch(FileNotFoundException fnf){
			fnf.printStackTrace();
			System.err.println("File cannot be found" + fnf);
			System.exit(1);
		}
		catch(NoSuchElementException nse){
			nse.printStackTrace();
			System.err.println("File contains blank row: " + nse);
			System.exit(1);
		}
		catch (IOException io) {
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
			writer.write(outStr.get(0));
			for (int i = 1; i < outStr.size(); i++) {
				writer.write("\n" + outStr.get(i));// writing data to file line
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