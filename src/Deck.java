import java.util.Random;

public class Deck extends List {
    public Deck() {
        super();
    }

    public void push(Card g) {
        this.addTail(g);
    }

    public Node pop() {
        return this.removeTail();
    }

    public void shuffle() {
        int n = this.size();
        if (n <= 1) {
            return;
        }

        Card[] carte = new Card[n];
        Node cur = this.getHead();
        int index = 0;

        while (cur != null) {
            carte[index] = cur.getCard();
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
            cur.setCard(carte[index]);
            cur = cur.getNext();
            index++;
        }
    }

}
