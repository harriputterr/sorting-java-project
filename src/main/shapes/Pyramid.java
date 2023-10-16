package main.shapes;

/**
* Created on October 15, 2023
* @author Zoë Goodwin
* @version 1.0
*/


public class Pyramid extends AbstractShape
{
	private double height;
	private double edgeLength;
	
	// class constructor
	public Pyramid(double height, double edgeLength)
	{
		this.height = height;
		this.edgeLength = edgeLength;
	}
	
	// override method for getting height
	@Override
	public double getHeight()
	{
		return height;
	}
	
	// method for calculating base area of Pyramid
	public double getBaseArea()
	{
		return edgeLength * edgeLength;
	}
	
	// method for calculating volume of Pyramid
	public double getVolume()
	{
		return (1.0 / 3.0) * edgeLength * edgeLength * height;
	}
}
