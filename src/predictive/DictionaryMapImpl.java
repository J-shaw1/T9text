package predictive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creates a new dictionary with the words stored in a tree format
 * 
 * To create an object of this class it takes ~1200ms
 * To convert 9000000 words it takes ~337ms
 * 
 * @author jgs328
 */
public class DictionaryMapImpl implements Dictionary{

	private Map<String, ArrayList<String>> dictionary;

	/**
	 * Constructor to create an object of this type
	 */
	public DictionaryMapImpl() {
		BufferedReader ourFile = openFile();
		dictionary = readWords(ourFile);
	}
	
	/**
	 * Converts a given word to its signature
	 * 
	 * @param word
	 *            The word to change to a signature
	 */
	@Override
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
	 * Gets a set of words for a given signature
	 * 
	 * @return signature The signature to get the set of words for
	 */
	@Override
	public List<String> signatureToWords(String signature) {
		if(dictionary.containsKey(signature)){
			return dictionary.get(signature);
		}
		else {
			return new ArrayList<String>();
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
	 * Reads the words from the file
	 * 
	 * @param ourFile
	 *            The file to read from
	 */
	private Map<String, ArrayList<String>> readWords(BufferedReader ourFile) {

		Map<String, ArrayList<String>> table = new HashMap<String, ArrayList<String>>();

		try {
			for (String word = ourFile.readLine(); word != null; word = ourFile
					.readLine()) {

				if (isValidWord(word)) {
					word = word.toLowerCase();
					
					String wordSig = wordToSignature(word);
					
					//If the table already contains a map for that object
					if(table.containsKey(wordSig)){
						//Check that the word is not already in the array
						if(!table.get(wordSig).contains(word))
						table.get(wordSig).add(word);
					}
					//Otherwise the table does not already contain the key
					else {
						ArrayList<String> temp = new ArrayList<String>();
						temp.add(word);
						table.put(wordSig, temp);
					}
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
	 * Tests if a given word is a valid word
	 * 
	 * @param word
	 *            The word to test
	 * @return TRUE if the word is valid, FALSE if it is not
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
