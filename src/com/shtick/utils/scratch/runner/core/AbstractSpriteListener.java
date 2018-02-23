/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import java.awt.geom.Point2D;

/**
 * @author sean.cox
 *
 */
public class AbstractSpriteListener implements SpriteListener {

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.SpriteListener#costumeChanged(int, java.lang.String, int, java.lang.String)
	 */
	@Override
	public void costumeChanged(int oldSceneIndex, String oldSceneName, int newSceneIndex, String newSceneName) {}

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.SpriteListener#scaleChanged(double, double)
	 */
	@Override
	public void scaleChanged(double oldValue, double newValue) {}

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.SpriteListener#headingChanged(double, double)
	 */
	@Override
	public void headingChanged(double oldValue, double newValue) {}

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.SpriteListener#rotationStyleChanged(java.lang.String, java.lang.String)
	 */
	@Override
	public void rotationStyleChanged(String oldValue, String newValue) {}

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.SpriteListener#positionChanged(java.awt.geom.Point2D, java.awt.geom.Point2D)
	 */
	@Override
	public void positionChanged(Point2D oldPoint, Point2D newPoint) {}

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.SpriteListener#effectChanged(java.lang.String, double, double)
	 */
	@Override
	public void effectChanged(String effect, double oldValue, double newValue) {}

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.SpriteListener#visibilityChanged(boolean)
	 */
	@Override
	public void visibilityChanged(boolean newVisibility) {}
}
