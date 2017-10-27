import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;
import java.util.ArrayList;

class Node implements Comparable<Node> {

    public Word word; // every index entry contains exactly one word
    public ArrayList<Attributes> attributes = new ArrayList<>(); // every index entry contains a list of attributes associated with the word

    /**
     * When creating a new node:
     * @param word a word object that the node should contain
     * @param attr the associated attributes passed when initializing the object
     */
    public Node(Word word, Attributes attr) {

        this.word = word;
        this.attributes.add(attr);
    }

    /**
     * Getter for the word contained within the node
     * @return the Word that a node holds
     */
    public Word getWord() {

        return this.word;
    }

    /**
     * Getter for the actual string content of the word contained within a node
     * @return the string contained in the node
     */
    public String getWordContent() {

        return this.word.word;
    }

    /**
     * Getter for the list of attributes contained in a node
     * @return the list of attributes
     */
    public ArrayList<Attributes> getAttributes() {

        return this.attributes;
    }

    /**
     * Method for adding attributes to the end of the arraylist of attributes
     * @param attr attribute to be added to the end of the list
     */
    public void addAttribute(Attributes attr) {

        this.attributes.add(attr);
    }

    /**
     * Method for getting a document from the list of attributes
     * @param i position in the arraylist of an attribute
     * @return the document of the specified attribute
     */
    public Document getDocument(int i) {

        return this.attributes.get(i).document;
    }

    /**
     * A method for comparing the string content of the words of two nodes to each other
     * @param node a node that we want to compare
     * @return 1, 0, or -1 based on which string is deemed "better", "bigger", "cooler" etc.
     */
    public int compareTo(Node node) {

        return this.word.word.compareTo(node.word.word);
    }

}
