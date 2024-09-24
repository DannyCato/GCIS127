package unit13.queens.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import unit13.backtracker.Configuration;

public class NQueens implements Configuration<NQueens> {
    private Queen[] queens;
    private int size;

    public NQueens(int size) {
        this(size, new Queen[0]);
    }

    public NQueens(int boardSize, Queen[] queens) {
        this.queens = queens;
        this.size = boardSize;
    }

    public static void main(String[] args) {
        NQueens nq = new NQueens(4);
        System.out.println(nq.toString());
        Collection<NQueens> nQqueens = nq.getSuccessors();
        for (NQueens n : nQqueens) {
            System.out.println(n);
            System.out.println(n.isValid());
        }
    }

    @Override
    public Collection<NQueens> getSuccessors() {
        List<NQueens> successors = new ArrayList<>();
        int length = queens.length;
        int row = (length > 0) ? queens[length-1].getRow() + 1 : 0;
        if (row < size) {
            for (int col = 0; col < size; col++) {
                Queen[] copy = Arrays.copyOf(queens, length + 1);
                copy[length] = new Queen(row, col);
                successors.add(new NQueens(size, copy));
            }
        } 
        return successors;
    }

    @Override
    public boolean isValid() {
        int length = queens.length;
        if (length < 2) {
            return true;
        }
        Queen last = queens[length - 1]; 
        for (int i = 0; i < length - 1; i++) {
            if (last.canAttack(queens[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isGoal() {
        return queens.length >= size && isValid();
    }

    public Queen[] getQueens() {
        return queens;
    }
    
    @Override
    public String toString() {
        String[][] ans = new String[size + 1][size + 1];
        for (int row = 1; row < size + 1; row++) {
            ans[row][0] = "" + row;
        }
        for (int col = 1; col < size + 1; col++) {
            ans[0][col] = "" + col;
        }

        for (Queen q : queens) {
            ans[q.getRow() + 1][q.getCol() + 1] = "Q";
        }
        
        String str = "";
        for (String[] row : ans) {
            for (String col : row) {
                if (col == null) {
                    str += "  ";
                } else {
                    str += col + " ";
                }
            }
            str += "\n";
        }
        return str;
    }
}
