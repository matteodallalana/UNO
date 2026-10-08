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

    protected Node<T> getTail(){
        return this.tail;
    }

    protected void setHead(Node<T> head){
        this.head = head;
    }

    protected void setTail(Node<T> tail){
        this.tail = tail;
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
                // il nodo c viene inserito direttamente (prima veniva creato un Node dentro un Node)
                c.setNext(cur);
                c.setPrev(cur.getPrev());
                cur.getPrev().setNext(c);
                cur.setPrev(c);
            }
        }
    }

    protected void addHead(Node<T> c){
        c.setPrev(null);
        c.setNext(head);

        if(this.head == null){
            this.head = c;
            this.tail = c;
            return;
        }

        head.setPrev(c);
        head = c;
    }

    protected void addTail(Node<T> c){
        c.setNext(null);

        if(this.head == null){
            c.setPrev(null);
            this.head = c;
            this.tail = c;
            return;
        }

        c.setPrev(this.tail);
        this.tail.setNext(c);
        this.tail = c;
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
        removedElement.setNext(null);
        removedElement.setPrev(null);
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
        removedElement.setNext(null);
        removedElement.setPrev(null);
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
        if (this.head == null) {
            return "[ lista vuota ]";
        }

        String finalString = " ";
        Node<T> cur = head;

        finalString += "Head: " + this.head.getValue() + "\n";
        finalString += "Tail: " + this.tail.getValue() + "\n";
        finalString += "[ ";

        while (cur != null) {
            finalString += cur.toString() + " ";
            cur = cur.getNext();
        }
        finalString += "]";
        return finalString;
    }
}