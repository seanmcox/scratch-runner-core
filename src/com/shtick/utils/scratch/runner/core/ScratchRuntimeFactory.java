/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import java.io.File;
import java.io.IOException;

/**
 * @author scox
 *
 */
public interface ScratchRuntimeFactory {
	/**
	 * 
	 * @param projectFile
	 * @return A ScratchRuntime instance.
	 * @throws IOException 
	 */
	public ScratchRuntime createScratchRuntime(File projectFile) throws IOException;

	/**
	 * 
	 * @param projectFile
	 * @param stageWidth
	 * @param stageHeight
	 * @return A ScratchRuntime instance.
	 * @throws IOException 
	 */
	public ScratchRuntime createScratchRuntime(File projectFile, int stageWidth, int stageHeight) throws IOException;

	/**
	 * 
	 * @param projectFile
	 * @param stageWidth
	 * @param stageHeight
	 * @param featureSet 
	 * @return A ScratchRuntime instance.
	 * @throws IOException 
	 */
	public ScratchRuntime createScratchRuntime(File projectFile, int stageWidth, int stageHeight, FeatureSet featureSet) throws IOException;
}
