package ae2_extended;

import java.util.Scanner;

public class Player {
//Their name, and score.	
    private String name;
    private int score;
    
    
//Constructor
	public Player() {
		this.name = null;
		this.score = 0;
	}

	
//Board passes information as a parameter in the takeTurn method  
    public boolean takeTurn(Board targetBoard) {
	//Print before shot      	
        System.out.println(targetBoard);
		System.out.println("Player [" + name + "], your previous target board now looks like above:");    	    	
        System.out.println("Player [" + name + "] Please enter 2 integers from 1 to 10 for rows and columns");    
        
    //Scanner         
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();	
    	int column = s.nextInt();
 
    //Cannot exceed the grid boundary    	
    	if (row < 1 || row >10 || column <1 || column > 10) {
            System.out.println("The numbers should between 1 to 10"); 
            System.out.println("Skip this round"); 
    	}
    	
    //The guess is valid	
    	else {        		
    	Square guess = targetBoard.getUnit()[row-1][column-1];
    	
    //getShot == 1, the ship is sunk    	
    	if (guess.getShot()) {
    		System.out.println("The grid has been attacked.");	}
    	
    //getShip == 0, no ship in this unit, and it is shot       	
    	else if (!guess.getShip()) {
    		System.out.println("Miss!");
    		guess.shot(); }
    	
    //Hit a ship      	
    	else {
    		guess.shot();
    		guess.isShip.setHealth(guess.isShip.getHealth() - 1);
    		//Sink the ship    		
    		if (guess.isShip.getHealth() == 0) {
    			score++;
    			targetBoard.shipNum--;
        		guess.isShip.setSunk(false);    			
    			//Print Results     			
    			System.out.println("Player [" + name + "] You have destroy a ship! And now your score is[" +score +"]");    			
    			System.out.println("The number of remaining ships is "+targetBoard.shipNum);    			
    		}
    		
	//Hit a ship, but the ship did not sink  		
    		else {
    			System.out.println("Hitting the ship!");  }		
    		}
    	}
    	
    //Print Results      	
		System.out.println("Player [" + name + "], after shot your target board now looks like this:");    	    	
        System.out.println(targetBoard);
        for(int i =1; i <= 40; i++){ 
        	System.out.print("-");	
        	}
        System.out.print("\n");
        
    //Remaining ships are 0, game over          
        if (targetBoard.shipNum == 0) 
            return true;
        else
        	return false;      	
    }    

	
//Setters 	
      public void setName(String name) {
          this.name = name;
      }
      
   
//Getters   
      public String getName() {
          return name;
      }
      public int getScores() {
          return score;
      }    
}
