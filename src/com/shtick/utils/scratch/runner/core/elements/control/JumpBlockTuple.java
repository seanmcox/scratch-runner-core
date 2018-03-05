/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements.control;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author sean.cox
 *
 */
public abstract class JumpBlockTuple extends ControlBlockTuple{
	java.util.List<Object> args;
	private Integer index;
	
	/**
	 * @param index
	 */
	public JumpBlockTuple(Integer index) {
		this.index = index;
		args = new ArrayList<>(1);
		args.add(index);
		args = Collections.unmodifiableList(args);
	}

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.elements.BlockTuple#getArguments()
	 */
	@Override
	public java.util.List<Object> getArguments() {
		return args;
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
