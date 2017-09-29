import se.kth.id1020.util.Attributes;
import se.kth.id1020.util.Document;
import se.kth.id1020.util.Word;
import java.util.ArrayList;

class Node implements Comparable<Node> {

    public Word word;
    public ArrayList<Attributes> attributes = new ArrayList<>();

    public Node(Word word, Attributes attr) {

        this.word = word;
        this.attributes.add(attr);
    }

    public Word getWord() {

        return this.word;
    }

    public String getWordContent() {

        return this.word.word;
    }

    public ArrayList<Attributes> getAttributes() {

        return this.attributes;
    }

    public void addAttribute(Attributes attr) {

        this.attributes.add(attr);
    }

    public Document getDocument(int i) {

        return this.attributes.get(i).document;
    }

    public int compareTo(Node node) {

        return this.word.word.compareTo(node.word.word);
    }

}
