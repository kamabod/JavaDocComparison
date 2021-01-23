package com.kama.tech;

import java.util.Map;

/**
 * Implements Runnable interface. Enables the use of threads. Threads are used
 * to concurrently build query map and subject map based on relevant input file
 * contents.
 * 
 * @author Kama
 * @version 1.0
 * @since 1.8
 */
public class Task implements Runnable {

	private Parser parser = new Parser();
	private String fileContent;
	private Map<Integer, Integer> map;

	/**
	 * Set words file content
	 * 
	 * @param fileContent Words
	 */
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	/**
	 * Set query map or subject map
	 * 
	 * @param Map<Integer,Integer> map
	 */
	public void setMap(Map<Integer, Integer> map) {
		this.map = map;
	}

	/**
	 * Instantiates Parser object,gets map
	 */
	@Override
	public void run() {
		this.map = parser.getMap(this.fileContent);
	}

	/**
	 * Get map
	 * 
	 * @return map
	 */
	public Map<Integer, Integer> getMap() {
		return this.map;
	}
}
