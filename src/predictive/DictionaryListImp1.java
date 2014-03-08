package predictive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryListImp1 implements Dictionary<WordSig> {

	private List<WordSig> wordTable = new ArrayList<WordSig>();
	private final String dictionaryLocation = Dictionary.dictionaryPath;
	private BufferedReader ourFile;

	public DictionaryListImp1() {
		ourFile = openFile();
		readWords();

	}

	private BufferedReader openFile() {
		BufferedReader tempBR = null;

		try {
			tempBR = new BufferedReader(new FileReader(dictionaryLocation));
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file to open.");
			e.printStackTrace(); //
			System.exit(1);
		}

		return tempBR;
	}

	private void readWords() {
		try {
			for (String word = ourFile.readLine(); word != null; word = ourFile
					.readLine()) {

				// Code to put key and value into the array list
				wordTable.add(new WordSig(PredictivePrototype.wordToSignature(word),word));

			}
		} catch (IOException e) {
			System.out.println("An error occured when copying: "
					+ e.getMessage());
		} finally {
			try {
				ourFile.close();
			} catch (IOException e) {
				System.out.println("An error occured when closing the file: "
						+ e.getMessage());
			}
		}
	}

	public String getWordFromSig() {
		return null;
	}

	@Override
	public List<WordSig> getWordTable() {
		return wordTable;
	}

	@Override
	public void printTable() {
		for (int i = 0; i < wordTable.size(); i++) {
			System.out.println(wordTable.get(i));
		}

	}
}
