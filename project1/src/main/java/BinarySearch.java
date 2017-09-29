import se.kth.id1020.TinySearchEngineBase;

import java.util.ArrayList;

public class BinarySearch extends TinySearchEngine {

    public static int insertionSearch(ArrayList<Node> arrl, Node node) {

        return insertionsearch(node.getWordContent(), arrl, 0, arrl.size());
    }

    public static int insertionsearch(String key, ArrayList<Node> arrl, int low, int high) {

        if (high <= low) { // If high and low converges, return high as we want to put the new node at the end of the arraylists
            return high;
        }

        int mid = low + (high - low) / 2; // generate a middle element to compare to

        int cmp = arrl.get(mid).getWordContent().compareToIgnoreCase(key); // compare the content of mid to the key we search for

        if (cmp > 0) { // if the comparison returns 1 we will keep looking in the lower bound of the array
            return insertionsearch(key, arrl, low, mid);
        }
        else if (cmp < 0) { // if the comparison returns -1 we will keep looking in the upper bound of the array
            return insertionsearch(key, arrl, mid+1, high);
        }
        else {
            f.f = true; 
            return mid;
        }
    }

    public static int binarysearch(ArrayList<Node> arrl, String key) {

        return binarysearch(key, arrl, 0, arrl.size());
    }

    public static int binarysearch(String key, ArrayList<Node> arrl, int low, int high) {

        if (high <= low) {
            return -1;
        }

        int mid = low + (high - low) / 2; // find middle element

        int cmp = arrl.get(mid).getWordContent().compareToIgnoreCase(key); // compare mid to sought after key

        if (cmp > 0) {
            return binarysearch(key, arrl, low, mid);
        }
        else if (cmp < 0) {
            return binarysearch(key, arrl, mid+1, high);
        }
        else {
            return mid;
        }
    }

}
