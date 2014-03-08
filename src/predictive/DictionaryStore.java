package predictive;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.lang.System;

public class DictionaryStore{

	BufferedReader ourFile;
	private final String dictionaryLocation = Dictionary.dictionaryPath;
	private Map<String, HashSet<String>> wordTable;

	public DictionaryStore() {

		ourFile = openFile();
		wordTable = readWords();
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

	private Map<String, HashSet<String>> readWords() {

		Map<String, HashSet<String>> table = new HashMap<String, HashSet<String>>();

		try {
			for (String word = ourFile.readLine(); word != null; word = ourFile
					.readLine()) {

				// Code to put key and value into the tree
				String key = decideKey(word);
				if (table.get(key) == null) {
					table.put(key, new HashSet<String>());
				}

				table.get(key).add(word);

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
		return table;
	}

	private String decideKey(String word) {
		return String.valueOf(word.length());
	}

	public Map<String, HashSet<String>> getWordTable() {
		return wordTable;
	}

	public void printTable(Map<String, HashSet<String>> table) { // Word list
		// successfully read and stored:

		// For each entry e of the table, print the key and the value:

		for (Entry<String, HashSet<String>> e : table.entrySet()) {
			System.out.println("Key " + e.getKey() + " -> ");

			for (String s : e.getValue())
				System.out.println(s);
		}
	}
}
