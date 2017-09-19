public class Node<T extends Comparable<T>> implements Comparable<Node <T>>{

    // newly created nodes get their fields set to null
    private T data = null;
    private Node<T> next = null;

    /**
     * Get what node the addressed node is pointing at
     *
     * @return the address of the next node
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * Set the addressed node's data
     *
     * @param data a value to be put in the data field
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Get what the addressed node has in its data field
     *
     * @return the data that the node had in its data field
     */
    public T getData() {
        return this.data;
    }

    /**
     * Assign a new next node to the addressed node
     *
     * @param nextNode the node that the node should point to
     */
    public void setNext(Node<T> nextNode) {
        this.next = nextNode;
    }

    /**
     * Compare the executing node to another node
     *
     * @param comparable the node we want to grab data from to compare our current node to
     * @return 1 if the executing nodes data is larger, 0 if they have the same value, or -1 if the compared node is larger
     */
    public int compareTo(Node<T> comparable) {
        System.out.println(this.getData().compareTo( comparable.getData() ));
        return this.getData().compareTo( comparable.getData() );
    }
}
