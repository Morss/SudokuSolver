package martinjo.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Sudoku {

	private final ArrayList<List<Integer>> array;

	public Sudoku(ArrayList<List<Integer>> array) {
		this.array = array;
	}

	public static Sudoku threeStarSudoku() {
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

	public static Sudoku threeStarSudoku2() {
		ArrayList<List<Integer>> array = new ArrayList<List<Integer>>();
		
		array.add(Arrays.asList(	0, 4, 0,	0, 3, 9,	 2, 5, 0	));
		array.add(Arrays.asList(	0, 0, 0,	0, 5, 0,	 0, 0, 6	));
		array.add(Arrays.asList(	2, 5, 0,	7, 0, 0,	 0, 0, 0	));

		array.add(Arrays.asList(	0, 0, 1,	0, 0, 3,	 5, 0, 0	));
		array.add(Arrays.asList(	0, 0, 3,	0, 8, 2,	 0, 7, 0	));
		array.add(Arrays.asList(	0, 0, 0,	4, 7, 0,	 0, 0, 3	));

		array.add(Arrays.asList(	0, 0, 7,	9, 0, 0,	 0, 0, 0	));
		array.add(Arrays.asList(	0, 1, 4,	8, 2, 5,	 3, 0, 0	));
		array.add(Arrays.asList(	0, 0, 5,	0, 0, 7,	 0, 1, 4	));
		
		return new Sudoku(array);
	}
	
	public static Sudoku fourStarSudoku() {
		ArrayList<List<Integer>> array = new ArrayList<List<Integer>>();
		
		array.add(Arrays.asList(	7, 0, 0,	0, 0, 0,	 3, 0, 0	));
		array.add(Arrays.asList(	0, 0, 0,	3, 0, 1,	 0, 4, 0	));
		array.add(Arrays.asList(	0, 9, 0,	0, 0, 0,	 0, 8, 6	));

		array.add(Arrays.asList(	0, 0, 5,	0, 6, 8,	 0, 0, 0	));
		array.add(Arrays.asList(	2, 6, 0,	0, 0, 0,	 0, 0, 0	));
		array.add(Arrays.asList(	0, 1, 3,	4, 0, 5,	 0, 0, 0	));

		array.add(Arrays.asList(	8, 0, 7,	0, 0, 0,	 0, 0, 9	));
		array.add(Arrays.asList(	0, 0, 0,	1, 3, 0,	 0, 0, 7	));
		array.add(Arrays.asList(	0, 0, 0,	0, 0, 0,	 0, 5, 4	));
		
		return new Sudoku(array);
	}

	public static Sudoku fiveStarSudoku() {
		ArrayList<List<Integer>> array = new ArrayList<List<Integer>>();
		
		array.add(Arrays.asList(	3, 0, 0,	0, 8, 0,	 0, 0, 0	));
		array.add(Arrays.asList(	8, 0, 0,	0, 0, 2,	 0, 5, 0	));
		array.add(Arrays.asList(	0, 7, 4,	0, 5, 0,	 0, 0, 8	));

		array.add(Arrays.asList(	5, 0, 0,	1, 0, 0,	 7, 0, 0	));
		array.add(Arrays.asList(	6, 0, 0,	0, 0, 0,	 0, 0, 3	));
		array.add(Arrays.asList(	0, 0, 7,	0, 0, 4,	 0, 0, 5	));

		array.add(Arrays.asList(	2, 0, 0,	0, 7, 0,	 1, 8, 0	));
		array.add(Arrays.asList(	0, 8, 0,	3, 0, 0,	 0, 0, 7	));
		array.add(Arrays.asList(	0, 0, 0,	0, 1, 0,	 0, 0, 6	));
		
		return new Sudoku(array);
	}
	
	// http://www.physicsinsights.org/sudoku_2.html
	// http://www.telegraph.co.uk/news/science/science-news/9359579/Worlds-hardest-sudoku-can-you-crack-it.html	
	public static Sudoku superHardSudoku() {
		ArrayList<List<Integer>> array = new ArrayList<List<Integer>>();
		
		array.add(Arrays.asList(	8, 0, 0,	0, 0, 0,	 0, 0, 0	));
		array.add(Arrays.asList(	0, 0, 3,	6, 0, 0,	 0, 0, 0	));
		array.add(Arrays.asList(	0, 7, 0,	0, 9, 0,	 2, 0, 0	));

		array.add(Arrays.asList(	0, 5, 0,	0, 0, 7,	 0, 0, 0	));
		array.add(Arrays.asList(	0, 0, 0,	0, 4, 5,	 7, 0, 0	));
		array.add(Arrays.asList(	0, 0, 0,	1, 0, 0,	 0, 3, 0	));

		array.add(Arrays.asList(	0, 0, 1,	0, 0, 0,	 0, 6, 8	));
		array.add(Arrays.asList(	0, 0, 8,	5, 0, 0,	 0, 1, 0	));
		array.add(Arrays.asList(	0, 9, 0,	0, 0, 0,	 4, 0, 0	));
		
		return new Sudoku(array);
	}
	
	
	public void print() {
		for (int row = 0; row < 9; row++) {
			if (row != 0 && row % 3 == 0) {
				System.out.println("------+------+-----");
			}
			for	(int col = 0; col < 9; col++) {
				if (col != 0 && col % 3 == 0) {
					System.out.print("|");
				}
				String entry = (getValueAt(row, col) == 0) ? " " : Integer.toString(getValueAt(row, col));
				System.out.print(entry + " ");
			}
			System.out.println();
		}
	}

	public int getValueAt(int row, int col) {
		SudokuBounds.checkSudokuBounds(row, col);
		return array.get(row).get(col);
	}

	public void setValueAt(int row, int col, int value) {
		SudokuBounds.checkSudokuBounds(row, col);
		array.get(row).set(col, value);
	}


}
