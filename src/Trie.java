/**
 * CSCI 1913, Spring 2022, Daniel Kluver, Project 3
 * Author: Benjamin Lindeen
 */

/**
 * Class Trie sets up the interface for the tree data structure for linking chars together into strings.
 */
public class Trie<Type> {
    private TrieNode<Type> root;

    /**
     * constructor, initializes new root node.
     */
    public Trie() {
        root = new TrieNode<>();
    }

    /**
     * makes a new temporary node of TrieNode Type, and sets it to root of Trie class
     * loops over the size of the segment that is being passed in.
     * checks the get child at the index of the segment in the for loop, until the end of the string is reached and the final node is found.
     *
     * @param segment the segment that is being searched in the tree.
     * @return the found node
     */
    private TrieNode<Type> getNode(String segment) {
        TrieNode<Type> node = root;
        for (int i = 0; i < segment.length(); i++) {
            node = node.getChild(segment.charAt(i));
        }

        return node;
    }

    /**
     * @param segment the segment that is being searched.
     * @return the data from the node at point of segment.
     */
    public Type get(String segment) {
        return getNode(segment).getData();
    }

    /**
     * makes a temp node storage.
     * sets the node at index segment to the new data that is being passed in.
     *
     * @param segment the segment where the node is found
     * @param data the new data that will replace the old.
     * @return the temp previous node.
     */
    public Type put(String segment, Type data) {
        Type temp = getNode(segment).getData();
        getNode(segment).setData(data);

        return temp;
    }

    /**
     * @return the node of the class.
     */
    public TrieNode<Type> getRoot() {
        return root;
    }
}