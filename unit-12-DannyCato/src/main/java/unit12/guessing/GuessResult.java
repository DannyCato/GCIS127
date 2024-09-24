package unit12.guessing;

/**
 * The possible results of making a guess.
 */
public enum GuessResult {
    /**
     * The guess is correct.
     */
    CORRECT,

    /**
     * The guess is too low.
     */
    TOO_LOW,

    /**
     * The guess is too high.
     */
    TOO_HIGH,

    /**
     * The player is out of guesses.
     */
    OUT_OF_GUESSES
}
