package martinjo.sudokutest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import martinjo.sudoku.Sudoku;
import martinjo.sudoku.SudokuGridPositionSet;

public class SudokuGridPositionSetTest {

	public Sudoku testSudoku() {
		ArrayList<List<Integer>> array = new ArrayList<List<Integer>>();

		array.add(Arrays.asList(	0, 0, 0,	0, 1, 0,	 0, 0, 0	));
		array.add(Arrays.asList(	0, 0, 0,	0, 1, 0,	 0, 0, 0	));
		array.add(Arrays.asList(	0, 0, 0,	0, 1, 0,	 0, 0, 0	));

		array.add(Arrays.asList(	0, 0, 0,	0, 1, 0,	 0, 0, 0	));
		array.add(Arrays.asList(	1, 1, 1,	1, 1, 1,	 1, 1, 1	));
		array.add(Arrays.asList(	0, 0, 0,	0, 1, 0,	 0, 0, 0	));

		array.add(Arrays.asList(	0, 0, 0,	0, 1, 0,	 0, 0, 0	));
		array.add(Arrays.asList(	0, 0, 0,	0, 1, 0,	 0, 0, 0	));
		array.add(Arrays.asList(	0, 0, 0,	0, 1, 0,	 0, 0, 0	));

		return new Sudoku(array);
	}

	@Test
	public void testContainsPosition() {
		SudokuGridPositionSet testSet = SudokuGridPositionSet.fromAvailablePositions(testSudoku());

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (col == 4 || row == 4) {
					assertTrue(testSet.containsPosition(row, col));
				} else {
					assertFalse(testSet.containsPosition(row, col));
				}
			}
		}
	}
	
	@Test
	public void testAddPosition() {
		SudokuGridPositionSet testSet = SudokuGridPositionSet.fromAvailablePositions(testSudoku());
		assertFalse(testSet.containsPosition(0, 0));
		testSet.addPosition(0, 0);
		assertTrue(testSet.containsPosition(0, 0));
	}

	@Test
	public void testRemovePosition() {
		SudokuGridPositionSet testSet = SudokuGridPositionSet.fromAvailablePositions(testSudoku());
		assertTrue(testSet.containsPosition(4, 4));
		testSet.removePosition(4, 4);
		assertFalse(testSet.containsPosition(4, 4));
	}
	
	@Test
	public void testRemoveColPositions() {
		SudokuGridPositionSet testSet = SudokuGridPositionSet.fromAvailablePositions(testSudoku());
		for (int row = 0; row < 8; row++) {
			assertTrue(testSet.containsPosition(row, 4));
		}
		testSet.removeColumPositions(4);
		for (int row = 0; row < 8; row++) {
			assertFalse(testSet.containsPosition(row, 4));
		}
	}

	@Test
	public void testRemoveRowPositions() {
		SudokuGridPositionSet testSet = SudokuGridPositionSet.fromAvailablePositions(testSudoku());
		for (int col = 0; col < 8; col++) {
			assertTrue(testSet.containsPosition(4, col));
		}
		testSet.removeRowPositions(4);
		for (int col = 0; col < 8; col++) {
			assertFalse(testSet.containsPosition(4, col));
		}
	}

	@Test
	public void testRemoveQuadPositions() {
		SudokuGridPositionSet testSet = SudokuGridPositionSet.fromAvailablePositions(testSudoku());
		testSet.removeQuadPositions(3, 3);
		
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (row > 2 && row < 6 && col > 2 && col < 6)
					assertFalse(testSet.containsPosition(row, col));
				else if (row == 4 || col == 4) {
					assertTrue(testSet.containsPosition(row, col));
				} else {
					assertFalse(testSet.containsPosition(row, col));
				}
			}
		}
	}
}
