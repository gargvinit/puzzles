package puzzles.sudoku.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class SudokuMatrix {

	private List<String> issues = new ArrayList<String>();
	private final Integer[][] matrix;

	public boolean isValid() {
		return issues().isEmpty();
	}

	public String issues() {
		return colToString(issues);
	}

	private final String separator;

	public SudokuMatrix(List<String> ip, String separator) {
		this.separator = separator;
		checkCompleteSolution(ip);
		if (!isValid()) {
			matrix = null;
			return;
		}
		int N = N(ip);
		matrix = new Integer[N][];
		for (int i = 0; i < N; i++) {
			matrix[i] = new Integer[N];
			String[] elements = elements(ip.get(i));
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(elements[j]);
			}
		}
		ensureValidMatrix();
		if (!isValid()) {
			return;
		}

		SudokuCheck rulesChecks = new SudokuCheck(
				MatrixViewFactory.getViews(matrix));
		issues.addAll(rulesChecks.issues());

	}

	private void ensureValidMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int element = matrix[i][j];
				if (element < 1 || element > matrix.length) {
					issues.add("(" + i + "," + j + ") not in range 1-"
							+ matrix.length);
				}
			}
		}
	}

	private void checkCompleteSolution(List<String> ip) {
		if (ip == null || ip.isEmpty()) {
			issues.add("Empty solution");
			return;
		}
		if (!nonNumericEntries(ip).isEmpty()) {
			issues.add("Non numeric entries found: "
					+ colToString(nonNumericEntries(ip)));

		} else if (distinctSizes(ip).size() != 1) {
			issues.add("All numElements must be of same size. Sizes are "
					+ colToString(distinctSizes(ip)));
		} else if (!validN(N(ip))) {
			issues.add(N(ip) + " must be square of an Integer");
		}

	}

	private Set<Integer> distinctSizes(List<String> ip) {
		Set<Integer> sizes = new HashSet<Integer>();
		for (String row : ip)
			sizes.add(numElements(row));
		return sizes;
	}

	private boolean validN(int N) {
		int sqrtN = (int) Math.sqrt(N);
		return sqrtN * sqrtN == N;
	}

	private List<String> nonNumericEntries(List<String> ip) {
		List<String> nne = new ArrayList<String>();
		for (String r : ip) {
			for (String c : elements(r)) {
				try {
					Integer.parseInt(c);
				} catch (NumberFormatException nfe) {
					nne.add(c);
				}
			}
		}
		return nne;
	}

	private String[] elements(String ip) {
		return ip.split(separator);
	}

	private Integer numElements(String ip) {
		return elements(ip).length;
	}

	private Integer N(List<String> ip) {
		return numElements(ip.get(0));
	}

	private String colToString(Collection col) {
		StringBuilder builder = new StringBuilder();
		for (Object s : col) {
			builder.append(s + ",");
		}
		return builder.toString();

	}

}
