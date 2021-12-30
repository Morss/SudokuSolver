package martinjo.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Sudoku4x4 extends Sudoku {

    public static Sudoku4x4 easy() {
        ArrayList<List<Integer>> array = new ArrayList<List<Integer>>();

        array.add(Arrays.asList(	0, 3,    4, 0	));
        array.add(Arrays.asList(	4, 0,    0, 2	));

        array.add(Arrays.asList(	1, 0,    0, 3	));
        array.add(Arrays.asList(	0, 2,    1, 0	));

        return new Sudoku4x4(array);
    }

    public static Sudoku4x4 beginner() {
        ArrayList<List<Integer>> array = new ArrayList<List<Integer>>();

        array.add(Arrays.asList(	0, 0,    1, 0	));
        array.add(Arrays.asList(	4, 0,    0, 0	));

        array.add(Arrays.asList(	0, 0,    0, 2	));
        array.add(Arrays.asList(	0, 3,    0, 0	));

        return new Sudoku4x4(array);
    }

    private Sudoku4x4(ArrayList<List<Integer>> array) {
        super(array, 4);
    }


}
