package spreadsheetUpdates.observer;

import spreadsheetUpdates.util.Cell;
import spreadsheetUpdates.util.Operands;
import spreadsheetUpdates.util.Sheet;

public interface Subject {
	public void registerObserver(Cell o);
	public void removeObserver();
	public void notifyObservers(Sheet sheet); // parameter?

}
