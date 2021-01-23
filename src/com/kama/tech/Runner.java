package com.kama.tech;

import java.util.Map;
import java.util.Scanner;

/**
 * Runs the application. Enables the user to enter query file and subject file.
 * Coordinates the execution of threads, enables the user to view the c.distance
 * 
 * @author Kama
 * @version 1.0
 * @since 1.8
 */
public class Runner {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		String queryFile = "";
		String subjectFile = "";
		
		// Create calculator object
		Calculator calc = new Calculator();

		// Prompt user to enter query file, capture the path entered into queryFile
		System.out.println("Enter a query file:");
		queryFile = scanner.nextLine();

		// Create FileHandler object, access readText method and capture the return
		FileHandler fh = new FileHandler();

		String queryFileContent = fh.readText(queryFile);

		// Prompt user to enter subject file, capture the path entered into subjectFile
		System.out.println("Enter a subject file:");
		subjectFile = scanner.nextLine();

		String subjectFileContent = fh.readText(subjectFile);

		// Close Scanner to avoid resource leak
		scanner.close();

		// Thread info
		// Create task objects, access Task method setFileContent
		Task taskQuery = new Task();
		taskQuery.setFileContent(queryFileContent);

		// Create task objects, access Task method setFileContent
		Task taskSubject = new Task();
		taskSubject.setFileContent(subjectFileContent);

		// A thread depends on a runnable object
		Thread threadQuery = new Thread(taskQuery);
		Thread threadSubject = new Thread(taskSubject);

		// Start to run thread
		threadQuery.start();

		// Start to run thread
		threadSubject.start();

		// User will see this on the screen
		System.out.println("\n...Processing...please wait...");
		
		// Wait till thread finishes, join the thread with the main flow of execution
		threadQuery.join();
		// Wait till thread finishes, join the thread with the main flow of execution
		threadSubject.join();

		// Using getMap method of Task to create qmap
		Map<Integer, Integer> qmap = taskQuery.getMap();

		// Using getMap method of Task to create smap
		Map<Integer, Integer> smap = taskSubject.getMap();

		// Access getSimilarity method of Calculator to calculate c. distance
		double cDistance = calc.getSimilarity(qmap, smap);

		// User will see the c. distance on the screen
		System.out.println("\nThe c. distance is: " + String.format("%.2f", cDistance)+"%");
	}
}