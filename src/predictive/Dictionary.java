package predictive;

import java.util.List;

public interface Dictionary<TableType> {
	public static final String dictionaryPath = "C:\\Users\\Joe\\Documents\\GitHub\\T9text\\src\\predictive\\words.txt";
	public List<TableType> getWordTable();
	public void printTable();
}
