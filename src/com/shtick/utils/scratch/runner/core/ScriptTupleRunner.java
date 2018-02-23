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
	 * Tells the ScriptTupleRunner to stop executing BlockTuples.
	 */
	public void flagStop();
	
	/**
	 * 
	 * @return true if flagStop has been called on the instance, or false otherwise.
	 */
	public boolean isStopFlagged();

	/**
	 * Runs a chain of BlockTuples. Blocks until the script completes.
	 * 
	 * @param context The context to be used by the script.
	 * @param script The list of BlockTuples to run. Can be null.
	 * @throws InvalidScriptDefinitionException 
	 */
	@Deprecated
	public void runBlockTuples(ScriptContext context, java.util.List<BlockTuple> script) throws InvalidScriptDefinitionException;
//	
//	/**
//	 * 
//	 * @param context The context in which the logic will be evaluated.
//	 * @param object One of String, Boolean, Integer, Double, or BlockTuple
//	 * @return If object is a BlockTuple, then the value determined for the given BlockTuple is returned. Otherwise object is returned unchanged.
//	 */
//	public Object getValue(ScriptContext context, Object object);
	
	/**
	 * 
	 * @param blockTuple
	 * @return The Opcode being referred to by blockTuple.
	 */
	public Opcode getOpcode(BlockTuple blockTuple);
	
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
	 * @return true if the current script is executing atomically, and false otherwise.
	 */
	public boolean isAtomic();
	

    /**
     * Waits at most {@code millis} milliseconds plus
     * {@code nanos} nanoseconds for the associated thread to die.
     *
     * @param  millis
     *         the time to wait in milliseconds
     *
     * @param  nanos
     *         {@code 0-999999} additional nanoseconds to wait
     *
     * @throws  IllegalArgumentException
     *          if the value of {@code millis} is negative, or the value
     *          of {@code nanos} is not in the range {@code 0-999999}
     *
     * @throws  InterruptedException
     *          if any thread has interrupted the associated thread. The
     *          <i>interrupted status</i> of the associated thread is
     *          cleared when this exception is thrown.
     */
    public void join(long millis, int nanos) throws InterruptedException;

    /**
     * Waits for the associated thread to die.
     *
     * <p> An invocation of this method behaves in exactly the same
     * way as the invocation
     *
     * <blockquote>
     * {@linkplain #join(long) join}{@code (0)}
     * </blockquote>
     *
     * @throws  InterruptedException
     *          if any thread has interrupted the associated thread. The
     *          <i>interrupted status</i> of the associated thread is
     *          cleared when this exception is thrown.
     */
    public void join() throws InterruptedException;

}
