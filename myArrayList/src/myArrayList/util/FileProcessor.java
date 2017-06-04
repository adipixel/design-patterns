package myArrayList.util;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;


import java.util.ArrayList;

public class FileProcessor {
	
	public List<Integer> inputList = new ArrayList<Integer>();
	String fileName;
	int next =0;
	BufferedReader read = null;
	FileReader fr = null;
	File f = null;
	
	public FileProcessor(String fileNameIn) {
		//Logger.writeMessage("File Processor constructor", Logger.DebugLevel.CONSTRUCTOR);
		fileName = fileNameIn;
	}
	
	public List<Integer> readFile() throws Exception {
		try 
		{
			f = new File(fileName);
			fr = new FileReader(f);
			read = new BufferedReader(fr);
			String line;
			while ((line = read.readLine()) != null) {
				inputList.add(Integer.parseInt(line));
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

	public int getLength()
	{
		int count = 0;
		try {
			File f1 = new File(fileName);
			FileReader fr1 = new FileReader(f1);
			BufferedReader read1 = new BufferedReader(fr1);
			String line = null;
			while ((line = read1.readLine()) != null) {
				inputList.add(Integer.parseInt(line));
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
	
	public void writeFile(String outStr) throws Exception {
		FileWriter writer = null;
		try {
			File file = new File(fileName);
			file.createNewFile();
			writer = new FileWriter(file);
			writer.write(outStr);
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