package main.shapes;

/**
* Represents a cylinder shape. This class extends AbstractShape and implements
* the necessary methods to calculate the cylinder's height, base area, and volume.
* The cylinder is defined by its height and the radius of its base.
* 
* Created on October 15, 2023
* 
* @author Zoë Goodwin
* @version 1.0
*/


public class Cylinder extends AbstractShape
{
	// attributes
    	private double height;
	private double radius;
	
	/**
	 * Constructs a Cylinder object with the specified height and radius.
	 * 
	 * @param height The height of the cylinder.
	 * @param radius The radius of the cylinder's base.
	 */
	public Cylinder(double height, double radius)
	{
		this.height = height;
		this.radius = radius;
	}
	
	/**
	 * Returns the height of the cylinder.
	 * 
	 * @return The height of the cylinder.
	 */
	@Override
	public double getHeight()
	{
		return height;
	}
	
	/**
	 * Calculates and returns the base area of the cylinder.
	 * The base area is calculated as \(\pi \times radius^2\).
	 * 
	 * @return The base area of the cylinder.
	 */
	@Override
	public double getBaseArea()
	{
		return Math.PI * radius * radius;
	}
	
	/**
	 * Calculates and returns the volume of the cylinder.
	 * The volume is calculated as \(\pi \times radius^2 \times height\).
	 * 
	 * @return The volume of the cylinder.
	 */
	@Override
	public double getVolume()
	{
		return Math.PI * radius * radius * height;
	}

}
