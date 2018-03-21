/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import com.shtick.utils.scratch.runner.core.elements.ScriptTuple;

/**
 * @author Sean
 *
 */
public interface OpcodeSubaction {
	/**
	 * @author Sean
	 *
	 */
	public enum Type{
		/**
		 * A type that will tell the runner whether to yield control on the script rather than continuing with the next script actions.
		 */
		YIELD_CHECK,
		/**
		 * A type that will provide further instruction to be executed before returning control to the currently executing script.
		 */
		SUBSCRIPT}
	
	/**
	 * 
	 * @return A Type indicating how the subaction should be interpreted.
	 */
	public Type getType();
	
	/**
	 * Provides the response for a YIELD_CHECK type OpcodeSubaction
	 * 
	 * @return true if the script should yield and false if it should continue.
	 */
	public boolean shouldYield();
	
	/**
	 * Provides a response for a SUBSCRIPT type OpcodeSubaction
	 * 
	 * @return The ScriptTuple to be run.
	 */
	public ScriptTuple getSubscript();
	
	/**
	 * Provides a response for a SUBSCRIPT type OpcodeSubaction
	 * 
	 * @return true if the subscript is atomic and false otherwise.
	 */
	public boolean isSubscriptAtomic();
}
