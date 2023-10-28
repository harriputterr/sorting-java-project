package main.shapes;

/**
* Represents an octagonal prism shape. This class extends AbstractPrism and
* implements the method to calculate the base area of an octagonal prism.
* The octagonal prism is defined by its height and the length of the edge of its base
* 
* Created on October 15, 2023
* 
* @author Zoë Goodwin
* @version 1.0
*/


public class OctagonalPrism extends AbstractPrism {
	
    	// attribute
    	private double edgeLength;
	
    	/**
         * Constructs an OctagonalPrism object with the specified height and edge length.
         *
         * @param height     The height of the octagonal prism.
         * @param edgeLength The length of an edge of the octagonal base.
         */
	public OctagonalPrism(double height, double edgeLength)
	{
		super(height);
		this.edgeLength = edgeLength;
	}
	
	/**
	 * Calculates and returns the base area of the octagonal prism.
	 * The base area is calculated using the formula:
	 * 2 * (1 + sqrt(2)) * edgeLength^2.
	 *
	 * @return The base area of the octagonal prism.
	 */
	@Override
	public double getBaseArea()
	{
		return 2 * (1 + Math.sqrt(2)) * edgeLength * edgeLength;
	}

}
