/**
 * 
 */
package com.shtick.utils.scratch.runner.core;

import com.shtick.utils.scratch.runner.core.elements.List;

/**
 * @author sean.cox
 *
 */
public interface ListListener {
	/**
	 * 
	 * @param index 1-based index at which the item was added.
	 * @param value The value added.
	 * @param list The List that triggered the event. (The contents of the list may have changed since the event was triggered, or even may change while processing the event.)
	 */
	public void itemAdded(int index, Object value, List list);

	/**
	 * 
	 * @param index 1-based index at which the item was removed.
	 * @param value The value removed.
	 * @param list The List that triggered the event. (The contents of the list may have changed since the event was triggered, or even may change while processing the event.)
	 */
	public void itemRemoved(int index, Object value, List list);

	/**
	 * 
	 * @param index 1-based index at which the item was removed.
	 * @param oldValue The old value at the given index.
	 * @param newValue The new value at the given index.
	 * @param list The List that triggered the event. (The contents of the list may have changed since the event was triggered, or even may change while processing the event.)
	 */
	public void itemUpdated(int index, Object oldValue, Object newValue, List list);
}
