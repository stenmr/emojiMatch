import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {

    @Test
    public void test() {

        Deck deck = new Deck(new String[] {"S", "T"}, 4);

        assertEquals("Deck size is 4: ", deck.size(), 4);
    }
}