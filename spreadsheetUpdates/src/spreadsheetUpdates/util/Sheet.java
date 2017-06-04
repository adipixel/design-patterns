package spreadsheetUpdates.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import spreadsheetUpdates.util.FileProcessor;

public class Sheet implements StdoutDisplayInterface, FileDisplayInterface {

	public Cell matrix[][] = new Cell[26][26];
	List<String> outList = new ArrayList<String>();
	FileProcessor outFile;
	int finalTotal=0;
	
	
	public void setDefaultData()
	{
		//creating Subjects
		for(int i=0;i<26;i++)
		{
			for(int j=0; j<26; j++)
			{
				matrix[i][j]= new Cell();
			}
		}
	}
	
	public void totaltMatrix()
	{
		
		for(int i=0;i<26;i++)
		{
			for(int j=0; j<26; j++)
			{
				finalTotal = finalTotal + matrix[i][j].getCellData(this);
			}
		}
	}
	
	public void printMatrix()
	{
		for(int i=0;i<26;i++)
		{
			for(int j=0; j<26; j++)
			{
				System.out.print(matrix[i][j].getCellData(this)+ " ");
			}
			System.out.println();
		}
	}
	
	public void refreshMatrix()
	{
		for(int i=0;i<26;i++)
		{
			for(int j=0; j<26; j++)
			{
				matrix[i][j].total = matrix[i][j].getCellData(this);
			}	
		}
	}
	
	public void setData(String inputString)
	{
		String input = inputString;
		int skipInstructionFlag = 0;
		int val1=0, val2=0;
		StringTokenizer token = new StringTokenizer(inputString,"=+");
		String lhs = token.nextToken();
		int lhsRow = lhs.charAt(0) - 97;
		String temp="";
		for(int i=1; i<lhs.length();i++)
		{
			temp = temp + lhs.charAt(i);
		}
		int lhsCol = Integer.parseInt(temp)-1;
		matrix[lhsRow][lhsCol].name = lhs;
		String op1 = token.nextToken();
		String op2 = token.nextToken();
		int op1Row=0, op1Col=0, op2Row=0, op2Col=0;
		
		
		//check for dependency cycle
		if(op1.charAt(0)>96)
		{
			op1Row = op1.charAt(0) - 97;
			String temp1="";
			for(int i=1; i<op1.length();i++)
			{
				temp1 = temp1 + op1.charAt(i);
			}
			op1Col = Integer.parseInt(temp1)-1;
			if(matrix[op1Row][op1Col].getObservers().contains(matrix[lhsRow][lhsCol]))
			{
				skipInstructionFlag = 1;
				outList.add("Cycle Detected: " + input + ". As " + op1 + " is already dependent on "+ lhs + ", a cycle is formed.");
				Logger.writeMessage("Cycle Detected: " + input + ". As " + op1 + " is already dependent on "+ lhs + ", a cycle is formed.", Logger.DebugLevel.FROM_RESULTS);
				//System.out.println("Cycle Detected: " + inputString);
				
			}
		}
		if(op2.charAt(0)>96)
		{
			op2Row = op2.charAt(0) - 97;
			String temp1="";
			for(int i=1; i<op2.length();i++)
			{
				temp1 = temp1 + op2.charAt(i);
			}
			op2Col = Integer.parseInt(temp1)-1;
			if(matrix[op2Row][op2Col].getObservers().contains(matrix[lhsRow][lhsCol]))
			{
				skipInstructionFlag = 1;
				outList.add("Cycle Detected: " + input + ". As " + op2 + " is already dependent on "+ lhs + ", a cycle is formed.");
				Logger.writeMessage("Cycle Detected: " + input + ". As " + op2 + " is already dependent on "+ lhs + ", a cycle is formed.", Logger.DebugLevel.FROM_RESULTS);
				//System.out.println("Cycle Detected: " + inputString);
			}
		}
		
		//if no cycle
		if(0==skipInstructionFlag)
		{
			//remove observers
			matrix[lhsRow][lhsCol].removeObserver();
			
			//remove all subjects
			for(int i=0;i<26;i++)
			{
				for(int j=0; j<26; j++)
				{
					matrix[lhsRow][lhsCol].removeSubject(matrix[i][j]);
				}
			}
			
			//op1 is cell
			int opIndex= 0;
			if(op1.charAt(0)>96)
			{
				val1 =-1;
				matrix[lhsRow][lhsCol].subjectList.add(matrix[op1Row][op1Col]);
				matrix[lhsRow][lhsCol].subjectList.get(opIndex).name = op1;
				matrix[op1Row][op1Col].registerObserver(matrix[lhsRow][lhsCol]); //add to observerList
				opIndex++;
			}
			else //op1 is value
			{
				//code for remove previous observer
				val1 = Integer.parseInt(op1);
			}
			
			//op2 is cell
			if(op2.charAt(0)>96)
			{
				val2 = -1;
				matrix[lhsRow][lhsCol].subjectList.add(matrix[op2Row][op2Col]);
				matrix[lhsRow][lhsCol].subjectList.get(opIndex).name = op2;
				matrix[op2Row][op2Col].registerObserver(matrix[lhsRow][lhsCol]); //add to observerList
			}
			else //op2 is value
			{
				//code for remove previous observer
				val2 = Integer.parseInt(op2);
			}

			
			matrix[lhsRow][lhsCol].update(val1,val2,this);
			//refreshMatrix();
			//notify Observers - cell acting as subject
			matrix[lhsRow][lhsCol].notifyObservers(this);
			
		}
		
		
	}
	


	public void checkDep()
	{
		for()
	}
	@Override
	public void writeSchedulesToFile(String outputFileName) {
		outFile = new FileProcessor(outputFileName);
		try {
			outList.add("The sum of all cell values is: " + finalTotal);
			outFile.writeFile(outList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void writeScheduleToStdout() {
		
		
	}
}
