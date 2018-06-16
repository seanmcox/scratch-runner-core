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
public class OpcodeRegistry {
	private static OpcodeRegistry DEFAULT_OPCODE_REGISTRY = new OpcodeRegistry();
	private HashMap<String,Opcode> opcodes=new HashMap<>();
	
	/**
	 * @return A static shared instance of OpcodeRegistry.
	 * 
	 */
	public static OpcodeRegistry getOpcodeRegistry() {
		return DEFAULT_OPCODE_REGISTRY;
	}
	
	/**
	 * 
	 * @param opcodeID
	 * @return The Opcode with the given id.
	 */
	public Opcode getOpcode(String opcodeID){
		synchronized(opcodes){
			return opcodes.get(opcodeID);
		}
	}
	
	/**
	 * 
	 * @return A set of already registered opcodes.
	 */
	public Set<Opcode> getOpcodes(){
		synchronized(opcodes){
			return new HashSet<>(opcodes.values());
		}
	}
	
	/**
	 * 
	 * @param opcode 
	 */
	public void registerOpcode(Opcode opcode){
		synchronized(opcodes) {
			opcodes.put(opcode.getOpcode(),opcode);
		}
	}

	/**
	 * 
	 * @param opcode 
	 */
	public void unregisterOpcode(Opcode opcode){
		synchronized(opcodes) {
			if(opcode == opcodes.get(opcode.getOpcode()))
				opcodes.remove(opcode.getOpcode());
		}
	}
	
	/**
	 * 
	 * @param opcodes
	 */
	public void registerOpcodes(Collection<Opcode> opcodes){
		synchronized(opcodes) {
			for(Opcode opcode:opcodes)
				this.opcodes.put(opcode.getOpcode(),opcode);
		}
	}

	/**
	 * 
	 * @param opcodes
	 */
	public void unregisterOpcodes(Collection<Opcode> opcodes){
		synchronized(opcodes) {
			for(Opcode opcode:opcodes)
				if(opcode == this.opcodes.get(opcode.getOpcode()))
					this.opcodes.remove(opcode.getOpcode());
		}
	}
}
