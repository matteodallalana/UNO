/*public class Hand extends List{
    public Hand(){
        super();
    }

    public void playWithIndex(int index) {
        if (this.getHead() == null) {
            System.out.println("la lista è vuota");
            return;
        }
        if (index < 0) {
            System.out.println("l'indice non è valido");
            return;
        }

        Node<Card> cur = this.getHead();
        int cont = 0;

        while (cur != null && cont < index) {
            cur = cur.getNext();
            cont++;
        }

        if (cur == null) {
            System.out.println("l'indice è fuori dai limiti");
            return;
        }

        if (cur == this.getHead()) {
            this.removeHead();
        }

        else if (cur == this.getTail()) {
            this.removeTail();
        }

        else {
            cur.getPrev().setNext(cur.getNext());
            cur.getNext().setPrev(cur.getPrev());
        }
    }




    public void play(Card c) {
        if (this.getHead() == null) {
            System.out.println("La mano è vuota");
            return;
        }

        Node cur = this.getHead();
        boolean found = false;

        while (cur != null) {

            if (cur.getCard().equals(c)) {
                found = true;
                break;
            }
            cur = cur.getNext();
        }

        if (!found) {
            System.out.println("La carta non è presente nella mano");
            return;
        }

        if (cur == this.getHead()) {
            this.removeHead();
        }
        else if (cur == this.getTail()) {
            this.removeTail();
        }
        else {
            cur.getPrev().setNext(cur.getNext());
            cur.getNext().setPrev(cur.getPrev());
        }
    }

}*/
