package MarsRovers;
/* Public class Rovers deals with the rovers movements and outputs it's arrived position. 
* The class contains 2 methods, the first one performs the desired movement provided 
* by the user's input, the second outputs the Rover current location. */

public class Rovers{
	
	private Position position;
	private String instructionSet;
	
	public Rovers(int x, int y, char direction, String instructionSet) {
		
		this.position = new Position(x, y, direction);
		this.instructionSet = instructionSet;
	}
		
    public void executeInstructionSet(Plateau plateau, int a, int b) {        
    	int i = 0;
    	
    	while (i < instructionSet.length()) {
    		
    		char instructions = instructionSet.charAt(i);
    		i++;
    		
            if(instructions == 'L') {
            	switch (position.getDirection()) {
                	case 'N':
	                    position.setDirection('W');
	                    break;
                	case 'W':
	                	position.setDirection('S');
	                    break;
                	case 'S':
	                	position.setDirection('E');
	                    break;
                	case 'E':
	                	position.setDirection('N');
	                    break;
            	}
            } else if(instructions =='R'){
	            switch (position.getDirection()) {
	                case 'N':
	                	position.setDirection('E');
	                    break;
	                case 'W':
	                	position.setDirection('N');
	                    break;
	                case 'S':
	                	position.setDirection('W');
	                    break;
	                case 'E':
	                    position.setDirection('S');
	                    break;
	            }
	        } else if(instructions == 'M') {
	        	
	        	switch (position.getDirection()) {
		            case 'N':
		            	if (position.getY() < plateau.getY()) {
		            		if (position.getY()+1 != b || position.getX() != a) {
		            			position.setY(position.getY() + 1);
		            		} else {
		            			System.out.println("Rover colision detected. Executing next instruction");
		            		}
		            	} else {
		            		System.out.println("This move is impossible. Executing next instruction");
		            	}
		                break;
		            case 'W':
		            	if (position.getX() > 0)  {
		            		if(position.getY() != b || position.getX()-1 != a) {
		            			position.setX(position.getX() - 1);
		            		} else {
		            			System.out.println("Rover colision detected. Executing next instruction");
		            		}
		            	} else {
		            		System.out.println("This move is impossible. Executing next instruction");
		            	}
		            	
		            	break;
		            case 'S':
		            	if (position.getY() > 0) {
		            		if(position.getY()-1 != b || position.getX() != a) {
		            			position.setY(position.getY() - 1);
		            		} else {
		            			System.out.println("Rover colision detected. Executing next instruction");
		            		}
		            	} else {
		            		System.out.println("This move is impossible. Executing next instruction");
		            	}
		                break;
		            case 'E':
		            	if (position.getX() < plateau.getX()) {
		            		if(position.getY() != a || position.getX()+1 != b) {
		            			position.setX(position.getX() + 1);
		            		} else {
		            			System.out.println("Rover colision detected. Executing next instruction");
		            		}
		            	} else {
		            		System.out.println("This move is impossible or rover colision detected. Executing next instruction");
		            	}
		            	break;
	        	}
        	
	        } else {
	        	System.out.println("This move is invalid. Awaiting next instruction");
	        	
	        }
    	}
    }
    // Broadcast current position of the rover to the user.
    public void showCurrentLocation(){

        System.out.println("Current Cell is:");
        System.out.print(position.getX());
        System.out.print(" "+position.getY());
        System.out.print(" "+position.getDirection()+"\n");

    }
    // Broadcast current position to class Command for future collision evaluation.
	public int getX() {
		return position.getX();
	}
	public int getY() {
		return position.getY();
	}
}

