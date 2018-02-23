/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements;

import java.awt.image.BufferedImage;

/**
 * @author sean.cox
 *
 */
public interface Costume {
	/**
	 * @return the costumeName
	 */
	public String getCostumeName();

	/**
	 * @return the baseLayerID
	 */
	public long getBaseLayerID();

	/**
	 * @return the baseLayerMD5
	 */
	public String getBaseLayerMD5();

	/**
	 * @return the bitmapResolution
	 */
	public int getBitmapResolution();

	/**
	 * @return the rotationCenterX
	 */
	public int getRotationCenterX();

	/**
	 * @return the rotationCenterY
	 */
	public int getRotationCenterY();

	/**
	 * @return the image
	 */
	public BufferedImage getImage();
}
