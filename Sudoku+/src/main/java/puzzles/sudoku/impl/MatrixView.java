package puzzles.sudoku.impl;

import java.util.List;

/**
 * Provides a "view" of an matrix.
 * 
 * @author vgarg
 * 
 */
public interface MatrixView {
	List<Integer> elements();

	String viewType();

	String startLocation();
}
