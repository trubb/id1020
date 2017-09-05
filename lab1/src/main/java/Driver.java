import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdIn;

/**
 Erik Pettersson, erpette@kth.se
 **/

public class Driver {

    /**
     * ask for input and run the whole thing
     */
    public static void main(String[] args){

        // make able to use and modify direction and arrays properly.
        recursivePascal recursive = new recursivePascal();
        iterativePascal iterative = new iterativePascal();

        //ask how many rows to print
        StdOut.println("How many rows shall be printed");
        while (!StdIn.isEmpty()) {

            // set row number to print
            int n = StdIn.readInt();

            //ask what direction to print it
            StdOut.println("What direction should we print the triangle in?");
            StdOut.println("true = normal (top down), false = upside down (bottom up)");

            // set print direction
            recursive.direction = StdIn.readBoolean();
            iterative.direction = recursive.direction;

            // set the recursive/iterative arrays to correct size
            recursive.binom_store = new int[n+1][n+1];
            iterative.iterationarray = new int[n+1][n+1];

            // ask which version to run
            StdOut.println("Do you want to run the iterative implementation? Y/n");
            String pick = StdIn.readString();
            if (pick.equals("y") || pick.equals("Y")) {
                // call printPascal with our n
                iterative.printPascal(n);
            } else if (pick.equals("n") || pick.equals("N")) {
                // call printPascal with our n
                recursive.printPascal(n);
            } else {
                recursive.printPascal(n);
            }
        }
    }

}
