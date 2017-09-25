import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;
import java.util.Iterator;
import java.util.ArrayList;
import java.lang.UnsupportedOperationException;

class IterateTrie implements Iterator<Entry<String, Integer>> {

    private Trie trie; // create a new trie
    private String prefix; // create a string to hold our prefix
    private Node topNode; // create a top node
    private int counter; // create a counter

    private String current = ""; // 

    public IterateTrie(String prefix, Trie trie) {

        this.trie = trie;
        this.prefix = prefix;

        this.topNode = trie.dig(this.prefix);

        counter = trie.distinct(prefix);
    }

    public boolean hasNext() {

        if (counter > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Node getWord(String key) {
        return this.getWord(key.toCharArray());
    }

    public Node getWord(char[] key) {

        Node node = trie.dig(key);

        if (node == null) {
            return null;
        }

        if (current.compareTo(node.word()) < 0 && node.getValue() != '\0') {
            return node;
        }

        return nextWord(node.getChildren());
    }

    private Node nextWord(ArrayList<Node> al) {
        Node rv = null;

        for (Node c : al) {
            ArrayList<Node> children = c.getChildren();

            if (c.getValue() > 0) {
                if (current.compareTo(c.word()) < 0) {
                    return c;
                }
            }
            if (children != null) {
                rv = nextWord(children);
            }
            if (rv != null) {
                return rv;
            }
        }

        return rv;
    }

    public Entry<String, Integer> next() {

        counter--;

        //ArrayList<Node> children = topNode.getChildren();
        Entry<String, Integer> rv = null;
        Node c = this.getWord(this.prefix);

        current = c.word();

        if (c != null) {
            rv = new SimpleEntry<String, Integer>( current, c.getValue() );
        }

        return rv;
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}