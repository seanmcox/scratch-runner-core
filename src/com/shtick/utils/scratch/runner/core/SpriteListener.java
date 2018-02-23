/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import java.awt.geom.Point2D;

/**
 * @author sean.cox
 *
 */
public interface SpriteListener {
	/**
	 * 
	 * @param oldSceneIndex 1-based index
	 * @param oldSceneName
	 * @param newSceneIndex 1-based index
	 * @param newSceneName
	 */
	public void costumeChanged(int oldSceneIndex, String oldSceneName, int newSceneIndex, String newSceneName);
	
	/**
	 * 
	 * @param oldValue
	 * @param newValue
	 */
	public void scaleChanged(double oldValue, double newValue);
	
	/**
	 * 
	 * @param oldValue
	 * @param newValue
	 */
	public void headingChanged(double oldValue, double newValue);
	
	/**
	 * 
	 * @param oldValue
	 * @param newValue
	 */
	public void rotationStyleChanged(String oldValue, String newValue);
	
	/**
	 * 
	 * @param oldPoint
	 * @param newPoint
	 */
	public void positionChanged(Point2D oldPoint, Point2D newPoint);
	
	/**
	 * @param effect 
	 * @param oldValue 
	 * @param newValue 
	 * 
	 */
	public void effectChanged(String effect, double oldValue, double newValue);
	
	/**
	 * @param newVisibility 
	 * 
	 */
	public void visibilityChanged(boolean newVisibility);
}
