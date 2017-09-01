import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 Erik Pettersson, erpette@kth.se
 **/

public class fasterRecursivePascal {

    // print direction boolean
    public boolean direction = true;
    public int[][] binom_store;

    /*
        calculate (n,k) by using (n,k) == (n-1, k-1) + (n-1, k)
        Complexity should be O(N) for this calculation
        As we calculate everything once and keep them
    */
    public int binom(int n, int k) {

        if (n == k) {
            binom_store[n][k] = 1;
            return 1;
        } else if (k == 0) {
            binom_store[n][0] = 1;
            return 1;
        } else if (binom_store[n][k] == 0) {
            return binom_store[n][k] = binom(n -1, k - 1) + binom(n - 1, k);
        } else {
            return binom_store[n][k];
        }
    }

    /*
        count row by calling printPascal recursively
        one loop inside of printPascal for generating column number
        effectively linear complexity as it simply prints what is calculated by binom().
    */
    public void fasterPrintPascal(int n) {

        if (n < 0) {
            return;
        }
        // if direction = true, print small to large
        if (direction) {
            fasterPrintPascal( n - 1);
        }
        for (int i = 0; i <= n ; i++) {
            StdOut.print(binom(n, i) + " ");
        }
        StdOut.println();

        // if direction = false, print from large to small
        if (!direction) {
            fasterPrintPascal(n - 1);
        }
    }

    public static void main(String[] args){

        // make able to use and modify direction properly.
        fasterRecursivePascal recursive = new fasterRecursivePascal();

        //ask how many rows to print
        StdOut.println("How many rows shall be printed");
        while (!StdIn.isEmpty()) {

            int n = StdIn.readInt();

            //ask what direction to print it
            StdOut.println("What direction should we print the triangle in?");
            StdOut.println("true = normal (top down), false = upside down (bottom up)");

            recursive.direction = StdIn.readBoolean();

            recursive.binom_store = new int[n+1][n+1];

            // call printPascal with our n
            recursive.fasterPrintPascal(n);
        }
    }
}
