public class App {
    public static void main(String[] args) {
        Game game = new Game();
        game.initializeDeck(new String[] { "S", "P", "K", "Q", "U" }, 10);
        game.start();
    }
}