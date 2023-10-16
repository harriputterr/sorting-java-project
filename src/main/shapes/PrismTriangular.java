package main.shapes;

/**
* Created on October 15, 2023
* @author Zoë Goodwin
* @version 1.0
*/


public class PrismTriangular extends AbstractPrism
{
	private double edgeLength;
	
	// constructor
	public PrismTriangular(double height, double edgeLength)
	{
		super(height);
		this.edgeLength = edgeLength;
	}
	
	// override method for calculating base area of triangular prism
	@Override
	public double getBaseArea()
	{
		return (Math.sqrt(3) / 4) * edgeLength * edgeLength;
	}
}
