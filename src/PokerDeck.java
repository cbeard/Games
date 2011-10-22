import java.util.*;

public class PokerDeck extends Deck{
	
	
	
	
	public PokerDeck(){		
		super(52);
		loadDeck();
		
	}
	
	private void loadDeck(){
		
		int place=0;
		
		int suitStart = 2;
		int suitEnd   =15;
		
		for(int clubs =suitStart; clubs < suitEnd ;clubs++){
			deck[place++] = new Card(clubs,'C');
		}
		for(int hearts =suitStart; hearts < suitEnd; hearts++){
			deck[place++] = new Card(hearts,'H');
		}
		for(int diamonds =suitStart; diamonds < suitEnd; diamonds++){
			deck[place++] = new Card(diamonds,'D');
		}
		for(int spades=suitStart; spades<suitEnd;spades++){
			deck[place++] = new Card(spades,'S');
		}
	}	
	

}//end of PokerDeck

