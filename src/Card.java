public class Card {
    private int value;
    private Color color;

    public Card(int value, Color c){
        this.value = value;
        this.color = c;
    }

    public void setValue(int v){
        this.value = v;
    }

    public void setColor(Color c){
        this.color = c;
    }

    public int getValue(){
        return this.value;
    }

    public Color getColor(){
        return this.color;
    }

    @Override
    public String toString(){
        String  finalString = "";
        return finalString += "[ colore: " + this.color + " <-> valore: " + this.value + "]" ;
    }
}
