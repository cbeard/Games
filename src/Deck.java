import java.util.Random;


public class Deck {
	
	 Card deck[];
	
	public Deck(int size){		
		deck = new Card[size];		 
		
	}
	
	public void shuffle(){
		
		Random r = new Random();
		
		Card newDeck[]= new Card[deck.length];
		int list[]  = new int[deck.length];
		
		for(int i=0 ; i<deck.length;i++){
			    list[i]=-1;
				int pick=r.nextInt(deck.length);
				
	    	    if(!isInList(list,pick)){ newDeck[i]=deck[pick]; list[i]=pick;}
			    else{ i--;}
			
		}
		
		deck = newDeck;
		
	}
	
	public String cardToString(int spot){
		return ""+deck[spot].getFaceValue()+deck[spot].getSuitType();
	}
	
	public void newlyDealtDeck(int offTheTop){
		
		int start =0;
		
		if(offTheTop>deck.length){offTheTop = deck.length;}
		
		Card[] temp = new Card[deck.length-offTheTop];
		
		for(int newTop = offTheTop; newTop<deck.length;newTop++){
			temp[start++] = deck[newTop];
		
		}
		
		deck = temp;
		
	}
	
	public void throwBackToDeck(Card toBack){
		
		Card[] temp = new Card[deck.length+1];
		
		for(int i = 0; i<deck.length;i++){
			temp[i] = deck[i];
		
		}
		temp[deck.length]= toBack;
		deck = temp;
		
	}
	
	private boolean isInList(int list[],int pick){
		
		for(int i=0;i<list.length;i++){
			if(pick==list[i]){return true;}
		}
		
		return false;
		
	}
	
	
	public Card[] getDeck(){
		return deck;
	}
	
	public void setDeck(Card[] d){
		 deck = d;
	}
	

}//end of Deck
