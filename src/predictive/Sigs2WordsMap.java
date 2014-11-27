package predictive;

/**
 * Tests going from a signature to a list with the dictionary represented as a
 * series of maps
 * 
 * @author Joe
 * 
 */
public class Sigs2WordsMap {

	public static void main(String[] args) {

		Dictionary dict = new DictionaryMapImpl();

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + ": " + dict.signatureToWords(args[i]));
		}
	}
}