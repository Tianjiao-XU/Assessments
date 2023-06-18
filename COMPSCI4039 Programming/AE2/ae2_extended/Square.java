package ae2_extended;


public class Square {
//Attributes	
	//An attribute to indicate whether the square has a ship in it.A reference to a battleship if one is currently on the Square.
	//if isShip	== null, there’s no ship in it.
	BattleShip isShip;
	//An attribute to indicate whether the player has fired a shot at the square.
	private boolean isShot;
	
	
//Constructor	
	public Square() {
		this.isShip = null;
		this.isShot = false;
	}
	
	
	//If the player guesses the grid correctly,isShot = true. 	
	public void shot() {
		isShot = true;
	}

	
//Getters
    public boolean getShot() {
        return isShot;
    }	
    public boolean getShip() {
        return isShip != null;
    }

     
    public String toString() {   
    	//Hit a ship
    	if (isShot && isShip != null) {    	
            return "x";} 
    	//test
    	  // 	else if (isShip != null) {    	
    	  //    return "s";} 
    	//Hit the sea    	
        else if (isShot) {
            return "o";} 
    	//Not attacked      	
        else {
            return "-";}
    }    
    
}
