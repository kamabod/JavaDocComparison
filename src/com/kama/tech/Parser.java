package com.kama.tech;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Takes in input file contents, splits it into words, creates hash code values
 * of the strings, builds a map with hash code values and frequency of
 * occurrence, returns a map
 * 
 * @author Kama
 * @version 1.0
 * @since 1.8
 */
public class Parser {

	private Map<Integer, Integer> map = new ConcurrentHashMap<>();

	/**
	 * Split words, create hash codes and return map
	 * 
	 * @param fileContent
	 * @return map
	 */
	public Map<Integer, Integer> getMap(String fileContent) {
		String[] words = fileContent.split(" ");
		for (String word : words) {
			int hash = word.hashCode();
			int frequency = 1;
			if (map.containsKey(hash)) {
				frequency += map.get(hash);
				map.put(hash, frequency);
			} else {
				map.put(hash, frequency);
			}
		}
		return map;
	}
}
