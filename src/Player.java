
public class Player {
	
	Hand hand;
	int winnings;
	
	public Player(Hand hand,int winnings){
		
		this.hand = hand;
		this.winnings = winnings;
		
		
	}
	
	public Hand getHand(){ return hand;}
	public Card[] getCards(){return hand.getHand();}
	public int getWinnings(){ return winnings;}
	
	public void setHand(Hand hand){  this.hand=hand;}
	public void setCards(Card[] hand){ hand.equals(hand);}
	public void setWinnings(int winnings){ this.winnings = winnings;}
}
