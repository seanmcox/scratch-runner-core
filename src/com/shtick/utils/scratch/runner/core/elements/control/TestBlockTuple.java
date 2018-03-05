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
public class TestBlockTuple extends ControlBlockTuple{
	java.util.List<Object> args;
	private Object test;
	
	/**
	 * @param test Either a Boolean, or a BlockTuple that should resolve to a Boolean.
	 */
	public TestBlockTuple(Object test) {
		super();
		this.test = test;
		args = new ArrayList<>(1);
		args.add(test);
		args = Collections.unmodifiableList(args);
	}

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.elements.BlockTuple#getArguments()
	 */
	@Override
	public java.util.List<Object> getArguments() {
		return args;
	}
}
