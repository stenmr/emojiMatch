import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {

    @Test
    public void deckSize() {

        Deck deck = new Deck(new String[] {"S", "T"}, 4);

        assertEquals("Deck size is correct", deck.size(), 4);
    }

    @Test
    public void deckIndexing() {
        Deck deck = new Deck(new String[] {"Q", "Y"}, 4);

        assertEquals("Indexing is correct", deck.get(1), "Y");
    }
}