import java.util.ArrayList;
import java.util.Collections;
import java.lang.StringBuilder;

class Node implements Comparable<Node> {
    private ArrayList<Node> children = new ArrayList();
    private Node parent;
    private Character content = null;
    private Integer value = 0;

    public Node(char value) {
        this.content = value;
    }

    public ArrayList<Node> getChildren() {

        if (this.children.size() > 0)
            return this.children;
        else
            return null;
    }

    public Node getChild(char e) {

        int i = this.search(e);
        if (i != -1) {
            return this.children.get(i);
        } else {
            return null;
        }
    }

    public boolean hasChild(char e) {

        if (this.getChild(e) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void addChild(char e) {

        if (this.hasChild(e)) {
            return;
        }
        Node n = new Node(e);
        n.setParent(this);
        this.children.add(n);
        Collections.sort(children);
    }

    public void removeChild(char e) {

        int i = this.search(e);

        if (i != -1) {
            this.children.remove(i);
        }
    }

    public Node getParent() {
        return this.parent;
    }

    public void setParent(Node p) {
        this.parent = p;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int i) {
        this.value = i;
    }

    public void increment() {
        if (this.value == null) {
            this.value = 1;
        } else {
            this.value += 1;
        }
    }

    public Character getContent()
    {
        return this.content;
    }

    public int compareTo(Character c)
    {
        return Character.compare(this.getContent(), c);
    }

    public int compareTo(Node other)
    {
        return Character.compare(this.getContent(), other.getContent());
    }

    public String word()
    {
        Node n = this;
        StringBuilder sb = new StringBuilder();

        sb.insert(0, this.getContent());

        n = n.getParent();

        if (n != null)
            while(n.getContent() != '\0')
            {
                sb.insert(0, n.getContent());
                n = n.getParent();
            }

        return sb.toString();
    }

    private int search(Character key)
    {
        return search(key, 0, this.children.size());
    }

    private int search(Character key, int lo, int hi)
    {
        while (true)
        {
            if (hi <= lo) return -1;
            int mid = lo + (hi - lo)/2;
            int cmp = this.children.get(mid).compareTo(key);
            if      (cmp > 0) hi = mid;
            else if (cmp < 0) lo = mid + 1;
            else              return mid;
        }
    }
}