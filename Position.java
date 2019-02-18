package MarsRovers;

/* Class Position functions as a navigation map for the rover.
 * 7 methods were created to acquire the rover position and facing direction.
 * The first one keeps the initial values for navigation, the other 6 are means to provide
 * position and set the new positions after the movements were executed. */

public class Position {
	    private int x;
	    private int y;
	    private char direction;

	    public Position(int PosX, int PosY, char direction) {
	        this.x=PosX;
	        this.y=PosY;
	        this.direction = direction;
	    }
	    public int getX() {
	    	return x;
	    	
	    }
	    public int getY() {
	    	return y;
	    }
	    public char getDirection() {
	    	return direction;
	    }
	    
	    public void setX(int x) {
	    	this.x = x;
	    	
	    }
	    public void setY(int y) {
	    	this.y = y;
	    }
	    public void setDirection(char direction) {
	    	this.direction = direction;
	    }
}
