import java.util.Arrays;
import java.util.Scanner;

/**
 * Game
 */
public class Game implements Actions {
    private String[] placeholders = new String[] { "1️⃣", "2️⃣", "3️⃣", "4️⃣", "5️⃣", "6️⃣", "7️⃣", "8️⃣", "9️⃣",
            "🔟" };
    private Deck deck;
    private Boolean[] cardStates;
    public Boolean running = false;

    @Override
    public void flipTwo(int[] indices) {

    }

    @Override
    public Deck initializeDeck(String[] faces, int cards) {
        Deck deck = new Deck(faces, cards);
        this.deck = deck;
        return deck;
    }

    @Override
    public Boolean[] initializeFlip(Deck deck) {
        Boolean[] booleans = new Boolean[deck.size()];
        Arrays.fill(booleans, false);
        this.cardStates = booleans;

        return booleans;
    }

    @Override
    public void start() {
        renderCards();
        running = true;
        Scanner input = new Scanner(System.in);
        System.out.println("sisesta kaks tühikuga eraldatud arvu.\nleia klappivad kaardid.");
        while (running) {
            String move = input.nextLine();
            String[] split = move.split(" ");
            int[] numbers = { Integer.parseInt(split[0]), Integer.parseInt(split[1]) };
            flipTwo(numbers);
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

        input.close();
    }

    private String renderCards() {

        StringBuilder output = new StringBuilder();

        int deckSize = deck.size();
        int row = deckSize / 2;
        for (int i = 0; i < row; i++) {
            output.append("/====\\  ");
        }
        output.append("\n");
        for (int i = 0; i < row; i++) {
            output.append("| " + placeholders[i] + "  |  ");
        }
        output.append("\n");
        for (int i = 0; i < row; i++) {
            output.append("\\====/  ");
        }

        if (row < 2) {
            return output.toString();
        }
        output.append("\n\n");

        for (int i = row; i < deckSize; i++) {
            output.append("/====\\  ");
        }
        output.append("\n");
        for (int i = row; i < deckSize; i++) {
            output.append("| " + placeholders[i] + "  |  ");
        }
        output.append("\n");
        for (int i = row; i < deckSize; i++) {
            output.append("\\====/  ");
        }

        return output.toString();
    }
}