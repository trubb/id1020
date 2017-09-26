import java.util.ArrayList;

public class Trie {

    private Node root = new Node('\0'); // \0 since we need to feed the char something

    /**
     * @return the root
     */
    public Node getRoot() {

        return this.root;
    }


    /**
     * If we would happen to make a call to put(char[]) with a string, this saves our bacon
     */
    public void put(String key) {

        this.put(key.toCharArray()); // changes the key into a char array (splits the key)
    }

    /**
     * insert a key into the trie
     * @param key the key that is to be inserted
     */
    public void put(char[] key) {

        Node current = this.root;

        // for every character in key do the following
        for (char c : key) {

            current.addChild(c); // add a child to the current
            current = current.getChild(c); // change current to be it's child so we can add a child to the child
        }

        current.increment(); // increment the associated value for every time we insert a letter
    }

    /**
     * if we would happen to make a call to get(char[]) with a string, this saves our bacon
     */
    public int get(String key) {

        return this.get(key.toCharArray());
    }

    /**
     * A method for returning the associated value of a key
     * @param key a chararray containing the key we are looking for
     * @return returns the associated value for key, or 0 if no value
     */
    public int get(char[] key) {

        Node current = dig(key); // retrieve the node

        if (current == null) { // if it doesn't have  a value return 0
            return 0;
        } else {
            return current.getValue(); // return the value of the node
        }
    }

    /**
     * Calls Trieiterator.java and thereby creates a new
     * iterator for the sought after purpose
     * @param prefix
     * @return the created iterator
     */
    public Trieiterator iterator(String prefix) {

        return new Trieiterator(prefix, this);
    }


    /** if we would happen to make a call to distinct() with a string, this saves our bacon
     */
    public int distinct(String k) {

        return this.distinct(k.toCharArray());
    }

    /**
     * Distinct returns the number of distinct keys that have values in the sub-tree
     * that starts at key
     * @param key the start key
     * @return the number of keys
     */
    public int distinct(char[] key) {

        Node current = dig(key); // retrieve the node
        int distinct = 0;

        if (current == null) { // if there is no such node return 0
            return 0;
        }

        if (current.getValue() > 0) { // if the returned value is above zero, add 1 to distinct
            distinct += 1;
        }

        ArrayList<Node> children = current.getChildren(); // create an arraylist for the children

        // add the number of children to the counter
        if (children != null) {
            distinct += num_of_children(children);
        }

        return distinct;
    }


    /** if we would happen to make a call to count() with a string, this saves our bacon
     */
    public int count(String key) {

        return this.count(key.toCharArray());
    }

    /**
     * Returns the sum of all associated values of the subtree from key and down
     * @param key the start key
     * @return the sum of values
     */
    public int count(char[] key) {

        Node current = dig(key);

        if (current == null) { // if there is no such node return 0
            return 0;
        }

        int count = 0;

        count += current.getValue(); // put current value to counter

        ArrayList<Node> children = current.getChildren(); // create an arraylist for the children

        if (children != null) { // if there are children, add to count
            count += children_count(children);
        }

        return count;
    }

    /** if we would happen to make a call to dig() with a string, this saves our bacon
     */
    public Node dig(String key) {

        return this.dig(key.toCharArray());
    }

    /**
     * Digs down in the trie to find the node that corresponds to the last character in the key
     * @param key the sought after key
     * @return return a node
     */
    public Node dig(char[] key) {

        Node current = this.root;

        for (char c : key) { // for every char in key do the following

            current = current.getChild(c); // set current to be the child of the original current (1 step down)

            if (current == null) {
                return null; // if there is no child (if getChild sets current to null) return null
            }
        }

        return current; // when we've come to the end of the key, return the current node
    }

    /**
     * A method for counting the sum of the children's value
     * @param arraylist a bunch of nodes
     * @return the sum of their values
     */
    private int children_count(ArrayList<Node> arraylist) {

        int count = 0;

        for (Node current : arraylist) { // for every entry do:

            ArrayList<Node> children = current.getChildren(); // create an arraylist for the children

            count += current.getValue(); // add the value of current to counter

            if (children != null) { // if there are children, recursion!
                count += children_count(children);
            }
        }

        return count;
    }

    /**
     * A method for counting how many children there are
     * @param arraylist a bunch of nodes
     * @return the number of children
     */
    private int num_of_children(ArrayList<Node> arraylist) {

        int count = 0;

        for (Node current : arraylist) { // for every entry do:

            ArrayList<Node> children = current.getChildren(); // create an arraylist for the children

            if (current.getValue() > 0) { // if current has a value > 0, add 1 to the counter
                count += 1;
            }

            if (children != null) { // if there are children, recursion!
                count += num_of_children(children);
            }
        }

        return count;
    }

}
