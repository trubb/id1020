import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Word;
import java.util.ArrayList;

class Node {

    private Word word;
    private ArrayList<Attributes> attributes = new ArrayList<>();

    public Node(Word word, Attributes attr) {

        this.word = word;
        attributes.add(attr);
    }

    public Word getWord() {

        return this.word;
    }

    public ArrayList<Attributes> getAttributes() {

        return this.attributes;
    }

    public void addAttribute(Attributes attr) {

        attributes.add(attr);
    }

}
