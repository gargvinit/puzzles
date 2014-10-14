package puzzles.sudoku.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides the elements in row given the the matrix and row number. Row number
 * is 0 based
 * 
 * @author vgarg
 * 
 */
public class RowLevelMatrixView implements MatrixView {
	private final Integer row;
	private List<Integer> elements = new ArrayList<Integer>();

	public RowLevelMatrixView(Integer[][] matrix, Integer row) {
		this.row = row;
		if (matrix == null || row >= matrix.length || row < 0)
			return;

		for (int i = 0; i < matrix[row].length; i++) {
			elements.add(matrix[row][i]);
		}

	}

	public List<Integer> elements() {
		return elements;
	}

	public String viewType() {
		return "Row";
	}

	public String startLocation() {
		return "" + (row + 1);
	}

}
