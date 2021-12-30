package martinjo.sudoku;

import java.util.List;

public class Sudoku {
    protected final List<List<Integer>> array;
    private final SudokuBounds bounds;

    public Sudoku(List<List<Integer>> array, int size) {
        this.array = array;
        this.bounds = SudokuBounds.forSize(size);
    }

    public SudokuBounds getBounds() {
        return bounds;
    }

    public void print() {
		for (int row : bounds.getIndexes()) {
			if (row != 0 && row % bounds.getRegionSize() == 0) {
			    StringBuilder sb = new StringBuilder();
                final int regionSize = bounds.getRegionSize();
                String regionUnderline = "-".repeat(regionSize * 2 + regionSize);
			    sb.append(regionUnderline);
                for (int i = 0; i < regionSize - 1; i++) {
                    sb.append("+-");
                    sb.append(regionUnderline);
                }
                System.out.println(sb);
            }
			for	(int col : bounds.getIndexes()) {
				if (col != 0 && col % bounds.getRegionSize() == 0) {
					System.out.print("| ");
				}
                int entry = getValueAt(row, col);
				String printableEntry = entry < 10 ? String.format("%02d", entry).replace("0", " ") : entry + "";
                System.out.print(printableEntry + " ");
			}
			System.out.println();
		}
	}

    public int getValueAt(int row, int col) {
		bounds.checkSudokuBounds(row, col);
		return array.get(row).get(col);
	}

    public void setValueAt(int row, int col, int value) {
        bounds.checkSudokuBounds(row, col);
		array.get(row).set(col, value);
	}
}
