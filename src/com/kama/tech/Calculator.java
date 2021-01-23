package com.kama.tech;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Calculates differences between two files using c. distance
 * 
 * @author Kama
 * @version 1.0
 * @since 1.8
 */

public class Calculator {

	public Calculator() {

	}

	/**
	 * Merges two sets using DoubleBrace Initialization
	 * 
	 * @param Set<Integer> firstSet, Set<Integer> secondSet
	 * @return hashSet
	 */
	@SuppressWarnings("serial")
	private Set<Integer> mergeSet(Set<Integer> firstSet, Set<Integer> secondSet) {
		return new HashSet<Integer>() {
			{
				addAll(firstSet);
				addAll(secondSet);
			}
		};
	}

	/**
	 * Calculates c.distance between two files. Uses mergeSet method to create
	 * a set of all keys. Loops over the set of all keys, calculates dot product,
	 * dot product sum and frequencies. Calculates magnitudes and c. distance.
	 * 
	 * @param Map <Integer, Integer> qmap, Map <Integer, Integer> smap
	 * @return cDistance
	 * 
	 */
	public double getSimilarity(Map<Integer, Integer> qmap, Map<Integer, Integer> smap) {
		// Set of all keys
		Set<Integer> keys = this.mergeSet(qmap.keySet(), smap.keySet());

		// Local variables
		int qFrequency = 0;
		int sFrequency = 0;
		int dotProductSum = 0;
		int dotProductRow = 0;
		int qFrequencySquareSum = 0;
		int sFrequencySquareSum = 0;

		// Loop keys and calculates dot product, dot product sum and frequencies
		for (int key : keys) {
			qFrequency = 0;
			if (qmap.containsKey(key)) {
				qFrequency = qmap.get(key);
			}
			qFrequencySquareSum += (int) Math.pow(qFrequency, 2);

			sFrequency = 0;
			if (smap.containsKey(key)) {
				sFrequency = smap.get(key);
			}
			sFrequencySquareSum += (int) Math.pow(sFrequency, 2);

			// Dot Product row
			dotProductRow = qFrequency * sFrequency;

			// Dot Product Sum
			dotProductSum += dotProductRow;
		}

		// Magnitude
		double qMagnitude = Math.sqrt(qFrequencySquareSum);
		double sMagnitude = Math.sqrt(sFrequencySquareSum);

		// C. distance
		double qsMagnitude = (qMagnitude * sMagnitude) == 0 ? 1 : (qMagnitude * sMagnitude);
		double cDistance = dotProductSum / qsMagnitude;

		return cDistance;
	}
}
