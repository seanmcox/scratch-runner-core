/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements.control;

/**
 * The local variables are ephemeral variables.
 * The identifier for the variable only has meaning within the context of the control operation for which it was defined.
 * A thread processing this BlockTuple can associate it with whichever memory address, or register, or whatever,
 * that it deems appropriate, and may internally replace this BlockTuple with a copy that has a more suitable identifier unique to the script being processed.
 * 
 * @author sean.cox
 *
 */
public class ReadLocalVarBlockTuple extends LocalVarBlockTuple{
	/**
	 * @param id 
	 */
	public ReadLocalVarBlockTuple(Integer id) {
		super(id);
	}

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.elements.BlockTuple#getArguments()
	 */
	@Override
	public Object[] getArguments() {
		return new Object[] {getLocalVarIdentifier()};
	}
}
