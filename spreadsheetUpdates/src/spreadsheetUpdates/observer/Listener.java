package spreadsheetUpdates.observer;

import spreadsheetUpdates.util.Sheet;

public interface Listener {
	public void update(int val1, int val2, Sheet sheet);
}
