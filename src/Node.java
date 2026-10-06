public class Node {
    private Card carta;
    private Node next;
    private Node prev;

    public Node(Card c){
        this.next = null;
        this.prev = null;
        this.carta = c;
    }

    public Card getCard(){
        return this.carta;
    }

    public void setCard(Card c){
        this.carta = c;
    }

    public int getValue(){
        return this.carta.getValue();
    }

    public Color getColor(){
        return this.carta.getColor();
        }

    public void setNext(Node n){
        this.next = n;
    }

    public void setPrev(Node p){
        this.prev = p;
    }

    public Node getNext(){
        return this.next;
    }

    public Node getPrev(){
        return this.prev;
    }
}
