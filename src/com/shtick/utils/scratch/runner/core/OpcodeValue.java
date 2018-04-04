/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import com.shtick.utils.scratch.runner.core.elements.ScriptContext;

/**
 * @author sean.cox
 *
 */
public interface OpcodeValue extends Opcode{
	/**
	 * TODO Change the arguments parameter to be read-only.
	 * 
	 * @param runtime
	 * @param runner 
	 * @param context
	 * @param arguments 
	 * @return The value resulting from the execution. Must be one of String, Long, Double, or Boolean
	 */
	public Object execute(ScratchRuntime runtime, ScriptTupleRunner runner, ScriptContext context, Object[] arguments);
}
