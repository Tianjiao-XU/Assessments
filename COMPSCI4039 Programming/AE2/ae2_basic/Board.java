package ae2_basic;

import java.util.Random;

public class Board {
/*
 * The board constructor should take in two values representing the number of rows and columns, 
 * again you can assume that these values will be 10 when testing your program.
 */
	int numRows = 10;
	int numColumns = 10;	
    Square[][] unit = new Square[numRows][numColumns];
    int shipNum;

  //Constructor
    public Board() {
        for (int i = 0; i <= (numRows-1); i++) {
            for (int j = 0; j <= (numColumns-1); j++) {
            	this.unit[i][j] = new Square();
            }
        }
    }
    
   
	
    //get unit    
    public Square[][] getUnit() {
        return unit;
    }    
    
    //toString
    public String toString() {
        String temp = "";
        for (int i = 0; i <numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                String unitString = String.format("%3s", unit[i][j]);
            	temp += unitString;
            }
            temp += "\n";
        }
        return temp;
    }
    
    public void generateShip() {
    //Calculate the total number of ships	
    	shipNum = BattleShip.number; 
		
    //Generate  ships  	  	
    	BattleShip[] ship = new BattleShip[shipNum];
		int number = shipNum;
    	while (number>0) {
        	Random r = new Random();
        	//Random Direction
        	int direction = r.nextInt(2);
        	// Random location
        	int x = r.nextInt(numRows);
        	int y = r.nextInt(numColumns); 
    		          	
        	/*0:vertically
        	 *For vertical ships, if the number of row is less than or equal to 9, 
        	 *And the two spaces occupied by ship are not the same as those already placed
        	 *Then the generation is successful
        	 */
        	if (direction == 0 && x<(numRows-1) && unit[x][y].getShip() == false && unit[x+1][y].getShip() == false) {
        		ship[5-number] = new BattleShip(unit[x][y],unit[x+1][y]); 
            	unit[x][y].isShip = ship[5-number];            	
            	unit[x+1][y].isShip = ship[5-number];
            	number--;				
            	}
        	
        	/*1:horizontal
        	 *For horizontal ships, if the number of column is less than or equal to 9, 
        	 *And the two spaces occupied by ship are not the same as those already placed
        	 *Then the generation is successful
        	 */
        	else if (direction == 1 && y<(numColumns-1) && unit[x][y].getShip() == false && unit[x][y+1].getShip() == false) {
        		ship[5-number] = new BattleShip(unit[x][y],unit[x][y+1]);             	
        		unit[x][y].isShip = ship[5-number];
            	unit[x][y+1].isShip = ship[5-number];
            	number--;            		
            	}       		
        }
   
   	    	
    }   
}

