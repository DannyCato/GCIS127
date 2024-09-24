package unit13.queens.model;

/**
 * Interface implemented by a class that should be notified when the N-Queens
 * board has been upddated, i.e. at least one queen has been placed on or
 * removed from the board.
 */
public interface BoardObserver {
    /**
     * Called on a registered observer when at least one queen has been placed
     * on or removed from the board.
     * 
     * @param board The board on which the queen was placed or from which it
     * was removed.
     */
    void boardUpdated(Board board);
}
