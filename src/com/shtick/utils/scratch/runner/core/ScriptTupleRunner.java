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
