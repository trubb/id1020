import se.kth.id1020.Driver;
import se.kth.id1020.TinySearchEngineBase;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;
import se.kth.id1020.util.Attributes;

import java.util.List;

public class TinySearchEngine implements TinySearchEngineBase {

    public static void main(String[] args) throws Exception {
        TinySearchEngineBase searchEngine = new TinySearchEngine();
        Driver.run(searchEngine);
    }


    // build index
    public void insert(Word word, Attributes attr) {

        Index index = new Index();

        Node node = new Node(word, attr);

        index.insert(node);

    }

    // searching
    @Override
    public List<Document> search(String query) {

        query.toLowerCase().trim();
        String[] words = query.split("(\\. )|:|,|;|!|\\?|( - )|--|(\' )| ");

        return null;
    }


}
