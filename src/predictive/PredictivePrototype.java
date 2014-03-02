package predictive;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * A prototype for using T9 predictive text
 * 
 * @author Joseph Shaw
 */
public class PredictivePrototype {

	private static final ValueMaps valueMaps = new ValueMaps();

	/**
	 * Converts a given string to the corresponding key pad numbers on a mobile
	 * phone. It was better to use StringBuffer as String are immutable, whereas
	 * StringBuffers are not and given we need to constantly append it was
	 * better to use StringBuffer.
	 * 
	 * @param word
	 *            The word you wish to convert
	 * @return A string of numbers.
	 */
	public static String wordToSignature(String word) {

		word = word.toLowerCase();

		StringBuffer numString = new StringBuffer();

		for (int i = 0; i < word.length(); i++) {
			Integer c = valueMaps.getLetterToNum().get(word.charAt(i));
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
	 * @param signature
	 *            The signature to convert
	 * @return The list of possible words the string could be
	 */
	public static Set<String> signatureToWords(String signature) {

		// Convert the string to lowercase
		signature.toLowerCase();

		Dictionary dict = new Dictionary();
		Map<Integer, TreeSet<String>> table = dict.getWordTable();

		TreeSet<String> wordsSameLength = table.get(signature.length());

		for (Iterator<String> iter = wordsSameLength.iterator(); iter.hasNext();) {

			boolean removeString = false;

			String s = iter.next();
			for (int i = 0; i < signature.length(); i++) {

				removeString = false;

				int currInt = signature.charAt(i) - 48;

				char[] charArray = valueMaps.getNumToLettersValue(currInt);

				if (!arrayContainsChar(charArray, s.charAt(i))) {
					removeString = true;
					break;
				}
			}

			if (removeString) {
				iter.remove();
			}

		}
		return wordsSameLength;
	}

	/**
	 * Test if a char array contains contains a given to character
	 * 
	 * @param charArray
	 *            The char array to test
	 * @param c
	 *            The character to test if it is in the array
	 * @return TRUE if the array contains the char, FALSE if it does not
	 */
	private static boolean arrayContainsChar(char[] charArray, char c) {
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == c) {
				return true;
			}
		}
		return false;
	}

}
