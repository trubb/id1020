import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.ArrayList;
import java.lang.UnsupportedOperationException;

class Trieiterator implements Iterator<Entry<String, Integer>> {

    private Trie trie; // create a new trie
    private String prefix; // create a string to hold our commonPrefix
    private Node topNode; // create a top node (the node furthest from the root)
    private int counter; // create a counter

    private String current = ""; // create a string to hold current

    /**
     * creates a new iterator object
     * @param prefix a string containing the sought-after commonPrefix
     * @param trie the trie we want to look at
     */
    public Trieiterator(String prefix, Trie trie) {

        this.trie = trie; // this trie is the trie we provided
        this.prefix = prefix; // the commonPrefix is the commonPrefix we provided

        this.topNode = trie.dig(this.prefix); // find the node furthest from the root

        counter = trie.distinct(prefix); // count how many distinct keys there are with values in the subtree
    }

    /**
     * @return true or false depending on if there is a next
     */
    public boolean hasNext() {

        if (counter > 0) {
            return true;
        } else {
            return false;
        }
    }

    /** if we would happen to make a call to getWord() with a string, this saves our bacon
     */
    public Node getWord(String key) {

        return this.getWord(key.toCharArray());
    }

    /**
     * Get a word
     * @param key
     * @return
     */
    public Node getWord(char[] key) {

        Node node = trie.dig(key); // find the node corresponding to the last part of the key

        if (node == null) { // if no such node return null, oops
            return null;
        }

        // if the node we compare to is larger than the current, or if the node is empty
        if (current.compareTo(node.word()) < 0 && node.getValue() != '\0') {
            return node;
        }

        return nextWord(node.getChildren()); // call nextWord with the arraylist provided from the node by getChildren()
    }

    /**
     *
     * @param arraylist takes in an arraylist containing Nodes
     * @return a node that contains the next word
     */
    private Node nextWord(ArrayList<Node> arraylist) {

        Node returnvalue = null; // create a node for our return node

        for (Node currentnode : arraylist) { // for every node in arraylist do the following

            ArrayList<Node> children = currentnode.getChildren(); // create an arraylist for the children's children

            if (currentnode.getValue() > 0) { // if the value of the current node is set

                if (this.current.compareTo(currentnode.word()) < 0) { // and compare the string current to the node's key
                    return currentnode; // if we get a -1 return the current node
                }
            }
            if (children != null) { // if children is not null, set returnvalue by a recursive call
                returnvalue = nextWord(children);
            }
            if (returnvalue != null) { // if returnvalue has been set to something that isnt null, return it
                return returnvalue;
            }
        }

        return returnvalue; // return the node, now containing the next node, in other words, the next "word"
    }

    /**
     * create a map entry
     * @return the key value pair
     */
    public Entry<String, Integer> next() {

        counter--; // decrement the counter so that hasNext() behaves properly

        Entry<String, Integer> returnentry = null; // create a key value pair
        Node curr = this.getWord(this.prefix); // create a node to work with, set it to be

        current = curr.word(); // set the string current to be the

        if (curr != null) {
            returnentry = new SimpleEntry<String, Integer>( current, curr.getValue() );
        }

        return returnentry; // return the key value pair
    }

    /**
     * We have no reason to remove entries but the interface wants us to have a method for it
     */
    public void remove() {

        throw new UnsupportedOperationException();
    }
}