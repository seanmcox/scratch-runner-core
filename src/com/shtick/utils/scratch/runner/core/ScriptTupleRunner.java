/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import com.shtick.utils.scratch.runner.core.elements.BlockTuple;
import com.shtick.utils.scratch.runner.core.elements.ScriptContext;

/**
 * @author sean.cox
 *
 */
public interface ScriptTupleRunner {
	/**
	 * Tells the ScriptTupleRunner to stop executing the current BlockTuples. If there are multiple scripts in the call stack, this will cause only the current script to return.
	 */
	public void flagStop();
	
	/**
	 * 
	 * @return true if flagStop has been called on the instance, or false otherwise.
	 */
	public boolean isStopFlagged();
	
	/**
	 * 
	 * @return true if the ScriptTupleRunner has completed its run through the script (including if the run is aborted) and false otherwise.
	 */
	public boolean isStopped();
	
	/**
	 * 
	 * @param blockTuple
	 * @return The Opcode being referred to by blockTuple.
	 */
	public Opcode getOpcode(BlockTuple blockTuple);
	
	/**
	 * 
	 * @return The ScriptContext for the script being run.
	 */
	public ScriptContext getContext();
	
	/**
	 * 
	 * @param blockTuple
	 * @return The Opcode currently being executed.
	 *         Between opcodes this could be the last one executed, or the next one that will be executed.
	 *         Can be null at the beginning or end of the thread.
	 */
	public Opcode getCurrentOpcode();
	
	/**
	 * 
	 * @return A string in which each line describes an element of the current scratch call stack.
	 */
	public String getStackTrace();
}
