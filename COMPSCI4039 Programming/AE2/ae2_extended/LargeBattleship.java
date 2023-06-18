package ae2_extended;

public class LargeBattleship extends BattleShip {
	//large boats occupy 3 grids, and there are 1 large boats in total.
	static Square[] cell = new Square[3];
	static int number = 1;
	
	//health and size are 3	
	public LargeBattleship(Square large1,Square large2,Square large3) {
		cell[0] = large1;
		cell[1] = large2;
		cell[2] = large3;		
		this.setHealth(3);
		this.setSize(3);
	}
	
	//Getters
    public int getNum() {
        return number;
    }
	
}
