import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class recursivePascal {

    /*
        if true print triangle right side up
        if false print triangle upside down
    */

    // calculate (n,k) by using (n,k) == (n-1, k-1) + (n-1, k)
    public int binom(int n, int k) {

        // if n (row) is 0, or if n == k (column) the number to return will be 1 due to position within the triangle
        if (n == 0 || n == k) {
            return 1;
        } else {
            return binom(n - 1, k - 1) + binom(n - 1, k);
        }

    }

    public void printPascal( int n) {




        // print pascals triangle magically
    }

    public static void main(String[] args){

        // handle how many rows of pascal triangle should be printed

        //ask how many rows to print
        System.out.println("How many rows shall be printed");
        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
        }

        //ask what direction to print it


    }

}
