import java.util.Random;

public class Hand extends List<Card> {
    private Random random;

    public Hand() {
        super();
        this.random = new Random();
    }

    // ingresso in coda
    public void addCard(Node<Card> c) {
        this.addTail(c);
    }

    // uscita: toglie la carta in posizione index e la restituisce
    public Node<Card> playWithIndex(int index) {
        if (this.getHead() == null) {
            System.out.println("la lista è vuota");
            return null;
        }
        if (index < 0) {
            System.out.println("l'indice non è valido");
            return null;
        }

        Node<Card> cur = this.getHead();
        int cont = 0;

        while (cur != null && cont < index) {
            cur = cur.getNext();
            cont++;
        }

        if (cur == null) {
            System.out.println("l'indice è fuori dai limiti");
            return null;
        }

        if (cur == this.getHead()) {
            this.removeHead();
        } else if (cur == this.getTail()) {
            this.removeTail();
        } else {
            cur.getPrev().setNext(cur.getNext());
            cur.getNext().setPrev(cur.getPrev());
            cur.setNext(null);
            cur.setPrev(null);
        }
        return cur;
    }

    // uscita casuale: sceglie a caso una tra le carte giocabili.
    // Se onlyTen è true sono giocabili solo i 10 (quando c'è un malus da pescare).
    // Restituisce null se nessuna carta è giocabile.
    public Node<Card> playRandom(Card top, boolean onlyTen) {
        int playable = 0;
        Node<Card> cur = this.getHead();

        while (cur != null) {
            if (canPlay(cur.getValue(), top, onlyTen)) {
                playable++;
            }
            cur = cur.getNext();
        }

        if (playable == 0) {
            return null;
        }

        int choice = this.random.nextInt(playable);
        int index = 0;
        cur = this.getHead();

        while (cur != null) {
            if (canPlay(cur.getValue(), top, onlyTen)) {
                if (choice == 0) {
                    return this.playWithIndex(index);
                }
                choice--;
            }
            cur = cur.getNext();
            index++;
        }
        return null;
    }

    private boolean canPlay(Card c, Card top, boolean onlyTen) {
        if (onlyTen) {
            return c.getValue() == 10;
        }
        return c.getValue() == top.getValue() || c.getColor() == top.getColor();
    }

    @Override
    public String toString() {
        String finalString = "[ ";
        Node<Card> cur = this.getHead();

        while (cur != null) {
            finalString += cur.toString() + " ";
            cur = cur.getNext();
        }
        finalString += "]";
        return finalString;
    }
}