/**
 * Actions
 */
public interface Actions {

    public void flipTwo(Deck deck, int[] indices);

    public Deck initializeDeck(String[] faces, int cards) throws Exception;
}