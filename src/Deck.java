public class Deck extends List{
    public Deck(){
        super();
    }

    public void push(Card g){
        this.addTail(g);
    }

    public Card pop(){
        return this.removeTail();
    }
}
