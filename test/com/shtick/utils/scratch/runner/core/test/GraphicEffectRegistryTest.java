package com.shtick.utils.scratch.runner.core.test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Test;

import com.shtick.utils.scratch.runner.core.GraphicEffect;
import com.shtick.utils.scratch.runner.core.GraphicEffectRegistry;

class GraphicEffectRegistryTest {

	@Test
	void testConstructor() {
		GraphicEffectRegistry registry = new GraphicEffectRegistry();
	}

	@Test
	void testStaticSharedInstance() {
		GraphicEffectRegistry instance = GraphicEffectRegistry.getGraphicEffectRegistry();
		GraphicEffectRegistry notInstance = new GraphicEffectRegistry();
		assertEquals(instance,GraphicEffectRegistry.getGraphicEffectRegistry());
		
		GraphicEffect op = new GraphicEffect() {
			
			@Override
			public String getName() {
				return "op";
			}
			
			@Override
			public BufferedImage getAffectedImage(BufferedImage image, double value) {
				return null;
			}
		};
		GraphicEffectRegistry.getGraphicEffectRegistry().registerGraphicEffect(op);

		assertEquals(instance,GraphicEffectRegistry.getGraphicEffectRegistry());
		
		assertEquals(op,instance.getGraphicEffect("op"));
		assertNull(notInstance.getGraphicEffect("op"));
	}

	@Test
	void testRegister() {
		GraphicEffectRegistry instance = new GraphicEffectRegistry();
		GraphicEffect op1 = new GraphicEffect() {
			
			@Override
			public String getName() {
				return "op1";
			}
			
			@Override
			public BufferedImage getAffectedImage(BufferedImage image, double value) {
				return null;
			}
		};
		GraphicEffect op2 = new GraphicEffect() {
			
			@Override
			public String getName() {
				return "op2";
			}
			
			@Override
			public BufferedImage getAffectedImage(BufferedImage image, double value) {
				return null;
			}
		};
		GraphicEffect op3 = new GraphicEffect() {
			
			@Override
			public String getName() {
				return "op3";
			}
			
			@Override
			public BufferedImage getAffectedImage(BufferedImage image, double value) {
				return null;
			}
		};

		assertNull(instance.getGraphicEffect("op1"));
		assertNull(instance.getGraphicEffect("op2"));
		assertNull(instance.getGraphicEffect("op3"));
		assertEquals(0,instance.getGraphicEffects().size());
		
		instance.registerGraphicEffect(op1);
		assertEquals(op1,instance.getGraphicEffect("op1"));
		assertNull(instance.getGraphicEffect("op2"));
		assertNull(instance.getGraphicEffect("op3"));
		assertEquals(1,instance.getGraphicEffects().size());
		assertTrue(instance.getGraphicEffects().contains(op1));

		instance.registerGraphicEffect(op2);
		assertEquals(op1,instance.getGraphicEffect("op1"));
		assertEquals(op2,instance.getGraphicEffect("op2"));
		assertNull(instance.getGraphicEffect("op3"));
		assertEquals(2,instance.getGraphicEffects().size());
		assertTrue(instance.getGraphicEffects().contains(op1));
		assertTrue(instance.getGraphicEffects().contains(op2));

		instance.registerGraphicEffect(op3);
		assertEquals(op1,instance.getGraphicEffect("op1"));
		assertEquals(op2,instance.getGraphicEffect("op2"));
		assertEquals(op3,instance.getGraphicEffect("op3"));
		assertEquals(3,instance.getGraphicEffects().size());
		assertTrue(instance.getGraphicEffects().contains(op1));
		assertTrue(instance.getGraphicEffects().contains(op2));
		assertTrue(instance.getGraphicEffects().contains(op3));

		instance.unregisterGraphicEffect(op3);
		assertEquals(op1,instance.getGraphicEffect("op1"));
		assertEquals(op2,instance.getGraphicEffect("op2"));
		assertNull(instance.getGraphicEffect("op3"));
		assertEquals(2,instance.getGraphicEffects().size());
		assertTrue(instance.getGraphicEffects().contains(op1));
		assertTrue(instance.getGraphicEffects().contains(op2));
	}
}
