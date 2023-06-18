package ae2_extended;

public class SmallBattleship extends BattleShip {
	//Small boats occupy one grid, and there are 3 small boats in total.
	static Square[] cell = new Square[1];
	static int number = 3;
	
	//health and size are 1
    public SmallBattleship(Square small) {
        cell[0] = small;
        this.setHealth(1);
		this.setSize(1);
    }
    
  //Getters
    public int getNum() {
        return number;
    }
   

}
