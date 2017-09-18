import edu.princeton.cs.introcs.StdOut;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        int[] inversionarray = null;

        // 30 entries for testing
/*
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
        for (int i = 0; i < 30; i++) {

            int random = (int)(Math.random() * 50 + 1);
            list.addNode(random);
            inversionarray[i] = random;

        }

        StdOut.println("List before sorting: " + list.toString());
        int inversions = list.bubbleSort();
        StdOut.println("List after sorting: " + list.toString());
        StdOut.println("Number of swapped keys (int inversions) " + inversions);

    }
}
