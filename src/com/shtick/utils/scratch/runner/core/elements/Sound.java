/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements;

/**
 * @author sean.cox
 *
 */
public interface Sound {
	/**
	 * @return the soundName
	 */
	public String getSoundName();

	/**
	 * @return the soundID
	 */
	public long getSoundID();

	/**
	 * @return the md5
	 */
	public String getMd5();

	/**
	 * @return the sampleCount
	 */
	public long getSampleCount();

	/**
	 * @return the rate
	 */
	public long getRate();

	/**
	 * @return the format
	 */
	public String getFormat();
	
}
