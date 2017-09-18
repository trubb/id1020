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

    private void swapTwo(Node higher, Node lower) {
        Node temporary = lower.getNext();
        this.first = lower;
        this.first.setNext(higher);
        higher.setNext( temporary );
    }

    private void swapThree(Node first, Node second, Node third) {
        Node temporary = third.getNext();
        first.setNext( third );
        third.setNext( second );
        second.setNext( temporary );
    }

    public void bubbleSort() {

        int R = this.size - 2;

        boolean swapped = true;

        while (R >= 0 && swapped) {
            swapped = false;
            int index = 0;

            for (Node i = first; i.getNext().getNext() != null; i = i.getNext()) {

                if ( index == 0 ) {
                    if ( i.getData().compareTo(i.getNext().getData()) > 0 ) {


                        swapTwo( i.getNext(), i.getNext().getNext() );
                        swapped = true;
                    }
                }

                System.out.println(i.getNext().getNext().getData());

                if ( i.getNext().getData().compareTo(i.getNext().getNext().getData()) > 0 ) {
                    swapThree(i, i.getNext(), i.getNext().getNext());
                    swapped = true;
                }
                index++;
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
