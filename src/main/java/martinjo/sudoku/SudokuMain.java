package martinjo.sudoku;

public class SudokuMain {

	public static void main(String[] args) {
//		Sudoku sudoku = Sudoku.threeStarSudoku();
//		Sudoku sudoku = Sudoku.threeStarSudoku2();
//		Sudoku sudoku = Sudoku.fourStarSudoku();
		Sudoku sudoku = Sudoku.fiveStarSudoku();
//		Sudoku sudoku = Sudoku.superHardSudoku();
		sudoku.print();
		System.out.println();
		Solver solver = new Solver(sudoku);
		solver.solve();
	}
}
