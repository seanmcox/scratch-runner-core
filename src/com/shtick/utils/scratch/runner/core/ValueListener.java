/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import com.shtick.utils.scratch.runner.core.elements.ScriptContext;

/**
 * @author sean.cox
 *
 */
public interface ValueListener {
	/**
	 * 
	 * @return The ScriptContext in which the OpcodeValue will be evaluating.
	 */
	public ScriptContext getScriptContext();
	
	/**
	 * 
	 * @return The arguments for OpcodeValueExecution
	 */
	public Object[] getArguments();
	
	/**
	 * 
	 * @param oldValue
	 * @param newValue
	 */
	public void valueUpdated(Object oldValue, Object newValue);
}
