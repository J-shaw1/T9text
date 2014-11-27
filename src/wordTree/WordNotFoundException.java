package wordTree;

/**
 * A checked exception for if the word is not found in the dictionary
 * @author jgs328
 *
 */
@SuppressWarnings("serial")
public class WordNotFoundException extends Exception {
	
	/**
	 * Creates a new exception with no message
	 */
	public WordNotFoundException(){
		super();
	}
	
	/**
	 * Creates a new error message with a given message
	 * @param s The given message
	 */
	public WordNotFoundException(String s){
		super(s);
	}
	
}
