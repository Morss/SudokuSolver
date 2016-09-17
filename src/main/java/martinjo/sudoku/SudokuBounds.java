package martinjo.sudoku;

public class SudokuBounds {
	private static final int MAX_SIZE = 8;
	private static final int MIN_SIZE = 0;
	
	public static void checkSudokuBounds(int row, int col) {
		if (row < MIN_SIZE || row > MAX_SIZE || col < MIN_SIZE || col > MAX_SIZE) {
			throwCatchBoundsException();
		}
	}

	public static void checkSudokuRowBounds(int row) {
		if (row < MIN_SIZE || row > MAX_SIZE) {
			throwCatchBoundsException();
		}
	}

	public static void checkSudokuColBounds(int col) {
		if (col < MIN_SIZE || col > MAX_SIZE) {
			throwCatchBoundsException();
		}
	}

	private static void throwCatchBoundsException() {
		try {
			throw new OutOfSudokuBoundsException();
		} catch (OutOfSudokuBoundsException e) {
			e.printStackTrace();
		}
	}
	
	private static class OutOfSudokuBoundsException extends Exception {
		private static final long serialVersionUID = 1L;
	}
}