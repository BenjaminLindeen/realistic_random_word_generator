/**
 * CSCI 1913, Spring 2022, Daniel Kluver, Project 3
 * Author: Benjamin Lindeen
 */

/**
 * Class CharBag represents a collection of letters and the period along with the index of the amount of letters contained.
 * uses 2 arrays to first store all of the letters of the english alphabet and the period in a char array,
 * and then to match the index to an int array which stores the amount of letters that the bag contains
 */
public class CharBag {
    private int size;
    private char[] alphaCharBag;
    private int[] alphaCharCount;

    /**
     * constructor, initiates the size of the bag to 0 on start
     * the alphabet array to the given 26 characters of the alphabet and a period.
     * the int array that stores the amount of times the letter is found in the bag, with size of the first array.
     */
    public CharBag() {
        size = 0;
        alphaCharBag = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '.'};
        alphaCharCount = new int[alphaCharBag.length];
    }

    /**
     * checks if the char passed is in a letter, if not converts to .
     * checks if the char passed in is upper case, if so converts to lowercase
     * iterates over the list of letters until it finds the index of the letter
     *
     * @param letter the char being compared
     * @return the index of the letter passed in
     */
    public int alphaCharIndex(char letter) {
        if (!Character.isLetter(letter)) {
            letter = LetterSample.STOP;
        }
        if (Character.isUpperCase(letter)) {
            letter = Character.toLowerCase(letter);
        }
        for (int i = 0; i < alphaCharBag.length; i++) {
            if (letter == alphaCharBag[i]) {
                return i;
            }
        }

        return -1;
    }

    /**
     * uses alphaIndex to find the index of the char
     * adds to the count of the int array for the letter at the index
     *
     * @param letter the char being added
     */
    public void add(char letter) {
        alphaCharCount[alphaCharIndex(letter)]++;
        size++;
    }

    /**
     * checks if the int array counter for the passed in letter isn't 0;
     * if there are elements to remove, decrement array counter by one and bag size by one
     *
     * @param letter the char being removed
     */
    public void remove(char letter) {
        if (alphaCharCount[alphaCharIndex(letter)] != 0) {
            alphaCharCount[alphaCharIndex(letter)]--;
            size--;
        }
    }

    /**
     * @param letter the letter of which the amount is being retrieved
     * @return the amount at index of the letter.
     */
    public int getCount(char letter) {
        return alphaCharCount[alphaCharIndex(letter)];
    }

    /**
     * @return the amount of chars in the CharBag
     */
    public int getSize() {
        return size;
    }

    /**
     * initiates a new string. formats the data in the char bag into a readable string,
     * while looping over the length of the alphabet array, and appending the letter and the amount to a string.
     *
     * @return the appended string
     */
    public String toString() {
        String toString = "CharBag{";
        for (int i = 0; i < alphaCharBag.length; i++) {
            toString += alphaCharBag[i] + ":" + getCount(alphaCharBag[i]) + ", ";
        }
        if (size != 0) {
            toString = toString.substring(0, toString.length() - 2);
        }
        toString += "}";

        return toString;
    }

    /**
     * finds a random number between 0 and the amount of chars in the bag.
     * loops over the size of the bag, decrementing the count by the amount in the letter index.
     * if the count drops below 0
     *
     * @return the letter at the index of the loop, otherwise return .
     */
    public char getRandomChar() {
        int count = (int) (Math.random() * size);
        for (int i = 0; i < size; i++) {
            count -= getCount(alphaCharBag[i]);
            if (count < 0) {
                return alphaCharBag[i];
            }
        }

        return LetterSample.STOP;
    }
}