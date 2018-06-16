package com.shtick.utils.scratch.runner.core.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.shtick.utils.scratch.runner.core.ScratchRuntime;
import com.shtick.utils.scratch.runner.core.StageMonitorCommand;
import com.shtick.utils.scratch.runner.core.StageMonitorCommandRegistry;
import com.shtick.utils.scratch.runner.core.ValueListener;
import com.shtick.utils.scratch.runner.core.elements.ScriptContext;

class StageMonitorCommandRegistryTest {

	@Test
	void testConstructor() {
		StageMonitorCommandRegistry registry = new StageMonitorCommandRegistry();
	}

	@Test
	void testStaticSharedInstance() {
		StageMonitorCommandRegistry instance = StageMonitorCommandRegistry.getStageMonitorCommandRegistry();
		StageMonitorCommandRegistry notInstance = new StageMonitorCommandRegistry();
		assertEquals(instance,StageMonitorCommandRegistry.getStageMonitorCommandRegistry());
		
		StageMonitorCommand op = new StageMonitorCommand() {
			
			@Override
			public void removeValueListener(ValueListener valueListener) {
			}
			
			@Override
			public String getCommand() {
				return "op";
			}
			
			@Override
			public String execute(ScratchRuntime runtime, ScriptContext context, String param) {
				return null;
			}
			
			@Override
			public void addValueListener(ValueListener valueListener) {
			}
		};
		StageMonitorCommandRegistry.getStageMonitorCommandRegistry().registerStageMonitorCommand(op);

		assertEquals(instance,StageMonitorCommandRegistry.getStageMonitorCommandRegistry());
		
		assertEquals(op,instance.getStageMonitorCommand("op"));
		assertNull(notInstance.getStageMonitorCommand("op"));
	}

	@Test
	void testRegister() {
		StageMonitorCommandRegistry instance = new StageMonitorCommandRegistry();
		StageMonitorCommand op1 = new StageMonitorCommand() {
			
			@Override
			public void removeValueListener(ValueListener valueListener) {
			}
			
			@Override
			public String getCommand() {
				return "op1";
			}
			
			@Override
			public String execute(ScratchRuntime runtime, ScriptContext context, String param) {
				return null;
			}
			
			@Override
			public void addValueListener(ValueListener valueListener) {
			}
		};
		StageMonitorCommand op2 = new StageMonitorCommand() {
			
			@Override
			public void removeValueListener(ValueListener valueListener) {
			}
			
			@Override
			public String getCommand() {
				return "op2";
			}
			
			@Override
			public String execute(ScratchRuntime runtime, ScriptContext context, String param) {
				return null;
			}
			
			@Override
			public void addValueListener(ValueListener valueListener) {
			}
		};
		StageMonitorCommand op3 = new StageMonitorCommand() {
			
			@Override
			public void removeValueListener(ValueListener valueListener) {
			}
			
			@Override
			public String getCommand() {
				return "op3";
			}
			
			@Override
			public String execute(ScratchRuntime runtime, ScriptContext context, String param) {
				return null;
			}
			
			@Override
			public void addValueListener(ValueListener valueListener) {
			}
		};

		assertNull(instance.getStageMonitorCommand("op1"));
		assertNull(instance.getStageMonitorCommand("op2"));
		assertNull(instance.getStageMonitorCommand("op3"));
		assertEquals(0,instance.getStageMonitorCommands().size());
		
		instance.registerStageMonitorCommand(op1);
		assertEquals(op1,instance.getStageMonitorCommand("op1"));
		assertNull(instance.getStageMonitorCommand("op2"));
		assertNull(instance.getStageMonitorCommand("op3"));
		assertEquals(1,instance.getStageMonitorCommands().size());
		assertTrue(instance.getStageMonitorCommands().contains(op1));

		instance.registerStageMonitorCommand(op2);
		assertEquals(op1,instance.getStageMonitorCommand("op1"));
		assertEquals(op2,instance.getStageMonitorCommand("op2"));
		assertNull(instance.getStageMonitorCommand("op3"));
		assertEquals(2,instance.getStageMonitorCommands().size());
		assertTrue(instance.getStageMonitorCommands().contains(op1));
		assertTrue(instance.getStageMonitorCommands().contains(op2));

		instance.registerStageMonitorCommand(op3);
		assertEquals(op1,instance.getStageMonitorCommand("op1"));
		assertEquals(op2,instance.getStageMonitorCommand("op2"));
		assertEquals(op3,instance.getStageMonitorCommand("op3"));
		assertEquals(3,instance.getStageMonitorCommands().size());
		assertTrue(instance.getStageMonitorCommands().contains(op1));
		assertTrue(instance.getStageMonitorCommands().contains(op2));
		assertTrue(instance.getStageMonitorCommands().contains(op3));

		instance.unregisterStageMonitorCommand(op3);
		assertEquals(op1,instance.getStageMonitorCommand("op1"));
		assertEquals(op2,instance.getStageMonitorCommand("op2"));
		assertNull(instance.getStageMonitorCommand("op3"));
		assertEquals(2,instance.getStageMonitorCommands().size());
		assertTrue(instance.getStageMonitorCommands().contains(op1));
		assertTrue(instance.getStageMonitorCommands().contains(op2));
	}
}
