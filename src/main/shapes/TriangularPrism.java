package main.shapes;

/**
* Created on October 15, 2023
* @author Zoë Goodwin
* @version 1.0
*/


public class TriangularPrism extends AbstractPrism
{
	private double edgeLength;
	
	// constructor
	public TriangularPrism(double height, double edgeLength)
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
	
	// toString() override for Triangular Prism, for printing shapeData values
	@Override
	public String toString()
	{
	    return "Triangular Prism, height: " + getHeight() + ", edge length: " + edgeLength;
	}
}
