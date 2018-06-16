/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author scox
 *
 */
public class StageMonitorCommandRegistry {
	private static StageMonitorCommandRegistry DEFAULT_STAGE_MONITOR_REGISTRY = new StageMonitorCommandRegistry();
	private HashMap<String,StageMonitorCommand> stageMonitorCommands=new HashMap<>();
	
	/**
	 * @return A static shared instance of StageMonitorCommandRegistry.
	 * 
	 */
	public static StageMonitorCommandRegistry getStageMonitorCommandRegistry() {
		return DEFAULT_STAGE_MONITOR_REGISTRY;
	}
	
	/**
	 * 
	 * @param id
	 * @return The StageMonitorCommand with the given id.
	 */
	public StageMonitorCommand getStageMonitorCommand(String id){
		synchronized(stageMonitorCommands){
			return stageMonitorCommands.get(id);
		}
	}
	
	/**
	 * 
	 * @return A set of already registered commands.
	 */
	public Set<StageMonitorCommand> getStageMonitorCommands(){
		synchronized(stageMonitorCommands){
			return new HashSet<>(stageMonitorCommands.values());
		}
	}
	
	/**
	 * 
	 * @param stageMonitorCommand 
	 */
	public void registerStageMonitorCommand(StageMonitorCommand stageMonitorCommand){
		synchronized(stageMonitorCommands) {
			stageMonitorCommands.put(stageMonitorCommand.getCommand(),stageMonitorCommand);
		}
	}

	/**
	 * 
	 * @param stageMonitorCommand 
	 */
	public void unregisterStageMonitorCommand(StageMonitorCommand stageMonitorCommand){
		synchronized(stageMonitorCommands) {
			if(stageMonitorCommand == stageMonitorCommands.get(stageMonitorCommand.getCommand()))
				stageMonitorCommands.remove(stageMonitorCommand.getCommand());
		}
	}
	
	/**
	 * 
	 * @param stageMonitorCommands
	 */
	public void registerStageMonitorCommand(Collection<StageMonitorCommand> stageMonitorCommands){
		synchronized(stageMonitorCommands) {
			for(StageMonitorCommand stageMonitorCommand:stageMonitorCommands)
				this.stageMonitorCommands.put(stageMonitorCommand.getCommand(),stageMonitorCommand);
		}
	}

	/**
	 * 
	 * @param stageMonitorCommands
	 */
	public void unregisterStageMonitorCommand(Collection<StageMonitorCommand> stageMonitorCommands){
		synchronized(stageMonitorCommands) {
			for(StageMonitorCommand stageMonitorCommand:stageMonitorCommands)
				if(stageMonitorCommand == this.stageMonitorCommands.get(stageMonitorCommand.getCommand()))
					this.stageMonitorCommands.remove(stageMonitorCommand.getCommand());
		}
	}
}
