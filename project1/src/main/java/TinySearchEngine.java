import se.kth.id1020.Driver;
import se.kth.id1020.TinySearchEngineBase;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;
import se.kth.id1020.util.Attributes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TinySearchEngine implements TinySearchEngineBase {

    private ArrayList<Node> index = new ArrayList<>(); // create a new arraylist to contain the index
    static Flag f = new Flag(false); // a flag for knowing when to add a new node and when to simply update attributes

    /**
     * Main calls Driver.run to start reading the documents and generate an index by repeatedly calling insert()
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        TinySearchEngineBase searchEngine = new TinySearchEngine();
        Driver.run(searchEngine);
    }

    /**
     * Insert creates and inserts new nodes into the index
     * @param word a Word object that we want to add into a node
     * @param attr the Attributes object that we get passed that should be associated with the Word
     */
    public void insert(Word word, Attributes attr) {

        Node node = new Node(word, attr); // create a new node, insert word and attr into it

        if (index.isEmpty()) { // if the index is empty, simply add the node straight into the index
            index.add(node); // arraylist.add() adds a new element to the end of the list
            return;
        }

        // If there are nodes in the index, figure out where we should insert the new node by using binary search
        int i = BinarySearch.insertionSearch(index, node);

//        System.out.println("i before if : " + i); // debug message

        if (f.flag) { // if the flag is set to true we have a preexisting node with the same key, we only want to update attr

            index.get(i).addAttribute(attr); // at the provided index, call addAttribute() and update the attributes of that node
            f.flag = false; // and set the flag to false again

//            System.out.println("index[i]: " + index.get(i).getWordContent()); // debug message

        } else {
            // .add(int i,E element) is safe to do since it splits the list, inserts
            // the new element, and then reattaches the right part of the list to the left
            index.add(i, new Node(word, attr));
        }

    }

    /**
     * search uses binary search to find a node matching the sought after key
     * It then generates a list of documents that are related to the query
     * and returns them
     * @param query a word that we want to search for
     * @return a list of documents that are related to the sought after word
     */
    @Override
    public List<Document> search(String query) {

        String[] qarr = query.split(" "); // split the query on space and put it into a string array

        HashSet<Document> documentHashSet = new HashSet<>(); // hashset to put the received documents into temporarily
        ArrayList<Document> documents = new ArrayList<>(); // arraylist to return the documents

        for (int i = 0; i < qarr.length; i++) {

            int sresult = BinarySearch.binarysearch(index, qarr[i]); // find the sought after word in the index

            // if we get a -1 returned from the binary search we have a search miss and therefore can't do much but
            if (sresult == -1 ) {
                System.out.println("\"" + query + "\" was not found within the index.\nPlease try again");
                return null;
            } else {

//                System.out.println("i: "+ i + " sizeof index " + index.size()); // debug message

                // for all the attributes associated with the word, add all documents of that attribute to a list
                // when done return the list of documents
                for (int j = 0; j < index.get(sresult).attributes.size(); j++) { //

                    // put the list of documents into the hashset thereby ensuring all duplicates are removed
                    documentHashSet.add(index.get(sresult).getDocument(j));
                }
            }
        }

        documents.addAll(documentHashSet); // insert the hashset into the arraylist, no duplicates since we had a hashset first
        return documents; // and then return the set of documents
    }

}
