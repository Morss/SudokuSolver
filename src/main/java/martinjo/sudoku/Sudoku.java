package martinjo.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {
	private ArrayList<List<Integer>> array;

	public Sudoku(ArrayList<List<Integer>> array) {
		this.array = array;
	}

	public static Sudoku withPredefinedArray() {
		ArrayList<List<Integer>> array = new ArrayList<List<Integer>>();

		array.add(Arrays.asList(	9, 0, 0,	0, 0, 0,	 7, 1, 0	));
		array.add(Arrays.asList(	0, 0, 0,	9, 0, 8,	 0, 2, 0	));
		array.add(Arrays.asList(	0, 0, 0,	3, 7, 0,	 0, 0, 8	));

		array.add(Arrays.asList(	7, 6, 0,	8, 0, 0,	 0, 0, 0	));
		array.add(Arrays.asList(	8, 0, 1,	0, 3, 4,	 0, 5, 0	));
		array.add(Arrays.asList(	0, 5, 0,	0, 0, 0,	 0, 0, 0	));

		array.add(Arrays.asList(	0, 0, 5,	2, 0, 0,	 8, 0, 0	));
		array.add(Arrays.asList(	6, 2, 0,	7, 0, 0,	 0, 0, 4	));
		array.add(Arrays.asList(	0, 3, 0,	0, 0, 0,	 5, 0, 0	));

		return new Sudoku(array);
	}

	public void print() {
		for (int row = 0; row < 9; row++) {
			if (row != 0 && row % 3 == 0) {
				System.out.println("------+-------+------");
			}
			for	(int col = 0; col < 9; col++) {
				if (col != 0 && col % 3 == 0) {
					System.out.print("| ");
				}
				String entry = (getValueAt(row, col) == 0) ? " " : Integer.toString(getValueAt(row, col));
				System.out.print(entry + " ");
			}
			System.out.println();
		}
	}

	public int getValueAt(int row, int col) {
		checkSudokuBounds(row, col);
		return array.get(row).get(col);
	}

	public void setValueAt(int row, int col, int value) {
		checkSudokuBounds(row, col);
		array.get(row).set(col, value);
	}

	private void checkSudokuBounds(int row, int col) {
		if (row > 9 || col > 9) {
			throw new OutOfSudokuBoundsException();
		}
	}

	private class OutOfSudokuBoundsException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public OutOfSudokuBoundsException() {
			super();
		}
	}
}
