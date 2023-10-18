/**
* Created on October 17, 2023
* @author Zoë Goodwin
* @version 1.0
*/

public class Driver
{
	// program entry point
	public static void main(String[] args)
	{
		/*
		 * Initialisation & Execution
		 * - checks the number of command-line arguments
		 * - parses the command-line arguments
		 * - prints the input guide if arguments incomplete
		 * - loads the shapes text file into the array AbstractShape[]
		 * - prints an error message for an empty or null text file
		 * - executes the sorting arguments
		 */
				
		// check command-line arguments
		if (args.length < 6)
		{
			inputGuide();
			return;
		}
		
		// parse command-line arguments
		String fileName = parseCase(args, "-f");
		String typeComparison = parseCase(args, "-t");
		String sortingAlgorithm = parseCase(args, "-s");
		
		// if command-line input is incomplete, print inputGuide
		if (fileName == null || typeComparison == null || sortingAlgorithm == null)
		{
			inputGuide();
			return;
		}
		
		// load shapes file into array AbstractShape
		AbstractShape[] shapes = loadShapesFile(fileName);
		
		// error message for empty or null file
		if (shapes == null)
		{
			System.out.println("Unable to load shapes.");
			return;
		}
		
		// execute sorting arguments
		sortShapes(shapes, typeComparison, sortingAlgorithm);
		
		/*
		 * Benchmarking & Results		
		 */
		
	}
	
	// method to ensure case and order insensitivity for interpreting command-line arguments
	private static String parseCase(String[] args, String choice)
	{
		for (int i = 0; i < args.length - 1; i++)
		{
			if (args[i].equalsIgnoreCase(choice))
			{
				return args[i + 1];
			}
		}
		return null;
	}
	
	// method to handle loading the shapes text file into an array
	private static AbstractShape[] loadShapesFile(String fileName)
	{
		// load shapes
		
		// return array
		
		
	}
	
	// method to sort shapes using typeComparison, sortingAlgorithm, and Utility
	private static void sortShapes(AbstractShape[] shapes, String typeComparison, String sortingAlgorithm)
	{
		// sort shapes using typeComparison and sorting Algorithm
		
		// complete sorting using Utility class
		
	}
	
	// method to print the input guide when command-line inputs are incomplete
	private static void inputGuide()
	{
		System.out.println("Inputs: java -jar sort.jar -f <file_name> -t <v/h/a> -s <b/s/i/m/q/z>");
		System.out.println("-f: File path for the shapes text file.");
		System.out.println("-t: Type comparison (v: volume, h: height, a: base area");
		// UPDATE CUSTOM ALGORITHM NAME
		System.out.println("-s: Sorting algorithm (b: bubble, s: selection, i: insertion, m: merge, q: quick, x: EDIT ME");
	}
	
	
	
}
