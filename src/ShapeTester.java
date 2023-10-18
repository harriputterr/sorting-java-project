import java.io.BufferedReader;
import shapes.AbstractShape;
import java.io.FileReader;
import java.io.IOException;
import shapes.PrismOctagonal;
import shapes.PrismPentagonal;
import shapes.PrismSquare;
import shapes.PrismTriangular;
import shapes.Pyramid;
import shapes.Cone;
import shapes.Cylinder;


public class ShapeTester {
	
	// Read and Separate information from file
	public static void ShapeTesting(AbstractShape[] shapes, String field ) {

		// Read the file from the path (field is the given path)
		try (BufferedReader reader = new BufferedReader(new FileReader(field))){
			
			// Take out the first numbers which is the number of shapes
			int numShapes = Integer.parseInt(reader.readLine().trim());
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
			}
		} catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	

}
