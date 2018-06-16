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
public class GraphicEffectRegistry {
	private static GraphicEffectRegistry DEFAULT_GRAPHIC_EFFECT_REGISTRY = new GraphicEffectRegistry();
	private HashMap<String,GraphicEffect> graphicEffects=new HashMap<>();
	
	/**
	 * @return A static shared instance of GraphicEffectRegistry.
	 * 
	 */
	public static GraphicEffectRegistry getGraphicEffectRegistry() {
		return DEFAULT_GRAPHIC_EFFECT_REGISTRY;
	}
	
	/**
	 * 
	 * @param id
	 * @return The GraphicEffect with the given id.
	 */
	public GraphicEffect getGraphicEffect(String id){
		synchronized(graphicEffects){
			return graphicEffects.get(id);
		}
	}
	
	/**
	 * 
	 * @return A set of already registered effects.
	 */
	public Set<GraphicEffect> getGraphicEffects(){
		synchronized(graphicEffects){
			return new HashSet<>(graphicEffects.values());
		}
	}
	
	/**
	 * 
	 * @param graphicEffect 
	 */
	public void registerGraphicEffect(GraphicEffect graphicEffect){
		synchronized(graphicEffects) {
			graphicEffects.put(graphicEffect.getName(),graphicEffect);
		}
	}

	/**
	 * 
	 * @param graphicEffect 
	 */
	public void unregisterGraphicEffect(GraphicEffect graphicEffect){
		synchronized(graphicEffects) {
			if(graphicEffect == graphicEffects.get(graphicEffect.getName()))
				graphicEffects.remove(graphicEffect.getName());
		}
	}
	
	/**
	 * 
	 * @param graphicEffects
	 */
	public void registerGraphicEffects(Collection<GraphicEffect> graphicEffects){
		synchronized(graphicEffects) {
			for(GraphicEffect graphicEffect:graphicEffects)
				this.graphicEffects.put(graphicEffect.getName(),graphicEffect);
		}
	}

	/**
	 * 
	 * @param graphicEffects
	 */
	public void unregisterGraphicEffects(Collection<GraphicEffect> graphicEffects){
		synchronized(graphicEffects) {
			for(GraphicEffect graphicEffect:graphicEffects)
				if(graphicEffect == this.graphicEffects.get(graphicEffect.getName()))
					this.graphicEffects.remove(graphicEffect.getName());
			}
	}
}
