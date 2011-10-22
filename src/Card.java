
public class Card {
	
	private int  faceValue;
	private char suitType;

	public Card(int cardValue, char suit){
		faceValue = cardValue;
		suitType  = Character.toUpperCase(suit);
		
	}
	
	public int getFaceValue(){
		return faceValue;
	}
	
	public char getSuitType(){
		return suitType;
	}

}//end of Card
