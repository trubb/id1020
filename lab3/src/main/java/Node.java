public class Node<T extends Comparable<T>> implements Comparable<Node <T>>{

    // newly created nodes get their fields set to null
    private T data = null;
    private Node<T> next = null;


    public Node<T> getNext() {
        return this.next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setNext(Node<T> nextNode) {
        this.next = nextNode;
    }

    public int compareTo(Node<T> comparable) {
        return getData().compareTo( comparable.getData() );
    }
}
