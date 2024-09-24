package unit12.guessing;

/**
 * Implements a simple guessing game. During each round a random number
 * between 1 and 100 is picked. The player is given 6 chances to guess the
 * number. Each time the player guesses, they are given feedback indicating
 * whether the guess was {@link GuessResult#CORRECT correct},
 * {@link GuessResult#TOO_LOW too low}, {@link GuessResult#TOO_HIGH too high},
 * or that they have {@link GuessResult#OUT_OF_GUESSES run out of guesses}.
 */
public interface GuessingGame {
    /**
     * The maximum number of guesses that the player gets each game.
     */
    public static int MAX_GUESSES = 6;

    /**
     * Starts a new guessing game. A random number between 1 and 100 is
     * generated and the number of guesses is reset to {@link #MAX_GUESSES}.
     */
    public void restart();

    /**
     * Called when the player would like to make a guess.
     *
     * @param number The number that the player is guessing.
     * @return The {@link GuessResult result} of the player's guess. May be
     *         {@link GuessResult#CORRECT correct},
     *         {@link GuessResult#TOO_LOW too low},
     *         {@link GuessResult#TOO_HIGH too high},
     *         or indicate that they have
     *         {@link GuessResult#OUT_OF_GUESSES run out of guesses}.
     *
     */
    public GuessResult guess(int number);

    /**
     * Called to clean up any resources that are being used before ending the
     * game. OPTIONAL.
     */
    public void quit();
}
