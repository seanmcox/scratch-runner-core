/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import com.shtick.utils.scratch.runner.core.elements.ScriptContext;

/**
 * @author sean.cox
 *
 */
public interface StageMonitorCommand {
	/**
	 * 
	 * @return The command text that identifies this command.
	 */
	public String getCommand();
	
	/**
	 * 
	 * @param runtime
	 * @param context 
	 * @param param 
	 * @return The String resulting from the execution of the command.
	 * @throws IllegalArgumentException if param doesn't make sense for the comment.
	 */
	public String execute(ScratchRuntime runtime, ScriptContext context, String param);
	
	/**
	 * @param valueListener 
	 * 
	 */
	public void addValueListener(ValueListener valueListener);
	
	/**
	 * @param valueListener 
	 * 
	 */
	public void removeValueListener(ValueListener valueListener);
}
