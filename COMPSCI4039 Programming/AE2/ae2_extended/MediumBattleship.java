package ae2_extended;

public class MediumBattleship extends BattleShip {
	//medium boats occupy 2 grids, and there are 2 medium boats in total.	
	static Square[] cell = new Square[2];
	static int number = 2;

	//health and size are 2	
	public MediumBattleship(Square medium1,Square medium2) {
		cell[0] = medium1;
		cell[1] = medium2;
		this.setHealth(2);
		this.setSize(2);
	}
	
	//Getters
    public int getNum() {
        return number;
    }
   
}	
