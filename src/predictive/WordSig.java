package predictive;

public class WordSig implements Comparable<WordSig>{

	private String signature;
	private String word;
	
	public WordSig(String signature, String word) {
		this.signature = signature;
		this.word = word;
	}

	@Override
	public int compareTo(WordSig o) {
		return Integer.valueOf(this.getSignature()) - Integer.valueOf(o.getSignature());
	}

	public String getSignature() {
		return signature;
	}

	public String getWord() {
		return word;
	}
	
	public String toString(){
		return "Signature: " + signature + "   Word: " + word;
	}

}
