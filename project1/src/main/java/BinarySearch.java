import java.util.ArrayList;

public class BinarySearch extends TinySearchEngine { // extends due to a really weird issue with flag.flag

    /**
     * Helper method for calling the binary search for insertions
     * @param arrl an arraylist where we want to insert new nodes
     * @param node a node that we are looking to insert into the arraylist
     * @return an index where we can (hopefully) safely insert our new node
     */
    public static int insertionSearch(ArrayList<Node> arrl, Node node) {

        return insertionsearch(node.getWordContent(), arrl, 0, arrl.size());
    }

    /**
     * A binary search for finding the correct position in the provided arraylist to insert a given node
     * @param key the string content of a Word that we are looking to insert into the arraylist
     * @param arrl an array list that we want to insert the node into
     * @param low lower bound of the search, starting at 0
     * @param high upper bound of the search, starting at arrl.size()
     * @return an index where we should insert the new node into the arraylist
     */
    public static int insertionsearch(String key, ArrayList<Node> arrl, int low, int high) {

        if (high <= low) { // If high and low converges, return high as we want to put the new node at the end of the arraylists
            return high; // We obviously didnt find what we were looking for.
        }

        int mid = low + (high - low) / 2; // generate a middle element to compare to

        int cmp = arrl.get(mid).getWordContent().compareToIgnoreCase(key); // compare the content of mid to the key we search for

        if (cmp > 0) { // if the comparison returns 1 we will keep looking in the lower bound of the array
            return insertionsearch(key, arrl, low, mid);
        }
        else if (cmp < 0) { // if the comparison returns -1 we will keep looking in the upper bound of the array
            return insertionsearch(key, arrl, mid+1, high);
        }
        else { // if the word already exists within the index, we only want to add the new attributes to the word
            f.flag = true; // therefore we set the flag to true and return the index of the node we want to update the attributes of
            return mid;
        }
    }

    /**
     * Helper method for calling the binary search for searching
     * @param arrl an arraylist containing our index that we want to search through
     * @param key the string that we are looking for
     * @return an index where we find what we are looking for
     */
    public static int binarysearch(ArrayList<Node> arrl, String key) {

        return binarysearch(key, arrl, 0, arrl.size());
    }

    /**
     * A binary search for finding indices that match the sought after string
     * @param key the string that we are looking for among the documents
     * @param arrl the index arraylist
     * @param low the lower bound of the search, starting at 0
     * @param high the upper bound of the search, starting at arrl.size()
     * @return an index where we can find something that we looked for
     */
    public static int binarysearch(String key, ArrayList<Node> arrl, int low, int high) {

        if (high <= low) { // If high and low converges we didn't find what we were looking for
            return -1;
        }

        int mid = low + (high - low) / 2; // generate a middle element

        int cmp = arrl.get(mid).getWordContent().compareToIgnoreCase(key); // compare the content of mid to the key we search for

        if (cmp > 0) { // if the comparison returns 1 we will keep looking in the lower bound of the array
            return binarysearch(key, arrl, low, mid);
        }
        else if (cmp < 0) { // if the comparison returns -1 we will keep looking in the upper bound of the array
            return binarysearch(key, arrl, mid+1, high);
        }
        else { // if cmp == 0 then we have found a node that matches what we were looking for, return it's index
            return mid;
        }
    }

}
