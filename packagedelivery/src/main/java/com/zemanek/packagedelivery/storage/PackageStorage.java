package com.zemanek.packagedelivery.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.zemanek.packagedelivery.model.Package;

/**
 * Class representing the storage of the package items
 * 
 * @author Petr Zemanek
 *
 */
public class PackageStorage {
	
	// Package info storage
	private ArrayList<Package> storage = new ArrayList<Package>(); 

	public PackageStorage() {		
	}
	
	/**
	 * Adds a package to the storage
	 * @param pckg
	 */
	public synchronized void addPackage(Package pckg) {
		storage.add(pckg);
	}
	
	/**
	 * Aggregation of items by ZIP
	 * @return Map of ZIP and sum 
	 */
	public synchronized Map<String, Double> groupWeightByZip() {
		Map<String, Double> ret = storage
	            .stream()
	            .collect(
	            	Collectors.groupingBy(
	            		Package::getZipCode, 
	            		Collectors.summingDouble(p -> p.getWeight().doubleValue())
	            	)
	            );
		
		return ret;
	}
	
	/**
	 * Sorts the items by the sum desc and concatenates the fields for easier display 
	 * @return
	 */
	public synchronized List<String> listByWeightSorted() {
		Map<String, Double> gb = groupWeightByZip();
		List<String> ret = gb.keySet().stream()
				.sorted((k1, k2) -> {
					Double d1 = (Double)gb.get(k1);
					Double d2 = gb.get(k2);
					return d2.compareTo(d1);
				}).
				map(k -> {
					String s = k + " " + String.format("%.3f", gb.get(k).doubleValue());
					return s;
				}).collect(Collectors.toList())
				;
		return ret;
	}
}
