public class App {
    public static void main(String[] args) {
       
        System.out.println("Hello World!\n");

        Game game = new Game();
        game.initializeDeck(new String[] { "🍩", "🍤", "🥩", "🍹", "🍉" }, 10);
        game.start();
    }
}