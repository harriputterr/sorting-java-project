package main.shapes;

/**
* The Cone class represents a cone shape. It extends the AbstractShape class,
* inheriting its basic structure while providing specific implementations for 
* the height, base area, and volume calculations specific to a cone.
* 
* Created on October 15, 2023
* 
* @author Zoë Goodwin
* @version 1.0
*/

public class Cone extends AbstractShape
{
	// attributes
        private double height;
	private double radius;
	
	/**
	 * Constructs a new Cone instance with the specified height and radius.
	 * 
	 * @param height The height of the cone.
	 * @param radius The radius of the cone's base.
	 */
	public Cone(double height, double radius)
	{
		this.height = height;
		this.radius = radius;
	}
	
	/**
	 * Retrieves the height of the cone.
	 * 
	 * @return The height of the cone.
	 */
	@Override
	public double getHeight()
	{
		return height;
	}
	
	/**
	 * Calculates and returns the base area of the cone.
	 * 
	 * @return The base area of the cone.
	 */
	public double getBaseArea()
	{
		return Math.PI * radius * radius;
	}
	
	/**
	 * Calculates and returns the volume of the cone.
	 * 
	 * @return The volume of the cone.
	 */
	public double getVolume()
	{
		return (1.0 / 3.0) * Math.PI * radius * radius * height;
	}

}
