/**
 * CSCI 1913, Spring 2022, Daniel Kluver, Project 3
 * Author: Benjamin Lindeen
 */

/**
 * Class TrieNode sets up the tree data structure for linking chars together into strings.
 */
public class TrieNode<Type> {
    private int alphaSize;
    private Type data;
    private TrieNode<Type>[] children;

    /**
     * Constructor initializes the node data, and the array of possible children to null
     */
    public TrieNode() {
        alphaSize = 26;
        data = null;
        children = new TrieNode[alphaSize];
    }

    /**
     * @return node data variable
     */
    public Type getData() {
        return data;
    }

    /**
     * sets passed in data to node data
     *
     * @param data data being passed in
     */
    public void setData(Type data) {
        this.data = data;
    }

    /**
     * checks if char passed in is an english letter or not, returns null if not
     * checks if the letter that is being passed in is uppercase, if so, converts to lowercase.
     * converts the passed in char to an ASCII value.
     * checks if the index in the array with the value minus the ascii modifier is null;
     * if it is creates a new node in that index
     *
     * @param letter to be checked
     * @return the array at the index
     */
    public TrieNode<Type> getChild(char letter) {
        if (!Character.isLetter(letter) || Character.isUpperCase(letter)) {
            return null;
        }
        int charToInt = letter;
        int asciiModifier = 97;
        if (children[charToInt - asciiModifier] == null) {
            children[charToInt - asciiModifier] = new TrieNode<>();
        }

        return children[charToInt - asciiModifier];
    }

    /**
     * loops over the children array, if a node is found that isn't null, recursively searched that node's children array.
     *
     * @return the composite count index.
     */
    public int getTreeSize() {
        int count = 1;
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null) {
                count += children[i].getTreeSize();
            }
        }

        return count;
    }
}