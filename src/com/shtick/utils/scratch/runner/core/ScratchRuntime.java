package com.shtick.utils.scratch.runner.core;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

import com.shtick.utils.scratch.runner.core.elements.RenderableChild;
import com.shtick.utils.scratch.runner.core.elements.ScriptContext;
import com.shtick.utils.scratch.runner.core.elements.ScriptTuple;
import com.shtick.utils.scratch.runner.core.elements.Sprite;
import com.shtick.utils.scratch.runner.core.elements.Stage;

/**
 * 
 * @author sean.cox
 *
 */
public interface ScratchRuntime {
	/**
	 * 
	 * @return The current Stage, or null if there is none.
	 */
	public Stage getCurrentStage();
	
	/**
	 * 
	 * @param name
	 * @return The named ScriptContext
	 */
	public ScriptContext getScriptContextByName(String name);
	
	/**
	 * Similar to getScriptContextByName, except never returns the stage.
	 * 
	 * @param name
	 * @return The named Sprite.
	 */
	public Sprite getSpriteByName(String name);
	
	/**
	 * 
	 * @param sprite
	 * @param image If image is null, then sprite can also be null. All bubble images are removed.
	 */
	public void setSpriteBubbleImage(Sprite sprite, Image image);
	
	/**
	 * 
	 * @return An array of all Sprites/Lists/StageMonitors.
	 */
	public RenderableChild[] getAllRenderableChildren();
	
	/**
	 * @return The Stage width in pixels. Normally this should be 480.
	 */
	public int getStageWidth();

	/**
	 * @return The Stage height in pixels. Normally this should be 360.
	 */
	public int getStageHeight();
	
	/**
	 * 
	 * @return The last reported mouse location.
	 */
	public Point2D.Double getMouseStagePosition();
	
	/**
	 * 
	 * @return True if the primary mouse button is depressed and false otherwise.
	 */
	public boolean isMouseDown();
	
	/**
	 * Starts executing the given ScriptTuple on a new thread.
	 * 
	 * @param script
	 * @param isAtomic 
	 * @return A ScriptTupleRunner for the started ScriptTuple.
	 * 
	 */
	public ScriptTupleRunner startScript(ScriptTuple script, boolean isAtomic);

	/**
	 * 
	 * @return A Graphics2D object that will let you paint on the background using a coordinate system similar to scratch's, but with the y-axis reversed. (ie. centered on the middle, with x increasing to the right and y increasing to the bottom. The width and the height are the stage width and height.)
	 */
	public Graphics2D getPenLayerGraphics();
	
	/**
	 * Clears all marks on the pen layer.
	 */
	public void clearPenLayer();
	
	/**
	 * Repositions the given Sprite on top of all the other Sprites.
	 * 
	 * @param sprite
	 */
	public void bringToFront(Sprite sprite);
	
	/**
	 * Repositions the given Sprite beneath all the other Sprites.
	 * 
	 * @param sprite
	 */
	public void sendToBack(Sprite sprite);
	
	/**
	 * Moves the given sprite back n layers.
	 * 
	 * @param sprite
	 * @param n Can be a negative number to bring the sprite forward.
	 */
	public void sendBackNLayers(Sprite sprite, int n);
	
	/**
	 * Used to add a component to the top layer (above all the sprites) of the stage.
	 * Uses a coordinate system similar to scratch's, but with the y-axis reversed.
	 * ie. centered on the middle, with x increasing to the right and y increasing to the bottom.
	 * The width and the height are the stage width and height.
	 * 
	 * @param component
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void addComponent(Component component, int x, int y, int width, int height);
	
	/**
	 * Removes the given component from the stage.
	 * 
	 * @param component
	 */
	public void removeComponent(Component component);
	
	/**
	 * 
	 */
	public void repaintStage();
	
	/**
	 * Stops all sounds currently being played.
	 */
	public void stopAllSounds();
	
	/**
	 * 
	 * @param listener The KeyListener instance to register.
	 */
	public void addKeyListener(KeyListener listener);
	
	/**
	 * 
	 * @param listener The KeyListener instance to unregister.
	 */
	public void removeKeyListener(KeyListener listener);
	
	/**
	 * 
	 * @param listener A StageMouseListener.  Coordinates will be reported with respect to the stage.
	 */
	public void addStageMouseListener(MouseListener listener);
	
	/**
	 * 
	 * @param listener A StageMouseListener
	 */
	public void removeStageMouseListener(MouseListener listener);
	
	/**
	 * 
	 * @param listener A MouseMotionListener. Coordinates will be reported with respect to the stage.
	 */
	public void addStageMouseMotionListener(MouseMotionListener listener);
	
	/**
	 * 
	 * @param listener A MouseMotionListener
	 */
	public void removeStageMouseMotionListener(MouseMotionListener listener);

	/**
	 * 
	 * @param keyID The scratch identifier for the key.
	 * @return true if the key is currently pressed and false otherwise.
	 * @throws IllegalArgumentException if the keyID is unrecognized.
	 */
	public boolean isKeyPressed(String keyID);
}
