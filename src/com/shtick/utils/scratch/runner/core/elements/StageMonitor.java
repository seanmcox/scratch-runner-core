/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements;

/**
 * @author sean.cox
 *
 */
public interface StageMonitor extends RenderableChild{
	/**
	 * 
	 */
	public static final int MODE_NORMAL = 1;
	/**
	 * 
	 */
	public static final int MODE_LARGE = 2;
	/**
	 * 
	 */
	public static final int MODE_SLIDER = 3;

	/**
	 * @return the target
	 */
	public String getTarget();

	/**
	 * @return the cmd
	 */
	public String getCmd();

	/**
	 * @return the param
	 */
	public String getParam();

	/**
	 * @return the color
	 */
	public int getColor();

	/**
	 * @return the label
	 */
	public String getLabel();

	/**
	 * @return the mode
	 */
	public int getMode();

	/**
	 * @return the sliderMin
	 */
	public int getSliderMin();

	/**
	 * @return the sliderMax
	 */
	public int getSliderMax();

	/**
	 * @return the isDiscrete
	 */
	public boolean isDiscrete();

	/**
	 * @return the x
	 */
	public int getX();

	/**
	 * @return the y
	 */
	public int getY();
}
