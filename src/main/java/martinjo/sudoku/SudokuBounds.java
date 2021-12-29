package martinjo.sudoku;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SudokuBounds {

    private final int size;
    private final int minIndex;
    private final int maxIndex;
    @Getter
    private final List<Integer> indexes;

    @Getter
    private final int regionSize;
    private final int regionMinIndex;
    private final int regionMaxIndex;
    @Getter
    private final List<Integer> regionIndexes;
    @Getter
    private final List<Integer> possibleNumbers;

    public static SudokuBounds forSize(int size) {
        int minIndex = 0;
        int maxIndex = size - 1;

        int regionSize = (int)Math.sqrt(size);
        int regionMinIndex = 0;
        int regionMaxIndex = regionSize - 1;

        List<Integer> indexesMutable = new ArrayList<>();
        List<Integer> regionIndexesMutable = new ArrayList<>();
        List<Integer> possibleNumbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            indexesMutable.add(i);
        }

        for (int i = 0; i < regionSize; i++) {
            regionIndexesMutable.add(i);
        }

        for (int i = 0; i <= size; i++) {
            possibleNumbers.add(i);
        }

        return new SudokuBounds(
                size,
                minIndex,
                maxIndex,
                Collections.unmodifiableList(indexesMutable),
                regionSize,
                regionMinIndex,
                regionMaxIndex,
                Collections.unmodifiableList(regionIndexesMutable),
                Collections.unmodifiableList(possibleNumbers));
    }

    public void checkSudokuBounds(int row, int col) {
		if (row < minIndex || row > maxIndex || col < minIndex || col > maxIndex) {
            throw new OutOfSudokuBoundsException();
        }
	}

	public void checkSudokuRowBounds(int row) {
		if (row < minIndex || row > maxIndex) {
            throw new OutOfSudokuBoundsException();
        }
	}

	public void checkSudokuColBounds(int col) {
		if (col < minIndex || col > maxIndex) {
            throw new OutOfSudokuBoundsException();
        }
	}

    private static class OutOfSudokuBoundsException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}
}