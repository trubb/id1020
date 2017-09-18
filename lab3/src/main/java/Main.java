import edu.princeton.cs.introcs.StdOut;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.addNode(14); // 30 entries
        list.addNode(40);
        list.addNode(3);
        list.addNode(30);
        list.addNode(15);
        list.addNode(41);
        list.addNode(6);
        list.addNode(48);
        list.addNode(49);
        list.addNode(35);
/*
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
*/
        // magic filler of list, hopefully works later
        /*for (int i = 0; i < 30; i++) {

            int random = (int)(Math.random() * 50 + 1);
            list.addNode(random);
        }*/

        StdOut.println("List content before sorting: " + list.toString());
        list.bubbleSort();
        StdOut.println("List after sorting: " + list.toString());

    }
}
