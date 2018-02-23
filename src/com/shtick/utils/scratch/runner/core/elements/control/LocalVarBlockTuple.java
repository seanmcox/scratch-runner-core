/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements.control;

/**
 * @author sean.cox
 *
 */
public abstract class LocalVarBlockTuple extends ControlBlockTuple{
	private Integer id;
	
	/**
	 * @param id An ID for the local variable.
	 */
	public LocalVarBlockTuple(Integer id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Integer getLocalVarIdentifier() {
		return id;
	}

	/**
	 * @param id the index to set
	 */
	public void setLocalVarIdentifier(Integer id) {
		this.id = id;
	}
}
