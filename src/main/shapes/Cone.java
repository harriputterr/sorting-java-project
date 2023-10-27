package main.shapes;

/**
* Created on October 15, 2023
* @author Zoë Goodwin
* @version 1.0
*/


public class Cone extends AbstractShape
{
	private double height;
	private double radius;
	
	// class constructor
	public Cone(double height, double radius)
	{
		this.height = height;
		this.radius = radius;
	}
	
	// method for getting height
	@Override
	public double getHeight()
	{
		return height;
	}
	
	// method for calculating base area of Cone
	public double getBaseArea()
	{
		return Math.PI * radius * radius;
	}
	
	// method for calculating volume of Cone
	public double getVolume()
	{
		return (1.0 / 3.0) * Math.PI * radius * radius * height;
	}
	
	// toString() override for Cone, for printing shapeData values
	@Override
	public String toString()
	{
	    return "Cone, height: " + height + ", radius: " + radius;
	}
}
