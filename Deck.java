import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Deck {
    String[] deck;
    static Random random = new Random();

    //
    public Deck(String[] faces, int cards) throws Exception {

        int cap = faces.length;
        ArrayList<String> facesList = new ArrayList<String>(Arrays.asList(faces));

        if (cards < faces.length) {
            throw new Exception("Amount of faces must be equal to or above the amount of cards");
        } else if (cards % 2 != 0) {
            throw new Exception("Amount of cards must be an even number");
        }

        for (int i = 0; i < cards / 2; i++) {
            deck[i] = facesList.remove(random.nextInt(cap));
        }
    }

    // Fisher-Yates-i algoritm
    // https://stackoverflow.com/a/18456998
    private static void shuffleDeck(String[] deck) {
        int index;
        String temp;
        for (int i = deck.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = deck[index];
            deck[index] = deck[i];
            deck[i] = temp;
        }
    }
}