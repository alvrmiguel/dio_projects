package dio.projects.hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordBank {
    private static final List<String> WORDS = Arrays.asList(
            "JAVA", "PROGRAMACAO", "ORIENTACAO", "OBJETOS", "FORCA"
    );

    public static String getRandomWord() {
        Random rand = new Random();
        return WORDS.get(rand.nextInt(WORDS.size()));
    }
}
