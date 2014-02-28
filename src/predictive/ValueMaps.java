package predictive;

import java.util.Map;
import java.util.TreeMap;

/**
 * Contains two TreeMaps, one for converting from a letter to a
 * number(letterToNum) and one for converting from a number to a letter
 * (numToLetter);
 * 
 * @author Joseph Shaw
 * 
 */
public class ValueMaps {

	private Map<Integer, char[]> numToLetters = new TreeMap<Integer, char[]>();
	private Map<Character, Integer> letterToNum = new TreeMap<Character, Integer>();

	/**
	 * Sets up the two value maps for going from a number to and letter and visa
	 * versa
	 */
	public ValueMaps() {

		// Create the char arrays for each number
		char[] twoCharArray = { 'a', 'b', 'c' };
		numToLetters.put(2, twoCharArray);

		char[] threeCharArray = { 'd', 'e', 'f' };
		numToLetters.put(3, threeCharArray);

		char[] fourCharArray = { 'g', 'h', 'i' };
		numToLetters.put(4, fourCharArray);

		char[] fiveCharArray = { 'j', 'k', 'l' };
		numToLetters.put(5, fiveCharArray);

		char[] sixCharArray = { 'm', 'n', 'o' };
		numToLetters.put(6, sixCharArray);

		char[] sevenCharArray = { 'p', 'q', 'r', 's' };
		numToLetters.put(7, sevenCharArray);

		char[] eightCharArray = { 't', 'u', 'v' };
		numToLetters.put(8, eightCharArray);

		char[] nineCharArray = { 'w', 'x', 'y', 'z' };
		numToLetters.put(9, nineCharArray);

		// Map from a letter to a number
		letterToNum.put('a', 2);
		letterToNum.put('b', 2);
		letterToNum.put('c', 2);
		letterToNum.put('d', 3);
		letterToNum.put('e', 3);
		letterToNum.put('f', 3);
		letterToNum.put('g', 4);
		letterToNum.put('h', 4);
		letterToNum.put('i', 4);
		letterToNum.put('j', 5);
		letterToNum.put('k', 5);
		letterToNum.put('l', 5);
		letterToNum.put('m', 6);
		letterToNum.put('n', 6);
		letterToNum.put('o', 6);
		letterToNum.put('p', 7);
		letterToNum.put('q', 7);
		letterToNum.put('r', 7);
		letterToNum.put('s', 7);
		letterToNum.put('t', 8);
		letterToNum.put('u', 8);
		letterToNum.put('v', 8);
		letterToNum.put('w', 9);
		letterToNum.put('x', 9);
		letterToNum.put('y', 9);
		letterToNum.put('z', 9);
	}

	/**
	 * Returns the mapped char array of a given value
	 * 
	 * @param x
	 *            The key to return the mapped char array
	 * @return The mapped char array of the key
	 */
	public char[] getNumToLettersValue(int x) {
		return numToLetters.get(x);
	}

	/**
	 * Returns the mapped number from a char of the given value
	 * 
	 * @param x
	 *            The key to return the mapped int
	 * @return The mapped int of the char
	 */
	public int getLetterToNumValue(char x) {
		return letterToNum.get(x);
	}

	/**
	 * Returns the tree map for going from a number to a letter
	 * 
	 * @return The tree map numToLetters
	 */
	public Map<Integer, char[]> getNumToLetters() {
		return numToLetters;
	}

	/**
	 * Return the tree map for going from a letter to a number
	 * 
	 * @return The tree map letterToNum
	 */
	public Map<Character, Integer> getLetterToNum() {
		return letterToNum;
	}

}
