/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements;

import com.shtick.utils.scratch.runner.core.SoundMonitor;
import com.shtick.utils.scratch.runner.core.ValueListener;

/**
 * @author sean.cox
 *
 */
public interface ScriptContext {
	/**
	 * 
	 * @return The Stage or Sprite that is the foundation of this ScriptContext. This might also be described as a root context.
	 */
	public ScriptContext getContextObject();
	
	/**
	 * 
	 * @return The name of the ContextObject returned by getContextObject().
	 *         This value should be unique to the object prototypes.
	 *         (ie. No two prototypes should share this name, but clones should have the same name as the prototype they were cloned from.)
	 */
	public String getObjName();
	
	/**
	 * Resolves the name first in the current context and next in the parent context, if any.
	 * 
	 * @param name
	 * @return The named list, or null if not found in either this ScriptContext or any parent ScriptContext.
	 */
	public List getContextListByName(String name);

	/**
	 * Resolves the name first in the current context and next in the parent context, if any.
	 * 
	 * @param name
	 * @return The value of the given variable, or null if the variable is undefined.
	 */
	public Object getContextVariableValueByName(String name);
	/**
	 * Updates the value of the named variable to the given value.
	 * Resolves the name first in the current context and next in the parent context, if any.
	 * 
	 * @param name
	 * @param value
	 * @throws IllegalArgumentException if the named variable doesn't exist in either this ScriptContext or any parent ScriptContext.
	 */
	public void setContextVariableValueByName(String name, Object value) throws IllegalArgumentException;
	
	/**
	 * 
	 * @param var
	 * @param listener 
	 */
	public void addVariableListener(String var, ValueListener listener);
	
	/**
	 * 
	 * @param var
	 * @param listener 
	 */
	public void removeVariableListener(String var, ValueListener listener);
	
	/**
	 * Ignores parent contexts.
	 * 
	 * @param name the name of a property. (A variable, or some other context-specific property.)
	 * @return The value of the given property.
	 * @throws IllegalArgumentException if the named property does not exist in this SciptContext.
	 */
	public Object getContextPropertyValueByName(String name) throws IllegalArgumentException;
	
	/**
	 * 
	 * @param property
	 * @param listener 
	 */
	public void addContextPropertyListener(String property, ValueListener listener);
	
	/**
	 * 
	 * @param property
	 * @param listener 
	 */
	public void removeContextPropertyListener(String property, ValueListener listener);
	
	/**
	 * 
	 * @param soundName
	 * @return A SoundMonitor that can be used to determine if the sound has finished playing.
	 */
	public SoundMonitor playSoundByName(String soundName);
	
	/**
	 * Valid values range from 0 to 100. Values of volume outside this range will be set to the closest of either the maximum or the minimum value.
	 * 
	 * @param volume
	 */
	public void setVolume(double volume);
	
	/**
	 * 
	 * @return The current volume. A value in the range of 0 to 100.
	 */
	public double getVolume();
	
	/**
	 * 
	 * @param listener
	 */
	public void addVolumeListener(ValueListener listener);
	
	/**
	 * 
	 * @param listener
	 */
	public void removeVolumeListener(ValueListener listener);
	
	/**
	 * <p>Stops all scripts currently running under this ScriptContext, and child contexts.
	 * (Scripts can still be subsequently executed when triggered.)</p>
	 * 
	 */
	public void stopScripts();
}
