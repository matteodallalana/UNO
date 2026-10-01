public class List {
    private Card head;
    private Card tail;

    protected List(){
        this.head = null;
        this.tail = null;
    }

    protected Card getHead(){
        return this.head;
    }

    protected Card getTail(){
        return this.tail;
    }

    protected void setHead(Card head){
        this.head = head;
    }

    protected void setTail(Card tail){
        this.tail = tail;
    }

    protected void addHead(Card c){
        Card newCard = new Card(c.getValue(), c.getColor());

        newCard.setNext(head);

        if(this.head == null){
            this.head = newCard;
            this.tail = head;
            return;
        }else if(head != null){
            head.setPrev(newCard);
        }
        head = newCard;
    }

    protected void addTail(Card c){
        Card newCard = new Card(c.getValue(), c.getColor());

        if(this.head == null){
            this.head = newCard;
            this.tail = head;
            return;
        }

        newCard.setPrev(this.tail);
        this.tail.setNext(newCard);
        this.tail = this.tail.getNext();
    }

    protected Card removeHead(){
        if(this.head == null){
            System.out.println("la lista è vuota");
            return null;
        }
        Card removedElement = this.head;

        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        }else{
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }
        return removedElement;
    }

    protected Card removeTail(){
        if(this.tail == null) {
            System.out.println("la lista è vuota");
            return null;
        }
        Card removedElement = this.tail;

        if(this.head == this.tail){
            this.tail = null;
            this.head = null;
        }else{
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }
        return removedElement;
    }

    @Override
    public String toString() {
        String finalString = " ";
        Card cur = head;

        finalString += "Head: " + this.head.getValue() + "\n";
        finalString += "Tail: " + this.tail.getValue() + "\n";
        finalString += "[ ";

        while (cur != null) {
            finalString += "value: " + cur.getValue() + ", color: " + cur.getColor();
            if (cur.getNext() != null) {
                finalString += " <-> ";
            }
            cur = cur.getNext();
        }
        finalString += " ]";
        return finalString;
    }
}
