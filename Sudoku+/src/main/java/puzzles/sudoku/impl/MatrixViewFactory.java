package puzzles.sudoku.impl;

import java.util.ArrayList;
import java.util.List;

public class MatrixViewFactory {
	/**
	 * Provides different views of matrix to check. This is where we would
	 * configure all the views we need to check for. Currently views and checks
	 * are decoupled.
	 * 
	 * @param matrix
	 * @return
	 */
	public static List<MatrixView> getViews(Integer[][] matrix) {
		List<MatrixView> views = new ArrayList<MatrixView>();
		if (matrix != null) {
			for (int i = 0; i < matrix.length; i++) {
				views.add(new RowLevelMatrixView(matrix, i));
				views.add(new ColumnLevelMatrixView(matrix, i));
			}
			int sqrtN = (int) Math.sqrt(matrix.length);
			for (int i = 0; i < sqrtN; i++) {
				views.add(new SubMatrixMatrixView(matrix, i * sqrtN, i * sqrtN));
			}
		}
		return views;
	}
}
