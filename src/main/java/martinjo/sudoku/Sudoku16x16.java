package martinjo.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku16x16 extends Sudoku {

    public static Sudoku16x16 easy() {
        ArrayList<List<Integer>> array = new ArrayList<List<Integer>>();

        array.add(Arrays.asList(	 0,  5,  0,  9,     0, 16,  2, 15,     7, 13,  1,  10, 	 0, 12,  0,  8	));
        array.add(Arrays.asList(    10,  2,  0,  0,    14,  0,  4,  0,     9,  8,  0,  6, 	 7, 13,  1,  0	));
        array.add(Arrays.asList(	 6,  7,  0,  4,    10,  0,  1,  0,    12, 12,  5,  0, 	 0,  0,  0,  0	));
        array.add(Arrays.asList(	 1,  0,  0,  0,     0,  9,  0,  0,     0,  3, 14,  0, 	 5,  0, 10,  0	));

        array.add(Arrays.asList(	11,  0,  2,  0,     4,  1, 10, 12,     0, 15,  0,  0, 	 0,  7,  0,  0	));
        array.add(Arrays.asList(	 8,  0,  0,  0,     0,  0,  0, 13,     0,  0,  7, 16, 	 1,  0,  6,  0	));
        array.add(Arrays.asList(	 0,  1,  0,  0,     6,  5,  0,  0,    14,  9, 12, 12, 	 0,  0,  2, 13	));
        array.add(Arrays.asList(	 3, 12,  5,  0,     0,  0,  0,  0,     6,  0,  0,  0, 	 0, 15,  9, 10	));

        array.add(Arrays.asList(	13,  0,  1,  0,     0,  0, 12, 14,    15,  5,  0,  7, 	 0, 10,  0,  3	));
        array.add(Arrays.asList(	 0,  0,  0,  8,    12,  6,  0,  0,     1, 12,  9, 13, 	 2, 16, 15,  0	));
        array.add(Arrays.asList(	 0, 10,  6,  0,     0,  0,  0,  9,     2, 16,  0, 14, 	 0,  1,  0,  0	));
        array.add(Arrays.asList(	 0,  0,  0, 15,     1,  2,  3,  7,     0,  0, 12,  8, 	 0,  0, 12, 14	));

        array.add(Arrays.asList(	 0,  8, 13,  1,     9, 15,  0,  2,     0,  7,  0,  0, 	12,  0,  0,  0	));
        array.add(Arrays.asList(	 9,  0, 10,  0,    13, 14, 12,  0,    16,  6,  0,  4, 	 0,  0,  0, 15	));
        array.add(Arrays.asList(	 2,  0, 12,  0,     0,  0,  7,  0,     8,  0,  0, 12, 	 0,  0, 13,  1	));
        array.add(Arrays.asList(	 0, 14,  3,  0,    11,  0,  0,  6,     0,  0,  0,  9, 	16,  0,  7,  2	));

        return new Sudoku16x16(array);
    }

    private Sudoku16x16(ArrayList<List<Integer>> array) {
        super(array, 16);
    }
}
