package main;

/**
* Created on October 17, 2023
* @author Zoë Goodwin, Mousamiben Desai
* @version 1.3
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import main.shapes.AbstractShape;
import main.shapes.Cone;
import main.shapes.Cylinder;
import main.shapes.PrismOctagonal;
import main.shapes.PrismPentagonal;
import main.shapes.PrismSquare;
import main.shapes.PrismTriangular;
import main.shapes.Pyramid;
import main.utils.Utility;

public class Driver
{
	// program entry point
	public static void main(String[] args) {
	    if (args.length < 6) {
		inputGuide();
            return;
	    }
	    
	    // Parse command-line arguments
	    String fileName = parseCase(args, "-f");
	    String typeComparison = parseCase(args, "-t");
	    String sortingAlgorithm = parseCase(args, "-s");
		
		// if command-line input is incomplete, print inputGuide
		if (fileName == null || typeComparison == null || sortingAlgorithm == null) {
			inputGuide();
			return;
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

	
	// method to ensure case and order insensitivity for interpreting command-line arguments
	private static String parseCase(String[] args, String choice) {
	    for (int i = 0; i < args.length; i++) {
	        if (args[i].equalsIgnoreCase(choice)) {
	            if (i < args.length - 1) {
	                return args[i + 1];
	            }
	        }
	    }
	    return null;
	}

	
	
	// method to handle loading the shapes text file into an array
	private static AbstractShape[] loadShapesFile(String fileName)
	{
		List<AbstractShape> shapeList = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
			// Take out the first numbers which is the number of shapes
			String firstLine = reader.readLine();
	        if (firstLine == null) {
	            System.out.println("File is empty.");
	            return null;
	        }
	        
	        int numShapes = 0;
	        try {
	            numShapes = Integer.parseInt(firstLine.trim());
	        } catch (NumberFormatException e) {
	            System.out.println("Expected an integer (number of shapes) on the first line, but got: '" + firstLine + "'.");
	            return null;
	        }

	        // Check if the number of shapes is a reasonable value
	        if (numShapes <= 0) {
	            System.out.println("Invalid number of shapes: " + numShapes);
	            return null;
	            }

			AbstractShape[] shape = new AbstractShape[numShapes];
			
			
			// Run a loop up to the number of shapes present
			for(int i = 0; i < numShapes; i++) {
				// Read all the text and put it into a line
				String line = reader.readLine();
				// split the line into separate parts
				String[] parts = line.split(" ");
				// Take first index as ShapeType
				String shapeType = parts[0];
				// Second Index as height
				double height = Double.parseDouble(parts[1]);
				// Third index as baseRadius
				double baseRadius = Double.parseDouble(parts[2]);
				
				// this will put the values of height and baseRadius in shapes If "Cylinder" match with shapeType
				if("Cylinder".equalsIgnoreCase(shapeType)) {
					shape[i] = new Cylinder(height,baseRadius);
					
					
				}
				// this will put the values of height and baseRadius in shapes If "Cone" match with shapeType
				else if ("Cone".equalsIgnoreCase(shapeType)) {
					shape[i] = new Cone(height,baseRadius);
				}
				// this will put the values of height and baseRadius in shapes If "Pyramid" match with shapeType
				else if ("Pyramid".equalsIgnoreCase(shapeType)) {
					shape[i] = new Pyramid(height,baseRadius);
				}
				// this will put the values of height and baseRadius in shapes If "PrismOctagonal" match with shapeType
				else if ("PrismOctagonal".equalsIgnoreCase(shapeType)){
					shape[i] = new PrismOctagonal(height,baseRadius);
				}
				// this will put the values of height and baseRadius in shapes If "PrismPentagonal" match with shapeType
				else if ("PrismPentagonal".equalsIgnoreCase(shapeType)) {
					shape[i] = new PrismPentagonal(height,baseRadius);
				}
				// this will put the values of height and baseRadius in shapes If "PrismSquare" match with shapeType
				else if ("PrismSquare".equalsIgnoreCase(shapeType)) {
					shape[i] = new PrismSquare(height,baseRadius);
				}
				// this will put the values of height and baseRadius in shapes If "PrismTriangular" match with shapeType
				else if ("PrismTriangular".equalsIgnoreCase(shapeType)) {
					shape[i] = new PrismTriangular(height,baseRadius);
				}
				if (shape != null) {
					shapeList.add(shape[i]);}
			}
			
		} catch (IOException e) {
                e.printStackTrace();
            }
			
	    // return array
	    return shapeList.toArray(new AbstractShape[0]);
			
	}	

	
	// method to sort shapes using typeComparison, sortingAlgorithm, and Utility
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
	        	    break;
	        	case "a":
	        	    // Compare by base area using the BaseAreaComparator
	        	    comparator = new AbstractShape.BaseAreaComparator();
	        	    break;
			}
	    
    	    	if (comparator != null) {
    	    	    Arrays.sort(shapes, comparator);
    	    	} else {
    	    	    Arrays.sort(shapes);
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
    	    		case "x":
    	    		    Utility.shellSort(shapes, comparator);
    	    		    break;
    	    		default:
    	    		    System.out.println("Not a valid algorithm selection.");
    	    		    return;
    	    	}
	}
		
	
	// method to print the input guide when command-line inputs are incomplete
	private static void inputGuide() {
	    System.out.println("Inputs: java -jar sort.jar -f <file_name> -t <v/h/a> -s <b/s/i/m/q/z>");
	    System.out.println("-f: File path for the shapes text file.");
	    System.out.println("-t: Type comparison (v: volume, h: height, a: base area");
	    System.out.println("-s: Sorting algorithm (b: bubble, s: selection, i: insertion, m: merge, q: quick, x: shell");
	}
	
	// method to display the benchmarking and sorted results
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
