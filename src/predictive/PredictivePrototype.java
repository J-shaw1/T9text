package predictive;

/**
 * A prototype for using T9 predictive text
 * 
 * @author Joseph Shaw
 */
public class PredictivePrototype {

	private static final ValueMaps valueMaps = new ValueMaps();

	/**
	 * Converts a given string to the corresponding key pad numbers on a mobile
	 * phone
	 * 
	 * @param word
	 *            The word you wish to convert
	 * @return A string of numbers.
	 */
	public static String wordToSignature(String word) {

		word = word.toLowerCase();

		StringBuffer numString = new StringBuffer();

		for (int i = 0; i < word.length(); i++) {
			Integer c = valueMaps.getLetterToNumValue(word.charAt(i));
			if (c == null) {
				numString.append(' ');
			} else {
				numString.append(c);
			}
		}
		return numString.toString();
	}
}
