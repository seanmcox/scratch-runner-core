package com.shtick.utils.scratch.runner.core;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * 
 * @author scox
 *
 */
public class FeatureLibrary {
	private static HashMap<String, FeatureSetGenerator> generators = new HashMap<>();

	/**
	 * 
	 * @param name
	 * @return The named FeatureSetGenerator, or null if none is defined with the given name.
	 */
	public static FeatureSetGenerator getFeatureSetGenerator(String name) {
		return generators.get(name);
	}
	
	/**
	 * 
	 * @param generator
	 */
	public static void registerFeatureSetGenerator(FeatureSetGenerator generator) {
		generators.put(generator.getFeatureSetName(), generator);
	}

	/**
	 * 
	 * @param generator
	 */
	public static void unregisterFeatureSetGenerator(FeatureSetGenerator generator) {
		if(generators.get(generator.getFeatureSetName()) == generator)
			generators.remove(generator.getFeatureSetName());
	}
	
	/**
	 * 
	 * @return A collection of all registered FeatureSetGenerators.
	 */
	public static Collection<FeatureSetGenerator> getFeatureSetGenerators(){
		return Collections.unmodifiableCollection(generators.values());
	}
}
