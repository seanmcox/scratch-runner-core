/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements.control;

import com.shtick.utils.scratch.runner.core.elements.BlockTuple;

/**
 * A Tuple with a String as the first element.
 * 
 * @author sean.cox
 *
 */
public abstract class ControlBlockTuple implements BlockTuple{
	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.elements.BlockTuple#getOpcode()
	 */
	@Override
	public String getOpcode() {
		return this.getClass().getName();
	}

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.elements.Tuple#toArray()
	 */
	@Override
	public Object[] toArray() {
		return null;
	}
}
