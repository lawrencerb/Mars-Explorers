package MarsRovers;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/* The public class Command deals with users input. It was meant to be  
* the means by which NASA would pass on instructions to the landed rovers in
* Mars plateau. */

public class Command{

    
    public static void main(String[] args) {
    	
    	String fileName;
    	Rovers curiosity, opportunity;
        Plateau plateau;
        Scanner firstInput = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        File file;
        
        int selection;
        int m, n; //Plateau size
        int a = -1, b = -1; //Initial value for other rover collision evaluation. Default is -1 -1 for not deployed Rover.
        int x1, y1; //Initial value for the rover position.
        char direction;
        
        //Choose input type: 1 for text file input. 2 for manual input.
        System.out.println("Choose input type: 1 for text file input. 2 for manual input.");
        selection = firstInput.nextInt();
        firstInput.nextLine();
        
        if (selection == 1) {
        	
        	System.out.print("Input file name: ");
        	fileName = firstInput.nextLine();
        	try {
        		file = new File(fileName);
        		input = new Scanner(file);
        	
        	} catch(Exception e) {
        		System.out.println("File name does not exist");
        	} finally {
        		firstInput.close();
        	}
        } else if(selection == 2) {
        	input = new Scanner(System.in);
        	
        } else {
        	System.out.println("Not a valid input. Exiting.");
        	System.exit(0);
        }
        
        
        //System now will attempt to acquire a valid user input for  the first Rover:
        System.out.println("Enter with Plateau size: (Two positive intergers in between space)");
        m = input.nextInt();
        n = input.nextInt();
        plateau = new Plateau(m, n);
        
        System.out.println("Enter with the rover position and direction:");
    	x1 = input.nextInt();
    	y1 = input.nextInt();
   		input.skip(" ");
    	direction = input.nextLine().charAt(0);
    	System.out.println("Enter with the exploration instructions:");
    	curiosity = new Rovers(x1, y1, direction, input.nextLine());
    	
    	curiosity.executeInstructionSet(plateau, a, b);
    	curiosity.showCurrentLocation();
    	a = curiosity.getX();
    	b = curiosity.getY();
    	
    	
    	
        System.out.println("Enter with the  other rover position and direction:");
    	x1 = input.nextInt();
    	y1 = input.nextInt();
   		input.skip(" ");
    	direction = input.nextLine().charAt(0);
    	System.out.println("Enter with the exploration instructions:");
    	opportunity = new Rovers(x1, y1, direction, input.nextLine());
    	
    	opportunity.executeInstructionSet(plateau, a, b);
    	opportunity.showCurrentLocation();
    	
        input.close();
    }
}
