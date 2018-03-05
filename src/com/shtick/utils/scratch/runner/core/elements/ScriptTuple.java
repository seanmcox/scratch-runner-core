/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements;

/**
 * A Tuple containing other Tuples
 * 
 * @author sean.cox
 *
 */
public interface ScriptTuple extends Tuple{

	/**
	 * @return List of all BlockTuples
	 */
	public java.util.List<BlockTuple> getBlockTuples();
	
	/**
	 * 
	 * @param index
	 * @return The BlockTuple at the given index.
	 */
	public BlockTuple getBlockTuple(int index);
	
	/**
	 * 
	 * @return The number of BlockTuples in this ScriptTuple
	 */
	public int getBlockTupleCount();

	/**
	 * @return the context
	 */
	public ScriptContext getContext();
	
	/**
	 * When creating a sprite clone, exactly the same script will be associated with the new clone,
	 * just with a different context.
	 * 
	 * TODO Come up with a pithy name that isn't easily confused with an existing standard function name.
	 * 
	 * @param context
	 * @return A ScriptTupleImplementation that contains the same script with given context.
	 */
	public ScriptTuple clone(ScriptContext context);

}
