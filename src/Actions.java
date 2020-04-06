/**
 * Actions
 */
public interface Actions {

    public void flipTwo(int[] indices);

    public Deck initializeDeck(String[] faces, int cards);

    public Boolean[] initializeFlip(Deck deck);

    public void start();
}