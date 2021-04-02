package hello;

import static java.nio.file.StandardOpenOption.APPEND;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SentencecountUsedLogic {

	public static void main(String[] args) {
		File file = new File("F:/vino--programs-2021/sentence1.txt");
		Path path = Paths.get(file.toString());
		try {
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line = null;

			String state = "OUTSIDE_SENTENCE";
			int sentencecount = 0;
			while ((line = reader.readLine()) != null) {

				for (int j = 0; j < line.length(); j++) {

					if (line.charAt(j) != ' ' && line.charAt(j) != '.') {
						state = "INSIDE_SENTENCE";

					}

					else if (line.charAt(j) == '.' && state.equals("INSIDE_SENTENCE")) {

						sentencecount++;
						state = "OUTSIDE_SENTENCE";
					}

				}

			}

			System.out.println("Total number of sentence:" + sentencecount);

			reader.close();

		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

}
