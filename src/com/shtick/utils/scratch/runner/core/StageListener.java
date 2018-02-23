/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

/**
 * @author sean.cox
 *
 */
public interface StageListener {
	/**
	 * 
	 * @param oldSceneIndex 1-based index
	 * @param oldSceneName
	 * @param newSceneIndex 1-based index
	 * @param newSceneName
	 */
	public void sceneChanged(int oldSceneIndex, String oldSceneName, int newSceneIndex, String newSceneName);
}
