package main.shapes;

/**
* Created on October 15, 2023
* @author Zoë Goodwin
* @version 1.0
*/


public abstract class AbstractPrism extends AbstractShape
{
	private double height;
	
	// constructor
	public AbstractPrism(double height)
	{
		this.height = height;
	}
	
	// override method for getting height
	@Override
	public double getHeight()
	{
		return height;
	}
	
	// override method for calculating volume
	@Override
	public double getVolume()
	{
		return getBaseArea() * height;
	}
}
