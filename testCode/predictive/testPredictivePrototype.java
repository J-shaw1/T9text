package predictive;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;

@Test
public class testPredictivePrototype {

	@BeforeMethod
	public void setup() {

	}

	public void testWordToSignature() {

		// for(int i = 0; i < 5000000; i++) {
		assertEquals("843", PredictivePrototype.wordToSignature("The"));
		assertEquals("78425", PredictivePrototype.wordToSignature("quick"));
		assertEquals("27696", PredictivePrototype.wordToSignature("brown"));
		assertEquals("369", PredictivePrototype.wordToSignature("fox"));
		assertEquals("58677", PredictivePrototype.wordToSignature("jumps"));
		assertEquals("6837", PredictivePrototype.wordToSignature("over"));
		assertEquals("843", PredictivePrototype.wordToSignature("the"));
		assertEquals("5299", PredictivePrototype.wordToSignature("lazy"));
		assertEquals("364", PredictivePrototype.wordToSignature("dog"));
		// }
	}

	
	public void testSignatureToWords(){
		PredictivePrototype.signatureToWords("Hello");
	}
	
}
