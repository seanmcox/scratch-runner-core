/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements.control;

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
	public Object[] getArguments() {
		return new Object[] {index};
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
