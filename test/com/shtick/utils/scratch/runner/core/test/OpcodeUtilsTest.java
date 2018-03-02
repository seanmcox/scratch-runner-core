package com.shtick.utils.scratch.runner.core.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import com.shtick.utils.scratch.runner.core.OpcodeUtils;
import com.shtick.utils.scratch.runner.core.elements.BlockTuple;
import com.shtick.utils.scratch.runner.core.elements.Tuple;

class OpcodeUtilsTest {

	@Test
	void testIsEvaluable() {
		assertFalse(OpcodeUtils.isEvaluable(null));
		assertFalse(OpcodeUtils.isEvaluable(new LinkedList<>()));
		assertTrue(OpcodeUtils.isEvaluable("String"));
		assertTrue(OpcodeUtils.isEvaluable(new Double(1.0)));
		assertTrue(OpcodeUtils.isEvaluable(new Integer(2)));
		assertTrue(OpcodeUtils.isEvaluable(new BlockTuple() {
			@Override
			public Object[] toArray() {
				return null;
			}
			
			@Override
			public String getOpcode() {
				return null;
			}
			
			@Override
			public Object[] getArguments() {
				return null;
			}
		}));
		assertFalse(OpcodeUtils.isEvaluable(new Tuple() {
			
			@Override
			public Object[] toArray() {
				return null;
			}
		}));
	}

	@Test
	void testEquals() {
		// Test straight type comparisons.
		assertFalse(OpcodeUtils.equals("value","value2"));
		assertTrue(OpcodeUtils.equals("value","value"));
		assertFalse(OpcodeUtils.equals(new Double(1.23),new Double(4.56)));
		assertTrue(OpcodeUtils.equals(new Double(1.23),new Double(1.23)));
		assertFalse(OpcodeUtils.equals(new Integer(1),new Integer(4)));
		assertTrue(OpcodeUtils.equals(new Integer(1),new Integer(1)));
		assertFalse(OpcodeUtils.equals(new Boolean(true),new Boolean(false)));
		assertTrue(OpcodeUtils.equals(new Boolean(true),new Boolean(true)));

		// Test double/string comparisons.
		assertFalse(OpcodeUtils.equals("1.23",new Double(4.56)));
		assertTrue(OpcodeUtils.equals("1.23",new Double(1.23)));
		assertFalse(OpcodeUtils.equals(new Double(4.56),"1.23"));
		assertTrue(OpcodeUtils.equals(new Double(1.23),"1.23"));

		// Test integer/string comparisons.
		assertFalse(OpcodeUtils.equals("1",new Integer(4)));
		assertTrue(OpcodeUtils.equals("1",new Integer(1)));
		assertFalse(OpcodeUtils.equals(new Integer(4),"1"));
		assertTrue(OpcodeUtils.equals(new Integer(1),"1"));

		// Test integer/double comparisons.
		assertFalse(OpcodeUtils.equals(new Integer(4),new Double(4.56)));
		assertTrue(OpcodeUtils.equals(new Integer(4),new Double(4)));
		assertFalse(OpcodeUtils.equals(new Double(4.56),new Integer(4)));
		assertTrue(OpcodeUtils.equals(new Double(4),new Integer(4)));

		// Test boolean/string comparisons.
		assertFalse(OpcodeUtils.equals("0",new Boolean(true)));
		assertFalse(OpcodeUtils.equals("true",new Boolean(true)));
		assertFalse(OpcodeUtils.equals("false",new Boolean(true)));
		assertTrue(OpcodeUtils.equals("1",new Boolean(true)));
		assertFalse(OpcodeUtils.equals(new Boolean(true),"0"));
		assertFalse(OpcodeUtils.equals(new Boolean(true),"true"));
		assertFalse(OpcodeUtils.equals(new Boolean(true),"false"));
		assertTrue(OpcodeUtils.equals(new Boolean(true),"1"));

		// Test boolean/double comparisons.
		assertFalse(OpcodeUtils.equals(new Double(1.23),new Boolean(true)));
		assertFalse(OpcodeUtils.equals(new Double(1.23),new Boolean(false)));
		assertTrue(OpcodeUtils.equals(new Double(1.0),new Boolean(true)));
		assertTrue(OpcodeUtils.equals(new Double(0.0),new Boolean(false)));
		assertFalse(OpcodeUtils.equals(new Boolean(true),new Double(1.23)));
		assertFalse(OpcodeUtils.equals(new Boolean(false),new Double(1.23)));
		assertTrue(OpcodeUtils.equals(new Boolean(true),new Double(1.0)));
		assertTrue(OpcodeUtils.equals(new Boolean(false),new Double(0.0)));

		// Test boolean/integer comparisons.
		assertFalse(OpcodeUtils.equals(new Integer(2),new Boolean(true)));
		assertFalse(OpcodeUtils.equals(new Integer(2),new Boolean(false)));
		assertTrue(OpcodeUtils.equals(new Integer(1),new Boolean(true)));
		assertTrue(OpcodeUtils.equals(new Integer(0),new Boolean(false)));
		assertFalse(OpcodeUtils.equals(new Boolean(true),new Integer(2)));
		assertFalse(OpcodeUtils.equals(new Boolean(false),new Integer(2)));
		assertTrue(OpcodeUtils.equals(new Boolean(true),new Integer(1)));
		assertTrue(OpcodeUtils.equals(new Boolean(false),new Integer(0)));
	}

	@Test
	void testGetStringValue() {
		// String
		assertEquals("test",OpcodeUtils.getStringValue("test"));
		assertEquals("blah",OpcodeUtils.getStringValue("blah"));
		
		// Double
		assertEquals("1.23",OpcodeUtils.getStringValue(new Double(1.23)));
		assertEquals("4",OpcodeUtils.getStringValue(new Double(4.0)));
		
		// Long
		assertEquals("1",OpcodeUtils.getStringValue(new Long(1)));
		assertEquals("4",OpcodeUtils.getStringValue(new Long(4)));
		
		// Integer
		assertEquals("1",OpcodeUtils.getStringValue(new Integer(1)));
		assertEquals("4",OpcodeUtils.getStringValue(new Integer(4)));
		
		// Boolean
		assertEquals("true",OpcodeUtils.getStringValue(new Boolean(true)));
		assertEquals("false",OpcodeUtils.getStringValue(new Boolean(false)));
		
		// Weird values
		assertEquals("",OpcodeUtils.getStringValue(null));
		assertEquals("",OpcodeUtils.getStringValue(new Object()));
	}

	@Test
	void testGetNumericValue() {
		// Number
		for(Number n:new Number[] {new Double(1.23),new Long(4), new Integer(5)})
			assertEquals(n,OpcodeUtils.getNumericValue(n));
		
		// Boolean
		assertEquals(1,OpcodeUtils.getNumericValue(new Boolean(true)));
		assertEquals(0,OpcodeUtils.getNumericValue(new Boolean(false)));
		
		// String
		assertEquals(1,OpcodeUtils.getNumericValue("1"));
		assertEquals(0,OpcodeUtils.getNumericValue("0"));
		assertEquals(1.5,OpcodeUtils.getNumericValue("1.5"));
		assertEquals(0,OpcodeUtils.getNumericValue("Hello world"));
		assertEquals(0,OpcodeUtils.getNumericValue("NaN"));
		assertEquals(0,OpcodeUtils.getNumericValue("Infinity"));
		assertEquals(0,OpcodeUtils.getNumericValue("0AFFp1"));
		assertEquals(0,OpcodeUtils.getNumericValue("0AFF.p2"));
		assertEquals(0,OpcodeUtils.getNumericValue("0x0AFF.5Ep3"));
		assertEquals(0,OpcodeUtils.getNumericValue("0x.5Ep4"));
		assertEquals(0,OpcodeUtils.getNumericValue("0affp5"));
		assertEquals(0,OpcodeUtils.getNumericValue("0aff.p6"));
		assertEquals(0,OpcodeUtils.getNumericValue("0x0aff.5ep7"));
		assertEquals(0,OpcodeUtils.getNumericValue("0x.5ep8"));
		assertEquals(0,OpcodeUtils.getNumericValue("0x0aff.5ep2"));
		
		// Other
		assertEquals(0,OpcodeUtils.getNumericValue(new Object()));
	}
}
