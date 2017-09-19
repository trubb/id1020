public class LinkedList<T extends Comparable<T>> {

    private Node<T> first; // create a magic first node
    private int size = 0; // create a int to hold the size of the linked list

    /**
     * Adds new nodes to the linked list
     *
     * @param key a value to be put in the node's data field
     */
    public void addNode(T key) {

        Node<T> n = new Node<>(); // create a new node
        Node current = first; // create a new node current, set it to be equal to the first node
        n.setData(key); // set the data of n to be equal to what the method was provided

        if (first == null) { // if first has no assigned values
            first = n; // set first to be n
        } else {
            while (current.getNext() != null) { // as long as the current node is pointing at something
                current = current.getNext(); // overwrite the current node to be the next node
            }
            current.setNext(n); // set the next-field of current node to point to n
        }
        size++; // when we create a new node in the list we obviously need to make the list larger
    }

    /**
     * Swaps the position of two nodes with the help of a temporary third node
     *
     * @param higher a node earlier in the list, but with a higher value than lower
     * @param lower a node directly after higher, but with a lower value than higher
     */
    private void swap(Node<T> higher, Node<T> lower) {
        Node<T> temporary = lower.getNext(); // create a new node for the swap operation, set it to be lower's next node
        lower.setNext( higher ); // set the "lower" node to point to the higher one so that (higher, lower) -> (lower, higher)
        higher.setNext( temporary ); // set the higher nodes next to be the lower value's next
    }

    /**
     * Performs a bubble sort on the linked list, so that it is ordered from smallest to largest
     *
     * @return the number of times swap() has been called
     */
    public int bubbleSort() {

        int R = this.size - 1; // in order to not overstep the end of the list, set R to 1 less than size
        boolean swapped = true; // create a boolean to toggle when we swap
        int swaps = 0; // this int is used to count the amount of swaps that we perform

        while (R >= 0 && swapped) { // as long as R is above or equal to 0, and swapped is true do the following

            swapped = false; // this will break the while loop when we are done swapping stuff
            Node<T> previous = null; // create a new node to hold the value of the previous node, null for now

            // create yet another new node, as long as it is not null and the next node is not null, step through
            for (Node<T> curr = first; curr != null && curr.getNext() != null; curr = previous.getNext()) {

                Node<T> next = curr.getNext(); // create and set the next-node to be the node after current-node

                if ( curr.compareTo(next) > 0 ) { // if current node is greater than the next node do the following
                    if (previous == null) { // if previous is null
                        first = next; // set first to next
                    } else {
                        previous.setNext(next); // set the previous to point at the next node
                    }

                    swap(curr, next); // send current and next node to swap() so that they change place
                    swapped = true; // toggle swapped
                    swaps += 1; // increment swap counter
                    previous = next; // set previous to next
                } else {
                    previous = curr; // else set previous to current
                }
            }
            R--; // decrement R (where we are in the list)
        }
        return swaps; // return the number of swaps
    }

    /**
     * A function for counting the number of inversions in the list
     *
     * MUST be used before bubbleSort() or there will be no inversions to count
     *
     * @return the number of inversions in the provided list
     */
    public int inversions() {

        int inversions = 0; // create int to store the amount of inversions
        Node current = this.first; // create a new node current

        while (current != null) { // as long as current node exists do the following

            Node inner = current.getNext(); // create a new node, inner, and set it to be the node following current-node

            while (inner != null) { // as long as inner node exists do the following

                if ( inner.getData().compareTo(current.getData()) < 0 ) { // if the data field of inner-node is greater than that of the current

                    inversions++; // add 1 to the number of inversions

                }
                inner = inner.getNext(); // set inner to be the node next in line
            }
            current = current.getNext(); // set current to be the node next in line
        }
        return inversions; // return the number of inversions
    }

    /**
     * A function for exporting the linked list to string format
     *
     * @return the list in string form
     */
    public String toString() {

        if (this.first == null) { // if first is null we have obviously not filled the list properly
            return "()"; // therefor return what's essentially nothing
        }

        StringBuilder printlist = new StringBuilder(); // create a new instance of stringbuilder

        Node current = first; // create a current node to be able to start printing the list

        while (current != null) { // as long as the current node exists
            printlist.append("("); // add a ( to the string
            printlist.append(current.getData()); // add the data of the current node to the string
            printlist.append(") "); // add a ) to the string
            current = current.getNext(); // step down the list
        }
        return printlist.toString(); // return the string to the caller
    }

}
