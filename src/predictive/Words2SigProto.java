package predictive;

/**
 * Tests going from a word to a sig using predictive prototype
 * @author jgs328
 */
public class Words2SigProto {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(PredictivePrototype.wordToSignature(args[i]));
		}
	}
}
