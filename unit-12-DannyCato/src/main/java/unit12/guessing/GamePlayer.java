package unit12.guessing;

import java.util.Scanner;

/**
 * A class that provides a simple command line interface to play a
 * {@link GuessingGame}.
 */
public class GamePlayer {
    /**
     * The {@link GuessingGame} being used to play the game.
     */
    private final GuessingGame game;

    /**
     * Creates a new {@Link GamePlayer} that uses the specified
     * {@link GuessingGame}.
     *
     * @param game The game to use when playing.
     */
    public GamePlayer(GuessingGame game) {
        this.game = game;
    }

    /**
     * Starts a game play loop. The player is prompted to enter a command,
     * and the command is interpreted. The player may quit at any time, and
     * the loop is terminated.
     */
    public void playTheGame() {
        Scanner scanner = new Scanner(System.in);
        // a sentinel boolean used to control the play loop; play continues
        // as long as the boolean is not set to false (i.e. when the user
        // opts to quit).
        boolean sentinel = true;
        while (sentinel) {
            System.out.print("Enter a command (help to list commands): ");
            String commandLine = scanner.nextLine();
            String[] tokens = commandLine.split(" ");

            if (tokens.length == 0) {
                System.err.println("You must enter a command.");
                continue;
            }

            switch (tokens[0]) {
                case "help":
                    help();
                    break;
                case "restart":
                    restart();
                    break;
                case "guess":
                    guess(tokens);
                    break;
                case "quit":
                    sentinel = !quit(scanner);
                    break;
                default:
                    System.err.println("Unrecognized command.");
                    break;
            }
        }

        System.out.println("Thanks for playing!");
    }

    /**
     * Prints a help message.
     */
    private static void help() {
        System.out.println("Available commands: ");
        System.out.println("  help - displays this message");
        System.out.println("  restart - starts a new game");
        System.out.println("  guess # - makes a guess");
        System.out.println("  quit - quits the game");
        System.out.println();
    }

    /**
     * Prompts the user to confirm that they would like to quit the game.
     *
     * @param scanner The scanner used to read the user's input.
     *
     * @return True if the user opted to quite the game; false otherwise.
     */
    private boolean quit(Scanner scanner) {
        System.out.print("Are you sure (Y/N)? ");
        String response = scanner.nextLine();
        boolean shouldQuit = response.equalsIgnoreCase("y");
        if (shouldQuit) {
            game.quit();
        }
        return shouldQuit;
    }

    /**
     * Starts a new game.
     */
    private void restart() {
        game.restart();
    }

    /**
     * Attempts to make a guess on behalf of the user. Prints an error message
     * if the user enters the wrong number of tokens or a non-numeric guess.
     *
     * @param tokens The tokenized user input.
     */
    private void guess(String[] tokens) {
        if (tokens.length != 2) {
            System.err.println("You must indicate exactly one number to " +
                    "guess.");
        } else {
            try {
                int number = Integer.parseInt(tokens[1]);
                GuessResult result = game.guess(number);
                switch (result) {
                    case CORRECT:
                        System.out.println("Your guess was correct!");
                        break;
                    case TOO_LOW:
                        System.out.println("Your guess is too low.");
                        break;
                    case TOO_HIGH:
                        System.out.println("You guess was too high.");
                        break;
                    case OUT_OF_GUESSES:
                        System.out.println("You are out of guesses!");
                        break;
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Your guess must be an integer.");
            }
        }
    }
}
