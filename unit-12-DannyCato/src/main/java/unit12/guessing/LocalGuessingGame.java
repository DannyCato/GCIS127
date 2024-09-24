package unit12.guessing;

/**
 * Plays a local guessing game (no network).
 */
public class LocalGuessingGame {
    /**
     * Creates and runs a local version of the guessing game (no network).
     *
     * @param args Ignored.
     */
    public static void main(String[] args) {
        // make a guessing game
        GuessingGame game = new GuessingGameImpl();
        // use a game player to play it
        GamePlayer player = new GamePlayer(game);
        player.playTheGame();
    }
}
