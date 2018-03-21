/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import com.shtick.utils.scratch.runner.core.elements.BlockTuple;
import com.shtick.utils.scratch.runner.core.elements.Tuple;

/**
 * @author sean.cox
 *
 */
public class OpcodeUtils {
	/**
	 * 
	 * @param obj1 Expected types are Number, Boolean, String. Must never be null.
	 * @param obj2 Expected types are Number, Boolean, String. Must never be null.
	 * @return true if the object can be resolved to a value using ScriptTupleRunner.getValue(), and false otherwise.
	 */
	public static boolean equals(Object obj1,Object obj2) {
		String a0 = obj1+"";
		String a1 = obj2+"";
		if(obj1 instanceof Double) {
			if(((Double)obj1).doubleValue() == ((Double)obj1).longValue())
				a0 = ""+((Double)obj1).longValue();
		}
		if(obj2 instanceof Double) {
			if(((Double)obj2).doubleValue() == ((Double)obj2).longValue())
				a1 = ""+((Double)obj2).longValue();
		}
		if(obj1 instanceof Boolean) {
			a0 = OpcodeUtils.booleanToNumber((Boolean)obj1)+"";
		}
		if(obj2 instanceof Boolean) {
			a1 = OpcodeUtils.booleanToNumber((Boolean)obj2)+"";
		}
		return a0.equals(a1);
	}

	/**
	 * 
	 * @param obj Expected types are java.util.List, Number, Boolean, Tuple, and String. null is handled, but otherwise, it is assumed that no other types will be passed in.
	 * @return true if the object can be resolved to a value using ScriptTupleRunner.getValue(), and false otherwise.
	 */
	public static boolean isEvaluable(Object obj) {
		if((obj==null)||(obj instanceof java.util.List<?>))
			return false;
		if(obj instanceof Tuple)
			return (obj instanceof BlockTuple);
		return true;
	}
	
	/**
	 * 
	 * @param b
	 * @return 1 if b and 0 if !b.
	 */
	private static int booleanToNumber(Boolean b) {
		if(b)
			return 1;
		return 0;
	}
	
	/**
	 * 
	 * @param value Number, Boolean, or String
	 * @return The Scratch String representation of the object.
	 *         null, or any other weird value returns an empty String.
	 */
	public static String getStringValue(Object value) {
		if(value == null)
			return "";
		if(value instanceof String)
			return (String)value;
		if(value instanceof Boolean)
			return value.toString();
		if(value instanceof Number) {
			Number n = (Number)value;
			if(n instanceof Long)
				return n.toString();
			if(n instanceof Integer)
				return n.toString();
			String retval = n.toString();
			if(retval.endsWith(".0"))
				return ""+n.longValue();
			return retval;
		}
		return "";
	}
	
	/**
	 * 
	 * @param value The value to resolve to an Numeric type.
	 * @return The numeric value of value as per Scratch's method of resolving data types to numbers.
	 *         The returned value will be either an Integer or a Double.
	 *         If value is a Double or an Integer, then value is returned.
	 */
	public static Number getNumericValue(Object value) {
		if(value instanceof Number)
			return (Number)value;
		if(value instanceof Boolean)
			return ((Boolean)value).booleanValue()?1:0;

		try {
			return new Integer(value.toString());
		}
		catch(NumberFormatException t) {}
		if(!(value instanceof String))
			return new Integer(0);
		if("NaN".equals(value)||"Infinity".equals(value))
			return new Integer(0);
		if(((String)value).startsWith("0x")) // Quick and easy way to exclude hexadecimal floating point values.
			return new Integer(0);
		try {
			return new Double(value.toString());
		}
		catch(NumberFormatException t) {}
		return new Integer(0);
	}
}
