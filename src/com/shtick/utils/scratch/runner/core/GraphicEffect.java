/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import java.awt.image.BufferedImage;

/**
 * @author sean.cox
 *
 */
public interface GraphicEffect {
	/**
	 * 
	 * @return The name of the effect, as identified by blocks that refer to effects.
	 */
	public String getName();
	
	/**
	 * 
	 * @param image May be modified.
	 * @param value
	 * @return The updated image. (May be the same instance as image)
	 */
	public BufferedImage getAffectedImage(BufferedImage image, double value);
}
