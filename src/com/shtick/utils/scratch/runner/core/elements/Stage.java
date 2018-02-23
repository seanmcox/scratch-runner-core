/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements;

import com.shtick.utils.scratch.runner.core.StageListener;

/**
 * @author sean.cox
 *
 */
public interface Stage extends ScriptContext{

	/**
	 * @return the objName
	 */
	public String getObjName();

	/**
	 * @return the penLayerID
	 */
	public long getPenLayerID();

	/**
	 * @return the penLayerMD5
	 */
	public String getPenLayerMD5();

	/**
	 * @return the tempoBPM
	 */
	public long getTempoBPM();

	/**
	 * 
	 * @return The current Costume.
	 */
	public Costume getCurrentCostume();
	
	/**
	 * 
	 * @param i (base-0)
	 */
	public void setCurrentCostumeIndex(int i);

	/**
	 * @return the currentCostumeIndex (base-0)
	 */
	public int getCurrentCostumeIndex();

	/**
	 * 
	 * @return The the number of costumes.
	 */
	public int getCostumeCount();
	
	/**
	 * Sets the costume by its name.
	 * @param name
	 */
	public void startScene(String name);
	
	/**
	 * 
	 * @param listener
	 */
	public void addStageListener(StageListener listener);
	
	/**
	 * 
	 * @param listener
	 */
	public void removeStageListener(StageListener listener);
}
