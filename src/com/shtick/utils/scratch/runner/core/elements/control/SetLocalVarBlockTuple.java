/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements.control;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The local variables are ephemeral variables.
 * The identifier for the variable only has meaning within the context of the control operation for which it was defined.
 * A thread processing this BlockTuple can associate it with whichever memory address, or register, or whatever,
 * that it deems appropriate, and may internally replace this BlockTuple with a copy that has a more suitable identifier unique to the script being processed.
 * 
 * @author sean.cox
 *
 */
public class SetLocalVarBlockTuple extends LocalVarBlockTuple{
	java.util.List<Object> args;
	private Object value;
	
	/**
	 * @param id 
	 * @param value 
	 */
	public SetLocalVarBlockTuple(Integer id, Object value) {
		super(id);
		this.value = value;
		argumentsUpdated();
	}
	
	private void argumentsUpdated() {
		args = new ArrayList<>(2);
		args.add(getLocalVarIdentifier());
		args.add(value);
		args = Collections.unmodifiableList(args);
	}

	/* (non-Javadoc)
	 * @see com.shtick.utils.scratch.runner.core.elements.BlockTuple#getArguments()
	 */
	@Override
	public java.util.List<Object> getArguments() {
		return args;
	}

	@Override
	public void setLocalVarIdentifier(Integer id) {
		super.setLocalVarIdentifier(id);
		argumentsUpdated();
	}
}
