/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

/**
 * @author sean.cox
 *
 */
public interface Opcode {
	/**
	 * @author Sean
	 *
	 */
	public enum DataType{
	/**
	 * 
	 */
	STRING,
	/**
	 * 
	 */
	NUMBER,
	/**
	 * 
	 */
	BOOLEAN,
	/**
	 * Shows up in the arguments and an Object[]
	 */
	TUPLE,
	/**
	 * Shows up in arguments as a List<>
	 */
	SCRIPT,
	/**
	 * This means any one of the preceding data types, except TUPLE, or SCRIPT.
	 */
	OBJECT,
	/**
	 * Must be the last data type of an argument list.
	 * Takes zero or more trailing arguments and puts them in an array to pass in to the opcode implementation, when executed.
	 */
	OBJECTS
	};
	
	/**
	 * 
	 * @return The opcode for the instruction.
	 */
	public String getOpcode();

	/**
	 * 
	 * @return An array describing the DataTypes to be accepted as opcode arguments.
	 */
	public DataType[] getArgumentTypes();
}
