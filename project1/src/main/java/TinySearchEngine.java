import se.kth.id1020.Driver;
import se.kth.id1020.TinySearchEngineBase;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;
import se.kth.id1020.util.Attributes;

import java.util.ArrayList;
import java.util.List;


/**
 * n/a
 */
public class TinySearchEngine implements TinySearchEngineBase {

    private ArrayList<Node> wordnodes = new ArrayList<>(); // create a new arraylist to contain the index
    static Flag f = new Flag(false); // a flag for

    /**
     * Main calls Driver.run();
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        TinySearchEngineBase searchEngine = new TinySearchEngine();
        Driver.run(searchEngine);
    }


    // build index
    public void insert(Word word, Attributes attr) {

        Node node = new Node(word, attr);

        if (wordnodes.isEmpty()) {
            wordnodes.add(node);
            return;
        }

        int i = BinarySearch.insertionSearch(wordnodes, node);

    //    System.out.println("i before if : " + i); // debug


        if (f.f) {
            wordnodes.get(i).addAttribute(attr);
    //        System.out.println("wordnodes[i]: " + wordnodes.get(i).getWordContent()); // debug
            f.f = false;
        } else {
            wordnodes.add(i, new Node(word, attr));
        }

    }

    // searching
    @Override
    public List<Document> search(String query) {

        //query.toLowerCase().trim();
        int i = BinarySearch.binarysearch(wordnodes, query);
        while (true) {
            ArrayList<Document> documents = new ArrayList<>();
            System.out.println("i: "+ i + " sizeof wordnodes " + wordnodes.size());
            for (int j = 0; j < wordnodes.get(i).attributes.size(); j++) {
                documents.add(wordnodes.get(i).getDocument(j));
            }
            return documents;
        }
    }

}
