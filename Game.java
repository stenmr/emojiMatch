/**
 * Game
 */
public class Game implements Actions {

    @Override
    public void flipTwo(Deck deck, int[] indices) {
        // TODO Auto-generated method stub

    }

    @Override
    public Deck initializeDeck(String[] faces, int cards) throws Exception {
        return new Deck(faces, cards);
    }
}