public class Main {
    public static void main(String[] args){
        String[] nomi = {"Anna", "Luca", "Marco", "Sara"};

        Game partita = new Game(nomi);
        partita.start();
    }
}