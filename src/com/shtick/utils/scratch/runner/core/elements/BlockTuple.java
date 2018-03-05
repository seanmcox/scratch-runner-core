/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements;

/**
 * A Tuple with a String as the first element.
 * 
 * TODO Don't pass the BlockTuple out to the block implementations.
 * Move this definition to the scratch runner implementation. 
 * 
 * @author sean.cox
 *
 */
public interface BlockTuple extends Tuple{
	/**
	 * @return the opcode, the first element of the tuple.
	 */
	public String getOpcode();

	/**
	 * @return the arguments; an immutable list of Objects. These can be String, Integer, Double, Boolean, BlockTuple, or List&lt;BlockTuple>
	 */
	public java.util.List<Object> getArguments();
}
