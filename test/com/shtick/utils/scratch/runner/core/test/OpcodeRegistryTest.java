package com.shtick.utils.scratch.runner.core.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.shtick.utils.scratch.runner.core.Opcode;
import com.shtick.utils.scratch.runner.core.OpcodeRegistry;

class OpcodeRegistryTest {

	@Test
	void testConstructor() {
		OpcodeRegistry registry = new OpcodeRegistry();
	}

	@Test
	void testStaticSharedInstance() {
		OpcodeRegistry instance = OpcodeRegistry.getOpcodeRegistry();
		OpcodeRegistry notInstance = new OpcodeRegistry();
		assertEquals(instance,OpcodeRegistry.getOpcodeRegistry());
		
		Opcode op = new Opcode() {
			
			@Override
			public String getOpcode() {
				return "op";
			}
			
			@Override
			public DataType[] getArgumentTypes() {
				return null;
			}
		};
		OpcodeRegistry.getOpcodeRegistry().registerOpcode(op);

		assertEquals(instance,OpcodeRegistry.getOpcodeRegistry());
		
		assertEquals(op,instance.getOpcode("op"));
		assertNull(notInstance.getOpcode("op"));
	}

	@Test
	void testRegister() {
		OpcodeRegistry instance = new OpcodeRegistry();
		Opcode op1 = new Opcode() {
			
			@Override
			public String getOpcode() {
				return "op1";
			}
			
			@Override
			public DataType[] getArgumentTypes() {
				return null;
			}
		};
		Opcode op2 = new Opcode() {
			
			@Override
			public String getOpcode() {
				return "op2";
			}
			
			@Override
			public DataType[] getArgumentTypes() {
				return null;
			}
		};
		Opcode op3 = new Opcode() {
			
			@Override
			public String getOpcode() {
				return "op3";
			}
			
			@Override
			public DataType[] getArgumentTypes() {
				return null;
			}
		};

		assertNull(instance.getOpcode("op1"));
		assertNull(instance.getOpcode("op2"));
		assertNull(instance.getOpcode("op3"));
		assertEquals(0,instance.getOpcodes().size());
		
		instance.registerOpcode(op1);
		assertEquals(op1,instance.getOpcode("op1"));
		assertNull(instance.getOpcode("op2"));
		assertNull(instance.getOpcode("op3"));
		assertEquals(1,instance.getOpcodes().size());
		assertTrue(instance.getOpcodes().contains(op1));

		instance.registerOpcode(op2);
		assertEquals(op1,instance.getOpcode("op1"));
		assertEquals(op2,instance.getOpcode("op2"));
		assertNull(instance.getOpcode("op3"));
		assertEquals(2,instance.getOpcodes().size());
		assertTrue(instance.getOpcodes().contains(op1));
		assertTrue(instance.getOpcodes().contains(op2));

		instance.registerOpcode(op3);
		assertEquals(op1,instance.getOpcode("op1"));
		assertEquals(op2,instance.getOpcode("op2"));
		assertEquals(op3,instance.getOpcode("op3"));
		assertEquals(3,instance.getOpcodes().size());
		assertTrue(instance.getOpcodes().contains(op1));
		assertTrue(instance.getOpcodes().contains(op2));
		assertTrue(instance.getOpcodes().contains(op3));

		instance.unregisterOpcode(op3);
		assertEquals(op1,instance.getOpcode("op1"));
		assertEquals(op2,instance.getOpcode("op2"));
		assertNull(instance.getOpcode("op3"));
		assertEquals(2,instance.getOpcodes().size());
		assertTrue(instance.getOpcodes().contains(op1));
		assertTrue(instance.getOpcodes().contains(op2));
	}
}
