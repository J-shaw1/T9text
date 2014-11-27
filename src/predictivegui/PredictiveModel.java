package predictivegui;

import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;

import predictive.Dictionary;

/**
 * Contains a model of the dictionary and all methods needed to do predictive
 * text
 * 
 * @author jgs328
 * 
 */
public class PredictiveModel extends Observable {

	private Dictionary model;
	private Collection<String> words;
	private Iterator<String> i;
	private String currentWord;
	private String currentMessage;
	private String workingSig = new String();

	/**
	 * Creates the dictionary model from an Dictionary type
	 * 
	 * @param model
	 *            The Dictionary type to read the word from.
	 */
	public PredictiveModel(Dictionary model) {
		super();
		this.model = model;
		currentMessage = new String();
	}

	/**
	 * Gets the words related to a given signature, the words will be trimmed
	 * 
	 * @param sig
	 *            The words to get the signature for.
	 */
	public void getWordsFromSig() {
		words = model.signatureToWords(workingSig);
		setupIterator();
		nextWord();
		setChanged();
		notifyObservers();
	}

	/**
	 * Sets the current word to the next one in the list
	 */
	public void nextWord() {
		// Might be able to get rid of this if iterator goes back to the start
		try {
			if (i.hasNext()) {
				currentWord = i.next();
			} else {
				setupIterator();
				if (i.hasNext())
					currentWord = i.next();
			}
			setChanged();
			notifyObservers();
		}
		// Catches null point so that if next is pressed it dosnt throw an
		// error. Storing words at the root would solver this problem
		catch (NullPointerException e) {
		}
	}

	/**
	 * Create a new iterator, will be at the start of the set
	 */
	private void setupIterator() {
		i = words.iterator();
	}

	/**
	 * Gets the current word
	 * 
	 * @return Current word
	 */
	public String getCurrentWord() {
		return currentWord;
	}

	/**
	 * Adds a sig char to the current working sig, the updates all things that
	 * need to be updated Called when the user presses a number button
	 * 
	 * @param k
	 *            the sig char to append
	 */
	public void addSigChar(int k) {
		workingSig += String.valueOf(k);
		getWordsFromSig();
	}

	/**
	 * Gets the current working signature
	 * 
	 * @return The working signature
	 */
	public String getWorkingSig() {
		return workingSig;
	}

	/**
	 * Called when a new word need to be written, ie when the user has pressed 0
	 */
	public void newWord() {
		currentWord += " ";
		currentMessage += currentWord;
		currentWord = new String();
		workingSig = new String();
		setupIterator();
		setChanged();
		notifyObservers();

	}

	/**
	 * Gets the entire message
	 * 
	 * @return The enture message
	 */
	public String getMessage() {
		return currentMessage;
	}

	/**
	 * removes a char from the current word, this is buggy and throws several
	 * exceptions
	 */
	public void backSpace() {
		// if(workingSig.length() < 1){
		workingSig = workingSig.substring(0, workingSig.length() - 1);
		// }
		// else {
		// workingSig = new String();
		// }
		getWordsFromSig();

	}

}
