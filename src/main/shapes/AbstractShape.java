package main.shapes;

/**
* Created on October 15, 2023
* @author Zoë Goodwin
* @version 1.0
*/

import java.util.Comparator;

public abstract class AbstractShape implements Comparable<AbstractShape>
{
	
	// getters
	public abstract double getHeight();
	public abstract double getBaseArea();
	public abstract double getVolume();
	
	// compareTo() using height
	@Override
	public int compareTo(AbstractShape otherShape)
	{
		return Double.compare(this.getHeight(), otherShape.getHeight());
	}
	
	// inner comparator using volume
	public static class VolumeComparator implements Comparator<AbstractShape>
	{
		@Override
		public int compare(AbstractShape s1, AbstractShape s2)
		{
			return Double.compare(s1.getVolume(), s2.getVolume());
		}
	}
	
	// inner comparator using base area
	public static class BaseAreaComparator implements Comparator<AbstractShape>
	{
		@Override
		public int compare(AbstractShape s1, AbstractShape s2)
		{
			return Double.compare(s1.getBaseArea(), s2.getBaseArea());
		}
	}

}
