package main.shapes;

/**
* Represents a pentagonal prism shape. This class extends AbstractPrism and
* provides the implementation to calculate the base area of a pentagonal prism.
* A pentagonal prism is characterized by its height and the length of the edges of its
* pentagonal base.
* 
* Created on October 15, 2023
* 
* @author Zoë Goodwin
* @version 1.0
*/


public class PentagonalPrism extends AbstractPrism
{
	// attribute
    	private double edgeLength;
	
    	/**
         * Constructs a PentagonalPrism object with the specified height and edge length.
         *
         * @param height     The height of the pentagonal prism.
         * @param edgeLength The length of an edge of the pentagonal base.
         */
	public PentagonalPrism(double height, double edgeLength)
	{
		super(height);
		this.edgeLength = edgeLength;
	}
	
	/**
	 * Calculates and returns the base area of the pentagonal prism.
	 * The base area is calculated using the formula:
	 * (5/4) * tan(π / 5) * edgeLength^2.
	 *
	 * @return The base area of the pentagonal prism.
	 */
	@Override
	public double getBaseArea()
	{
		return (5.0/4.0) * Math.tan(Math.PI / 5) * edgeLength * edgeLength;
	}
	
}
