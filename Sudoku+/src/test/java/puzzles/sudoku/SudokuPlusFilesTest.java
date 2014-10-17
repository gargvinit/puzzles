package puzzles.sudoku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import puzzles.sudoku.impl.SudokuMatrix;
import junit.framework.TestCase;

/**
 * Tests based on file name convention that files are valid or not. Does not
 * check for reason for invalidity currently.
 * 
 * @author vgarg
 * 
 */
public class SudokuPlusFilesTest extends TestCase {
	public void testValidInputs() throws IOException {
		String[] validFiles = { "1x1", "4x4", "9x9" };
		for (String validFile : validFiles) {
			SudokuMatrix matrix = getMatrix("validInput " + validFile);
			assertTrue(validFile + " must be valid", matrix.isValid());
			assertTrue(
					validFile + " must not have any issues " + matrix.issues(),
					matrix.issues().isEmpty());
		}
	}

	public void testInvalidInputs() throws IOException {
		String[] validFiles = { "TextualEnglish", "SizeMismatch",
				"NumbersNotMatching", "NumbersNotInRange",
				"NonNumericCharacter", "Empty", "ElementsAre0",
				"DuplicateEntries", "2x2", "4x4" };
		for (String invalidFile : validFiles) {
			SudokuMatrix matrix = getMatrix("invalidInput" + invalidFile);
			assertFalse(invalidFile + " must not be valid", matrix.isValid());
			assertFalse(invalidFile + " must have issues", matrix.issues()
					.isEmpty());
		}
	}

	private SudokuMatrix getMatrix(String fn) throws IOException {
		return new SudokuMatrix(readFile(fn), ",");
	}

	private List<String> readFile(String fn) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(this
				.getClass().getResourceAsStream("/" + fn + ".txt")));
		List<String> contents = new ArrayList<String>();
		String content;
		while ((content = br.readLine()) != null) {
			contents.add(content);
		}
		return contents;
	}
}
