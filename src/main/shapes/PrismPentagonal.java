package main.shapes;

/**
* Created on October 15, 2023
* @author Zoë Goodwin
* @version 1.0
*/


public class PrismPentagonal extends AbstractPrism
{
	private double edgeLength;
	
	// constructor
	public PrismPentagonal(double height, double edgeLength)
	{
		super(height);
		this.edgeLength = edgeLength;
	}
	
	// override method for calculating base area of pentagonal prism
	@Override
	public double getBaseArea()
	{
		return (5.0/4.0) * Math.tan(Math.PI / 5) * edgeLength * edgeLength;
	}
	
}
