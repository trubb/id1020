import edu.princeton.cs.introcs.StdOut;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();

        String teststring = "noisiest authorities insisted on its being received ";
        teststring += "It was the year of Our Lord one thousand seven hundred and seventy-five ";
        teststring += "France, less favoured on the whole as to matters spiritual than her ";
        teststring += "marked by the Woodman, Fate, to come down ";
        teststring += "deliver on Turnham Green, by one highwayman ";
        teststring += "In the midst of them, the hangman, ever busy and ever worse than useless ";

        String[] stringarray = teststring.split("\\s+");

        for (String word : stringarray) { // for each short format, for every entry in stringarray put into trie
            trie.put(word);
        }

        String testWord = "t";

        StdOut.println();

        StdOut.println("Det finns " + String.valueOf(trie.distinct(testWord)) +
                " distinkta ord som börjar med: " + testWord);

        StdOut.println("Det finns " + String.valueOf(trie.count(testWord)) +
                " ord i texten som börjar med: " + testWord);

        Trieiterator it = trie.iterator(testWord);
        Entry<String, Integer> kv = null;

        while (it.hasNext()) {
            kv = it.next();
            StdOut.println(kv.getKey() + ": " + String.valueOf(kv.getValue()));
        }
    }

}