/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements.control;

/**
 * @author sean.cox
 *
 */
public class TestBlockTuple extends ControlBlockTuple{
	private Object test;
	
	/**
	 * @param test Either a Boolean, or a BlockTuple that should resolve to a Boolean.
	 */
	public TestBlockTuple(Object test) {
		super();
		this.test = test;
	}

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.elements.BlockTuple#getArguments()
	 */
	@Override
	public Object[] getArguments() {
		return new Object[] {test};
	}
}
