import edu.princeton.cs.introcs.StdOut;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>(); // create a new list
/*
        // 3 sets of 10 known entries each for testing, generated by random.org
        list.addNode(14);
        list.addNode(40);
        list.addNode(3);
        list.addNode(30);
        list.addNode(15);
        list.addNode(41);
        list.addNode(6);
        list.addNode(48);
        list.addNode(49);
        list.addNode(35);
// 10

        list.addNode(0);
        list.addNode(42);
        list.addNode(23);
        list.addNode(32);
        list.addNode(11);
        list.addNode(2);
        list.addNode(22);
        list.addNode(4);
        list.addNode(13);
        list.addNode(31);
// 20

        list.addNode(10);
        list.addNode(37);
        list.addNode(27);
        list.addNode(36);
        list.addNode(20);
        list.addNode(22);
        list.addNode(33);
        list.addNode(17);
        list.addNode(18);
        list.addNode(7);
// 30
*/
//        int inversionarray[] = {14,40,3,30,15,41,6,48,49,35}; // 10
//        int inversionarray[] = {14,40,3,30,15,41,6,48,49,35,0,42,23,32,11,2,22,4,13,31}; // 20
//        int inversionarray[] = {14,40,3,30,15,41,6,48,49,35,0,42,23,32,11,2,22,4,13,31,10,37,27,36,20,22,33,17,18,7}; // 30



        int numberofkeys = 10; // int used to set number of elements in array and list
        int[] inversionarray = new int[numberofkeys]; // initialise inversionarray to be of proper size for adding keys automatically
        for (int i = 0; i < numberofkeys; i++) {

            int random = (int)(Math.random() * 50 + 1);
            list.addNode(random);
            inversionarray[i] = random;
        }


        StdOut.println("List before sorting: " + list.toString()); // print the list before doing anything to it

        int arrayinversions = InversionCount.inversions(inversionarray); // create an int which will contain the number of counted inversions from the array solution
        int nodeinversions = list.inversions(); // create an int which will contain the number of counted inversions from the list solution
        int swaps = list.bubbleSort(); // create an int which will contain the number of swap operations performed by the sort

        StdOut.println("List after sorting: " + list.toString()); // print the list after it has been put through the sort
        StdOut.println("Number of swapped keys " + swaps); // print swaps
        StdOut.println("Number of calculated inversions (list) " + nodeinversions); // print inversion count from the node solution
        StdOut.println("Number of calculated inversions (array) " + arrayinversions); // print the inversion count from the array solution

        if (swaps == nodeinversions) { // if the number of swaps are the same as the number of inversions counted in the node solution
            StdOut.println("Swaps == nodeinversions"); // print that they are the same
        } else {
            StdOut.println("Swaps != nodeinversions"); // print that they are NOT the same
        }

        if (swaps == arrayinversions) { // if the number of swaps are the same as the number of inversions counted in the array solution
            StdOut.println("Swaps == arrayinversions"); // print that they are the same
        } else {
            StdOut.println("Swaps != arrayinversions"); // print that they are NOT the same
        }
    }

}
