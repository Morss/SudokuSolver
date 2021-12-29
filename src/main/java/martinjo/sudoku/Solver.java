package martinjo.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class Solver {

	private final static List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private final Sudoku9x9 sudoku;
    private final SudokuBounds bounds;

    public Solver(Sudoku9x9 sudoku) {
		this.sudoku = sudoku;
        bounds = sudoku.getBounds();
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
		for (int row : bounds.getIndexes()) {
			for (int col : bounds.getIndexes()) {
				if (sudoku.getValueAt(row, col) != 0) {
					continue;
				}
				Set<Integer> remainingOptions = eliminateByRowColReg(row, col);
				if (remainingOptions.size() == 1) {
					solvedSomething = true;
					sudoku.setValueAt(row, col, remainingOptions.stream().findFirst()
                            .orElseThrow(() -> new IllegalStateException("Not solved!")));
				}
			}
		}

		for (int num : NUMBERS) {
			SudokuFreeGridPositionSet posset = SudokuFreeGridPositionSet.fromAvailablePositions(sudoku);
            for (int row : bounds.getIndexes()) {
                for (int col : bounds.getIndexes()) {
					if (sudoku.getValueAt(row, col) == num) {
						posset.removeFreeRowPositions(row);
						posset.removeFreeColumPositions(col);
						posset.removeFreeRegionPositions(row, col);
					}
				}
			}
			Set<SudokuGridPosition> aloneInRegion = posset.getAloneInRegionPositions();
			if (aloneInRegion.size() > 0) {
				solvedSomething = true;
				aloneInRegion.forEach(p -> sudoku.setValueAt(p.getRow(), p.getCol(), num));
			}
		}

		return solvedSomething;
	}
	
	/**
	 * Eliminate all the numbers that are not possible b/c they are already in the row, col or region.
	 */
	private Set<Integer> eliminateByRowColReg(int row, int col) {
		Set<Integer> options = allNumbersAvailable();
		// Row
		for (int i : bounds.getIndexes()) {
			options.remove(sudoku.getValueAt(row, i));
		}

		// Column
		for (int i : bounds.getIndexes()) {
			options.remove(sudoku.getValueAt(i, col));
		}

		// Region
		regionIterator(row, col).forEachRemaining(options::remove);

		return options;
	}

	private Iterator<Integer> regionIterator(int row, int col) {
		final int regionRow = (row / 3) * 3;
		final int regionCol = (col / 3) * 3;

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
				int next = sudoku.getValueAt(regionRow + offSetRow, regionCol + offSetCol);
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
