package puzzles.sudoku.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Checks for Sudoku by ensuring that each view is separately correct. Assumes
 * that all views must maintain the invariant of having distinct elements. Makes
 * some assumptions about elements in view are within acceptable range
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
		Set<Integer> uniqueElements = new HashSet<Integer>(view.elements());
		for (Integer element : uniqueElements) {
			sum += element;
			if (element > max)
				max = element;
		}

		return max * (max + 1) / 2 == sum;
	}
}
