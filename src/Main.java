public class Main {
    public static void main(String[] args){
        Node<Card> zeroG = new Node<Card>(new Card(0, Color.YELLOW));
        Node<Card> unoG = new Node<Card>(new Card(1, Color.YELLOW));
        Node<Card> dueG = new Node<Card>(new Card(2, Color.YELLOW));
        Node<Card> treG = new Node<Card>(new Card(3, Color.YELLOW));
        Node<Card> quattroG = new Node<Card>(new Card(4, Color.YELLOW));
        Node<Card> cinqueG = new Node<Card>(new Card(5, Color.YELLOW));

        Deck<Card> mazzo = new Deck<Card>();
        //Hand giocatore = new Hand();

        //giocatore.addHead(zeroG);
        //giocatore.addHead(unoG);
        //giocatore.addHead(dueG);
        //giocatore.addHead(treG);
        mazzo.push(zeroG);
        mazzo.push(unoG);
        mazzo.push(dueG);
        mazzo.push(treG);

        //System.out.println(mazzo.toString());
        //System.out.println(giocatore.toString());
//
        //giocatore.playWithIndex(1);
        //System.out.println(giocatore.toString());

        mazzo.insert(1, quattroG);
        System.out.println(mazzo.toString());

        System.out.println(mazzo.size());

        mazzo.shuffle();
        System.out.println(mazzo.toString());

    }
}
