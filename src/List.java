public class List <T>{
    private Node<T> head;
    private Node<T> tail;

    protected List(){
        this.head = null;
        this.tail = null;
    }

    protected Node<T> getHead(){
        return this.head;
    }

    protected void insert(int index, Node<T> c){
        if(index <= 0){
            addHead(c);
        }else{
            int cont = 0;
            Node<T> cur = head;
            while (cur != null && cont < index){
                cont ++;
                cur = cur.getNext();
            }
            if(cur == null){
                addTail(c);
            }else {
                Node<T> newItem = new Node(c);
                newItem.setNext(cur);
                newItem.setPrev(cur.getPrev());
                cur.getPrev().setNext(newItem);
                cur.setPrev(newItem);
            }
        }
    }

    protected Node<T> getTail(){
        return this.tail;
    }

    protected void setHead(Node<T> head){
        this.head = head;
    }

    protected void setTail(Node<T> tail){
        this.tail = tail;
    }

    protected void addHead(Node<T> c){
        Node<T> newCard = c;

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

    protected void addTail(Node<T> c){
        Node<T> newCard = c;

        if(this.head == null){
            this.head = newCard;
            this.tail = head;
            return;
        }

        newCard.setPrev(this.tail);
        this.tail.setNext(newCard);
        this.tail = this.tail.getNext();
    }

    protected Node<T> removeHead(){
        if(this.head == null){
            System.out.println("la lista è vuota");
            return null;
        }
        Node<T> removedElement = this.head;

        if(this.head == this.tail){
            this.head = null;
            this.tail = null;
        }else{
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }
        return removedElement;
    }

    protected Node<T> removeTail(){
        if(this.tail == null) {
            System.out.println("la lista è vuota");
            return null;
        }
        Node<T> removedElement = this.tail;

        if(this.head == this.tail){
            this.tail = null;
            this.head = null;
        }else{
            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }
        return removedElement;
    }

    public int size() {
        int cont = 0;
        Node<T> cur = head;

        while(cur != null){
            cont ++;
            cur = cur.getNext();
        }
        return cont;
    }

    @Override
    public String toString() {
        String finalString = " ";
        Node<T> cur = head;

        finalString += "Head: " + this.head.getValue() + "\n";
        finalString += "Tail: " + this.tail.getValue() + "\n";
        finalString += "[ ";

        while (cur != null) {
            finalString += head.toString();
            cur = cur.getNext();
        }
        finalString += " ]";
        return finalString;
    }
}
