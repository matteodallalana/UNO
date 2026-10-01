public class Hand extends List{
    public Hand(){
        super();
    }

    public void play(int index){
        if(this.getHead() == null){
            System.out.println("la lista è vuota");
            return;
        } else if(index < 0){
            System.out.println("l'indice non è valido");
            return;
        }else {
            Card cur = this.getHead();
            int cont = 0;

            while(cur != null && cont < index){
                cur = cur.getNext();
                cont ++;
            }

            if(cur == null){
                System.out.println("l'indice è fuori dai limiti");
                return;
            }else if(cur == this.getHead()){
                this.setHead(cur.getNext());
                if(this.getHead() != null){
                    this.removeHead();
                }else {
                    this.setTail(null);
                }
            }else if(cur == this.getTail()){
                this.setTail(cur.getPrev());
                if(this.getTail() != null){
                    this.getTail().setNext(null);
                }else{
                    cur.getPrev().setNext(cur.getNext());
                    cur.getNext().setPrev(cur.getPrev());
                }
            }
        }
    }
}
