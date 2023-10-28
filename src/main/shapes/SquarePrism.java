package main.shapes;

/**
* Represents a square prism. This class provides implementation for calculating the 
* base area of a square prism.
* 
* Created on October 15, 2023
* 
* @author Zoë Goodwin
* @version 1.0
*/


public class SquarePrism extends AbstractPrism
{
	// attribute
    	private double edgeLength;
	
    	/**
         * Constructs a new SquarePrism with specified height and edge length.
         * Initializes the height of the prism using the superclass constructor and sets the edge length.
         * 
         * @param height     The height of the square prism.
         * @param edgeLength The length of an edge of the square base.
         */
	public SquarePrism(double height, double edgeLength)
	{
		super(height);
		this.edgeLength = edgeLength;
	}
	
	/**
	 * Calculates and returns the base area of the square prism.
	 * The base area is calculated as the square of the edge length.
	 * 
	 * @return The base area of the square prism.
	 */
	@Override
	public double getBaseArea()
	{
		return edgeLength * edgeLength;
	}
	
}
