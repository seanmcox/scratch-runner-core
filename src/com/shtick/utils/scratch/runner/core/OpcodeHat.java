/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import com.shtick.utils.scratch.runner.core.elements.ScriptTuple;

/**
 * @author sean.cox
 *
 */
public interface OpcodeHat extends Opcode{
	/**
	 * Should be the first called just after the application starts, marking the moment when event firing can be started.
	 * 
	 * @param runtime
	 */
	public void applicationStarted(ScratchRuntime runtime);
	
	/**
	 * Generally, scripts will be registered before applicationStarted is called,
	 * though clones will register their scripts afterwards. 
	 * 
	 * @param script 
	 * @param params 
	 * 
	 */
	public void registerListeningScript(ScriptTuple script, Object[] params);
	
	/**
	 * Generally, only clones will worry about unregistering their scripts.
	 * 
	 * @param script 
	 * @param params 
	 * 
	 */
	public void unregisterListeningScript(ScriptTuple script, Object[] params);
}
