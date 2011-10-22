

import java.util.*;

public class Game {


	public static void main(String[] args) {
		
		
		
		
		Dealer dealer = new Dealer();
		
		
		for(int i = 0; i<dealer.getDeck().length;i++){
			
				System.out.println(dealer.cardToString(i));
				
		
		}
		dealer.shuffle();
		
		System.out.println("-------------------------  \n");
		
		for(int i = 0; i<dealer.getDeck().length;i++){
			
			System.out.println(dealer.cardToString(i));
			
	
	    }
		
    Hand playHand =new Hand(dealer.dealHand(5));
    playHand.printHand();
		
		
		System.out.println("-------------------------  \n");
		
		for(int i = 0; i<dealer.getDeck().length;i++){
			
			System.out.println(dealer.cardToString(i));
			
	
	    }
		
		dealer.getNewDeck();
		
		System.out.println("-------------------------  \n");
		
		for(int i = 0; i<dealer.getDeck().length;i++){
			
			System.out.println(dealer.cardToString(i));
			
	
	    }
		

		
		dealer.shuffle();
		
		System.out.println("-------------------------  \n");
		
			System.out.println(dealer.deckListToString());
			
	
		Card[] testHand = { new Card(3,'c'),new Card(3,'s'),new Card(3,'c'),new Card(8,'h'),new Card(3,'c')};
		Hand hand = new Hand(testHand);
		hand.printInfo();
		System.out.println("\n-------------------------  \n");
        Hand playHand1 =new Hand(dealer.dealHand(5));
        playHand1.printInfo();
        System.out.println("\n-------------------------  \n");
	    Hand playHand2 =new Hand(dealer.dealHand(5));
	    playHand2.printInfo();
	    System.out.println("\n-------------------------  \n");
	    Hand playHand3 =new Hand(dealer.dealHand(5));
	    playHand3.printInfo();
	    System.out.println("\n-------------------------  \n");
	    Hand playHand4 =new Hand(dealer.dealHand(5));
	    playHand4.printInfo();
	    System.out.println("\n-------------------------  \n");
	    
		System.out.println("Enter in spot");

		Scanner input = new Scanner(System.in);
		
		
	    playHand4 = new Hand(dealer.draw(playHand4.getHand(), input.nextInt()-1, input.nextInt()-1));
		playHand4.printInfo();
		System.out.println("\n-------------------------  \n");
	    
	
			
			System.out.println(dealer.deckListToString());

	}

}//end of Game
