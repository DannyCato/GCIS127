package unit13.queens.model;

/**
 * Used to indicate the status of a square on the board in the N-Queens problem.
 */
public enum Square {
        EMPTY,       // the square is empty
        QUEEN,       // a queen is played on the square
        ATTACKABLE;  // the square can be attacked by at least one queen
}
