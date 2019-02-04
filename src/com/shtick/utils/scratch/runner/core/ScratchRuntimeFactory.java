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
	 * @param filename The name of a file to check.
	 * @return true if the given filename appears to be a file of the correct type to be run by this ScratchRuntimeFactory and false otherwise.
	 */
	public boolean isValidFilename(String filename);
	
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
