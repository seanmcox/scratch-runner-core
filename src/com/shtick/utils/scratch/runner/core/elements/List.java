/**
 * 
 */
package com.shtick.utils.scratch.runner.core.elements;

import com.shtick.utils.scratch.runner.core.ListListener;

/**
 * @author sean.cox
 *
 */
public interface List extends RenderableChild, Iterable<Object>{

	/**
	 * @return the listName
	 */
	public String getListName();

	/**
	 * @return a copy of the ordered contents
	 */
	public Object[] getContents();
	
	/**
	 * 
	 * @param index Base-1 index as per scratch's indexing standard.
	 * @return The item at the given index.
	 * @throws IndexOutOfBoundsException if there is no item at the given index.
	 */
	public Object getItem(int index);
	
	/**
	 * 
	 * @param index Base-1 index as per scratch's indexing standard.
	 * @throws IndexOutOfBoundsException if there is no item at the given index.
	 */
	public void deleteItem(int index);
	
	/**
	 * Replaces the existing value at index with the specified item.
	 * 
	 * @param item 
	 * @param index Base-1 index as per scratch's indexing standard.
	 */
	public void setItem(Object item, int index);
	
	/**
	 * Adds the given item to this list at the given index. The size of the list will grow by one.
	 * 
	 * @param item
	 * @param index Base-1 index as per scratch's indexing standard.
	 */
	public void addItem(Object item, int index);
	
	/**
	 * Adds the given item to this list.
	 * 
	 * @param item
	 */
	public void addItem(Object item);
	
	/**
	 * 
	 * @return The number of items in the list.
	 */
	public int getItemCount();
	
	/**
	 * 
	 * @param item 
	 * @return true if an equivalent object is contained, or false otherwise.
	 */
	public boolean contains(Object item);

	/**
	 * @return the x
	 */
	public Double getX();

	/**
	 * @return the y
	 */
	public Double getY();

	/**
	 * @return the width
	 */
	public Double getWidth();

	/**
	 * @return the height
	 */
	public Double getHeight();
	
	/**
	 * 
	 * @param listener
	 */
	public void addListListener(ListListener listener);
	
	/**
	 * 
	 * @param listener
	 */
	public void removeListListener(ListListener listener);
}
