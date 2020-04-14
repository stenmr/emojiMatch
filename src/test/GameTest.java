import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameTest {

    @Test
    public void deckSize() {
        Deck deck = new Deck(new String[] { "S", "T" }, 4);

        assertEquals("Deck size is correct", deck.size(), 4);
    }

    // Ajuvaba test
    @Test
    public void deckIndexing() {
        Deck deck = new Deck(new String[] { "Q" }, 2);

        assertEquals("Indexing is correct", deck.get(1), "Q");
    }

    @Test
    public void deckDisplayL() {
        Game game = new Game();
        game.initializeDeck(new String[] { "S", "P", "K", "Q", "U" }, 10);
        String testOutput = "/====\\  /====\\  /====\\  /====\\  /====\\  \n| 1  |  | 2  |  | 3  |  | 4  |  | 5  |  \n\\====/  \\====/  \\====/  \\====/  \\====/  \n\n/====\\  /====\\  /====\\  /====\\  /====\\  \n| 6  |  | 7  |  | 8  |  | 9  |  | 10  |  \n\\====/  \\====/  \\====/  \\====/  \\====/  \n"; 
        assertEquals("Deck display matches expected", testOutput.trim(), game.renderCards().trim());
    }

    @Test
    public void deckDisplayS() {
        Game game = new Game();
        game.initializeDeck(new String[] { "S", "P", "K", "Q", "U" }, 4);
        String testOutput = "/====\\  /====\\  \n| 1  |  | 2  |  \n\\====/  \\====/  \n\n/====\\  /====\\  \n| 3  |  | 4  |  \n\\====/  \\====/  \n"; 
        assertEquals("Deck display matches expected", testOutput.trim(), game.renderCards().trim());
    }
}