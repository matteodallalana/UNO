public class Game {
    private static final int CARTE_INIZIALI = 3;
    private static final int MAX_TURNI = 10000;

    private Deck mazzo;
    private Plate piatto;
    private PlayerList giocatori;
    private Node<Player> corrente;
    private boolean orario;
    private int malus;
    private Player vincitore;

    public Game(String[] nomi) {
        this.mazzo = new Deck();
        this.piatto = new Plate();
        this.giocatori = new PlayerList();
        this.orario = true;
        this.malus = 0;
        this.vincitore = null;

        this.mazzo.createFullDeck();
        this.mazzo.shuffle();

        for (int i = 0; i < nomi.length; i++) {
            this.giocatori.addPlayer(new Node<Player>(new Player(nomi[i])));
        }
        this.corrente = this.giocatori.getHead();

        // ogni giocatore pesca 3 carte
        for (int i = 0; i < CARTE_INIZIALI; i++) {
            Node<Player> cur = this.giocatori.getHead();
            do {
                cur.getValue().getHand().addCard(this.mazzo.pop());
                cur = cur.getNext();
            } while (cur != this.giocatori.getHead());
        }

        // carta iniziale sul piatto: se è speciale (10, 11, 12) la rimetto nel mazzo e ne pesco un'altra
        Node<Card> prima = this.mazzo.pop();
        while (prima.getValue().getValue() > 9) {
            this.mazzo.push(prima);
            this.mazzo.shuffle();
            prima = this.mazzo.pop();
        }
        this.piatto.push(prima);
    }

    public void start() {
        System.out.println("Giocatori: " + this.giocatori.toString());
        System.out.println("Carta iniziale: " + this.piatto.top());
        System.out.println();

        int turni = 0;
        while (this.vincitore == null && turni < MAX_TURNI) {
            this.playTurn();
            turni++;
        }

        System.out.println();
        if (this.vincitore != null) {
            System.out.println("Ha vinto " + this.vincitore.getName() + " dopo " + turni + " turni!");
        } else {
            System.out.println("Partita interrotta: troppi turni senza un vincitore.");
        }
    }

    private Node<Player> prossimo(Node<Player> n) {
        if (this.orario) {
            return n.getNext();
        }
        return n.getPrev();
    }

    // pesca una carta; se il mazzo è finito rimescola il piatto (tranne l'ultima carta)
    private boolean draw(Player p) {
        if (this.mazzo.size() == 0) {
            this.refillMazzo();
        }
        if (this.mazzo.size() == 0) {
            return false;
        }
        p.getHand().addCard(this.mazzo.pop());
        return true;
    }

    private void refillMazzo() {
        if (this.piatto.size() <= 1) {
            return;
        }
        Node<Card> ultima = this.piatto.pop();
        while (this.piatto.size() > 0) {
            this.mazzo.push(this.piatto.pop());
        }
        this.mazzo.shuffle();
        this.piatto.push(ultima);
    }

    private void playTurn() {
        Player p = this.corrente.getValue();
        Card top = this.piatto.top();
        Node<Card> giocata;

        System.out.println("Turno di " + p.getName() + " | piatto: " + top);
        System.out.println("  mano: " + p.getHand().toString());

        if (this.malus > 0) {
            // c'è un malus: si può rispondere solo con un altro 10
            giocata = p.getHand().playRandom(top, true);

            if (giocata == null) {
                System.out.println("  " + p.getName() + " non ha un 10 e pesca " + this.malus + " carte");
                for (int i = 0; i < this.malus; i++) {
                    this.draw(p);
                }
                this.malus = 0;
                this.corrente = this.prossimo(this.corrente);
                return;
            }
        } else {
            giocata = p.getHand().playRandom(top, false);

            if (giocata == null) {
                System.out.println("  " + p.getName() + " non può giocare e pesca una carta");
                this.draw(p);
                this.corrente = this.prossimo(this.corrente);
                return;
            }
        }

        Card c = giocata.getValue();
        this.piatto.push(giocata);
        System.out.println("  " + p.getName() + " cala " + c);

        if (p.getHand().size() == 0) {
            this.vincitore = p;
            return;
        }

        if (c.getValue() == 10) {
            this.malus += 2;
            System.out.println("  malus accumulato: " + this.malus);
        } else if (c.getValue() == 11) {
            this.orario = !this.orario;
            System.out.println("  il giro si inverte");
        } else if (c.getValue() == 12) {
            this.corrente = this.prossimo(this.corrente);
            System.out.println("  salta il turno di " + this.corrente.getValue().getName());
        }

        this.corrente = this.prossimo(this.corrente);
    }
}