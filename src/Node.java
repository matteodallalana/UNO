public class Node {
    private Card next;
    private Card prev;

    public Node(){
        this.next = null;
        this.prev = null;
    }

    public void setNext(Card n){
        this.next = n;
    }

    public void setPrev(Card p){
        this.prev = p;
    }

    public Card getNext(){
        return this.next;
    }

    public Card getPrev(){
        return this.prev;
    }
}
