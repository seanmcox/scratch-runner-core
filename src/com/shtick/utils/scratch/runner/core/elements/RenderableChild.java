/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements;

/**
 * @author sean.cox
 *
 */
public interface RenderableChild {
	/**
	 * 
	 * @return true if the RenderableChild is visible and false otherwise.
	 */
	public boolean isVisible();
	
	/**
	 * 
	 * @param visible
	 */
	public void setVisible(boolean visible);
}
