package ae2_basic;

public class BattleShip {
	
    protected boolean isSunk;  
	protected int health;
	protected int size;	
	static Square[] cell = new Square[2];
	static int number = 5;
	
	//Constructor	
	public BattleShip(Square ship1, Square ship2) {
		this.isSunk = false;
		this.health = 2;
		this.size = 2;
		cell[0] = ship1;
		cell[1] = ship2;
	}

	
	//Getters:health,size,number	
    public int getHealth() {
        return health;
    }
    public int getSize() {
        return size;
    }
    public int getNum() {
        return number;
    }    
    
  //Setters:health,size,isSunk  
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