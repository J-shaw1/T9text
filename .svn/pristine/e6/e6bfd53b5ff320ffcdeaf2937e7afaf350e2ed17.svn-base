package predictive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A List implementation of the predictive text system.
 * 
 * To construct this class it takes ~700ms on my home PC.
 * To read 9000000 words it takes ~2.8s
 * 
 * @author jgs328
 */
public class DictionaryListImpl implements Dictionary {

	private ArrayList<WordSig> wordTable;

	/**
	 * Constructor to store the dictionary
	 */
	public DictionaryListImpl() {
		BufferedReader ourFile = openFile();
		wordTable = readWords(ourFile);
		Collections.sort(wordTable);
	}

	/**
	 * Converts a given string to the corresponding key pad numbers on a mobile
	 * phone.
	 * 
	 * @param word
	 *            The word you wish to convert
	 * @return A string of numbers.
	 */
	public String wordToSignature(String word) {

		word = word.toLowerCase();

		StringBuffer numString = new StringBuffer();

		for (int i = 0; i < word.length(); i++) {
			Integer c = ValueMaps.getLetterToNum().get(word.charAt(i));
			if (c == null) {
				numString.append(' ');
			} else {
				numString.append(c);
			}
		}
		return numString.toString();
	}

	/**
	 * Converts a number signature of a word to a list of possible words that
	 * the signature could be
	 * 
	 * TIMINGS: (These are testNG timings, all ran on 900 words on my home PC.
	 * The test can be viewed in my testCode folder) PredictivePrototype:
	 * 138.189s DictionaryListImpl: 0.011s This does not include the time taken
	 * to construct the class which is ~700ms, but only has to be done once.
	 * 
	 * As you can see the time difference is very noticeable
	 * 
	 * @param signature
	 *            The signature to convert
	 * @return The list of possible words the string could be
	 */
	public List<String> signatureToWords(String signature) {

		List<String> wordsSame = new ArrayList<String>();

		addWord(wordsSame, signature);

		return wordsSame;

	}

	/**
	 * Helper method to add words with the given signature to a given list
	 * 
	 * @param wordsSame
	 *            The list to add to
	 * @param signature
	 *            The signature compare to all words
	 */
	private void addWord(List<String> wordsSame, String signature) {
		// Get the index
		int index = Collections.binarySearch(wordTable, new WordSig(signature,
				null));

		if (index < 0) {
			System.out.println("Word not found in the dictionary");
			return;
		}

		if (index >= 0) {
			wordsSame.add(wordTable.get(index).getWord());
			checkBelowIndex(wordsSame, index, signature);
			checkAboveIndex(wordsSame, index, signature);
		}
	}

	/**
	 * Helper method to check below a given index until the signature does not
	 * match, will add to given list.
	 * 
	 * @param wordsSame
	 *            The list to add the words to
	 * @param index
	 *            The index that has already been checked
	 * @param signature
	 *            The signature you are looking for all that words that match
	 */
	private void checkBelowIndex(List<String> wordsSame, int index,
			String signature) {

		int tempIndex = index - 1;

		if (wordTable.get(tempIndex).getSignature().equals(signature)) {
			wordsSame.add(wordTable.get(tempIndex).getWord());
			checkBelowIndex(wordsSame, tempIndex, signature);
		}
	}

	/**
	 * Helper method to check above a given index until the signature does not
	 * match, will add to given list.
	 * 
	 * @param wordsSame
	 *            The list to add the words to
	 * @param index
	 *            The index that has already been checked
	 * @param signature
	 *            The signature you are looking for all that words that match
	 */
	private void checkAboveIndex(List<String> wordsSame, int index,
			String signature) {

		int tempIndex = index + 1;

		if (wordTable.get(tempIndex).getSignature().equals(signature)) {
			wordsSame.add(wordTable.get(tempIndex).getWord());
			checkAboveIndex(wordsSame, tempIndex, signature);
		}

	}

	/**
	 * Helper method to open the file the dictionary is contained in
	 * 
	 * @return The open file
	 */
	private BufferedReader openFile() {

		BufferedReader tempBR = null;

		try {
			tempBR = new BufferedReader(new FileReader(
					Dictionary.dictionaryPath));
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file to open.");
			e.printStackTrace();
			System.exit(1);
		}

		return tempBR;
	}

	/**
	 * Read the words and adds them to an array list
	 * 
	 * @param ourFile
	 *            The file to read from
	 * @return The list of words from the dictionary, only valid words are
	 *         added.
	 */
	private ArrayList<WordSig> readWords(BufferedReader ourFile) {

		ArrayList<WordSig> table = new ArrayList<WordSig>();

		try {
			for (String word = ourFile.readLine(); word != null; word = ourFile
					.readLine()) {

				if (isValidWord(word)) {
					word = word.toLowerCase();
					// Code to put key and value into the tree
					String key = wordToSignature(word);

					table.add(new WordSig(key, word));
				}
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

	/**
	 * Helper method to check if a word is valid
	 * @param word The word to check
	 * @return TRUE of the word is valid, FALSE if the word is invalid
	 */
	private boolean isValidWord(String word) {
		char[] charArray = word.toCharArray();
		for (char c : charArray) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}

}
