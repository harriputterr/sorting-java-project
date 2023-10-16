package main.shapes;

/**
* Created on October 15, 2023
* @author Zoë Goodwin
* @version 1.0
*/


public class PrismSquare extends AbstractPrism
{
	private double edgeLength;
	
	// constructor
	public PrismSquare(double height, double edgeLength)
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
}
