/******************************************************************************
 *  Compilation:  javac BinarySearch.java
 *  Execution:    java BinarySearch wordlist.txt < input.txt
 *  Data files:   http://www.cs.princeton.edu/introcs/43sort/emails.txt
 *                http://www.cs.princeton.edu/introcs/43sort/whitelist.txt
 *
 *  Read in an alphabetical list of words from the given file.
 *  Then prompt the user to enter words. The program reports which
 *  words are *not* in the wordlist.
 * 
 *  % java BinarySearch whitelist.txt < emails.html
 *  marvin@spam
 *  mallory@spam
 *  eve@airport
 *
 ******************************************************************************/

import java.util.Arrays;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class BinarySearch {

    // return the index of the key in the sorted array a[]; -1 if not found
    public static int search(String key, String[] a) {
        return search(key, a, 0, a.length);
    }
    public static int search(String key, String[] a, int lo, int hi) {

        System.out.println("lo  = " + lo);
        System.out.println("hi  = " + hi);

        // possible key indices in [lo, hi)
        if (hi <= lo) return -1; // if hi is smaller than or equal to lo return -1, oops the key wasnt in the array
        int mid = lo + (hi - lo) / 2; // mid is equal to lo + (hi-lo)/2, choose what to guess at
        int cmp = a[mid].compareTo(key); // compare mid to the searched value
        if      (cmp > 0) return search(key, a, lo, mid); // if the comparison returns > 0 search for key in the lower part of the current span of array a
        else if (cmp < 0) return search(key, a, mid+1, hi); // if the comparison returns 0 < search for key in the upper part of the current span of array a
        else              return mid; // whe guessed correctly on the first try? wow
    }


    // whitelist, exception filter
    public static void main(String[] args) {

        In in = new In(args[0]);
        String s = in.readAll();
        String[] words = s.split("\\s+");
        System.err.println("Done reading words");

        // sort the words (if needed)
        Arrays.sort(words); // built-in magical sorting method
        System.err.println("Done sorting words");

        // prompt user to enter a word and check if it's there
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString(); // take in a key, its whatever is input into StdIn
            if (search(key, words) < 0) { // if search returns < 0 key didnt exist in the file
                StdOut.println(key + " fanns INTE i largeW.txt");
            } else { // if search returns any other value the key exists in the file
                StdOut.println(key + " fanns i largeW.txt");
            }
        }
    }
}

