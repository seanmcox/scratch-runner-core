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
	 * 
	 * @param runtime
	 * @param runner 
	 * @param context
	 * @param arguments 
	 * @return The value resulting from the execution. Must be one of String, Integer, Double, or Boolean
	 */
	public Object execute(ScratchRuntime runtime, ScriptTupleRunner runner, ScriptContext context, Object[] arguments);
	
	/**
	 * Adds a value listener which the OpcodeValue will report all changes to. (If the OpcodeValue is static, then it can ignore this.)
	 * 
	 * @param valueListener
	 */
	public void addValueListener(ValueListener valueListener);
	
	/**
	 * 
	 * @param valueListener
	 */
	public void removeValueListener(ValueListener valueListener);
}
