import edu.princeton.cs.introcs.In;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map.Entry;


public class Driver {

    public static void main(String[] args) {

        Trie drivertrie = new Trie();
        URL url = ClassLoader.getSystemResource("./kap1.txt");
        if (url != null) {
            System.out.println("Läser in från: " + url);
        } else {
            System.out.println("Kunde inte hitta fil vid: ./kap1.txt");
        }

        In input = new In(url);

        while (!input.isEmpty()) {
            // set all input to be lowercase in order to not miss any occurences
            String line = input.readLine().toLowerCase().trim(); // remove .toLowerCase() to revert to case sensitive

            String[] words = line.split("(\\. )|:|,|;|!|\\?|( - )|--|(\' )| ");

            String lastOfLine = words[words.length - 1];

            if (lastOfLine.endsWith(".")) {
                words[words.length - 1] = lastOfLine.substring(0, lastOfLine.length() - 1);
            }

            for (String word : words) {
                String word2 = word.replaceAll("\"|\\(|\\)", "");

                if (word2.isEmpty()) {
                    continue;
                }

                //System.out.println(word2);
                drivertrie.put(word2); // put word2 into drivertrie
            }
        }

        System.out.println("");

        commonFirstLetter(drivertrie);
        prefix(drivertrie);

        System.out.println("");

        System.out.println("De tio ord som förekommer oftast (ej inbördes sorterade):");
        for (String s : mostCommonWords(drivertrie)) {
            System.out.println(s);
        }

        System.out.println("");

        System.out.println("De tio ord som förekommer mest sällan (ej inbördes sorterade):");
        for (String s : leastCommonWords(drivertrie)) {
            System.out.println(s);
        }

    }

    public static String[] mostCommonWords(Trie commontrie) {

        final int nth = 10; // we are interested in the 10 most common words

        String[] rv = new String[nth];
        int[] vals = new int[nth];

        IterateTrie it = commontrie.iterator("");
        Entry<String, Integer> kv = null;

        while (it.hasNext()) {

            kv = it.next();
            int currVal = kv.getValue();
            for (int i = 0; i < nth; i++) {
                if (vals[i] == 0 || currVal > vals[i])
                {
                    rv[i] = kv.getKey();
                    vals[i] = currVal;
                    break;
                }
            }
        }

        return rv;
    }

    public static String[] leastCommonWords(Trie seldomtrie) {

        final int nth = 10; // we are interested in the 10 least common words

        String[] rv = new String[nth];
        int[] vals = new int[nth];

        IterateTrie it = seldomtrie.iterator("");
        Entry<String, Integer> kv = null;

        while (it.hasNext()) {
            kv = it.next();
            int currVal = kv.getValue();
            for (int i = 0; i < nth; i++)
            {
                if (vals[i] == 0 || currVal < vals[i])
                {
                    rv[i] = kv.getKey();
                    vals[i] = currVal;
                    break;
                }
            }
        }

        return rv;
    }

    public static void commonFirstLetter(Trie oftentrie) {

        String mostProminentLetter = "";
        int mostProminentLetterCount = 0;

        for (Node child : oftentrie.getRoot().getChildren()) {
            if (oftentrie.distinct(String.valueOf(child.getContent())) > mostProminentLetterCount) {
                mostProminentLetter = String.valueOf(child.getContent());
                mostProminentLetterCount = oftentrie.distinct(String.valueOf(child.getContent()));
            }
        }

        System.out.println("Den oftast förekommande första bokstaven är " + mostProminentLetter + " med " + String.valueOf(mostProminentLetterCount) + " förekomster av ord som börjar med den bokstaven.");
    }

    public static void prefix(Trie prefixtrie) {

        String prefixOfTwo = "";
        int highestFrequency = 0;

        for (Node fst : prefixtrie.getRoot().getChildren()) {
            ArrayList<Node> gc = fst.getChildren();

            if (gc == null)
                continue;

            for (Node snd : gc) {
                char[] prefix = {fst.getContent(), snd.getContent()};
                int tmp = prefixtrie.count(prefix);

                if (tmp > highestFrequency)
                {
                    prefixOfTwo = String.valueOf(prefix);
                    highestFrequency = tmp;
                }
            }
        }

        System.out.println("Det vanligast förekommande prefixet (2 tecken) i ord är " + prefixOfTwo + " med " + String.valueOf(highestFrequency) + " förekomster");
    }

}
