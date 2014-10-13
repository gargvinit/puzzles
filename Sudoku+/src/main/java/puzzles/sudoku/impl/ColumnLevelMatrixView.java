package puzzles.sudoku.impl;

import java.util.ArrayList;
import java.util.List;

public class ColumnLevelMatrixView implements MatrixView {
	private final Integer column;
	private List<Integer> elements = new ArrayList<Integer>();

	public ColumnLevelMatrixView(Integer[][] matrix, Integer column) {
		this.column = column;
		if (matrix == null || column < 0)
			return;

		for (int i = 0; i < matrix.length; i++) {
			if (column >= matrix[i].length)
				continue;

			elements.add(matrix[i][column]);
		}

	}

	public List<Integer> elements() {
		return elements;
	}

	public String viewType() {
		return "column";
	}

	public String startLocation() {
		return "" + (column + 1);
	}

}
