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
	 * @param message
	 */
	public InvalidScriptDefinitionException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidScriptDefinitionException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidScriptDefinitionException(String message, Throwable cause) {
		super(message, cause);
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
