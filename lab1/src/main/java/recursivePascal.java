import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class recursivePascal {

    public boolean direction;

    // calculate (n,k) by using (n,k) == (n-1, k-1) + (n-1, k)
    public int binom(int n, int k) {
        // if n (row) is 0, or if n == k (column) the number to return will be 1 due to position within the triangle
        if (n == 0 || n == k) {
            return 1;
        } else {
            return binom(n - 1, k - 1) + binom(n - 1, k);
        }
    }

    public void printPascal(int n) {

        // if direction = true
        for (int i = 0; i < ; i++) {
            
        }
        StdOut.println(binom(n,0));

        // if direction = false
        StdOut.println(binom(n,0)); // BUT BACKWARDS!

        // one loop for row
        // one loop inside of the previous for column
        // the triangle is essentially an array triangle[][]
        // print pascals triangle magically
    }

    public static void main(String[] args){

        recursivePascal recursive = new recursivePascal();

        //ask how many rows to print
        StdOut.println("How many rows shall be printed");
        while (!StdIn.isEmpty()) {
            int n = StdIn.readInt();
        }

        //ask what direction to print it
        StdOut.println("What direction should we print the triangle in?");
        StdOut.println("true = normal (top down), false = upside down (bottom up)");
        while (!StdIn.isEmpty()) {
             recursive.direction = StdIn.readBoolean();
        }

    }

}
