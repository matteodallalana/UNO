public class Card extends Node{
    private int value;
    private Color color;

    public Card(int value, Color c){
        this.value = value;
        this.color = c;
    }

    public int getValue(){
        return this.value;
    }

    public Color getColor(){
        return this.color;
    }
}
