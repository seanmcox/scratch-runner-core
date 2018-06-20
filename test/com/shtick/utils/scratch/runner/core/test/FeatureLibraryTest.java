package com.shtick.utils.scratch.runner.core.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.shtick.utils.scratch.runner.core.FeatureLibrary;
import com.shtick.utils.scratch.runner.core.FeatureSet;
import com.shtick.utils.scratch.runner.core.FeatureSetGenerator;

class FeatureLibraryTest {
	@Test
	void testRegister() {
		FeatureSetGenerator fg1 = new FeatureSetGenerator() {
			@Override
			public String getFeatureSetName() {
				return "fg1";
			}
			@Override
			public FeatureSet generateFeatureSet() {
				return null;
			}
		};
		FeatureSetGenerator fg2 = new FeatureSetGenerator() {
			@Override
			public String getFeatureSetName() {
				return "fg2";
			}
			@Override
			public FeatureSet generateFeatureSet() {
				return null;
			}
		};
		FeatureSetGenerator fg3 = new FeatureSetGenerator() {
			@Override
			public String getFeatureSetName() {
				return "fg3";
			}
			@Override
			public FeatureSet generateFeatureSet() {
				return null;
			}
		};

		assertNull(FeatureLibrary.getFeatureSetGenerator("fg1"));
		assertNull(FeatureLibrary.getFeatureSetGenerator("fg2"));
		assertNull(FeatureLibrary.getFeatureSetGenerator("fg3"));
		assertEquals(0,FeatureLibrary.getFeatureSetGenerators().size());
		
		FeatureLibrary.registerFeatureSetGenerator(fg1);
		assertEquals(fg1,FeatureLibrary.getFeatureSetGenerator("fg1"));
		assertNull(FeatureLibrary.getFeatureSetGenerator("fg2"));
		assertNull(FeatureLibrary.getFeatureSetGenerator("fg3"));
		assertEquals(1,FeatureLibrary.getFeatureSetGenerators().size());
		assertTrue(FeatureLibrary.getFeatureSetGenerators().contains(fg1));

		FeatureLibrary.registerFeatureSetGenerator(fg2);
		assertEquals(fg1,FeatureLibrary.getFeatureSetGenerator("fg1"));
		assertEquals(fg2,FeatureLibrary.getFeatureSetGenerator("fg2"));
		assertNull(FeatureLibrary.getFeatureSetGenerator("fg3"));
		assertEquals(2,FeatureLibrary.getFeatureSetGenerators().size());
		assertTrue(FeatureLibrary.getFeatureSetGenerators().contains(fg1));
		assertTrue(FeatureLibrary.getFeatureSetGenerators().contains(fg2));

		FeatureLibrary.registerFeatureSetGenerator(fg3);
		assertEquals(fg1,FeatureLibrary.getFeatureSetGenerator("fg1"));
		assertEquals(fg2,FeatureLibrary.getFeatureSetGenerator("fg2"));
		assertEquals(fg3,FeatureLibrary.getFeatureSetGenerator("fg3"));
		assertEquals(3,FeatureLibrary.getFeatureSetGenerators().size());
		assertTrue(FeatureLibrary.getFeatureSetGenerators().contains(fg1));
		assertTrue(FeatureLibrary.getFeatureSetGenerators().contains(fg2));
		assertTrue(FeatureLibrary.getFeatureSetGenerators().contains(fg3));

		FeatureLibrary.unregisterFeatureSetGenerator(fg3);
		assertEquals(fg1,FeatureLibrary.getFeatureSetGenerator("fg1"));
		assertEquals(fg2,FeatureLibrary.getFeatureSetGenerator("fg2"));
		assertNull(FeatureLibrary.getFeatureSetGenerator("fg3"));
		assertEquals(2,FeatureLibrary.getFeatureSetGenerators().size());
		assertTrue(FeatureLibrary.getFeatureSetGenerators().contains(fg1));
		assertTrue(FeatureLibrary.getFeatureSetGenerators().contains(fg2));
	}
}
