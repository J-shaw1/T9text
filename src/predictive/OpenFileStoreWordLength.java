package predictive;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.lang.System;

/**
 * Opens the file and stores it as a map from word length to string
 * 
 * @author Joe
 * 
 */
public class OpenFileStoreWordLength {

	BufferedReader ourFile;
	private final String dictionaryLocation = Dictionary.dictionaryPath;
	private Map<String, HashSet<String>> wordTable;

	/**
	 * Creates the dictionary
	 */
	public OpenFileStoreWordLength() {

		ourFile = openFile();
		wordTable = readWords();
	}

	/**
	 * Opens a file
	 * 
	 * @return The open file
	 */
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

	/**
	 * Return the set of words, mapped based on their length
	 * 
	 * @return The map of words
	 */
	private Map<String, HashSet<String>> readWords() {
		
		Map<String, HashSet<String>> table = new HashMap<String, HashSet<String>>();

		try {
			for (String word = ourFile.readLine(); word != null; word = ourFile.readLine()) {

				if (isValidWord(word)) {
					word = word.toLowerCase();
					// Code to put key and value into the tree
					String key = decideKey(word);
					if (table.get(key) == null) {
						table.put(key, new HashSet<String>());
					}

					table.get(key).add(word);
				}

			}
		} catch (IOException e) {
			System.out.println("An error occured when copying: " + e.getMessage());
		} finally {
			try {
				ourFile.close();
			} catch (IOException e) {
				System.out.println("An error occured when closing the file: " + e.getMessage());
			}
		}
		return table;
	}
	
	private boolean isValidWord(String s) {
		for (char c : s.toCharArray()) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Decides the key for a given word, this is redundant now as it was going
	 * to make other methods easier but it in fact didn't
	 * 
	 * @param word
	 *            The Word
	 * @return The Key
	 */
	private String decideKey(String word) {
		return String.valueOf(word.length());
	}

	/**
	 * Gets the word table
	 * 
	 * @return The word table
	 */
	public Map<String, HashSet<String>> getWordTable() {
		return wordTable;
	}

	/**
	 * prints out a given table
	 * 
	 * @param table
	 *            The table to print
	 */
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
