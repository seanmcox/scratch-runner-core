/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

/**
 * @author Sean
 *
 */
public class InvalidScriptDefinitionException extends Exception {

	/**
	 * 
	 */
	public InvalidScriptDefinitionException() {
	}

	/**
	 * @param arg0
	 */
	public InvalidScriptDefinitionException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public InvalidScriptDefinitionException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public InvalidScriptDefinitionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public InvalidScriptDefinitionException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
