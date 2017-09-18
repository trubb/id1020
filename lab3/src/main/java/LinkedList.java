public class LinkedList<T extends Comparable<T>> {

    private Node<T> first;
    private int size = 0;

    public void addNode(T key) {

        Node<T> n = new Node<>();
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

    private void swap(Node<T> higher, Node<T> lower) {
        Node<T> temporary = lower.getNext();
        //temporary.setData(lower.getData());
        //temporary.setNext(lower.getNext());

        lower.setNext( higher );
        higher.setNext( temporary );
    }

    public int bubbleSort() {

        int R = this.size - 1;
        boolean swapped = true;
        int inversions = 0;

        while (R >= 0 && swapped) {

            swapped = false;
            Node<T> previous = null;

            for (Node<T> curr = first; curr != null && curr.getNext() != null; curr = previous.getNext()) {
                Node<T> next = curr.getNext();

                if ( curr.compareTo(next) > 0 ) {
                    if (previous == null) {
                        first = next;
                    } else {
                        previous.setNext(next);
                    }

                    swap(curr, next);
                    swapped = true;
                    inversions += 1; // increment swap counter
                    previous = next;
                } else {
                    previous = curr;
                }
            }
            R--;
        }

        return inversions;
    }

    public String toString() {

        if (this.first == null) {
            return "()";
        }

        StringBuilder printlist = new StringBuilder();

        Node current = first;

        while (current != null) {
            printlist.append("(");
            printlist.append(current.getData());
            printlist.append(") ");
            current = current.getNext();
        }
        return printlist.toString();
    }
}
