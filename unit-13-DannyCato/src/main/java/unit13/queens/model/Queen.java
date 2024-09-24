package unit13.queens.model;

/**
 * Represents a Queen in the N-Queens problem. Essentially a row, column 
 * location on the board and some utility functions.
 */
public class Queen {
    /**
     * The row at which the queen has been placed on the board.
     */
    private final int row;

    /**
     * The column at which the queen has been placed on the board.
     */
    private final int col;

    /**
     * A string representation of the queen, suitable for printing to standard
     * output.
     */
    private final String string;

    /**
     * The hash code for the queen.
     */
    private final int hashCode;

    /**
     * Creates a new Queen at the specified location.
     * 
     * @param row The row at which the queen has been placed on the board.
     * @param col The column at which the queen has been placed on the board.
     */
    public Queen(int row, int col) {
        this.row = row;
        this.col = col;
        this.string = "Queen{row=" + row + ", col=" + col + "}";
        this.hashCode = string.hashCode();
    }

    /**
     * Returns the row at which the queen has been placed on the board.
     * 
     * @return The queen's row.
     */
    public int getRow() {
        return row;
    }


    /**
     * Returns the column at which the queen has been placed on the board.
     * 
     * @return The queen's column.
     */
    public int getCol() {
        return col;
    }

    /**
     * Returns true if this queen can attack the enemy queen, meaning that
     * they are aligned along the same row, column, or diagonal.
     * 
     * @param enemy The enemy queen.
     * 
     * @return True if this queen can attack the enemy queen (and vice versa).
     */
    public boolean canAttack(Queen enemy) {
        return canAttack(enemy.row, enemy.col);
    }

    /**
     * Returns true if the queen can attack the specified location, meaning
     * that it is aligned along the same row, column, or diagonal as the queen.
     * 
     * @param row The row of the location being checked.
     * @param col The column of the location being checked.
     * 
     * @return True if the queen can attack the specified location.
     */
    public boolean canAttack(int row, int col) {
        int rowDelta = this.row - row;
        int colDelta = this.col - col;

        return rowDelta == 0 
            || colDelta == 0
            || rowDelta == colDelta
            || rowDelta == -colDelta;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Queen) {
            Queen other = (Queen)obj;
            return this.row == other.row && this.col == other.col;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public String toString() {
        return string;
    }
    
}
