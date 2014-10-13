package puzzles.sudoku.impl;

import java.util.ArrayList;
import java.util.List;

public class RowLevelMatrixView implements MatrixView {
	private final Integer row;
	private List<Integer> elements = new ArrayList<Integer>();

	public RowLevelMatrixView(Integer[][] matrix, Integer row) {
		this.row = row;
		if (matrix != null && matrix.length > row && row > 0) {
			for (int i = 0; i < matrix[row].length; i++) {
				elements.add(matrix[row][i]);
			}
		}
	}

	public List<Integer> elements() {
		return elements;
	}

	public String viewType() {
		return "Row";
	}

	public String startLocation() {
		return "" + row + 1;
	}

}