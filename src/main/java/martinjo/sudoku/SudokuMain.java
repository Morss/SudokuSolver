package martinjo.sudoku;

public class SudokuMain {

	public static void main(String[] args) {
//      Sudoku4x4 sudoku = Sudoku4x4.easy();
//      Sudoku4x4 sudoku = Sudoku4x4.beginner();

//		Sudoku sudoku = Sudoku9x9.threeStarSudoku();
//		Sudoku sudoku = Sudoku9x9.threeStarSudoku2();
//		Sudoku sudoku = Sudoku9x9.fourStarSudoku();
//		Sudoku sudoku = Sudoku9x9.fiveStarSudoku();
//		Sudoku sudoku = Sudoku9x9.superHardSudoku();

//      Sudoku sudoku = Sudoku16x16.beginner();
		Sudoku sudoku = Sudoku16x16.easy();

		sudoku.print();
//		System.out.println();
		Solver solver = new Solver(sudoku);
		solver.solve();
	}
}
