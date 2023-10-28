package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.lang.reflect.Constructor;

import main.shapes.AbstractShape;
import main.utils.Utility;

/**
* The Driver class handles sorting different shapes based on user selected criteria.
* Driver parses command line arguments to determine the file containing shapes data,
* the criteria for comparison (i.e., volume, height, or base area), and the 
* sorting algorithm to use.
* The results, including performance metrics and every 1000th value of the sorted
* list, are then displayed.
* 
* Created on October 17, 2023
* @author Zoë Goodwin
* @author Mousamiben Desai
* @author Sourabh Thakur
* @version 1.5
*/

public class Driver
{
        /**
         * Entry point of the program. Processes command-line arguments for file name,
         * type of comparison, and sorting algorithm; loads shapes from the file; sorts them;
         * and then prints the sorting results and performance metrics.
         * 
         * @param args Command-line arguments for specifying input file, comparison type, and sorting algorithm.
         */
	public static void main(String[] args) {
	    
	    // Parse command-line arguments
	    String fileName = parseCase(args, 'f');
	    String typeComparison = parseCase(args, 't');
	    String sortingAlgorithm = parseCase(args, 's');

	    // if command-line input is incomplete, print inputGuide
	    if (fileName == null || typeComparison == null || sortingAlgorithm == null) {
		inputGuide();
	    }
		
	    // load shapes file into array AbstractShape
	    AbstractShape[] shapes = loadShapesFile(fileName);

	    // error message for empty or null file
	    if (shapes == null) {
		System.out.println("Unable to load shapes.");
		return;
	    }

	    // variable for storing benchmarking start time
	    long startTime = System.currentTimeMillis();

	    // execute sorting arguments
	    sortShapes(shapes, typeComparison, sortingAlgorithm);

	    // variable for storing benchmarking end time
	    long endTime = System.currentTimeMillis();

	    // calculate algorithm duration
	    long algorithmDuration = endTime - startTime;
		
	    // display the sorting results
	    printResults(shapes, algorithmDuration);
		
	}

	
	// ***PRIVATE METHODS***
	
	/**
	 * Parses the command-line arguments to find a match for a specified flag.
	 * This method is case-insensitive for the flag character.
	 *
	 * @param args The array of command-line arguments.
	 * @param flag The flag character to look for, case-insensitive.
	 * @return The string argument corresponding to the flag, or {@code null} if not found.
	 */
	private static String parseCase(String[] args, char flag) {
	    // convert any flag character to lower case
	    char lowerCaseFlag = Character.toLowerCase(flag);
	    // if a charArray starts with '-' and is followed by a flag character, 
	    // return the character after the flag to its respective String variable
	    for (int i = 0; i < args.length; i++) {
	        char[] charArray = args[i].toCharArray();
		if (charArray[0] == ('-')) {
	            if (charArray[1] == lowerCaseFlag) {
	                return args[i].substring(2);
	            }
	        }
	    }
	    return null;
	}
	
	
	/**
	 * Loads shapes from a specified file into an array of AbstractShape.
	 * The method uses reflection to instantiate shape objects based on the shape data provided in the file.
	 * 
	 * @param fileName The path of the file containing shape data.
	 * @return An array of AbstractShape objects, or {@code null} if the file cannot be loaded or parsed correctly.
	 */
	private static AbstractShape[] loadShapesFile(String fileName) {
		
	    List<AbstractShape> shapeList = new ArrayList<>();
	    
	    // used FileInputStream to minimise memory load for huge files
	    try (FileInputStream fis = new FileInputStream(fileName);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(isr)) {
		
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
		    sb.append(line).append(" ");
		}
		
		String[] shapeData = sb.toString().split(" ");
		
		// if not enough data for even one shape
		if (shapeData.length < 2) {
		    System.out.println("Not enough data in file.");
		    return null;
		}
		
		// if 'number of shapes' integer at beginning of file is missing
		int numShapes;
		try {
		    numShapes = Integer.parseInt(shapeData[0]);
		} catch (NumberFormatException e) {
		    System.out.println("Integer expected for number of shapes, but read" + shapeData[0] + ".");
		    return null;
		}
		
		// if number of shapes does not match number of expected shape attributes in file
		if (shapeData.length < 1 + numShapes * 3) {
		    System.out.println("There is not enough data for the number of shapes declared.");
		    return null;
		}
		
		// the reflection section!
		// manages iteration through the shapeData String
		// since shapeData[0] is the number of shapes integer, the index starts at shapeData[1]
		int dataIndex = 1;
		for (int i = 0; i < numShapes; i++) {
		    String shapeType = shapeData[dataIndex++];
		    double height = Double.parseDouble(shapeData[dataIndex++]);
		    double baseMeasure = Double.parseDouble(shapeData[dataIndex++]);
		    
		    // reflection to instantiate shape objects
		    // catches for various fun shape exceptions
		    try {
			Class<?> classy = Class.forName("main.shapes." + shapeType);
			Constructor<?> constructor = classy.getConstructor(double.class, double.class);
			AbstractShape shape = (AbstractShape) constructor.newInstance(height, baseMeasure);
			shapeList.add(shape);
		    } catch (ClassNotFoundException e) {
			System.out.println("Shape type not found:" + shapeType);
		    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | java.lang.reflect.InvocationTargetException e) {
			System.out.println("Error creating shape " + shapeType + ".");
		    }
		}		
	    } catch (IOException e) {
		e.printStackTrace();
		return null;
	    }
	    
	    return shapeList.toArray(new AbstractShape[0]);			
	}	

	
	/**
	 * Sorts an array of AbstractShape objects based on a specified comparison type and sorting algorithm.
	 * The method determines the appropriate Comparator for the shapes and uses the specified algorithm
	 * from the Utility class for sorting.
	 *
	 * @param shapes           The array of AbstractShape objects to be sorted.
	 * @param typeComparison   The criteria for comparison (e.g., volume, height, base area).
	 * @param sortingAlgorithm The sorting algorithm to use (e.g., bubble, selection, insertion).
	 */
	private static void sortShapes(AbstractShape[] shapes, String typeComparison, String sortingAlgorithm)
	{
		// sort shapes using typeComparison and sorting Algorithm
		Comparator<AbstractShape> comparator = null;
		
		switch (typeComparison.toLowerCase()) {
	        	case "v":
	        	    // Compare by volume using the VolumeComparator
	        	    comparator = new AbstractShape.VolumeComparator();
	        	    break;
	        	case "h":
	        	    // Compare by height using the natural ordering (compareTo)
	        	    comparator = Comparator.naturalOrder();
	        	    break;
	        	case "a":
	        	    // Compare by base area using the BaseAreaComparator
	        	    comparator = new AbstractShape.BaseAreaComparator();
	        	    break;
			} 
 
    	    	// Use the sorting algorithm from the Utility class based on the sortingAlgorithm parameter
    	    	switch (sortingAlgorithm.toLowerCase()) {
    	    		case "b":
    	    		    Utility.bubbleSort(shapes, comparator);
    	    		    break;
    	    		case "s":
    	    		    Utility.selectionSort(shapes, comparator);
    	    		    break;
    	    		case "i":
    	    		    Utility.insertionSort(shapes, comparator);
    	    		    break;
    	    		case "m":
    	    		    Utility.mergeSort(shapes, comparator);
    	    		    break;
    	    		case "q":
    	    		    Utility.quickSort(shapes, comparator);
    	    		    break;
    	    		case "z":
    	    		    Utility.shellSort(shapes, comparator);
    	    		    break;
    	    		default:
    	    		    System.out.println("Not a valid algorithm selection.");
    	    	}

	}
		
	
	/**
	 * Prints a guide for the expected input format when the command-line inputs are incomplete or incorrect.
	 */
	private static void inputGuide() {
	    System.out.println("Inputs: java -jar sort.jar -f <file_name> -t <v/h/a> -s <b/s/i/m/q/z>");
	    System.out.println("-f: File path for the shapes text file.");
	    System.out.println("-t: Type comparison (v: volume, h: height, a: base area");
	    System.out.println("-s: Sorting algorithm (b: bubble, s: selection, i: insertion, m: merge, q: quick, z: shell");
	}
	
	/**
	 * Displays the results of the sorting operation, including the algorithm's duration
	 * and a selection of sorted shapes from the list.
	 *
	 * @param shapes             An array of sorted AbstractShape objects.
	 * @param algorithmDuration  The time taken to sort the shapes, in milliseconds.
	 */
	private static void printResults(AbstractShape[] shapes, long algorithmDuration) {
	    
	    // print the algorithm duration, first sorted value, and last sorted value
	    System.out.println("Sorting time: " + algorithmDuration + " milliseconds");
	    System.out.println("First value: " + shapes[0]);
	    System.out.println("Last value: " + shapes[shapes.length - 1]);
	    
	    // print every 1000th value
	    for (int i = 1000; i < shapes.length; i += 1000) {
		System.out.println("Value for position " + i + ": " + shapes[i]);
	    }
	}
}
