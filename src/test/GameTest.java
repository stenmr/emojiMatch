import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
    // https://stackoverflow.com/a/50721277
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void deckSize() {
        Deck deck = new Deck(new String[] { "S", "T" }, 4);

        assertEquals("Deck size is correct", deck.size(), 4);
    }

    @Test
    public void deckIndexing() {
        Deck deck = new Deck(new String[] { "Q" }, 2);

        assertEquals("Indexing is correct", deck.get(1), "Q");
    }

    @Test
    public void deckDisplayS() {
        final String exitString = "q";

        Game game = new Game();
        game.initializeDeck(new String[] { "S", "P", "K", "Q", "U" }, 10);
        game.start();
        provideInput(exitString);
        assertEquals("Deck display matches expected", "", getOutput());
    }
}