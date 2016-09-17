package martinjo.sudoku;

public class SudokuBounds extends Exception {
	private static final long serialVersionUID = 1L;
	
	public static void checkSudokuBounds(int row, int col) {
		if (row < 0 || row > 8 || col < 0 || col > 9) {
			try {
				throw new OutOfSudokuBoundsException();
			} catch (OutOfSudokuBoundsException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static class OutOfSudokuBoundsException extends Exception {
		private static final long serialVersionUID = 1L;
	}
}