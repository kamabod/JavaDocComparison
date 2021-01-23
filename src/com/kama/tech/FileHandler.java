package com.kama.tech;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Reads the input File and returns its contents in a string
 * 
 * @author Kama
 * @version 1.0
 * @since 1.8
 */
public class FileHandler {

	public FileHandler() {
	}

	/**
	 * Reads the contents of input File and returns a string
	 * 
	 * @param String inputFile
	 * @return String response.
	 */
	public String readText(String inputFile) throws IOException {
		InputStream inStream = null;
		StringBuilder response = new StringBuilder();

		// Use try/catch statement
		try {
			// Load file contents into inputStream
			inStream = new FileInputStream(inputFile);
		} catch (Exception e) {
			// Throw exception if file is not found
			System.out.println("File not found. Please enter file path again.");
		}

		// Check if inputStream has contents
		if (inStream != null) {
			// If stream has contents, we read it using a reader object
			BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));

			String inputLine = null;

			// While loop to read contents, creates a stringBuilder, prints it
			// converting to string
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);

			}
			// Closing reader to avoid resource leak
			reader.close();
		}
		return response.toString();
	}
}