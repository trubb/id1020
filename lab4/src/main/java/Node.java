import java.util.ArrayList;
import java.util.Collections;
import java.lang.StringBuilder;

class Node implements Comparable<Node> {

    private ArrayList<Node> children = new ArrayList(); // create an arraylist containing nodes
    private Node parent; // every node has a parent (or most of them at least)
    private Character letter = null; // the char we want to store within the node
    private Integer value = 0; // the associated value

    /**
     * Sets the character of a node
     * @param letter a character to be stored in the node
     */
    public Node(char letter) {

        this.letter = letter;
    }

    /**
     * If a node has any children in the arraylist children then we can retrieve them like this
     * @return the arraylist containing children
     */
    public ArrayList<Node> getChildren() {

        if (this.children.size() > 0) { // if the size of the arraylist of children has any letter
            return this.children; // return them
        } else {
            return null; // empty list, there are no children for the node
        }
    }

    /**
     * Find a child which contains a specific letter
     * @param letter
     * @return
     */
    public Node getChild(char letter) {

        int find = this.search(letter); // call search with our sought after letter
        if (find != -1) { // as long as we get a proper answer (the letter is found)
            return this.children.get(find); // if successful find will contain the index of the sought after letter
        } else {
            return null; // if we got a -1 (letter not found), we return null: that we didnt find it among the children
        }
    }

    /**
     * A method for checking if there are any children of a node
     * @param letter the value in a node we want to check if it has children
     * @return true/false depending on if there are any
     */
    public boolean hasChild(char letter) {

        if (this.getChild(letter) != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A method for adding a child to the node
     * @param letter the character that we want to store in the node
     */
    public void addChild(char letter) {

        if (this.hasChild(letter)) {
            return;
        }
        Node n = new Node(letter); // create a new node containing a character
        n.setParent(this); // set it's parent to the current node
        this.children.add(n); // append the child to the arraylist
        Collections.sort(children); // sort the list into ascending order
    }
/*
    public void removeChild(char e) {

        int i = this.search(e);

        if (i != -1) {
            this.children.remove(i);
        }
    }
*/

    /**
     * A method for retrieving the parent of a node
     * @return the node's parent
     */
    public Node getParent() {

        return this.parent;
    }

    /**
     * A method for setting the parent of a node
     * @param parent the node that should be made a parent
     */
    public void setParent(Node parent) {

        this.parent = parent;
    }

    /**
     * A method for retrieving the associated value stored in a node
     * @return the value
     */
    public int getValue() {

        return this.value;
    }

    /**
     * A method for setting (changing) the value stored in a node
     * @param newvalue the value that we want to update to
     */
    public void setValue(int newvalue) {

        this.value = newvalue;
    }

    /**
     * Set the associated value to an appropriate value by incrementing every time the method is called
     */
    public void increment() {

        if (this.value == null) {
            this.value = 1;
        } else {
            this.value += 1;
        }
    }

    /**
     * A method for retrieving the character stored within the node
     * @return the character we put in the node beforehand
     */
    public Character getLetter() {

        return this.letter;
    }

    /**
     * Compares a given character with the letter of this node
     * @param comparechar the character we want to compare to the letter of the node
     * @return the result of the comparison
     */
    public int compareTo(Character comparechar) {

        return Character.compare(this.getLetter(), comparechar);
    }

    /**
     * Compares the letter of two nodes
     * @param compareme a node that we want to grab the letter from in order to compare it
     * @return the result of the comparison
     */
    public int compareTo(Node compareme) {

        return Character.compare(this.getLetter(), compareme.getLetter());
    }

    /**
     * A method for building words out of nodes
     * @return a hopefully well-formed string!
     */
    public String word() {

        Node node = this; // create a node that we can work with within the method
        StringBuilder sb = new StringBuilder(); // create a stringbuilder

        sb.insert(0, this.getLetter()); // at position 0, put the character stored in the current node

        node = node.getParent(); // step towards the root by setting node to the parent of the node *this*

        if (node != null) { // if there is a parent (oopsie if there isnt, how did we get here?)
            while (node.getLetter() != '\0') { // And as long as there is something in the node (the root has nothing stored in it, bingo!
                sb.insert(0, node.getLetter()); // insert the letter (character stored here) of the node at the front of the string
                node = node.getParent(); // builds the string by stepping towards the root (d -> ad -> bad)
            }
        }

        return sb.toString(); // return the string we just created
    }

    /**
     * A preface to calling search(), far easier for us since we don't
     * need to pass key, lo, hi to search() by "hand"
     * @param key
     * @return
     */
    private int search(Character key) {

        return search(key, 0, this.children.size());
    }

    /**
     * A method for finding the child with a sought after key by binary search!
     * @param key the key we are looking for
     * @param lo 0, the lower bound of the search
     * @param hi the length of the arraylist
     * @return the sought after key
     */
    private int search(Character key, int lo, int hi) {

        while (true) {

            if (hi <= lo) { // if the upper and lower bounds converge, oops, cant find that key
                return -1;
            }

            int mid = lo + (hi - lo)/2;

            int cmp = this.children.get(mid).compareTo(key); // compare the child matching mid to key

            if (cmp > 0) { // if the comparison yields a result >0, set hi to mid and continue looking
                hi = mid; // in the lower half of the previous search area
            } else if (cmp < 0) { // if the comparison yields a result <0 set low to and continue looking
                lo = mid + 1; // in the upper half of the previous search area
            } else {
                return mid;
            }
        }
    }
}