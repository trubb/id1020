import java.util.Objects;

public class LinkedList<T extends Comparable<T>> {

    private Node first;
    private int size = 0;

    public void addNode(T key) {

        Node n = new Node();
        Node current = first;
        n.setData(key);

        if (first == null) {
            first = n;
        } else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(n);
        }
        size++;
    }

    private void swap(Node higher, Node lower) {
        Node temporary = new Node();
        temporary.setData(lower.getData());
        temporary.setNext(lower.getNext());

        lower.setNext( higher );
        higher.setNext( temporary.getNext() );
    }

    public void bubbleSort() {

        int R = this.size - 1;
        boolean swapped = true;

        while (R >= 0 && swapped) {
            swapped = false;
            Node previous = null;
            for (Node curr = first; curr != null && curr.getNext() != null;) {
                Node next = curr.getNext();

                if ( curr.getData().compareTo(next.getData()) > 0 ) {
                    if (previous == null) {
                        first = next;
                    } else {
                        previous.setNext(next);
                    }

                    swap(curr, next);
                    swapped = true;
                    previous = next;
                } else {
                    previous = curr;
                    curr = next;
                }
            }
            R--;
        }
    }

    public String toString() {
        String printlist = "";
        printlist += "(" + this.first.getData() + ") ";

        Node current = first.getNext();
        while (current != null) {
            printlist += "(" + current.getData() + ") ";
            current = current.getNext();
        }
        return printlist;
    }
}
