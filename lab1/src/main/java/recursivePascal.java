import edu.princeton.cs.introcs.StdOut;

/**
 * Erik Pettersson, erpette@kth.se
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
     * This should lead to a worst-case complexity of O(N^2) since for bigger N a larger number of values
     * need to be calculated.
     *
     * Average should(?) land somewhere around Θ(N) since for any element that is on the edge of the triangle
     * we can just check if it is on the edge ({n, 0} or {n, k == n}) and if they are on position {n, 1} or {n, k-1}
     * the value to return will be equal to n
     */
    public int binom(int n, int k) {

        if (k == n) {
            binom_store[n][k] = 1; // k == n is the element farthest to the right, it is always 1
            return 1;
        } else if (k == 1 || k == n-1 ) {
            binom_store[n][k] = n;
            return n;
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
     * count row by calling printPascal recursively
     * one loop inside of printPascal for generating column number
     */
    public void printPascal(int n) {

        // when we hit n = 0 we back up from 0 through n, printing as we go
        if (n < 0) {
            return;
        }
        // if direction = true, print small to large
        if (direction) {
            printPascal( n - 1);
        }

        for (int i = 0; i <= n ; i++) {
            if (i <= n/2) { // if i is in left half of triangle, calculate it and print
                StdOut.print(binom(n, i) + " ");
            } else {
                StdOut.print(binom_store[n][n-i] + " "); // else print a value that is already within the array
            }
        }
        StdOut.println();

        // if direction = false, print from large to small
        if (!direction) {
            printPascal(n - 1);
        }
    }
}
