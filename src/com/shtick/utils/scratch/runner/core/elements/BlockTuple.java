/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements;

/**
 * A Tuple with a String as the first element.
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
	 * @return the arguments; an array of Objects. These can be String, Integer, Double, Boolean, BlockTuple, or List&lt;BlockTuple>
	 */
	public Object[] getArguments();
}
