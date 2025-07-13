package dio.projects.hangman;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private String secretWord;
    private Set<Character> guessedLetters = new HashSet<>();
    private int maxErrors = 10;
    private int errors = 0;
    private GameState state = GameState.PLAYING;

    public Game() {
        this.secretWord = WordBank.getRandomWord();
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (state == GameState.PLAYING) {
            display();
            System.out.print("Digite uma letra: ");
            String input = scanner.nextLine().toUpperCase();

            try {
                if (input.length() != 1) {
                    throw new GameException("Digite apenas uma letra!");
                }
                char letter = input.charAt(0);
                if (guessedLetters.contains(letter)) {
                    throw new GameException("Você já tentou essa letra!");
                }

                guessedLetters.add(letter);
                if (secretWord.indexOf(letter) == -1) {
                    errors++;
                }

                if (errors >= maxErrors) {
                    state = GameState.LOST;
                } else if (isWordGuessed()) {
                    state = GameState.WON;
                }

            } catch (GameException e) {
                System.out.println(e.getMessage());
            }
        }

        display();
        if (state == GameState.WON) {
            System.out.println("Parabéns! Você ganhou!");
        } else {
            System.out.println("Você perdeu! A palavra era: " + secretWord);
        }
    }

    private boolean isWordGuessed() {
        for (char c : secretWord.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    private void display() {
        System.out.println("\nForca: " + errors + "/" + maxErrors);
        for (char c : secretWord.toCharArray()) {
            if (guessedLetters.contains(c)) {
                System.out.print(c + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println("\nLetras usadas: " + guessedLetters);
    }
}
