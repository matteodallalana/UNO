import java.util.Random;

public class Deck extends List<Card> {
    public Deck() {
        super();
    }

    // per ogni colore: un solo 0 e due carte per ogni altro valore (1..12)
    public void createFullDeck() {
        for (Color c : Color.values()) {
            this.push(new Node<Card>(new Card(0, c)));
            for (int v = 1; v <= 12; v++) {
                this.push(new Node<Card>(new Card(v, c)));
                this.push(new Node<Card>(new Card(v, c)));
            }
        }
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

        Card[] carte = new Card[n];
        Node<Card> cur = this.getHead();
        int index = 0;

        while (cur != null) {
            carte[index] = cur.getValue();
            cur = cur.getNext();
            index++;
        }

        Random rand = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            Card temp = carte[i];
            carte[i] = carte[j];
            carte[j] = temp;
        }

        cur = this.getHead();
        index = 0;
        while (cur != null) {
            cur.setValue(carte[index]);
            cur = cur.getNext();
            index++;
        }
    }

}