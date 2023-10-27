package main.shapes;

/**
* Created on October 15, 2023
* @author Zoë Goodwin
* @version 1.0
*/


public class SquarePrism extends AbstractPrism
{
	private double edgeLength;
	
	// constructor
	public SquarePrism(double height, double edgeLength)
	{
		super(height);
		this.edgeLength = edgeLength;
	}
	
	// override method for calculating base area of square prism
	@Override
	public double getBaseArea()
	{
		return edgeLength * edgeLength;
	}
	
	// toString() override for Square Prism, for printing shapeData values
	@Override
	public String toString()
	{
	    return "Square Prism, height: " + getHeight() + ", edge length: " + edgeLength;
	}
}
