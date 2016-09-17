package martinjo.sudoku;

public class SudokuMain {

	public static void main(String[] args) {
		Sudoku sudoku = Sudoku.withPredefinedArray();
		sudoku.print();
		System.out.println();
		Solver solver = new Solver(sudoku);
		solver.solve();
	}
}
