package main.shapes;

/**
* AbstractPrism is an abstract class extending AbstractShape, representing the
* general properties of a prism. This class mainly handles common attributes
* and functionalities of prisms like height and volume calculation. The 
* specific base area calculation, which depends on the type of prism, is left
* to be implemented by subclasses.
* 
* Created on October 15, 2023
* 
* @author Zoë Goodwin
* @version 1.0
*/


public abstract class AbstractPrism extends AbstractShape {
	
    // prism height
    private double height;

    /**
     * Constructor
     * @param height
     */
    public AbstractPrism(double height)
    {
	this.height = height;
    }

    /**
     * Retrieves the height of the prism.
     * @return prism height.
     */
    @Override
    public double getHeight()
    {
	return height;
    }

    /**
     * Calculates the volume of the prism.
     * @return prism volume.
     */
    @Override
    public double getVolume()
    {
	return getBaseArea() * height;
    }
}
