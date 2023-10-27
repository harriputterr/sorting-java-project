package main.shapes;

/**
* Created on October 15, 2023
* @author Zoë Goodwin
* @version 1.0
*/


public class Cylinder extends AbstractShape
{
	private double height;
	private double radius;
	
	// class constructor
	public Cylinder(double height, double radius)
	{
		this.height = height;
		this.radius = radius;
	}
	
	// method to get cylinder's height
	@Override
	public double getHeight()
	{
		return height;
	}
	
	// method to calculate cylinder's base area
	@Override
	public double getBaseArea()
	{
		return Math.PI * radius * radius;
	}
	
	// method to calculate cylinder's volume
	@Override
	public double getVolume()
	{
		return Math.PI * radius * radius * height;
	}
	
	// toString() override for Cylinder, for printing shapeData values
	@Override
	public String toString()
	{
	    return "Cylinder, height: " + height + ", radius: " + radius;
	}
}
