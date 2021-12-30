package martinjo.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku16x16 extends Sudoku {

    public static Sudoku16x16 easy() {
        ArrayList<List<Integer>> array = new ArrayList<List<Integer>>();

        array.add(Arrays.asList(	 0,  5,  0,  9,     0, 16,  2, 15,     7, 13,  1,  10, 	 0, 12,  0,  8	));
        array.add(Arrays.asList(    10,  2,  0,  0,    14,  0,  4,  0,     9,  8,  0,  6, 	 7, 13,  1,  0	));
        array.add(Arrays.asList(	 6,  7,  0,  4,    10,  0,  1,  0,    11, 12,  5,  0, 	 0,  0,  0,  0	));
        array.add(Arrays.asList(	 1,  0,  0,  0,     0,  9,  0,  0,     0,  3, 14,  0, 	 5,  0, 10,  0	));

        array.add(Arrays.asList(	11,  0,  2,  0,     4,  1, 10, 12,     0, 15,  0,  0, 	 0,  7,  0,  0	));
        array.add(Arrays.asList(	 8,  0,  0,  0,     0,  0,  0, 13,     0,  0,  7, 16, 	 1,  0,  6,  0	));
        array.add(Arrays.asList(	 0,  1,  0,  0,     6,  5,  0,  0,    14,  9, 11, 12, 	 0,  0,  2, 13	));
        array.add(Arrays.asList(	 3, 12,  5,  0,     0,  0,  0,  0,     6,  0,  0,  0, 	 0, 15,  9, 10	));

        array.add(Arrays.asList(	13,  0,  1,  0,     0,  0, 11, 14,    15,  5,  0,  7, 	 0, 10,  0,  3	));
        array.add(Arrays.asList(	 0,  0,  0,  8,    12,  6,  0,  0,     1, 11,  9, 13, 	 2, 16, 15,  0	));
        array.add(Arrays.asList(	 0, 10,  6,  0,     0,  0,  0,  9,     2, 16,  0, 14, 	 0,  1,  0,  0	));
        array.add(Arrays.asList(	 0,  0,  0, 15,     1,  2,  3,  7,     0,  0, 12,  8, 	 0,  0, 11, 14	));

        array.add(Arrays.asList(	 0,  8, 13,  1,     9, 15,  0,  2,     0,  7,  0,  0, 	12,  0,  0,  0	));
        array.add(Arrays.asList(	 9,  0, 10,  0,    13, 14, 12,  0,    16,  6,  0,  4, 	 0,  0,  0, 15	));
        array.add(Arrays.asList(	 2,  0, 12,  0,     0,  0,  7,  0,     8,  0,  0, 11, 	 0,  0, 13,  1	));
        array.add(Arrays.asList(	 0, 14,  3,  0,    11,  0,  0,  6,     0,  0,  0,  9, 	16,  0,  7,  2	));

        return new Sudoku16x16(array);
    }

    // https://www.sudoku-puzzles-online.com/cgi-bin/hexadoku/print-a-grid-hexadoku.cgi
    // Converting https://www.sudoku-puzzles-online.com/cgi-bin/hexadoku/print-a-grid-hexadoku.cgi using google sheets:
    // =if(isblank(A1),0,if(A1 = 0, 16, if(A1 = "A", 10, if (A1 = "B", 11, if(A1 = "C", 12, if(A1 = "D", 13, if(A1 = "E", 14, if(A1 = "F", 15, A1))))))))
    public static Sudoku16x16 beginner() {
        ArrayList<List<Integer>> array = new ArrayList<List<Integer>>();

        array.add(Arrays.asList(11,0,7,8,0,5,14,0,3,0,0,10,13,0,12,16));
        array.add(Arrays.asList(0,0,4,0,0,7,0,0,0,12,0,15,10,0,0,2));
        array.add(Arrays.asList(10,0,0,0,0,0,0,0,0,0,0,4,3,7,0,0));
        array.add(Arrays.asList(0,0,5,0,0,0,9,15,0,0,0,0,0,0,0,8));
        array.add(Arrays.asList(0,4,0,0,11,8,0,0,0,14,0,7,9,3,0,0));
        array.add(Arrays.asList(0,0,14,3,7,12,0,0,0,0,15,13,11,0,0,4));
        array.add(Arrays.asList(9,15,0,7,0,0,5,13,0,3,0,0,0,0,8,0));
        array.add(Arrays.asList(5,0,0,13,0,15,3,0,2,4,10,8,12,0,16,0));
        array.add(Arrays.asList(0,8,0,0,0,0,0,0,11,0,0,0,0,16,13,5));
        array.add(Arrays.asList(0,0,13,0,0,0,0,0,0,8,0,0,15,0,14,0));
        array.add(Arrays.asList(0,0,10,0,9,0,15,0,0,6,7,0,0,0,11,12));
        array.add(Arrays.asList(0,0,0,12,0,10,11,0,0,0,0,14,7,2,4,0));
        array.add(Arrays.asList(7,10,0,9,0,11,1,0,0,0,5,0,0,6,3,0));
        array.add(Arrays.asList(13,0,12,14,15,0,7,0,10,0,0,0,0,8,0,0));
        array.add(Arrays.asList(0,0,0,0,14,0,10,0,0,13,0,0,5,0,0,0));
        array.add(Arrays.asList(0,6,3,5,16,9,12,0,0,11,0,0,14,0,0,0));

        return new Sudoku16x16(array);
    }

    public static Sudoku16x16 testSudokuInvalidForSolving() {
        ArrayList<List<Integer>> array = new ArrayList<List<Integer>>();

        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));
        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));
        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));
        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));

        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));
        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));
        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));
        array.add(Arrays.asList(	1, 1, 1, 1, 	 1, 1, 1, 1,	 1, 1, 1, 1,     1, 1, 1, 1     ));

        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));
        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));
        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));
        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));

        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));
        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));
        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));
        array.add(Arrays.asList(	0, 0, 0, 0, 	 0, 0, 1, 0,	 0, 0, 0, 0,     0, 0, 0, 0     ));

        return new Sudoku16x16(array);
    }

    private Sudoku16x16(ArrayList<List<Integer>> array) {
        super(array, 16);
    }
}

