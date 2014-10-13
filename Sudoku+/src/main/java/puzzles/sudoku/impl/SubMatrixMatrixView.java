package puzzles.sudoku.impl;

import java.util.ArrayList;
import java.util.List;

public class SubMatrixMatrixView implements MatrixView {
	private final Integer row;
	private final Integer col;

	private List<Integer> elements = new ArrayList<Integer>();

	public SubMatrixMatrixView(Integer[][] matrix, Integer row, Integer column) {
		this.row = row;
		this.col = column;
		if (matrix != null && matrix.length > row && row > 0 && col > 0) {
			for (int i = row; i < row + Math.sqrt(matrix.length); i++) {
				for (int j = col; j < col + Math.sqrt(matrix.length); j++) {
					if (matrix[i].length > j)
						elements.add(matrix[i][j]);
				}
			}
		}
	}

	public List<Integer> elements() {
		return elements;
	}

	public String viewType() {
		return "Submatrix";
	}

	public String startLocation() {
		return "" + (row + 1) + "," + (col + 1);
	}
}
