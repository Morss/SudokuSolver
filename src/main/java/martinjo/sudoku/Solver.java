package martinjo.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class Solver {

	private final static List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	private Sudoku sudoku;

	public Solver(Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	public void solve() {
		int count = 1;
		while (solverLoop()) {
			System.out.println("Iterations: " + count);
			count++;
		}
		System.out.println();
		sudoku.print();
	}

	private boolean solverLoop() {
		boolean solvedSomething = false;
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (sudoku.getValueAt(row, col) != 0) {
					continue;
				}
				Set<Integer> remainingOptions = eliminateByRowColQuad(row, col);
				if (remainingOptions.size() == 1) {
					solvedSomething = true;
					sudoku.setValueAt(row, col, remainingOptions.stream().findFirst().orElse(null));
				}
			}
		}

		for (int num : NUMBERS) {
			SudokuFreeGridPositionSet posset = SudokuFreeGridPositionSet.fromAvailablePositions(sudoku);
			for (int row = 0; row < 9; row++) {
				for (int col = 0; col < 9; col++) {
					if (sudoku.getValueAt(row, col) == num) {
						posset.removeFreeRowPositions(row);
						posset.removeFreeColumPositions(col);
						posset.removeFreeQuadPositions(row, col);
					}
				}
			}
			Set<SudokuGridPosition> aloneInQuad = posset.getAloneInQuadPositions();
			if (aloneInQuad.size() > 0) {
				solvedSomething = true;
				aloneInQuad.forEach(p -> sudoku.setValueAt(p.getRow(), p.getCol(), num));
			}
		}

		return solvedSomething;
	}
	
	/**
	 * Eliminate all the numbers that are not possible b/c they are already in the row, col or quad.
	 */
	private Set<Integer> eliminateByRowColQuad(int row, int col) {
		Set<Integer> options = allNumbersAvailable();
		// Row
		for (int i = 0; i < 9; i++) {
			options.remove(sudoku.getValueAt(row, i));
		}

		// Column
		for (int i = 0; i < 9; i++) {
			options.remove(sudoku.getValueAt(i, col));
		}

		// Box
		quadrantIterator(row, col).forEachRemaining(options::remove);

		return options;
	}

	private Iterator<Integer> quadrantIterator(int row, int col) {
		final int quadrantRow = (row / 3) * 3;
		final int quadrantCol = (col / 3) * 3;

		return new Iterator<Integer>() {
			int offSetRow = 0;
			int offSetCol = 0;

			@Override
			public boolean hasNext() {
				return (offSetCol < 3 && offSetRow < 3);
			}

			@Override
			public Integer next() {
				if (!hasNext()) {
					throw new RuntimeException();
				}
				int next = sudoku.getValueAt(quadrantRow + offSetRow, quadrantCol + offSetCol);
				offSetRow ++;
				if (offSetRow >= 3) {
					offSetRow = 0;
					offSetCol++;
				}
				return next;
			}
		};
	}

	private Set<Integer> allNumbersAvailable() {
		return new HashSet<Integer>(NUMBERS);
	}
}
