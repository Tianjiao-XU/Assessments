package ae2_extended;

public class BattleShip {
	
    protected boolean isSunk;  
	protected int health;
	protected int size;	
	
	//Constructor	
	//basic size=2
	public BattleShip() {
		this.isSunk = false;
		this.health = 2;
		this.size = 2;
	}

	
	//Getters	
    public int getHealth() {
        return health;
    }    
    public int getSize() {
        return size;
    }
    
  //Setters     
	public void setHealth(int health) {
        this.health = health;
    }
	public void setSize(int size) {
        this.size = size;
    }
	public void setSunk(boolean isSunk) {
        this.isSunk = isSunk;
    }	

}