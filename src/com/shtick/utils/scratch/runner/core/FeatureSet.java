/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import java.util.Set;

/**
 * @author scox
 *
 */
public interface FeatureSet {
	/**
	 * 
	 * @param opcode
	 * @return The Opcode with the given id.
	 */
	public Opcode getOpcode(String opcode);
	
	/**
	 * 
	 * @return A set of Opcodes.
	 */
	public Set<Opcode> getOpcodes();

	/**
	 * 
	 * @param id
	 * @return The GraphicEffect with the given id.
	 */
	public GraphicEffect getGraphicEffect(String id);
	
	/**
	 * 
	 * @return A set of GraphicEffects.
	 */
	public Set<GraphicEffect> getGraphicEffects();

	/**
	 * 
	 * @param id
	 * @return The StageMonitorCommand with the given id.
	 */
	public StageMonitorCommand getStageMonitorCommand(String id);
	
	/**
	 * 
	 * @return A set of StageMonitorCommand.
	 */
	public Set<StageMonitorCommand> getStageMonitorCommands();
}
