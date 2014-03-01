package predictive;

public class Sig2WordsProto {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			System.out.println(PredictivePrototype.signatureToWords(args[i]));
		}
	}
}
