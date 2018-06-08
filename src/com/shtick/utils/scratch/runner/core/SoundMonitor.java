/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import java.awt.event.ActionListener;

/**
 * @author Sean
 *
 */
public interface SoundMonitor {
	/**
	 * 
	 * @return true if the sound has finished playing, and false otherwise.
	 */
	public boolean isDone();
	
	/**
	 * 
	 * @param listener
	 */
	public void addCloseListener(ActionListener listener);
	
	/**
	 * 
	 * @param listener
	 */
	public void removeCloseListener(ActionListener listener);
	
	/**
	 * @param volume A value between 0 and 100.
	 * 
	 */
	public void setVolume(double volume);
	
	/**
	 * Stops the sound if currently still playing.
	 */
	public void stop();
}
