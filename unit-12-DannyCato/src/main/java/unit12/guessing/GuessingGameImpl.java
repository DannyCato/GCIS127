package unit12.guessing;

import java.util.Random;

/**
 * A simple, local implementation of the {@link GuessingGame}.
 */
public class GuessingGameImpl implements GuessingGame {
    /**
     * The {@link Random} number generator used to pick a number to guess.
     */
    private static final Random RNG = new Random();

    /**
     * The number of guesses that the player has left.
     */
    private int guessesLeft;

    /**
     * The number to guess.
     */
    private int numberToGuess;

    public GuessingGameImpl() {
        restart();
    }

    @Override
    public void restart() {
        // generate a random number 1-100
        numberToGuess = RNG.nextInt(100) + 1;
        guessesLeft = MAX_GUESSES;
    }

    @Override
    public GuessResult guess(int number) {
        if (guessesLeft == 0) {
            return GuessResult.OUT_OF_GUESSES;
        } else if (number == numberToGuess) {
            return GuessResult.CORRECT;
        } else {
            guessesLeft--;
            return number < numberToGuess ? GuessResult.TOO_LOW : GuessResult.TOO_HIGH;
        }
    }

    /**
     * Has no real effect on the game.
     */
    @Override
    public void quit() {

    }
}
