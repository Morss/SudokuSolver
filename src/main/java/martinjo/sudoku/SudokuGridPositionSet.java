package martinjo.sudoku;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class SudokuGridPositionSet {

	private final Set<SudokuGridPosition> positions;

	private SudokuGridPositionSet(Set<SudokuGridPosition> positions) {
		this.positions = positions;
	}

	public static SudokuGridPositionSet fromAvailablePositions(Sudoku sudoku) {
		Set<SudokuGridPosition> positions = new HashSet<>();
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (sudoku.getValueAt(row, col) != 0) {
					positions.add(new SudokuGridPosition(row, col));
				}
			}
		}
		return new SudokuGridPositionSet(positions);
	}

	public boolean containsPosition(int row, int col) {
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

	public void addPosition(int row, int col) {
		SudokuBounds.checkSudokuBounds(row, col);
		positions.add(new SudokuGridPosition(row, col));
	}

	public void removePosition(int row, int col) {
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

	public void removeRowPositions(int row) {
		SudokuBounds.checkSudokuColBounds(row);

		for (int col = 0; col < 9; col++) {
			removePosition(row, col);
		}
	}
	
	public void removeColumPositions(int col) {
		SudokuBounds.checkSudokuColBounds(col);

		for (int row = 0; row < 9; row++) {
			removePosition(row, col);
		}
	}
	
	public void removeQuadPositions(int row, int col) {
		SudokuBounds.checkSudokuBounds(row, col);
		final int quadrantRow = (row / 3) * 3;
		final int quadrantCol = (col / 3) * 3;
		
		for (int offSetRow = 0; offSetRow < 3; offSetRow++) {
			for (int offSetCol = 0; offSetCol < 3; offSetCol++) {
				removePosition(quadrantRow + offSetRow, quadrantCol + offSetCol);
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
				if (containsPosition(row, col)) {
					System.out.print("x ");
				}
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
}