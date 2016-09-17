package martinjo.sudoku;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class SudokuFreeGridPositionSet {

	private final Set<SudokuGridPosition> positions;

	private SudokuFreeGridPositionSet(Set<SudokuGridPosition> positions) {
		this.positions = positions;
	}

	public static SudokuFreeGridPositionSet fromAvailablePositions(Sudoku sudoku) {
		Set<SudokuGridPosition> positions = new HashSet<>();
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (sudoku.getValueAt(row, col) == 0) {
					positions.add(new SudokuGridPosition(row, col));
				}
			}
		}
		return new SudokuFreeGridPositionSet(positions);
	}

	public boolean containsFreePosition(int row, int col) {
		SudokuBounds.checkSudokuBounds(row, col);
		Iterator<SudokuGridPosition> it = positions.iterator();
		SudokuGridPosition currentPos;

		while (it.hasNext()) {
			currentPos = it.next();
			if (currentPos.getRow() == row && currentPos.getCol() == col) {
				return true;
			}
		}
		return false;
	}

	public void addFreePosition(int row, int col) {
		SudokuBounds.checkSudokuBounds(row, col);
		positions.add(new SudokuGridPosition(row, col));
	}

	public void removeFreePosition(int row, int col) {
		SudokuBounds.checkSudokuBounds(row, col);
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
		SudokuBounds.checkSudokuColBounds(row);

		for (int col = 0; col < 9; col++) {
			removeFreePosition(row, col);
		}
	}
	
	public void removeFreeColumPositions(int col) {
		SudokuBounds.checkSudokuColBounds(col);

		for (int row = 0; row < 9; row++) {
			removeFreePosition(row, col);
		}
	}
	
	public void removeFreeQuadPositions(int row, int col) {
		SudokuBounds.checkSudokuBounds(row, col);
		final int quadrantRow = (row / 3) * 3;
		final int quadrantCol = (col / 3) * 3;
		
		for (int offSetRow = 0; offSetRow < 3; offSetRow++) {
			for (int offSetCol = 0; offSetCol < 3; offSetCol++) {
				removeFreePosition(quadrantRow + offSetRow, quadrantCol + offSetCol);
			}
		}
	}

	public Set<SudokuGridPosition> getPositions() {
		return positions;
	}

	public void print() {
		for (int row = 0; row < 9; row++) {
			if (row != 0 && row % 3 == 0) {
				System.out.println("------+------+------");
			}
			for (int col = 0; col < 9; col++) {
				if (col != 0 && col % 3 == 0) {
					System.out.print("|");
				}
				if (containsFreePosition(row, col)) {
					System.out.print("0 ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}