import java.util.Arrays;
import java.util.Scanner;

/**
 * Game
 */
public class Game implements Actions {
    private String[] placeholders = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private Deck deck;
    // 0 on placeholder, 1 on kaardi nägu hetkeks, 2 on kaardi nägu aga lahendatud
    private int[] cardStates;
    public Boolean running = false;
    private int score = 0;

    @Override
    public void flipTwo(int[] indices) {
        if (deck.get(indices[0]).equals(deck.get(indices[1]))
                && (cardStates[indices[0]] != 2 || cardStates[indices[1]] != 2)) {
            cardStates[indices[0]] = 2;
            cardStates[indices[1]] = 2;
            score += 2;
        } else {
            cardStates[indices[0]] = 1;
            cardStates[indices[1]] = 1;
        }
    }

    private void resetMismatchedCards() {
        for (int i = 0; i < cardStates.length; i++) {
            if (cardStates[i] == 1) {
                cardStates[i] = 0;
            }
        }
    }

    @Override
    public Deck initializeDeck(String[] faces, int cards) {
        Deck deck = new Deck(faces, cards);
        this.deck = deck;
        initializeCardStates();
        return deck;
    }

    private void initializeCardStates() {
        int[] states = new int[deck.size()];
        Arrays.fill(states, 0);
        this.cardStates = states;
    }

    @Override
    public void start() {
        deck.shuffleDeck();
        running = true;
        Scanner input = new Scanner(System.in);
        System.out.println("sisesta kaks tühikuga eraldatud arvu.\nleia klappivad kaardid.\n'q' lõpetab mängu.");
        while (running) {
            System.out.println(renderCards());
            String move = input.nextLine();

            // Q lõpetab mängu
            if (move == "q" || move == "Q") {
                running = false;
            }

            String[] split = move.split(" ");
            int[] numbers = { Integer.parseInt(split[0]) - 1, Integer.parseInt(split[1]) - 1 };

            // Keerame kaks kaarti ümber ja renderdame 2 sekundiks
            flipTwo(numbers);
            System.out.println(renderCards());

            if (score == deck.size() / 2) {
                System.out.println("võit!");
                running = false;
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            resetMismatchedCards();

            System.out.print("\033[H\033[2J");
            System.out.flush();
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
            if (cardStates[i] != 0) {
                output.append("| " + deck.get(i) + "  |  ");
            } else {
                output.append("| " + placeholders[i] + "  |  ");
            }
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
            if (cardStates[i] != 0) {
                output.append("| " + deck.get(i) + "  |  ");
            } else {
                output.append("| " + placeholders[i] + "  |  ");
            }
        }
        output.append("\n");
        for (int i = row; i < deckSize; i++) {
            output.append("\\====/  ");
        }
        output.append("\n");

        return output.toString();
    }
}