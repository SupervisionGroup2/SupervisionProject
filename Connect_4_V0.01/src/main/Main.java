package main;
import java.util.Random;
import java.util.Scanner;
import Connect_4_backend.gameState;


public class Main {

	 public static void main(String[] args) {
		 	gameState test = new gameState();
		 	int z = 0;
		 	int x = 0;
	    	while (true) {
	    		
		        Scanner input = new Scanner(System.in);
		    	
		        System.out.print("\n col? \n> ");
		        int number = input.nextInt();
		        System.out.println("You entered " + number + "\n");
		        
		        z++;
		        if((z %2)==0) {x=1;}
		        else{x=2;};
		
		        test.addToken(number, x);
		        
		         
	    	}
	    }
	
}
