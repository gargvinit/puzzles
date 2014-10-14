package puzzles.sudoku.impl;

import java.util.List;

/**
 * Provides a "view" of a matrix. Abstraction used for row level, column level
 * or square root matrix. It is useful to ensure that we can provide different
 * ways of breaking down the matrix and validating them. Currently validation is
 * done in a single place but can be done as part of view if they are different.
 * 
 * @author vgarg
 * 
 */
public interface MatrixView {
	/**
	 * Elements part of this view. No ordering is guaranteed. If the view was
	 * formed incorrectly, it is assumed that elements could be empty
	 * 
	 * @return
	 */
	List<Integer> elements();

	/**
	 * Useful method to understand which rule is not met.
	 * 
	 * @return
	 */
	String viewType();

	String startLocation();
}
