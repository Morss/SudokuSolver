package martinjo.sudoku;

public class SudokuMain {

	public static void main(String[] args) {
//		Sudoku sudoku = Sudoku.threeStarSudoku();
//		Sudoku sudoku = Sudoku.threeStarSudoku2();
		Sudoku9x9 sudoku = Sudoku9x9.fourStarSudoku();
//		Sudoku sudoku = Sudoku.fiveStarSudoku();
//		Sudoku sudoku = Sudoku.superHardSudoku();
		sudoku.print();
		System.out.println();
		Solver solver = new Solver(sudoku);
		solver.solve();
	}
}
