import edu.princeton.cs.introcs.StdOut;

public class ErrorPascal implements Pascal {

    public void printPascal(int n) {

        if (n < 0) {
            StdOut.println("Illegal value for n, try again.");
        }
    }

    public int binom(int n, int k) {

        if (k < 0 && k > n) {
            StdOut.println("Illegal value for k, try again.");
        }
        return 0;
    }

}
