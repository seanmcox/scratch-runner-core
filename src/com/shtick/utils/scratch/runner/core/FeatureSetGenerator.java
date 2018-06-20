/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

/**
 * @author scox
 *
 */
public interface FeatureSetGenerator {
	/**
	 * 
	 * @return A label for the set of features generated by this FeatureSetGenerator.
	 */
	public String getFeatureSetName();
	
	/**
	 * 
	 * @return A new instance of the FeatureSet.
	 */
	public FeatureSet generateFeatureSet();
}
