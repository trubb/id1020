
import se.kth.id1020.util.Word;

import java.util.ArrayList;

class Index {

    ArrayList<Node> wordnodes = new ArrayList<>();

    public void insert(Node node) {

        // call to search

        this.binarysearch(wordnodes, node);

        // if word exists, add attributes to list

        // if word is new insert at correct pos
        this.wordnodes.add(index, node);
    }

    private int binarysearch(ArrayList<Node> arrl, Node node) {

        int low = 0;
        int high = arrl.size();
        Word word = node.getWord();

        return binarysearch(word, arrl, low, high);
    }

    public int binarysearch(Word word, ArrayList<Node> arrl, int low, int high) {

        if (high <= low) {
            return -1;
        }

        int mid = low + (high - low) / 2; // find middle element
        int cmp = arrl.get(mid).compareTo(word); // compare mid to sought after key

        if (cmp > 0) {
            return binarysearch(word, arrl, low, mid);
        }
        else if (cmp < 0) {
            return binarysearch(word, arrl, mid+1, high);
        }
        else {
            return mid;
        }
    }

}
