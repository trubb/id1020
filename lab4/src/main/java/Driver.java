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

        /**
         * read all that arrives at input and do some regexp magic on it among other stuff
         */
        while (!input.isEmpty()) {
            // set all input to be lowercase in order to not miss any occurences
            String line = input.readLine().toLowerCase().trim(); // remove .toLowerCase() to revert to case sensitive

            String[] words = line.split("(\\. )|:|,|;|!|\\?|( - )|--|(\' )| "); // magic regular expression, splits words into words on these characters

            for (String word : words) {
                String word2 = word.replaceAll("\"|\\(|\\)", ""); // more magic, removes some other characters

                if (word2.isEmpty()) {
                    continue;
                }

                System.out.println(word2); // puke out the words we put into the trie
                drivertrie.put(word2); // put word2 into drivertrie
            }
        }

        System.out.println("Distinct: ");
        System.out.println(drivertrie.distinct("x"));

        System.out.println(""); // give the printing below some headroom

        commonFirstLetter(drivertrie); // figure out what first letters are most common
        commonPrefix(drivertrie); // figure out what prefix is most common

        System.out.println(""); // give us more headroom

        System.out.println("De tio ord som förekommer oftast (ej inbördes sorterade):");

        for (String string : mostCommonWords(drivertrie)) { // print every entry in the stringarray
            System.out.print(string + ", ");
        }
        System.out.println("");
        for (int i : mostCommonWordsCount(drivertrie)) {
            System.out.print(i + ", ");
        }

        System.out.println("\n"); // still headbutting that roof, need more space

        System.out.println("De tio ord som förekommer mest sällan (ej inbördes sorterade):");
        for (String string : leastCommonWords(drivertrie)) { // print every entry in the stringarray
            System.out.print(string + ", ");
        }
        System.out.println("");
        for (int i : leastCommonWordsCount(drivertrie)) {
            System.out.print(i + ", ");
        }

    }


    /**
     * A method for figuring out what words occur least often in the provided text which has been put into a trie
     * @param seldomtrie the trie that we want to take a look at
     * @return the x least common words
     */
    public static String[] leastCommonWords(Trie seldomtrie) {

        final int numberofwords = 10; // we are interested in the 10 least common words

        int[] values = new int[numberofwords]; // create a new int array to hold values
        String[] stringarray = new String[numberofwords]; // create a new string array to hold words

        Trieiterator iterator = seldomtrie.iterator(""); // feed the local iterator with the provided trie's iterator
        Entry<String, Integer> key_values; // create a map entry

        while (iterator.hasNext()) { // as long as the iterator returns that it has a next node:

            key_values = iterator.next(); // set the key value pair to be provided by trieiterator.next()

            int currvalues = key_values.getValue(); // set currvalues to be the value from the key value pair

            for (int i = 0; i < numberofwords; i++) { // for the x least common words do:

                if (values[i] == 0 || currvalues < values[i]) { // if there is no entry in values[i] or if currvalues is smaller than values[i]

                    stringarray[i] = key_values.getKey(); // put the key into the string array
                    values[i] = currvalues; // put the current value into values

                    break; // when done above break so we can take in a new word (disable this and you get a single word 10 times
                }
            }
        }

        return stringarray; // return the array of strings so that we can print from it
    }
    /**
     * Duplicated above method to get a count as well...
     */
    public static int[] leastCommonWordsCount(Trie seldomtrie) {

        final int numberofwords = 10; // we are interested in the 10 least common words

        int[] values = new int[numberofwords]; // create a new int array to hold values
        String[] stringarray = new String[numberofwords]; // create a new string array to hold words

        Trieiterator iterator = seldomtrie.iterator(""); // feed the local iterator with the provided trie's iterator
        Entry<String, Integer> key_values; // create a map entry

        while (iterator.hasNext()) { // as long as the iterator returns that it has a next node:

            key_values = iterator.next(); // set the key value pair to be provided by trieiterator.next()

            int currvalues = key_values.getValue(); // set currvalues to be the value from the key value pair

            for (int i = 0; i < numberofwords; i++) { // for the x least common words do:

                if (values[i] == 0 || currvalues < values[i]) { // if there is no entry in values[i] or if currvalues is smaller than values[i]

                    stringarray[i] = key_values.getKey(); // put the key into the string array
                    values[i] = currvalues; // put the current value into values

                    break; // when done above break so we can take in a new word (disable this and you get a single word 10 times
                }
            }
        }

        return values; // return the array of strings so that we can print from it
    }

    /**
     * A method for figuring out what words occur most often in the provided text
     * @param commontrie the trie that we want to take a look at
     * @return the x most common words
     */
    public static String[] mostCommonWords(Trie commontrie) {

        final int numberofwords = 10; // we are interested in the 10 most common words

        int[] values = new int[numberofwords]; // create a new int array for the key value pair values
        String[] stringarray = new String[numberofwords]; // create a new string array to hold words

        Trieiterator iterator = commontrie.iterator(""); // feed the local iterator with the provided trie
        Entry<String, Integer> key_values; // create a map entry to hold stuff

        while (iterator.hasNext()) { // as long as the iterator returns that it has a next node

            key_values = iterator.next(); // set the key value pair to be provided by the iterator

            int currvalues = key_values.getValue(); // set currvalues to be the value from the key value pair

            for (int i = 0; i < numberofwords; i++) { // for the x most common do

                if (values[i] == 0 || currvalues > values[i]) { // if there is no entry in values[i] or if currvalues is smaller than values[i]

                    stringarray[i] = key_values.getKey(); // put the key into the string array
                    values[i] = currvalues; // put the current value into values

                    break; // break so that we can do another
                }
            }
        }

        return stringarray; // return the string array
    }

    /**
     * Copied above code to return the values #1hourleftsolutions
     */
    public static int[] mostCommonWordsCount(Trie commontrie) {

        final int numberofwords = 10; // we are interested in the 10 most common words

        int[] values = new int[numberofwords]; // create a new int array for the key value pair values
        String[] stringarray = new String[numberofwords]; // create a new string array to hold words

        Trieiterator iterator = commontrie.iterator(""); // feed the local iterator with the provided trie
        Entry<String, Integer> key_values; // create a map entry to hold stuff

        while (iterator.hasNext()) { // as long as the iterator returns that it has a next node

            key_values = iterator.next(); // set the key value pair to be provided by the iterator

            int currvalues = key_values.getValue(); // set currvalues to be the value from the key value pair

            for (int i = 0; i < numberofwords; i++) { // for the x most common do

                if (values[i] == 0 || currvalues > values[i]) { // if there is no entry in values[i] or if currvalues is smaller than values[i]

                    stringarray[i] = key_values.getKey(); // put the key into the string array
                    values[i] = currvalues; // put the current value into values

                    break; // break so that we can do another
                }
            }
        }

        return values; // return the string array
    }

    /**
     * A method for figuring out what two-letter "prefix" is the most common.
     * By checking the occurences of a prefix (a combination of two letters) against other prefixes.
     * By constantly checking if the next checked (temp) prefix/letter combo is more common
     * @param prefixtrie the trie where we want to take a look
     */
    public static void commonPrefix(Trie prefixtrie) {

        int mostfrequent = 0;
        String twoletterprefix = "";

        for (Node firstnode : prefixtrie.getRoot().getChildren()) { // for every child node from root do:

            ArrayList<Node> nodelist = firstnode.getChildren(); // get the children from the first node

            if (nodelist == null) { // if there are no children, keep on rocking
                continue;
            }

            for (Node secondnode : nodelist) { // for every node in nodelist

                char[] prefixletters = {firstnode.getLetter(), secondnode.getLetter()}; // put the letters of the first and second nodes into the char array

                int temp = prefixtrie.count(prefixletters); // count the occurences of the two letters

                if (temp > mostfrequent) { // most frequent starts at 0, but if temp is larger:

                    twoletterprefix = String.valueOf(prefixletters); // set the string twoletterprefix to be the above mentioned prefix
                    mostfrequent = temp; // and update mostfrequent to be the value of temp
                }
            }
        }

        System.out.println("Det vanligast förekommande prefixet (2 tecken) i ord är " + twoletterprefix + " med " + String.valueOf(mostfrequent) + " förekomster");
    }

    /**
     * A method for figuring out which letter is most common
     * @param oftentrie
     */
    public static void commonFirstLetter(Trie oftentrie) {

        int mostProminentLetterCount = 0; // int starting the count from 0
        String mostProminentLetter = ""; // empty string

        for (Node node : oftentrie.getRoot().getChildren()) { // for every node below root do

            if (oftentrie.distinct(String.valueOf(node.getLetter())) > mostProminentLetterCount) { // if the number off occurences from a node is larger than the current mostProminentLetterCount

                mostProminentLetter = String.valueOf(node.getLetter()); // update the most prominent letter to be this new one

                mostProminentLetterCount = oftentrie.distinct(String.valueOf(node.getLetter())); // update the count to be that of the new most common letter
            }
        }

        System.out.println("Den oftast förekommande första bokstaven är " + mostProminentLetter + " med " + String.valueOf(mostProminentLetterCount) + " förekomster.");
    }
}
