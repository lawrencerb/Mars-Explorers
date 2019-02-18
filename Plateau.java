package MarsRovers;

/* Plateau is essentially determine the boundaries for which the rovers can't 
 * go through. It does not create a full matrix of possible rover position,
 * instead it is solely used to limit the rover possible movement.
 */

public class Plateau {
    private int X, Y;
	
	public int getX(){
		return X;
	}
	
	public int getY(){
		return Y;
	}
	
    public Plateau(int X, int Y) {
    	
    	this.X = X;
    	this.Y = Y;

    }
}
