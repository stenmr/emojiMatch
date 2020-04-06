import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {

    ArrayList<String> deck = new ArrayList<String>();
    
    private static Random random = new Random();

    //
    public Deck(String[] faces, int cards) {
        ArrayList<String> facesList = new ArrayList<String>(Arrays.asList(faces));

        if (cards > faces.length * 2) {
            System.out.println("Amount of faces must be equal to or above the amount of cards");
            return;
        } else if (cards % 2 != 0) {
            System.out.println("Amount of cards must be an even number");
            return;
        }

        for (int i = 0; i < cards / 2; i++) {
            int randomNumber = random.nextInt(facesList.size());
            String face = facesList.get(randomNumber);
            facesList.remove(randomNumber);

            deck.add(face);
        }

        // Doubling array to have 2 of each card
        deck.addAll(deck);
    }

    // Fisher-Yates
    // https://stackoverflow.com/a/18456998
    public void shuffleDeck() {
        int index;
        String temp;
        for (int i = deck.size() - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = deck.get(index);
            deck.set(index, deck.get(i));
            deck.set(i, temp);
        }
    }

    public int size() {
        return deck.size();
    }

    public String get(int index) {
        return deck.get(index);
    }
}