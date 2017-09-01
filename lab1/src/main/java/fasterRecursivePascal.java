import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 Erik Pettersson, erpette@kth.se
 **/

public class fasterRecursivePascal {

    // print direction boolean
    public boolean direction = true;
    // binom storage array
    public int[][] binom_store;

    /*
        calculate (n,k) by using (n,k) == (n-1, k-1) + (n-1, k) improved to store the
        calculated values this time around in order to avoid redoing calculations.

        This should lead to a complexity of O(N) for this one-off calculating of all values for n
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

    /*
        count row by calling fasterPrintPascal recursively
        one loop inside of fasterPrintPascal for generating column number
        effectively linear complexity as it simply prints what is calculated by binom(), i.e. print each element once.
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


/**
 * this below is the slow version as we couldnt hand in more than one file
 */
/*public class recursivePascal {

    // print direction boolean
    public boolean direction = true;

    //    calculate (n,k) by using (n,k) == (n-1, k-1) + (n-1, k)
    //    Complexity should be N^2 for this calculation
public int binom(int n, int k) {
    // if n (row) is 0, or if n == k (column) the number to return will be 1 due to position within the triangle
    if (n == k || k == 0) {
        return 1;
    } else { // calculate the value of the binom
        return binom(n - 1, k - 1) + binom(n - 1, k);
            /*
                This gets really slow when the integers get large
                Calculating elements for a too high value of n makes for weird results.
                As ints have a max value of little over 2 billion they are prone to going over
                the limit and turning "negative".

    }
}

    /*
        count row by calling printPascal recursively
        one loop inside of printPascal for generating column number
        effectively linear complexity as it simply prints what is calculated by binom().

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

    public static void main(String[] args){

        // make able to use and modify direction properly.
        recursivePascal recursive = new recursivePascal();

        //ask how many rows to print
        StdOut.println("How many rows shall be printed");
        while (!StdIn.isEmpty()) {

            int n = StdIn.readInt();

            //ask what direction to print it
            StdOut.println("What direction should we print the triangle in?");
            StdOut.println("true = normal (top down), false = upside down (bottom up)");
            recursive.direction = StdIn.readBoolean();

            // call printPascal with our n
            recursive.printPascal(n);
        }
    }
}*/