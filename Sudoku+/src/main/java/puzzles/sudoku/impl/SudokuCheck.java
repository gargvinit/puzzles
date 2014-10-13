package puzzles.sudoku.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * Checks for Sudoku by ensuring that each view is separately correct.
 * 
 * @author vgarg
 * 
 */
public class SudokuCheck {

	private final List<MatrixView> incorrectViews = new ArrayList<MatrixView>();

	public SudokuCheck(List<MatrixView> views) {
		if (views == null) {
			return;
		}
		for (MatrixView view : views) {
			if (!viewOk(view)) {
				incorrectViews.add(view);
			}

		}
	}

	public boolean correct() {
		return incorrectViews.isEmpty();
	}

	public List<String> issues() {
		List<String> issues = new ArrayList<String>();
		for (MatrixView iv : incorrectViews) {
			issues.add(iv.viewType() + " at " + iv.startLocation()
					+ " is invalid");
		}
		return issues;
	}

	/**
	 * Find the maximum and ensure that sum is same as n*(n+1)/2
	 * 
	 * @param view
	 * @return
	 */
	private boolean viewOk(MatrixView view) {
		int sum = 0;
		int max = 0;

		for (Integer element : view.elements()) {
			sum += element;
			if (element > max)
				max = element;
		}

		return max * (max + 1) / 2 == sum;
	}
}
