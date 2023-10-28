package main.shapes;

/**
* Represents a pyramid shape with a square base. This class extends AbstractShape and
* provides methods to calculate the height, base area, and volume of the pyramid. 
* A pyramid in this context is characterized by its height and the length of an edge of its square base
* 
* Created on October 15, 2023
* 
* @author Zoë Goodwin
* @version 1.0
*/


public class Pyramid extends AbstractShape
{
	// attributes
    	private double height;
	private double edgeLength;
	
	/**
	 * Constructs a Pyramid object with the specified height and edge length.
	 *
	 * @param height     The height of the pyramid.
	 * @param edgeLength The length of an edge of the square base of the pyramid.
	 */
	public Pyramid(double height, double edgeLength)
	{
		this.height = height;
		this.edgeLength = edgeLength;
	}
	
	/**
	 * Gets the height of the pyramid.
	 *
	 * @return The height of the pyramid.
	 */
	@Override
	public double getHeight()
	{
		return height;
	}
	
	/**
	 * Calculates and returns the base area of the pyramid. The base area
	 * is calculated as the square of the edge length.
	 *
	 * @return The base area of the pyramid.
	 */
	public double getBaseArea()
	{
		return edgeLength * edgeLength;
	}
	
	/**
	 * Calculates and returns the volume of the pyramid.
	 * The volume is calculated using the formula:
	 * (1/3) * base area * height.
	 *
	 * @return The volume of the pyramid.
	 */
	public double getVolume()
	{
		return (1.0 / 3.0) * edgeLength * edgeLength * height;
	}

}
