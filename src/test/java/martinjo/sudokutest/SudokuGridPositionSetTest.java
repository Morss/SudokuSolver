package martinjo.sudokutest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import martinjo.sudoku.Sudoku;
import martinjo.sudoku.SudokuFreeGridPositionSet;

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
		SudokuFreeGridPositionSet testSet = SudokuFreeGridPositionSet.fromAvailablePositions(testSudoku());

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (col == 4 || row == 4) {
					assertFalse(testSet.containsFreePosition(row, col));
				} else {
					assertTrue(testSet.containsFreePosition(row, col));
				}
			}
		}
	}
	
	@Test
	public void testAddPosition() {
		SudokuFreeGridPositionSet testSet = SudokuFreeGridPositionSet.fromAvailablePositions(testSudoku());
		assertFalse(testSet.containsFreePosition(4, 4));
		testSet.addFreePosition(4, 4);
		assertTrue(testSet.containsFreePosition(4, 4));
	}

	@Test
	public void testRemovePosition() {
		SudokuFreeGridPositionSet testSet = SudokuFreeGridPositionSet.fromAvailablePositions(testSudoku());
		assertTrue(testSet.containsFreePosition(0, 0));
		testSet.removeFreePosition(0, 0);
		assertFalse(testSet.containsFreePosition(4, 4));
	}
	
	@Test
	public void testRemoveColPositions() {
		SudokuFreeGridPositionSet testSet = SudokuFreeGridPositionSet.fromAvailablePositions(testSudoku());
		for (int row = 0; row < 8; row++) {
			if (row == 4) {
				assertFalse(testSet.containsFreePosition(row, 0));
			}
			else {
				assertTrue(testSet.containsFreePosition(row, 0));
			}
		}
		testSet.removeFreeColumPositions(0);
		for (int row = 0; row < 8; row++) {
			assertFalse(testSet.containsFreePosition(row, 0));
		}
	}

	@Test
	public void testRemoveRowPositions() {
		SudokuFreeGridPositionSet testSet = SudokuFreeGridPositionSet.fromAvailablePositions(testSudoku());
		for (int col = 0; col < 8; col++) {
			if (col == 4) {
				assertFalse(testSet.containsFreePosition(0, col));
			}
			else {
				assertTrue(testSet.containsFreePosition(0, col));
			}
		}
		testSet.removeFreeRowPositions(0);
		for (int col = 0; col < 8; col++) {
			assertFalse(testSet.containsFreePosition(0, col));
		}
	}

	@Test
	public void testRemoveQuadPositions() {
		SudokuFreeGridPositionSet testSet = SudokuFreeGridPositionSet.fromAvailablePositions(testSudoku());
		testSet.removeFreeQuadPositions(3, 3);
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (row > 2 && row < 6 && col > 2 && col < 6) {
					assertFalse(testSet.containsFreePosition(row, col));
				}
				else if (row == 4 || col == 4) {
					assertFalse(testSet.containsFreePosition(row, col));
				}
				else {
					assertTrue(testSet.containsFreePosition(row, col));
				}
			}
		}
	}
}
