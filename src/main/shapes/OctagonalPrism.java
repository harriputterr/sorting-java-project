package main.shapes;

/**
* Created on October 15, 2023
* @author Zoë Goodwin
* @version 1.0
*/


public class OctagonalPrism extends AbstractPrism {
	private double edgeLength;
	
	// constructor
	public OctagonalPrism(double height, double edgeLength)
	{
		super(height);
		this.edgeLength = edgeLength;
	}
	
	// override method for calculating base area of octagonal prism
	@Override
	public double getBaseArea()
	{
		return 2 * (1 + Math.sqrt(2)) * edgeLength * edgeLength;
	}
	
	// toString() override for Octagonal Prism, for printing shapeData values
	@Override
	public String toString()
	{
	    return "Octagonal Prism, height: " + getHeight() + ", edge length: " + edgeLength;
	}
}
