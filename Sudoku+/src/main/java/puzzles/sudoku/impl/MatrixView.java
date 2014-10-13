package puzzles.sudoku.impl;

import java.util.List;

/**
 * Provides a "view" of a matrix. Abstraction used for row level, column level
 * or square root matrix
 * 
 * @author vgarg
 * 
 */
public interface MatrixView {
	List<Integer> elements();

	String viewType();

	String startLocation();
}
