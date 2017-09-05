import edu.princeton.cs.introcs.StdOut;

/**
 Erik Pettersson, erpette@kth.se
 **/

public class ErrorPascal implements Pascal {

    public void printPascal(int n) {

        // warn if value of n is below 0
        if (n < 0) {
            StdOut.println("Illegal value for n, try again.");
        }
        return;
    }

    public int binom(int n, int k) {

        // warn if k has a value below 0 or above n
        if (k < 0 || k > n) {
            StdOut.println("Illegal value for k, try again.");
        }
        return 0;
    }

}
