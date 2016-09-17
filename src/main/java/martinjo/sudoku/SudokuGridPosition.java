package martinjo.sudoku;

public final class SudokuGridPosition {

	private final int row;
	private final int col;

	public SudokuGridPosition(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
}
