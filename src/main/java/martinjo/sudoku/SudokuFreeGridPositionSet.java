package martinjo.sudoku;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class SudokuFreeGridPositionSet {

    private final Set<SudokuGridPosition> positions;
    private SudokuBounds bounds;

    private SudokuFreeGridPositionSet(Set<SudokuGridPosition> positions, SudokuBounds bounds) {
        this.positions = positions;
        this.bounds = bounds;
    }

    public static SudokuFreeGridPositionSet fromAvailablePositions(Sudoku sudoku) {
        SudokuBounds bounds = sudoku.getBounds();

        Set<SudokuGridPosition> positions = new HashSet<>();
        for (int row : bounds.getIndexes()) {
            for (int col : bounds.getIndexes()) {
                if (row == 6 && col == 4 ) {
                    //hello
                    int y = 0;
                }
                if (sudoku.getValueAt(row, col) == 0) {
                    positions.add(new SudokuGridPosition(row, col));
                }
            }
        }
        return new SudokuFreeGridPositionSet(positions, bounds);
    }

    public boolean containsFreePosition(int row, int col) {
        bounds.checkSudokuBounds(row, col);
        return positions.stream().anyMatch(p -> p.getCol() == col && p.getRow() == row);
    }

    public void addFreePosition(int row, int col) {
        bounds.checkSudokuBounds(row, col);
        positions.add(new SudokuGridPosition(row, col));
    }

    public void removeFreePosition(int row, int col) {
        bounds.checkSudokuBounds(row, col);
        Iterator<SudokuGridPosition> it = positions.iterator();
        SudokuGridPosition currentPos;

        while (it.hasNext()) {
            currentPos = it.next();
            if (currentPos.getRow() == row && currentPos.getCol() == col) {
                it.remove();
                return;
            }
        }
    }

    public void removeFreeRowPositions(int row) {
        bounds.checkSudokuColBounds(row);

        for (int col : bounds.getIndexes()) {
            removeFreePosition(row, col);
        }
    }

    public void removeFreeColumPositions(int col) {
        bounds.checkSudokuColBounds(col);

        for (int row : bounds.getIndexes()) {
            removeFreePosition(row, col);
        }
    }

    public void removeFreeRegionPositions(int row, int col) {
        bounds.checkSudokuBounds(row, col);
        final int regionSize = bounds.getRegionSize();
        final int regionRow = (row / regionSize) * regionSize;
        final int regionCol = (col / regionSize) * regionSize;

        for (int offSetRow : bounds.getRegionIndexes()) {
            for (int offSetCol : bounds.getRegionIndexes()) {
                removeFreePosition(regionRow + offSetRow, regionCol + offSetCol);
            }
        }
    }

    public Set<SudokuGridPosition> getPositions() {
        return positions;
    }

    public Set<SudokuGridPosition> getAloneInRegionPositions() {
        Set<SudokuGridPosition> freePosInRegion = new HashSet<>();
        for (int regionRow : bounds.getRegionIndexes()) {
            for (int regionCol : bounds.getRegionIndexes()) {
                freePosInRegion.addAll(freePositionsInRegion(regionRow, regionCol));
            }
        }
        return freePosInRegion;
    }

    private Set<SudokuGridPosition> freePositionsInRegion(int regionRow, int regionCol) {
        Set<SudokuGridPosition> freePosInRegion = new HashSet<>();
        final int regionSize = bounds.getRegionSize();
        int offSetRow = regionRow * regionSize;
        int offsetCol = regionCol * regionSize;

        for (int row = offSetRow; row < regionSize + offSetRow; row++) {
            for (int col = offsetCol; col < regionSize + offsetCol; col++) {
                if (containsFreePosition(row, col)) {
                    freePosInRegion.add(new SudokuGridPosition(row, col));
                }
            }
        }
        if (freePosInRegion.size() == 1) {
            return freePosInRegion;
        }
        return new HashSet<>();
    }

    public void print() {
        for (int row : bounds.getIndexes()) {
            if (row != 0 && row % bounds.getRegionSize() == 0) {
                StringBuilder sb = new StringBuilder();
                final int regionSize = bounds.getRegionSize();
                String regionUnderline = "-".repeat(regionSize + regionSize);
                sb.append(regionUnderline);
                for (int i = 0; i < regionSize - 1; i++) {
                    sb.append("+");
                    sb.append(regionUnderline);
                }
                System.out.println(sb);
            }
            for (int col : bounds.getIndexes()) {
                if (col != 0 && col % bounds.getRegionSize() == 0) {
                    System.out.print("|");
                }
                if (containsFreePosition(row, col)) {
                    System.out.print("0 ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}