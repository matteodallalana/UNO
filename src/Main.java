public class Main {
    public static void main(String[] args){
        Card zeroG = new Card(0, Color.YELLOW);
        Card unoG = new Card(1, Color.YELLOW);
        Card dueG = new Card(2, Color.YELLOW);
        Card treG = new Card(3, Color.YELLOW);
        Card quattroG = new Card(4, Color.YELLOW);
        Card cinqueG = new Card(5, Color.YELLOW);

        Deck mazzo = new Deck();
        Hand giocatore = new Hand();

        giocatore.addHead(zeroG);
        giocatore.addHead(unoG);
        giocatore.addHead(dueG);
        giocatore.addHead(treG);
        mazzo.push(zeroG);
        mazzo.push(unoG);
        mazzo.push(dueG);
        mazzo.push(treG);

        System.out.println(mazzo.toString());
        System.out.println(giocatore.toString());

        giocatore.playWithIndex(1);
        System.out.println(giocatore.toString());

        mazzo.insert(1, quattroG);
        System.out.println(mazzo.toString());

        System.out.println(mazzo.size());

        mazzo.shuffle();
        System.out.println(mazzo.toString());

    }
}
