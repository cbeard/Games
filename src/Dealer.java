
public class Dealer extends Thread{
	
	private PokerDeck playingDeck ;
	
	public Dealer(){
	
		playingDeck = new PokerDeck();		
		
	}
	
	public void run(){
		
		
		
	}
	
	public void shuffle(){
		playingDeck.shuffle();
	}
	
	public void getNewDeck(){
		playingDeck = new PokerDeck();
	}
	
	
	public Card[] dealHand(int numOfCards){		
		
		Card[] hand = new Card[numOfCards];
		
		for(int i =0; i<numOfCards;i++){
			hand[i] = playingDeck.getDeck()[i];			
		}
	
		playingDeck.newlyDealtDeck(numOfCards);
		
		return hand;		
		
	}
	
	public String cardToString(int spot){
		return playingDeck.cardToString(spot);
	}
	
	public Card[] getDeck(){
		return playingDeck.getDeck();
	}
	
	private void printDeck(){
		
		System.out.println("Deck Size : "+playingDeck.getDeck().length);
		
		for(int i =0; i<playingDeck.getDeck().length;i++){
			System.out.println( i+" - "+ playingDeck.getDeck()[i]);
			
		}
	}
	public Hand drawOption(Hand hand){
		
		if(Hand.HIGHCARD==hand.getRank()){
			hand.equals( draw(hand.getHand(), 0, 1, 2, 3));
			
		}
		else
		if(Hand.ONEPAIR==hand.getRank()){
			int card1 =-1,card2=-1,card3=-1;
			for(int i=0;i<hand.getHandLength()-1;i++){
			    if(hand.getHand()[i].getFaceValue()!=hand.getHand()[i+1].getFaceValue()){
			    	if(card1==-1){card1=i;} else
			    	if(card2==-1){card2=i;} else
			    	if(card3==-1){card3=i;}
			    }
			    else{ i++;}
			}   	
			if(card3==-1){card3=hand.getHandLength()-1;}
			
			hand.equals( draw(hand.getHand(), card1, card2,card3));

		}
		else
		if(Hand.TWOPAIR==hand.getRank()||Hand.FOUROFAKIND==hand.getRank()){
			int card1 =-1;
			for(int i=0;i<hand.getHandLength()-1;i++){
			    if(hand.getHand()[i].getFaceValue()!=hand.getHand()[i+1].getFaceValue()){
			    	if(card1==-1){card1=i;} 
			    }
			    else{ i++;}
			}   	
			if(card1==-1){card1=hand.getHandLength()-1;}
			
			hand.equals( draw(hand.getHand(), card1));


		}
		else
		if(Hand.THREEOFAKIND==hand.getRank()){
			int card1 =-1,card2=-1;
			for(int i=0;i<hand.getHandLength()-1;i++){
			    if(hand.getHand()[i].getFaceValue()!=hand.getHand()[i+1].getFaceValue()){
			    	if(card1==-1){card1=i;} else
			    	if(card2==-1){card2=i;} 
			    }
			    else{ i++;i++;}
			}   	
			if(card2==-1){card2=hand.getHandLength()-1;}
			
			hand.equals( draw(hand.getHand(), card1, card2));

		}
		
		
		return new Hand(hand.getHand());
		
	}
	public Card[] draw(Card hand[],int spot1){
		
		playingDeck.throwBackToDeck(hand[spot1]);
		hand[spot1]= playingDeck.getDeck()[0];
		playingDeck.newlyDealtDeck(1);
		return hand;
		
	}

	public Card[] draw(Card hand[],int spot1,int spot2){
		 
	    hand = draw(hand,spot1);
	    hand = draw(hand,spot2);
	    return hand;
		
	}
	
	public Card[] draw(Card hand[],int spot1,int spot2,int spot3){
		 
	    hand = draw(hand,spot1,spot2);
	    hand = draw(hand,spot3);
	    return hand;
		
	}
	
	public Card[] draw(Card hand[],int spot1,int spot2,int spot3,int spot4){
		 
	    hand = draw(hand,spot1,spot2,spot3);
	    hand = draw(hand,spot4);
	    return hand;
		
	}
	
	public Card[] draw(Card hand[],int spot1,int spot2,int spot3,int spot4,int spot5){
		 
	    hand = draw(hand,spot1,spot2,spot3,spot4);
	    hand = draw(hand,spot5);
	    return hand;
		
	}
	
	public String deckListToString(){
		String list ="";
		for(int i = 0; i<playingDeck.getDeck().length;i++){
			
			if(i%5==0){list+="\n";}
			list += playingDeck.cardToString(i)+",";			
	
	    }
		return list;
	}
	
}//end of Dearler
