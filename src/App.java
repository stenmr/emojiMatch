public class App {
    public static void main(String[] args) {
       
        System.out.println("Hello World!");
        Game game = new Game();
        Deck deck = game.initializeDeck(new String[] { "🍩", "🍤", "🥩", "🍹", "🍉" }, 10);
        deck.shuffleDeck();
        System.out.println(game.renderCards());
    }
}