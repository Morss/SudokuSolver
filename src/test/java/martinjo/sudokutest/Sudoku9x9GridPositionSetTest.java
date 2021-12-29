package martinjo.sudokutest;

import martinjo.sudoku.Sudoku9x9;
import martinjo.sudoku.SudokuFreeGridPositionSet;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Sudoku9x9GridPositionSetTest {

    private static Sudoku9x9 testSudoku() {
        return Sudoku9x9.testSudokuInvalidForSolving();
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
	public void testRemoveRegionPositions() {
		SudokuFreeGridPositionSet testSet = SudokuFreeGridPositionSet.fromAvailablePositions(testSudoku());
		testSet.removeFreeRegionPositions(3, 3);
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
