import edu.princeton.cs.introcs.StdOut;

/**
 Erik Pettersson, erpette@kth.se
 **/

public class recursivePascal extends ErrorPascal implements Pascal {

    // print direction boolean
    public boolean direction = true;
    // binom storage array
    public int[][] binom_store;

    /**
     * calculate (n,k) by using (n,k) == (n-1, k-1) + (n-1, k) improved to store the
     * calculated values this time around in order to avoid redoing calculations.
     *
     * This should lead to a complexity of O(N) for this one-off calculating of all values for n
     */
    public int binom(int n, int k) {

        if (k == n) {
            binom_store[n][k] = 1; // k == n is the element farthest to the right, it is always 1
            return 1;
        } else if (k == 0) {
            binom_store[n][0] = 1; // element farthest to the left, it is always 1
            return 1;
        } else if (binom_store[n][k] == 0) { // if the array element at [n][k] is not set we set it to be the calculated value
            return binom_store[n][k] = binom(n -1, k - 1) + binom(n - 1, k);
        } else {
            return binom_store[n][k]; // if the value has been set, return the value of [n][k]
        }
    }

    /**
     * count row by calling fasterPrintPascal recursively
     * one loop inside of fasterPrintPascal for generating column number
     * effectively linear complexity as it simply prints what is calculated by binom(), i.e. print each element once.
    */
    public void printPascal(int n) {

        if (n < 0) {
            return;
        }
        // if direction = true, print small to large
        if (direction) {
            printPascal( n - 1);
        }
        for (int i = 0; i <= n ; i++) {
            StdOut.print(binom(n, i) + " ");
        }
        StdOut.println();

        // if direction = false, print from large to small
        if (!direction) {
            printPascal(n - 1);
        }
    }
}
