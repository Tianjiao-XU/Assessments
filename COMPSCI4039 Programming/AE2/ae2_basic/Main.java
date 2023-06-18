package ae2_basic;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
        Scanner s = new Scanner(System.in);
        //Play1          
        System.out.println("Input Player1's name.");
        Player player1 = new Player();
        
        //Set player name
        player1.setName(s.next());
        
        //Generate the player's board
        Board playerTargetBoard1 = new Board();
        playerTargetBoard1.generateShip();
		System.out.println("TargetBoard fot [" + player1.getName() + "] is generated");
        
		//Play2
        System.out.println("Input Player2's name.");
        Player player2 = new Player();   
        
        //Set player name
        player2.setName(s.next());
        
        //Generate the player's board
        Board playerTargetBoard2 = new Board();
        playerTargetBoard2.generateShip();
		System.out.println("TargetBoard fot [" + player2.getName() + "] is generated");         

        
        //The game ends when a player has 0 ships left, otherwise the game continues
        while (true) {
            if (player1.takeTurn(playerTargetBoard1)){break;}
            if (player2.takeTurn(playerTargetBoard2)){break;}
        }
        
        //Judge the result of the game, the player with the higher score wins
        if (player1.getScores() > player2.getScores()) {
            System.out.printf("[%s] Win!", player1.getName());
        } else if (player1.getScores() < player2.getScores()) {
            System.out.printf("[%s] Win!", player2.getName());
        } else {
            System.out.println("Draw!");        		}
        
	}
}

