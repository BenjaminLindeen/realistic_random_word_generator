/**
 * CSCI 1913, Spring 2022, Daniel Kluver, Project 3
 * Author: Benjamin Lindeen
 */

/**
 * Class Gibberisher uses the other classes in the project to read, store, and create words
 */public class Gibberisher {
    private Trie<CharBag> model;
    private int segmentLength;
    private int letterSampleCount;

    /**
     * constructor initializes the variables
     * @param segmentLength the length of the segments to be generated in Letter Samples.
     */
    public Gibberisher(int segmentLength) {
        this.segmentLength = segmentLength;
        model = new Trie<>();
        letterSampleCount = 0;
    }

    /**
     * takes in the words from dictionary, and forms them all into chunks the size that is determined in the parameter of the class.
     * stores the string chunks in the tire data structure of type charbag.
     * creates new charbags accoring to when they are needed by samples that are new.
     * @param segmentStrings the array of strings to be dismembered and stored.
     */
    public void train(String[] segmentStrings) {
        if (model.getRoot().getData() == null) {
            model.getRoot().setData(new CharBag());
        }
        for (int i = 0; i < segmentStrings.length; i++) {
            LetterSample[] sample = LetterSample.toSamples(segmentStrings[i], segmentLength);
            for (int k = 0; k < sample.length; k++) {
                if (sample[k].getSegment().equals("")) {
                    model.getRoot().getData().add(sample[k].getNextLetter());
                } else {
                    CharBag tempBag = model.get(sample[k].getSegment());
                    if (tempBag == null) {
                        tempBag = new CharBag();
                        model.put(sample[k].getSegment(), tempBag);
                        tempBag.add(sample[k].getNextLetter());
                    } else {
                        tempBag.add(sample[k].getNextLetter());
                    }
                }
                letterSampleCount++;
            }
        }
    }

    /**
     *
     * @return the amount of samples created by train
     */
    public int getSampleCount() {
        return letterSampleCount;
    }

    /**
     * initializes a new word string to a random letter from the root charbag.
     * loops over the word until the end character is reached.
     * appends pseudo random letters based on the path of the last segment of the word to the word
     * @return the finished word.
     */
    public String generate() {
        String word = Character.toString(model.getRoot().getData().getRandomChar());

        while (word.charAt(word.length() - 1) != LetterSample.STOP) {
            if (word.length() < segmentLength) {
                word += model.get(word.substring((word.length() - 1))).getRandomChar();
            } else {
                String sample = word.substring(word.length() - segmentLength, word.length());
                CharBag charCheck = model.get(sample);
                if (charCheck == null) {
                    word += LetterSample.STOP;
                } else {
                    char tempChar = model.get(sample).getRandomChar();
                    word += tempChar;
                }
            }
        }

        return word.substring(0, word.length() - 1);
    }
}