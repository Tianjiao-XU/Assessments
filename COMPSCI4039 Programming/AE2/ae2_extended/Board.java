package ae2_extended;

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
    	shipNum = SmallBattleship.number + MediumBattleship.number + LargeBattleship.number; 
    	
    //Generate small ships    	
    	int num1 = SmallBattleship.number;     	
    	SmallBattleship[] small = new SmallBattleship[num1];    	    	
    	while (num1>0) {
    // Random location		
        	Random r = new Random();
        	int x1 = r.nextInt(numRows);
        	int y1 = r.nextInt(numColumns);  
    //If there is no ship at the current location, the generation is successful
        	if (unit[x1][y1].getShip() == false) {  		
        	small[3-num1] = new SmallBattleship(unit[x1][y1]);     
        	unit[x1][y1].isShip = small[3-num1];
        	num1--;
        	}
    	}
    	
    //Generate medium ships  	
    	int num2 = MediumBattleship.number;  	
    	MediumBattleship[] medium = new MediumBattleship[num2];
    	while (num2>0) {
        	Random r = new Random();
        	//Random Direction
        	int direction2 = r.nextInt(2);
        	// Random location
        	int x2 = r.nextInt(numRows);
        	int y2 = r.nextInt(numColumns); 
        	
        	/*0:vertically
        	 *For vertical ships, if the number of row is less than or equal to 9, 
        	 *And the two spaces occupied by ship are not the same as those already placed
        	 *Then the generation is successful
        	 */
        	if (direction2 == 0 && x2<(numRows-1) && unit[x2][y2].getShip() == false && unit[x2+1][y2].getShip() == false) {
        		medium[2-num2] = new MediumBattleship(unit[x2][y2],unit[x2+1][y2]); 
            	unit[x2][y2].isShip = medium[2-num2];            	
            	unit[x2+1][y2].isShip = medium[2-num2];
            	num2--;				
            	}
        	
        	/*1:horizontal
        	 *For horizontal ships, if the number of column is less than or equal to 9, 
        	 *And the two spaces occupied by ship are not the same as those already placed
        	 *Then the generation is successful
        	 */
        	else if (direction2 == 1 && y2<(numColumns-1) && unit[x2][y2].getShip() == false && unit[x2][y2+1].getShip() == false) {
        		medium[2-num2] = new MediumBattleship(unit[x2][y2],unit[x2][y2+1]);             	
        		unit[x2][y2].isShip = medium[2-num2];
            	unit[x2][y2+1].isShip = medium[2-num2];
            	num2--;            		
            	}       		
        }
    
    //Generate large ships     	
    	int num3 = LargeBattleship.number;  	
    	LargeBattleship[] large = new LargeBattleship[num3];
    	while (num3>0) {
        	Random r = new Random();
        	//Random Direction
        	int direction3 = r.nextInt(2);
        	// Random location
        	int x3 = r.nextInt(numRows);
        	int y3 = r.nextInt(numColumns); 
        	
        	/*0:vertically
        	 *For vertical ships, if the number of row is less than or equal to 8, 
        	 *And the 3 spaces occupied by ship are not the same as those already placed
        	 *Then the generation is successful
        	 */
        	if (direction3 == 0 && x3<(numRows-2) && unit[x3][y3].getShip() == false && unit[x3+1][y3].getShip() == false && unit[x3+2][y3].getShip() == false) {
        		large[1-num3] = new LargeBattleship(unit[x3][y3],unit[x3+1][y3],unit[x3+2][y3]); 
        		unit[x3][y3].isShip = large[1-num3];
            	unit[x3+1][y3].isShip = large[1-num3];
            	unit[x3+2][y3].isShip = large[1-num3];            	
            	num3--;				
            	}
        	
        	/*1:horizontal
        	 *For horizontal ships, if the number of column is less than or equal to 8, 
        	 *And the 3 spaces occupied by ship are not the same as those already placed
        	 *Then the generation is successful
        	 */
        	else if (direction3 == 1 && y3<(numColumns-2) && unit[x3][y3].getShip() == false && unit[x3][y3+1].getShip() == false && unit[x3][y3+1].getShip() == false) {
        		large[1-num3] = new LargeBattleship(unit[x3][y3],unit[x3][y3+1],unit[x3][y3+2]); 
        		unit[x3][y3].isShip = large[1-num3];
            	unit[x3][y3+1].isShip = large[1-num3];
            	unit[x3][y3+2].isShip = large[1-num3];              	
            	num3--;    
            	} 	
    	}
   	    	
    }   
}

