package com.shtick.utils.scratch.runner.core.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
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
		assertTrue(OpcodeUtils.isEvaluable(new Long(2)));
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
			public java.util.List<Object> getArguments() {
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
		assertFalse(OpcodeUtils.equals(new Long(1),new Long(4)));
		assertTrue(OpcodeUtils.equals(new Long(1),new Long(1)));
		assertFalse(OpcodeUtils.equals(new Boolean(true),new Boolean(false)));
		assertTrue(OpcodeUtils.equals(new Boolean(true),new Boolean(true)));

		// Test double/string comparisons.
		assertFalse(OpcodeUtils.equals("1.23",new Double(4.56)));
		assertTrue(OpcodeUtils.equals("1.23",new Double(1.23)));
		assertFalse(OpcodeUtils.equals(new Double(4.56),"1.23"));
		assertTrue(OpcodeUtils.equals(new Double(1.23),"1.23"));

		// Test integer/string comparisons.
		assertFalse(OpcodeUtils.equals("1",new Long(4)));
		assertTrue(OpcodeUtils.equals("1",new Long(1)));
		assertFalse(OpcodeUtils.equals(new Long(4),"1"));
		assertTrue(OpcodeUtils.equals(new Long(1),"1"));

		// Test integer/double comparisons.
		assertFalse(OpcodeUtils.equals(new Long(4),new Double(4.56)));
		assertTrue(OpcodeUtils.equals(new Long(4),new Double(4)));
		assertFalse(OpcodeUtils.equals(new Double(4.56),new Long(4)));
		assertTrue(OpcodeUtils.equals(new Double(4),new Long(4)));

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
		assertFalse(OpcodeUtils.equals(new Long(2),new Boolean(true)));
		assertFalse(OpcodeUtils.equals(new Long(2),new Boolean(false)));
		assertTrue(OpcodeUtils.equals(new Long(1),new Boolean(true)));
		assertTrue(OpcodeUtils.equals(new Long(0),new Boolean(false)));
		assertFalse(OpcodeUtils.equals(new Boolean(true),new Long(2)));
		assertFalse(OpcodeUtils.equals(new Boolean(false),new Long(2)));
		assertTrue(OpcodeUtils.equals(new Boolean(true),new Long(1)));
		assertTrue(OpcodeUtils.equals(new Boolean(false),new Long(0)));
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
		assertEquals(1L,OpcodeUtils.getNumericValue(new Boolean(true)));
		assertEquals(0L,OpcodeUtils.getNumericValue(new Boolean(false)));
		
		// String
		assertEquals(1L,OpcodeUtils.getNumericValue("1"));
		assertEquals(0L,OpcodeUtils.getNumericValue("0"));
		assertEquals(-1L,OpcodeUtils.getNumericValue("-1"));
		assertEquals(1.5,OpcodeUtils.getNumericValue("1.5"));
		assertEquals(0L,OpcodeUtils.getNumericValue("Hello world"));
		assertEquals(0L,OpcodeUtils.getNumericValue("NaN"));
		assertEquals(0L,OpcodeUtils.getNumericValue("Infinity"));
		assertEquals(0L,OpcodeUtils.getNumericValue("0AFFp1"));
		assertEquals(0L,OpcodeUtils.getNumericValue("0AFF.p2"));
		assertEquals(0L,OpcodeUtils.getNumericValue("0x0AFF.5Ep3"));
		assertEquals(0L,OpcodeUtils.getNumericValue("0x.5Ep4"));
		assertEquals(0L,OpcodeUtils.getNumericValue("0affp5"));
		assertEquals(0L,OpcodeUtils.getNumericValue("0aff.p6"));
		assertEquals(0L,OpcodeUtils.getNumericValue("0x0aff.5ep7"));
		assertEquals(0L,OpcodeUtils.getNumericValue("0x.5ep8"));
		assertEquals(0L,OpcodeUtils.getNumericValue("0x0aff.5ep2"));
		
		// Other
		assertEquals(0L,OpcodeUtils.getNumericValue(new Object()));
	}

	@Test
	void testCompareChars() {
		assertTrue(OpcodeUtils.compareChars('A', 'B')<0);
		assertTrue(OpcodeUtils.compareChars('B', 'A')>0);
		assertTrue(OpcodeUtils.compareChars('A', 'A')==0);
		assertTrue(OpcodeUtils.compareChars('a', 'B')<0);
		assertTrue(OpcodeUtils.compareChars('B', 'a')>0);
		assertTrue(OpcodeUtils.compareChars('a', 'A')==0);
		assertTrue(OpcodeUtils.compareChars('A', 'b')<0);
		assertTrue(OpcodeUtils.compareChars('b', 'A')>0);
		assertTrue(OpcodeUtils.compareChars('b', 'B')==0);
		
		{
			char[] chars = OpcodeUtils.ORDERED_CHARS.toCharArray();
			Character[] characters = new Character[chars.length];
			for(int i=0;i<chars.length;i++)
				characters[i] = Character.valueOf(chars[i]);
			Arrays.sort(characters, new Comparator<Character>() {
				/* (non-Javadoc)
				 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
				 */
				@Override
				public int compare(Character o1, Character o2) {
					return OpcodeUtils.compareChars(o1.charValue(), o2.charValue());
				}
			});
			for(int i=0;i<chars.length;i++)
				chars[i] = characters[i].charValue();
			assertEquals(OpcodeUtils.ORDERED_CHARS,new String(chars));
		}

		{
			StringBuilder sb = new StringBuilder();
			sb.append(OpcodeUtils.ORDERED_CHARS);
			sb = sb.reverse();
			
			char[] chars = sb.toString().toCharArray();
			Character[] characters = new Character[chars.length];
			for(int i=0;i<chars.length;i++)
				characters[i] = Character.valueOf(chars[i]);
			Arrays.sort(characters, new Comparator<Character>() {
				/* (non-Javadoc)
				 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
				 */
				@Override
				public int compare(Character o1, Character o2) {
					return OpcodeUtils.compareChars(o1.charValue(), o2.charValue());
				}
			});
			for(int i=0;i<chars.length;i++)
				chars[i] = characters[i].charValue();
			assertEquals(OpcodeUtils.ORDERED_CHARS,new String(chars));
		}
	}

	@Test
	void testCompareStrings() {
		assertTrue(OpcodeUtils.compareStrings("A", "B")<0);
		assertTrue(OpcodeUtils.compareStrings("B", "A")>0);
		assertTrue(OpcodeUtils.compareStrings("A", "A")==0);
		assertTrue(OpcodeUtils.compareStrings("AA", "AB")<0);
		assertTrue(OpcodeUtils.compareStrings("AB", "AA")>0);
		assertTrue(OpcodeUtils.compareStrings("AA", "AA")==0);
		assertTrue(OpcodeUtils.compareStrings("AAA", "AA")>0);
		assertTrue(OpcodeUtils.compareStrings("AA", "AAA")<0);
	}
}
