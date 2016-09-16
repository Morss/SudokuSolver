package martinjo.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Solver {

	private final static List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	private Sudoku sudoku;

	public Solver(Sudoku sudoku) {
		this.sudoku = sudoku;
	}

	public void solve() {
		int count = 0;
		while (solverLoop()) {
			System.out.println("Iteration: " + count++);
		}
		sudoku.print();
	}

	public boolean solverLoop() {
		boolean solvedSomething = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku.getValueAt(i, j) != 0) {
					continue;
				}
				Set<Integer> remainingOptions = remainingOptions(i, j);
				if (remainingOptions.size() == 1) {
					System.out.println("solved value at: " + i + "," + j + ", added: " + remainingOptions.stream().findFirst().orElse(null));
					solvedSomething = true;
					sudoku.setValueAt(i, j, remainingOptions.stream().findFirst().orElse(null));
				}
			}
		}
		return solvedSomething;
	}

	private Set<Integer> remainingOptions(int row, int col) {
		Set<Integer> options = allOptionsAvailable();
		// Row
		for (int i = 0; i < 9; i++) {
			options.remove(sudoku.getValueAt(row, i));
		}

		// Column
		for (int i = 0; i < 9; i++) {
			options.remove(sudoku.getValueAt(i, col));
		}

		// Box
		boxIterator(row, col).forEachRemaining(options::remove);

		return options;
	}

	public Iterator<Integer> boxIterator(int row, int col) {
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

	public Set<Integer> allOptionsAvailable() {
		return new HashSet<Integer>(NUMBERS);
	}
}
