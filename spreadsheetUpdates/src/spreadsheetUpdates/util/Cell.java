package spreadsheetUpdates.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import spreadsheetUpdates.util.Logger;
import spreadsheetUpdates.observer.Listener;
import spreadsheetUpdates.observer.Subject;

public class Cell implements Subject, Listener{

	List<Cell> observerList;
	List<Cell> subjectList;
	String name;
	int val1=0, val2=0;
	int total = 0;
	Sheet sheet = new Sheet();
	int  v1Col, v1Row, v2Col, v2Row;
	
	
	public Cell()
	{
		Logger.writeMessage("Cell class (Listener) constructor", Logger.DebugLevel.CONSTRUCTOR);
		observerList = new ArrayList<Cell>();
		subjectList = new ArrayList<Cell>();
	}
	
	@Override
	public void registerObserver(Cell o) {
		observerList.add(o);
		for(int i=0;i<o.observerList.size();i++)
		{
			observerList.add(o.observerList.get(i));
		}
	}

	@Override
	public void removeObserver() {
		//int i = observerList.indexOf(o);
		for(int i=0;i<observerList.size();i++)
		{
			observerList.remove(i);
		}
	}
	public void removeSubject(Listener o) {
		int i = subjectList.indexOf(o);
		if(i >= 0)
		{
			subjectList.remove(i);
		}
	}

	@Override
	public void notifyObservers(Sheet sheetIn) {
		Logger.writeMessage("Notifying Observers of " + name, Logger.DebugLevel.IN_RESULTS);
		sheet = sheetIn;
		sheet.refreshMatrix();
		
	}
	
	public int getCellData(Sheet sheet)
	{
		int pval1=0,pval2=0;
		if(-1 == val1)
		{
			pval1 = sheet.matrix[v1Row][v1Col].total;
		}
		else
		{
			pval1 = val1;
		}
		if(-1 == val2)
		{
			pval2 = sheet.matrix[v2Row][v2Col].total;
		}
		else
		{
			pval2 = val2;
		}
		return pval1 + pval2;
	}

	public List<Cell> getObservers()
	{
		return observerList;
	}
	
	
	@Override
	public void update(int val1In, int val2In, Sheet sheeti) {

		int opIndex=0;
		if((-1) == val1In)
		{
			String cellName = subjectList.get(opIndex).name;
			v1Row = cellName.charAt(0) - 97;
			String temp="";
			for(int i=1; i<cellName.length();i++)
			{
				temp = temp + cellName.charAt(i);
			}
			v1Col = Integer.parseInt(temp)-1;
			//System.out.println("v1Row:"+v1Row+" v1Col:"+v1Col);

			val1 = -1;
			opIndex++;
		}
		else
		{
			val1 = val1In;
		}
		
		if(-1 == val2In)
		{
			String cellName = subjectList.get(opIndex).name;
			v2Row = cellName.charAt(0) - 97;
			String temp="";
			for(int i=1; i<cellName.length();i++)
			{
				temp = temp + cellName.charAt(i);
			}
			v2Col = Integer.parseInt(temp)-1;
			val2 = -1;
		}
		else
		{
			val2 = val2In;
		}
		
		
	}

	
}
