public class PlayerList extends List<Player> {
    private int count;

    public PlayerList() {
        super();
        this.count = 0;
    }

    public void addPlayer(Node<Player> p) {
        this.addTail(p);
        this.getTail().setNext(this.getHead());
        this.getHead().setPrev(this.getTail());
        this.count++;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        if (this.getHead() == null) {
            return "[ nessun giocatore ]";
        }

        String finalString = "[ ";
        Node<Player> cur = this.getHead();

        do {
            finalString += cur.toString() + " ";
            cur = cur.getNext();
        } while (cur != this.getHead());

        finalString += "]";
        return finalString;
    }
}