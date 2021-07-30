package main;
import java.util.Random;
import java.util.Scanner;

import Connect_4_backend.AI;
import Connect_4_backend.gameState;


public class Main {

	 public static void main(String[] args) {
		 	//gameState pvp = new gameState();
		 	AI pve = new AI();
		 	gameState pvp = new gameState();
		 	int z = 0;
		 	int x = 0;
		 	
		 	
		 	Scanner input = new Scanner(System.in);
	    	
	        System.out.print("\n pve (1) or pvp (2)? \n> ");
	        int number = input.nextInt();
	        System.out.println("You entered " + number + "\n");
		 	
	        
	    	while (number == 1) {
	    		
		        Scanner game = new Scanner(System.in);
		    	
		        System.out.print("\n col? \n> ");
		        int col = game.nextInt();
		        System.out.println("You entered " + col + "\n");
		        
		        pve.addToken(col, 1);
		        
		        
		         
	    	}
	    	
	    	while (number == 2) {
	    		
		        Scanner game = new Scanner(System.in);
		    	
		        System.out.print("\n col? \n> ");
		        int col = game.nextInt();
		        System.out.println("You entered " + col + "\n");
		        
		        z++;
		        if((z %2)==0) {x=1;}
		        else{x=2;};
		
		        pvp.addToken(col, x);
		        
		        
		         
	    	}
	    	
	    }
	
}
