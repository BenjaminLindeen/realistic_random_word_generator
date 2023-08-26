/**
 * CSCI 1913, Spring 2022, Daniel Kluver, Project 3
 * Author: Benjamin Lindeen
 */

/**
 * Class LetterSample represents a collection of letters that are taken from a passed in string,
 * and the length of the segments that the string is being broken into.
 */
public class LetterSample {
    private String segment;
    private char nextLetter;

    /**
     * Constructor takes in the string to be or substring and the next letter in the sequence,
     * and sets them to the private variables that are in every class.
     *
     * @param segment    the string that will be set as the partial string segment
     * @param nextLetter the next letter from the original string in the sequence
     */
    public LetterSample(String segment, char nextLetter) {
        this.segment = segment;
        this.nextLetter = nextLetter;
    }

    /**
     * @return the string segment
     */
    public String getSegment() {
        return segment;
    }

    /**
     * @return the next letter in the string
     */
    public char getNextLetter() {
        return nextLetter;
    }

    /**
     * @return a formatted string with the segment of the pointing to the next letter.
     */
    public String toString() {
        return '"' + getSegment() + '"' + " -> " + getNextLetter();
    }

    /**
     * Static char . to signify any character that does not fit into the english alphabet, and the end of a string sample.
     */
    public static final char STOP = '.';

    /**
     * makes a new letter sample array that holds letter sample segments.
     * loops over the length of the input string, and adds substring segments to the array.
     * checks if the iteration is less that the size of the passed in segment size, and uses a special case for adding the segment.
     * substring goes from the start to i, and the from i minus the segment size to i.
     * adds the ending char to the string array.
     *
     * @param input       string to be sliced
     * @param segmentSize the size of the slices taken in the string
     * @return the Letter sample array
     */
    public static LetterSample[] toSamples(String input, int segmentSize) {
        LetterSample[] newSample = new LetterSample[input.length() + 1];
        int index;
        for (index = 0; index < input.length(); index++) {
            if (index < segmentSize + 1) {
                newSample[index] = new LetterSample(input.substring(0, index), input.charAt(index));
            } else {
                newSample[index] = new LetterSample(input.substring(index - segmentSize, index), input.charAt(index));
            }
        }
        newSample[index] = new LetterSample(input.substring(index - segmentSize, index), LetterSample.STOP);

        return newSample;
    }
}