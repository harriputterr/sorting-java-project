package main.shapes;

/**
* AbstractShape serves as the superclass for all shape classes in the application.
* It is an abstract class defining the fundamental attributes and behaviours
* that all shapes should have, such as height, base area, and volume. This class
* also implements the Comparable interface to allow for natural ordering of shape
* instances based on their height.
* 
* Created on October 15, 2023
* 
* @author Zoë Goodwin
* @version 1.1
*/

import java.util.Comparator;

// abstract class to manage shape classes, super class to all other shape classes
public abstract class AbstractShape implements Comparable<AbstractShape>
{

	/**
	 * retrieves the height, base area, and volume of a shape
	 * @return shape height
	 * @return shape base area
	 * @return shape volume
	 */
	public abstract double getHeight();
	public abstract double getBaseArea();
	public abstract double getVolume();
	
	/**
	 * Compares this shape with another shape for order. 
	 * Returns a negative integer, zero, or a positive integer as this shape's height
	 * is less than, equal to, or greater than the specified shape's height.
	 *
	 * @param otherShape The shape to be compared with.
	 * @return A negative integer, zero, or a positive integer as this height 
	 *         is less than, equal to, or greater than the height of the specified shape.
	 */
	@Override
	public int compareTo(AbstractShape otherShape)
	{
		return Double.compare(this.getHeight(), otherShape.getHeight());
	}
	
	/**
	 * VolumeComparator is a static inner class implementing Comparator interface
	 * to provide a comparison logic based on the volume of shapes.
	 */
	public static class VolumeComparator implements Comparator<AbstractShape>
	{
	    	/**
	         * Compares its two arguments for order based on their volumes.
	         * 
	         * @param s1 The first shape to be compared.
	         * @param s2 The second shape to be compared.
	         * @return A negative integer, zero, or a positive integer as the volume of
	         *         the first shape is less than, equal to, or greater than the volume
	         *         of the second shape.
	         */
	    	@Override
		public int compare(AbstractShape s1, AbstractShape s2)
		{
			return Double.compare(s1.getVolume(), s2.getVolume());
		}
	}
	
	/**
	 * BaseAreaComparator is a static inner class implementing Comparator interface
	 * to provide a comparison logic based on the base area of shapes.
	 */
	public static class BaseAreaComparator implements Comparator<AbstractShape>
	{
	    	/**
	         * Compares its two arguments for order based on their base areas.
	         * 
	         * @param s1 The first shape to be compared.
	         * @param s2 The second shape to be compared.
	         * @return A negative integer, zero, or a positive integer as the base area of
	         *         the first shape is less than, equal to, or greater than the base area
	         *         of the second shape.
	         */
	    	@Override
		public int compare(AbstractShape s1, AbstractShape s2)
		{
			return Double.compare(s1.getBaseArea(), s2.getBaseArea());
		}
	}
	
	/**
	 * Returns a string representation of this shape, including its class name,
	 * volume, height, and base area.
	 *
	 * @return A string representation of this shape.
	 */
	public String toString() {
	    return getClass().getSimpleName() + ", Volume: " + getVolume() + "  Height: " + getHeight() + "  Base Area: " + getBaseArea();
	}

}
