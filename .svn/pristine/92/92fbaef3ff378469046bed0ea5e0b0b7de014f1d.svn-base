package predictive;

import java.util.ArrayList;

/**
 * Tests going from a signature to a list with a dictionary represented as a
 * list
 * 
 * @author jgs328
 */
public class Sigs2WordsList {

	public static void main(String[] args) {

		Dictionary dict = new DictionaryListImpl();

		for (int i = 0; i < args.length; i++) {
			System.out.print("\n" + args[i] + ": ");

			ArrayList<String> set = (ArrayList<String>) dict.signatureToWords(args[i]);

			for (String string : set) {
				System.out.print(string + ", ");
			}
		}
	}
}
