package puzzles.sudoku;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * Main class for SudokuPlus verification. Expects files/directories to be
 * provided as arguments.
 * 
 * @author vgarg
 * 
 */
public class VerificationApp {
	public static void main(String[] args) {
		if (args == null || args.length < 1) {
			System.out.println("Input: text/csv files(s) to be verified.");
		}
		VerificationApp app = new VerificationApp();
		app.status(args);
	}

	private void status(String[] args) {
		Map<String, String> fileStatuses = new HashMap<String, String>();
		for (String arg : args) {
			File f = new File(arg);
			if (f.isDirectory()) {
				// Only first level of substructure is supported
				for (File df : f.listFiles()) {
					if (df.isFile())
						fileStatuses.put(arg + "/" + df.getName(),
								status(df.getAbsolutePath()));
				}
			} else
				fileStatuses.put(arg, status(arg));
		}

		for (String key : fileStatuses.keySet()) {
			System.out.println(key + ": " + fileStatuses.get(key));
		}

	}

	private String status(String arg) {
		File f = new File(arg);
		String status = null;
		if (f.exists()) {
			if (!f.getName().endsWith("csv") && !f.getName().endsWith("txt")) {
				status = f.getName() + "must be a csv or txt file";
			} else {
				try {
					List<String> lines = Files.readLines(f, Charsets.UTF_8);

					SudokuMatrix m = new SudokuMatrix(lines);
					if (!m.isValid()) {
						status = m.issues();
					}

					if (status == null)
						status = "is valid";
				} catch (IOException ioe) {
					status = ioe.getMessage();
				}
			}
		} else {
			status = "does not exist";
		}
		return status;
	}

}
