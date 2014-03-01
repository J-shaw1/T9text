package predictive;

import java.io.*;
import java.util.*;
import java.lang.System;

public class Dictionary {

	BufferedReader ourFile;
	private final String dictionaryLocation = "C:\\Users\\Joe\\Documents\\GitHub\\T9text\\src\\predictive\\words.txt";
	private Map<Integer, TreeSet<String>> wordTable;

	public Dictionary() {

		ourFile = openFile();

		wordTable = readWords();

		// printTable(wordTable);
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

	private Map<Integer, TreeSet<String>> readWords() {

		Map<Integer, TreeSet<String>> table = new TreeMap<Integer, TreeSet<String>>();

		try {
			for (String word = ourFile.readLine(); word != null; word = ourFile
					.readLine()) {

				// Code to put key and value into the tree
				int key = word.length();
				if (table.get(key) == null) {
					table.put(key, new TreeSet<String>());
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

	public Map<Integer, TreeSet<String>> getWordTable() {
		return wordTable;
	}

	public void printTable(Map<Integer, TreeSet<String>> table) { // Word list
		// successfully read and stored:

		// For each entry e of the table, print the key and the value:

		for (Map.Entry<Integer, TreeSet<String>> e : table.entrySet()) {
			System.out.println("Key " + e.getKey() + " -> ");

			for (String s : e.getValue())
				System.out.println(s);
		}
	}

}
