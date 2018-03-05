/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import com.shtick.utils.scratch.runner.core.elements.ScriptContext;

/**
 * @author sean.cox
 *
 */
public interface OpcodeAction extends Opcode{
	/**
	 * TODO Change the arguments parameter to be read-only.
	 * 
	 * @param runtime
	 * @param scriptRunner 
	 * @param context A ScriptContext. This will either be an instance of a Stage or a Sprite.
	 * @param arguments
	 * @throws IllegalArgumentException if one of the arguments is of an unexpected or improper type, or if the an argument is missing or superfluous
	 */
	public void execute(ScratchRuntime runtime, ScriptTupleRunner scriptRunner, ScriptContext context, Object[] arguments);
}
