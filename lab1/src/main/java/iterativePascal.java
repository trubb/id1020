import edu.princeton.cs.introcs.StdOut;

public class iterativePascal extends ErrorPascal implements Pascal {

    int[][] iterationarray; // for storing values in

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

        // count rows in array to print
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                StdOut.print(binom(i,j));
            }
            StdOut.println();
        }
    }

}
