package martinjo.sudokutest;

import martinjo.sudoku.Sudoku16x16;
import martinjo.sudoku.SudokuFreeGridPositionSet;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Sudoku16x16GridPositionSetTest {

    private static Sudoku16x16 testSudoku() {
        return Sudoku16x16.testSudokuInvalidForSolving();
    }

	@Test
	public void testContainsPosition() {
		SudokuFreeGridPositionSet testSet = SudokuFreeGridPositionSet.fromAvailablePositions(testSudoku());
		for (int row = 0; row < 16; row++) {
			for (int col = 0; col < 16; col++) {
				if (col == 6 || row == 7) {
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
        assertFalse(testSet.containsFreePosition(7, 4));
		testSet.addFreePosition(7, 4);
		assertTrue(testSet.containsFreePosition(7, 4));

        assertFalse(testSet.containsFreePosition(15, 6));
        testSet.addFreePosition(15, 6);
        assertTrue(testSet.containsFreePosition(15, 6));
	}

	@Test
	public void testRemovePosition() {
		SudokuFreeGridPositionSet testSet = SudokuFreeGridPositionSet.fromAvailablePositions(testSudoku());
		assertTrue(testSet.containsFreePosition(15, 15));
		testSet.removeFreePosition(15, 15);
		assertFalse(testSet.containsFreePosition(15, 15));
	}
	
	@Test
	public void testRemoveColPositions() {
		SudokuFreeGridPositionSet testSet = SudokuFreeGridPositionSet.fromAvailablePositions(testSudoku());
		for (int row = 0; row < 16; row++) {
			if (row == 7) {
				assertFalse(testSet.containsFreePosition(row, 0));
			}
			else {
				assertTrue(testSet.containsFreePosition(row, 0));
			}
		}
		testSet.removeFreeColumPositions(0);
		for (int row = 0; row < 16; row++) {
			assertFalse(testSet.containsFreePosition(row, 0));
		}
	}

	@Test
	public void testRemoveRowPositions() {
		SudokuFreeGridPositionSet testSet = SudokuFreeGridPositionSet.fromAvailablePositions(testSudoku());
		for (int col = 0; col < 8; col++) {
			if (col == 6) {
				assertFalse(testSet.containsFreePosition(0, col));
			}
			else {
				assertTrue(testSet.containsFreePosition(0, col));
			}
		}
		testSet.removeFreeRowPositions(0);
		for (int col = 0; col < 16; col++) {
			assertFalse(testSet.containsFreePosition(0, col));
		}
	}

// TODO: Fix test
//	@Test
//	public void testRemoveRegionPositions() {
//		SudokuFreeGridPositionSet testSet = SudokuFreeGridPositionSet.fromAvailablePositions(testSudoku());
//		testSet.removeFreeRegionPositions(3, 3);
//		for (int row = 0; row < 16; row++) {
//			for (int col = 0; col < 16; col++) {
//				if (row > 2 && row < 6 && col > 2 && col < 6) {
//					assertFalse(testSet.containsFreePosition(row, col));
//				}
//				else if (row == 4 || col == 4) {
//					assertFalse(testSet.containsFreePosition(row, col));
//				}
//				else {
//					assertTrue(testSet.containsFreePosition(row, col));
//				}
//			}
//		}
//	}
}
