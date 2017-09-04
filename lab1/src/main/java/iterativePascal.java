import edu.princeton.cs.introcs.StdOut;

/**
 * Erik Pettersson, erpette@kth.se
 *
 * an iterative implementation of a class that prints Pascal's triangle
 **/

public class iterativePascal extends ErrorPascal implements Pascal {

    // print direction boolean
    public boolean direction = true;
    int[][] iterationarray; // an array for storing values in

    public int binom(int n, int k) {

        // count row
        // if n (row) is 0, or if n == k (column) the number to return will be 1 due to position within the triangle
        if (n == k || k == 0) {
            iterationarray[n][k] = 1;
        } else {
            iterationarray[n][k] = iterationarray[n - 1][k - 1] + iterationarray[n - 1][k];
        }
        return iterationarray[n][k];
    }

    public void printPascal(int n) {

        // calculate values for the triangle
        for (int i = 0; i <= n ; i++) {
            for (int j = 0; j <= i ; j++) {
                binom(i, j);
            }
        }

        // print the values for the triangle from the array
        if (direction == true) { // if direction is true print topside up
            // count rows in array to print
            for (int i = 0; i <= n; i++) {
                // count columns in array to print
                for (int j = 0; j <= i; j++) {
                    StdOut.print(iterationarray[i][j] + " ");
                }
                StdOut.println();
            }
        } else if (!direction){ // if direction is false print upside down
            // count rows in array to print
            for (int i = n; i >= 0; i--) {
                // count columns in array to print
                for (int j = i; j >= 0; j--) {
                    StdOut.print(iterationarray[i][j] + " ");
                }
                StdOut.println();
            }
        }
    }

}
