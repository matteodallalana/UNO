public class Node <T>{
    private T value;
    private Node<T> next;
    private Node<T> prev;

    public Node(T c){
        this.next = null;
        this.prev = null;
        this.value = c;
    }

    public T getValue(){
        return this.value;
    }

    public void setValue(T v){
        this.value = v;
    }

    public void setNext(Node<T> n){
        this.next = n;
    }

    public void setPrev(Node<T> p){
        this.prev = p;
    }

    public Node<T> getNext(){
        return this.next;
    }

    public Node<T> getPrev(){
        return this.prev;
    }

    @Override
    public String toString(){
        return value.toString();
    }
}
