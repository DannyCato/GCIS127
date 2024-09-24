package unit13.assignment2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Implements a simple game of Hangman.
 * 
 * @author GCCIS Faculty
 */
public class Hangman {
    /**
     * The status of the game.
     */
    public enum Status {
        IN_PROGRESS,
        LOST,
        WON
    }

    public static final int MAX_WRONG = 5;

    /**
     * Used as banked out letters in a secret phrase.
     */
    private static final char BLANK = '_';

    /**
     * The secret phrase.
     */
    private final String secret;

    /**
     * The characters guessed so far (all uppercase).
     */
    private final Set<Character> guesses;

    /**
     * The string of uppercase guessed characters.
     */
    private String guessesString;

    /**
     * The secret phrase with any revealed letters or symbols.
     */
    private final StringBuilder revealed;

    /**
     * The number of wrong guesses so far.
     */
    private int wrongGuesses;

    /**
     * The status of the game.
     */
    private Status status;

    /**
     * Creates a hangman puzzle with the specified secret phrase.
     * @param secret The secret phrase to guess.
     */
    public Hangman(String secret) {
        this.secret = secret;
        this.guesses = new HashSet<>();
        guessesString = "";
        this.revealed = new StringBuilder();
        for(char c : secret.toCharArray()) {
            
            if(Character.isAlphabetic(c)) {
                revealed.append(BLANK);
            } else {
                revealed.append(c);
            }
        }
        this.wrongGuesses = 0;
        this.status = Status.IN_PROGRESS;
    }

    /**
     * Creates a deep copy of another Hangman object.
     * 
     * @param original The original object to copy.
     */
    public Hangman(Hangman original) {
        this.secret = original.secret;
        this.guesses = new HashSet<>();
        this.guesses.addAll(original.guesses);
        this.guessesString = original.guessesString;
        this.revealed = new StringBuilder(original.revealed());
        this.wrongGuesses = original.wrongGuesses;
        this.status = original.status;
    }

    /**
     * Guesses a character if the game is not over and the character has not
     * been guessed before.
     * 
     * @param c The character to guess.
     * @return True if the guess was made, and false otherwise.
     */
    public boolean guess(char c) {
        char uc = Character.toUpperCase(c);
        if(status != Status.IN_PROGRESS || guesses.contains(uc)) {
            // no guess is made
            return false;
        } else {
            guesses.add(uc);
            guessesString = guesses.size() == 1 ? 
                Character.toString(uc) : guessesString + " " + uc;

            int count = 0;
            for(int i=0; i<secret.length(); i++) {
                char s = secret.charAt(i);
                char us = Character.toUpperCase(s);
                if(us == uc) {
                    count++;
                    revealed.setCharAt(i, s);
                }
            }
            // if none of the letters match, increment wrong guesses
            wrongGuesses = count > 0 ? wrongGuesses : wrongGuesses + 1;

            if(wrongGuesses > MAX_WRONG) {
                status = Status.LOST;
            } else if(secret.equals(revealed())) {
                status = Status.WON;
            }

            // guess was made
            return true;
        }
    }

    public String getGuesses() {
        return guessesString;
    }

    public Status getStatus() {
        return status;
    }

    public String revealed() {
        return revealed.toString();
    }

    public int getWrongGuesses() {
        return wrongGuesses;
    }

    public static void main(String[] args) {
        Hangman hangman = new Hangman("Humpty Dumpty sat on a wall.");

        Scanner scanner = new Scanner(System.in);
        while(hangman.getStatus() == Status.IN_PROGRESS) {
            System.out.println(hangman.revealed());
            System.out.println("  letters guessed: " + hangman.getGuesses());
            System.out.println("  wrong guesses: " + hangman.getWrongGuesses());
            System.out.print("guess a letter >> ");
            char guess = scanner.next().charAt(0);
            if(!hangman.guess(guess)) {
                System.out.println("  Duplicate guess! Try again.");
            }
        }
        System.out.println(hangman.revealed());
        if(hangman.getStatus() == Status.WON) {
            System.out.println("Congratulations! You won!");
        } else {
            System.out.println("Too bad! You lost!");
        }
        scanner.close();
    }
}
