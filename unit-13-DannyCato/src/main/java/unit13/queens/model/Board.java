package unit13.queens.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Keeps track of the state of the board in the N-Queens problem. Primarily
 * focused on the queens that have been placed on the board.
 */
public class Board {
    /**
     * The size of the board (the number of rows and columns) as well as the
     * target number of queens to place on the board.
     */
    private final int n;

    /**
     * The queens that have been placed on the board.
     */
    private final Set<Queen> queens;

    /**
     * The observer to be notified whenever the board is updated.
     */
    private BoardObserver observer;

    /**
     * Creates a new, empty board with the specified size.
     * 
     * @param n The size of the board (the number of rows and columns) as well
     * as the target number of queens to place on the board.
     */
    public Board(int n) {
        this.n = n;
        this.queens = new HashSet<>();
    }

    /**
     * Returns the queens that have been placed on the board thus far.
     * 
     * @return An array of queens that have been placed on the board.
     */
    public Queen[] getQueens() {
        Queen[] array = new Queen[queens.size()];
        return queens.toArray(array);
    }

    /**
     * Returns true if the target number of queens has been placed on the
     * board.
     * 
     * @return True if the target number of queens has been placed on the 
     * board, and false otherwise.
     */
    public boolean isSolution() {
        return this.queens.size() == this.n;
    }

    /**
     * Removes all of the queens from the board.
     */
    public void clear() {
        queens.clear();
        boardUpdated();
    }

    /**
     * Adds an observer to the board to be notified whenever the board is
     * updated, i.e. a queen is placed on or removed from the board.
     * 
     * @param observer The observer to nofity if the board is updated.
     */
    public void setOnUpdate(BoardObserver observer) {
        this.observer = observer;
    }

    /**
     * Returns the status of the square at the specified location on the board.
     * 
     * @param row The row location of the square in question.
     * @param col The col location of the square in question.
     * 
     * @return One of the following states: Square.QUEEN if a queen has been
     * placed on the square, Square.ATTACKABLE if the square can be attacked
     * by one or more queens that have been placed on the board, or 
     * Square.EMPTY if the no queen has been played on the square and it is not
     * attackable.
     */
    public Square getSquare(int row, int col) {
        Queen queen = new Queen(row, col);
        if(queens.contains(queen)) {
            return Square.QUEEN;
        } else if(isAttackable(row, col)) {
            return Square.ATTACKABLE;
        } else {
            return Square.EMPTY;
        }
    }

    /**
     * Attempts to place a queen at the specified location on the board.
     * 
     * @param row The row at which the queen will be placed.
     * @param col The column at which the queen will be placed.
     * 
     * @return True if the queen is successfully placed on the board. False if
     * the queen cannot be placed because the square already has a queen on it,
     * or the square can be attacked by another queen.
     */
    public boolean placeQueen(int row, int col) {
        Queen queen = new Queen(row, col);
        boolean placed = placeQueen(queen);
        if(placed) {
            boardUpdated();
        }
        return placed;
    }

    /**
     * Attempts to place all of the queens in the specified array onto the 
     * board.
     * 
     * @param queens The array of queens to place on the board.
     * 
     * @return The number of queens that were successfully placed on the board.
     */
    public int placeQueens(Queen[] queens) {
        int placed = 0;
        for(Queen queen : queens) {
            placed += placeQueen(queen) ? 1 : 0;
        }
        if(placed > 0) {
            boardUpdated();
        }
        return placed;
    }

    /**
     * Attempts to remove the queen from the specified location on the board.
     * 
     * @param row The row from which the queen will be removed.
     * @param col The column from which the queen will be removed.
     * 
     * @return True if a queen was at the specified location and was removed
     * from the board. False if there was no queen at the specified location.
     */
    public boolean removeQueen(int row, int col) {
        boolean removed = false;
        Queen queen = new Queen(row, col);
        if(queens.contains(queen)) {
            queens.remove(queen);
            boardUpdated();
            removed = true;
        }
        return removed;
    }

    /**
     * If there is a queen at the specified location, it is removed. Otherwise,
     * an attempt is made to place a queen at the location.
     * 
     * @param row The row at which the queen should be toggled.
     * @param col The column at which the queen should be toggled.
     * 
     * @return True if a queen was added to or removed from the specified 
     * location.
     */
    public boolean toggleQueen(int row, int col) {
        Queen queen = new Queen(row, col);
        if(queens.contains(queen)) {
            return removeQueen(row, col);
        } else {
            return placeQueen(row, col);
        }
    }

    /**
     * Helper function that attempts to place the queen on the board. Does not 
     * notify observers.
     * 
     * @param queen The queen to place on the board.
     * 
     * @return True if the queen was successfully placed on the board. False
     * otherwise.
     */
    private boolean placeQueen(Queen queen) {
        boolean placed = false;
        if(!queens.contains(queen) 
            && !isAttackable(queen.getRow(), queen.getCol())) {
            queens.add(queen);
            placed = true;
        }
        return placed;
    }

    /**
     * Notifies the observer that the board has been updated (a queen has been
     * placed on or removed from the board).
     */
    private void boardUpdated() {
        if(observer != null) {
            observer.boardUpdated(this);
        }
    }

    /**
     * Returns true if the specified location can be attacked by at least one
     * queen.
     * 
     * @param row The row of the location in question.
     * @param col The column of the location in question.
     * 
     * @return True if the location can be attacked by at least one queen, and
     * false otherwise.
     */
    private boolean isAttackable(int row, int col) {
        for(Queen queen : queens) {
            if(queen.canAttack(row, col)) {
                return true;
            }
        }
        return false;
    }
    
}
