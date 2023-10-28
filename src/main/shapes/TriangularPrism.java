package main.shapes;

/**
* Represents a triangular prism. This class provides an implementation for 
* calculating the base area of a triangular prism.
* 
* Created on October 15, 2023
* 
* @author Zoë Goodwin
* @version 1.0
*/


public class TriangularPrism extends AbstractPrism
{
	// attribute
    	private double edgeLength;
	
    	/**
         * Constructs a new TriangularPrism with specified height and edge length.
         * Initializes the height of the prism using the superclass constructor and sets the edge length.
         * 
         * @param height     The height of the triangular prism.
         * @param edgeLength The length of an edge of the triangular base.
         */
	public TriangularPrism(double height, double edgeLength)
	{
		super(height);
		this.edgeLength = edgeLength;
	}
	
	/**
	 * Calculates and returns the base area of the triangular prism.
	 * The base area is calculated using the formula for the area of an equilateral triangle:
	 * (\sqrt{3} / 4) * edgeLength^2.
	 * 
	 * @return The base area of the triangular prism.
	 */
	@Override
	public double getBaseArea()
	{
		return (Math.sqrt(3) / 4) * edgeLength * edgeLength;
	}

}
