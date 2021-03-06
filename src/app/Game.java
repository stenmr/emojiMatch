import java.util.Arrays;
import java.util.Scanner;

/**
 * Game
 */
public class Game {
    private String[] placeholders = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
    private Deck deck;
    // 0 on placeholder, 1 on kaardi nägu hetkeks, 2 on kaardi nägu aga lahendatud
    private int[] cardStates;
    public Boolean running = false;
    private int score = 0;

    public Boolean flipTwo(int[] indices) {
        if (cardStates[indices[0]] == 2 || cardStates[indices[1]] == 2) {
            return false;
        }

        if (deck.get(indices[0]).equals(deck.get(indices[1]))) {
            cardStates[indices[0]] = 2;
            cardStates[indices[1]] = 2;
            score += 2;
            return true;
        } else {
            cardStates[indices[0]] = 1;
            cardStates[indices[1]] = 1;
            return true;
        }
    }

    private void resetMismatchedCards() {
        for (int i = 0; i < cardStates.length; i++) {
            if (cardStates[i] == 1) {
                cardStates[i] = 0;
            }
        }
    }

    public Deck initializeDeck(String[] faces, int cards) {
        Deck deck = new Deck(faces, cards);
        this.deck = deck;
        initializeCardStates();
        deck.shuffleDeck();
        return deck;
    }

    private void initializeCardStates() {
        int[] states = new int[deck.size()];
        Arrays.fill(states, 0);
        this.cardStates = states;
    }

    public void start() {
        running = true;
        Scanner input = new Scanner(System.in);
        System.out.println("sisesta kaks tühikuga eraldatud arvu.\nleia klappivad kaardid.\n'q' lõpetab mängu.");
        while (running) {
            System.out.println(renderCards());
            String move = input.nextLine();

            // Q lõpetab mängu
            if (move.toLowerCase().equals("q")) {
                running = false;
                break;
            }

            String[] split = move.split(" ");
            int[] indices = { Integer.parseInt(split[0]) - 1, Integer.parseInt(split[1]) - 1 };

            gameLoop(indices);
        }

        input.close();
    }

    public void gameLoop(int[] indices) {
        // Keerame kaks kaarti ümber ja renderdame 2 sekundiks
        Boolean status = flipTwo(indices);

        if (!status) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("vali numbritega kaarte!");
            return;
        }

        System.out.println(renderCards());

        if (score == deck.size()) {
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

    public String renderCards() {

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