/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.util.Map;
import java.util.Set;

import com.shtick.utils.scratch.runner.core.SpriteListener;

/**
 * @author sean.cox
 *
 */
public interface Sprite extends ScriptContext, RenderableChild{
	/**
	 * @return the objName
	 */
	@Override
	public String getObjName();

	/**
	 * @return the spriteInfo
	 */
	public Map<String, Object> getSpriteInfo();

	/**
	 * 
	 * @return The current Costume.
	 */
	public Costume getCurrentCostume();

	/**
	 * 
	 * @return The current Costume index. (base-0)
	 */
	public int getCurrentCostumeIndex();
	
	/**
	 * 
	 * @param i The index of the current costume. (base-0)
	 */
	public void setCurrentCostumeIndex(int i);

	/**
	 * 
	 * @return The the number of costumes.
	 */
	public int getCostumeCount();
	
	/**
	 * Sets the costume by its name.
	 * @param name
	 */
	public void setCostumeByName(String name);

	/**
	 * Paints the current rendering of the sprite onto the pen layer.
	 */
	public void stampSprite();

	/**
	 * @param scratchX the scratchX to set
	 * @param scratchY 
	 */
	public void gotoXY(double scratchX, double scratchY);

	/**
	 * @return the scratchX
	 */
	public double getScratchX();

	/**
	 * @param scratchX the scratchX to set
	 */
	public void setScratchX(double scratchX);

	/**
	 * @return the scratchY
	 */
	public double getScratchY();

	/**
	 * @param scratchY the scratchY to set
	 */
	public void setScratchY(double scratchY);

	/**
	 * @return the scale; a value where 0.0 means 0%, 1.0 means 100%, etc.
	 */
	public double getScale();

	/**
	 * @param scale the scale to set; a value where 0.0 means 0%, 1.0 means 100%, etc.
	 */
	public void setScale(double scale);

	/**
	 * @return the direction in degrees where 0 degrees is oriented pointing up. A value in the range of -180 to 180.
	 */
	public double getDirection();

	/**
	 * @param direction the direction to set; a value in degrees where 0 degrees is oriented pointing up.
	 */
	public void setDirection(double direction);

	/**
	 * @return the rotationStyle
	 */
	public String getRotationStyle();

	/**
	 * @param rotationStyle the rotationStyle to set
	 */
	public void setRotationStyle(String rotationStyle);
	
	/**
	 * An intensive calculation if this needs to be calculated.
	 * 
	 * The coordinate system of the shape will be centered on the rotation center of the current costume, with x increasing to the right and y increasing to the bottom.
	 * The shape will be scaled to match the Sprite's scale and rotated per the Sprite's direction and rotation style.
	 * 
	 * 
	 * @return An area describing the shape of the Sprite's current costume, using the current look of the sprite.
	 */
	public Area getSpriteShape();
	
	/**
	 * Returns an object on which the caller can synchronize in order to update or read properties atomically (ie. without other threads manipulating the sprite mid-update/use)
	 * Does not apply to member variables and lists. (ie. variable and list updates by other threads can occur while synchronizing on the lock object)
	 * 
	 * @return The lock object.
	 */
	public Object getSpriteLock();
	
	/**
	 * 
	 * @return true of this Sprite is a clone of another Sprite
	 */
	public boolean isClone();
	
	/**
	 * 
	 * @return The Sprite which is the parent of this clone, or null if this Sprite is not a clone.
	 */
	public Sprite getCloneParent();
	
	/**
	 * Causes a clone of this Sprite to be created.
	 */
	public void createClone();
	
	/**
	 * Deletes this sprite. This function must be called by a thread belonging to the Sprite's ThreadGroup, and the Sprite must be a clone.
	 */
	public void deleteClone();
	
	/**
	 * 
	 * @return All clones of this sprite. (Clones only advertise child clones.)
	 */
	public Set<Sprite> getClones();
	
	/**
	 * 
	 * @param name
	 * @return The value for the given effect.
	 */
	public double getEffect(String name);

	/**
	 * Sets the value for the named effect.
	 * 
	 * @param name
	 * @param value
	 */
	public void setEffect(String name, double value);
	
	/**
	 * Unsets all effects.
	 */
	public void clearEffects();

	/**
	 * @return the penDown
	 */
	public boolean isPenDown();

	/**
	 * @param penDown the penDown to set
	 */
	public void setPenDown(boolean penDown);

	/**
	 * @return the pen size
	 */
	public double getPenSize();

	/**
	 * @param penSize the pen size to set. If less than zero, then the size is set to 0.
	 */
	public void setPenSize(double penSize);
	
	/**
	 * 
	 * @return The pen hue.
	 */
	public int getPenHue();
	
	/**
	 * 
	 * @param hue A value from 0 to 199. Larger or smaller values should be modded to generate a value within the given range.
	 *            (Specifically ((hue%200)+200)%200, such that negative numbers result in a value in the proper range.)
	 */
	public void setPenHue(int hue);
	
	/**
	 * 
	 * @return The pen shade.
	 */
	public double getPenShade();
	
	/**
	 * 
	 * @param shade Any value. Represents the brightness of the color (HSB)
	 *              A pen shade of 0 is completely black, a pen shade of 100 is completely white, and a pen shade of 50 is the pure color.
	 *              Values between 0 and 50 mix the color with black, and values between 50 and 100 mix the color with white. If the value
	 *              is greater than 100, every 100 it alternates, being that 100-200 goes white to black, and 200-300 goes black to white.
	 *              Thus, the value is the same modulo 200; changing the shade by 200 or any multiple of 200 will have no effect.
	 */
	public void setPenShade(double shade);

	/**
	 * @return the penColor
	 */
	public Color getPenColor();

	/**
	 * @param penColor the penColor to set
	 */
	public void setPenColor(Color penColor);
	
	/**
	 * 
	 * @return The appropriate Stroke for the current pen.
	 */
	public Stroke getPenStroke();
	
	/**
	 * 
	 * @param listener
	 */
	public void addSpriteListener(SpriteListener listener);
	
	/**
	 * 
	 * @param listener
	 */
	public void removeSpriteListener(SpriteListener listener);
}
