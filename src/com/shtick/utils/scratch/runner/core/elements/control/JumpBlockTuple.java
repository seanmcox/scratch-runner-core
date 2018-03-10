/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements.control;

import java.util.Arrays;

/**
 * @author sean.cox
 *
 */
public abstract class JumpBlockTuple extends ControlBlockTuple{
	private Integer index;
	
	/**
	 * @param index
	 */
	public JumpBlockTuple(Integer index) {
		this.index = index;
	}

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.elements.BlockTuple#getArguments()
	 */
	@Override
	public java.util.List<Object> getArguments() {
		return Arrays.asList(index);
	}

	/**
	 * @return the index
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}
}
