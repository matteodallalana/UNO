import java.util.Random;

public class Deck<Card> extends List<Card> {
    public Deck() {
        super();
    }

    public void push(Node<Card> g) {
        this.addTail(g);
    }

    public Node<Card> pop() {
        return this.removeTail();
    }

    public void shuffle() {
        int n = this.size();
        if (n <= 1) {
            return;
        }

        Node<Card>[] carte = new Node[this.size()];
        Node<Card> cur = this.getHead();
        int index = 0;

        while (cur != null) {
            carte[index] = new Node<Card>(cur.getValue());
            cur = cur.getNext();
            index++;
        }

        Random rand = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            Node<Card> temp = carte[i];
            carte[i] = carte[j];
            carte[j] = temp;
        }

        cur = this.getHead();
        index = 0;
        while (cur != null) {
            cur.setValue(carte[index].getValue());
            cur = cur.getNext();
            index++;
        }
    }

}
