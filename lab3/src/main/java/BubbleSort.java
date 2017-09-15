import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class BubbleSort {

    public static void main(String[] args) {

        List list = new List();

        while (!StdIn.isEmpty()) {

            Comparable[] array = StdIn.readAll().split(""); // v ugly pls refurbish

            for (int i = 0; i < array.length; i++) {

                list.addNode(array[i]);

            }

            Sort.BubbleSort(list);

            StdOut.print(sortedlinkedlist);
        }

    }

}

class Sort {

    //method to bubblesort
    public static void BubbleSort(Comparable linkedlist) {

        //int countSwaps; // for counting Swaps

        boolean swapped;

        while (size > 0 && swapped) {

            swapped = false;

            for (int i = 0; i <= size; i++) {

                if ( linkedlist[i] .compareTo( linkedlist[i + 1] ) < 0) {

                    swapped = true;

                    List.Swap(i, i + 1);

                    //prepare for swap/inversion count
                    //countSwaps++;

                }
            }
        }

    }

}


class List {

    class Node {

        Comparable data = null;
        Node next = null;

    }

    private Node first;
    private int length; // ????

    public void addNode(Comparable key) {

        Node oldfirst = first;
        first = new Node();
        first.data = key;
        first.next = oldfirst;

    }

    static void Swap(Comparable largerkey, Comparable smallerkey) {

        // update to reflect linkedlist, very wrong currently
        Comparable temporary = largerkey.data;
        largerkey.data = smallerkey.data;
        smallerkey.data = temporary;
    }

}
