
public class Hand {
	
	public final static int HIGHCARD      = 0;
	public final static int ONEPAIR       = 1;
	public final static int TWOPAIR       = 2;
	public final static int THREEOFAKIND  = 3;
	public final static int STRAIGHT      = 4;
	public final static int FLUSH         = 5;
	public final static int FULLHOUSE     = 6;
	public final static int FOUROFAKIND   = 7;
	public final static int STRAIGHTFLUSH = 8;
	public final static int FIVEOFAKIND   = 9;
	
	private int rank;
	private Card[] hand;
	
	public Hand(Card[] cards){
      
		cards = sort(cards);
		
		hand = cards;

		readHand(cards);		
		
	}
		

	
	private Card[] sort(Card[] cards){
		
		for(int i =0; i < cards.length;i++){ 
			for(int j =0; j < cards.length;j++){ 
				if(cards[i].getFaceValue()< cards[j].getFaceValue()){ 
			        
				           Card holder = cards[j];
				              cards[j] = cards[i];
				              cards[i] = holder; 
				              
			    }
			}
		}
		
	
			
		return cards;
	}
	
	private void readHand(Card[] cards){
		

		if(isFIVEOFAKIND(cards)){
			rank =FIVEOFAKIND;
		}else
		if(isSTRAIGHTFLUSH(cards)){
			rank =STRAIGHTFLUSH;
		}else
		if(isFOUROFAKIND(cards)){
			rank =FOUROFAKIND;
		}else
		if(isFULLHOUSE(cards)){
			rank =FULLHOUSE;
		}else
		if(isFLUSH(cards)){
			rank =FLUSH;
		}else
		if(isSTRAIGHT(cards)){
			rank =STRAIGHT;
		}else
		if(isTHREEOFAKIND(cards)){
			rank =THREEOFAKIND;
		}else
		if(isTWOPAIR(cards)){
			rank =TWOPAIR;
		}else
		if(isONEPAIR(cards)){
			rank =ONEPAIR; 
		}
		else{
			rank = HIGHCARD ;
		}
			
		
	}
	
	private boolean isFIVEOFAKIND(Card[] cards){
		
		int counter =0;
		for(int i =0; i<cards.length ;i++){
			
		      if(cards[0].getFaceValue()==cards[i].getFaceValue()){counter++;}
		      else{return false;}
		}
		
		return counter == 5;
	}
	
	private boolean isSTRAIGHTFLUSH(Card[] cards){
		
		int counter =0;
	
		
		for(int i =cards.length-1; 0<i ;i--){	
						
		      if(cards[i].getSuitType()==(cards[i-1].getSuitType())&&
		    		  cards[i].getFaceValue()==(cards[i-1].getFaceValue()+1)){counter++;}		    
		      else{ return false;}
		      
		}
		
		return counter == 4;
	}
	
	private boolean isFOUROFAKIND(Card[] cards){
		
		int counter =0;
		for(int i =cards.length-1; 0<=i ;i--){
			for(int j =cards.length-1; 0<=j ;j--){
    	      if(cards[i].getFaceValue()==cards[j].getFaceValue()){counter++;}
		      if(counter == 17){ return true;}
			}  
		}
		
		return counter == 17;
	}
	
	private boolean isFULLHOUSE(Card[] cards){
		
     return(cards[0].getFaceValue()==cards[1].getFaceValue()&&
    		cards[1].getFaceValue()==cards[2].getFaceValue()&&
    		cards[3].getFaceValue()==cards[4].getFaceValue())||
    	   (cards[0].getFaceValue()==cards[1].getFaceValue()&&
    	    cards[2].getFaceValue()==cards[3].getFaceValue()&&
    	    cards[3].getFaceValue()==cards[4].getFaceValue());		
	}
	
	private boolean isFLUSH(Card[] cards){
		
		int counter =0;
			
		char same = cards[0].getSuitType();
		for(int i =0; i<cards.length ;i++){						
		      if(cards[i].getSuitType()==same){counter++;}		    
		      else{ return false;}
		     
		}
		
		return counter == 5;
	}
	
	private boolean isSTRAIGHT(Card[] cards){
		
		int counter =0;
				
		for(int i =cards.length-1; 0<i ;i--){						
		      if(cards[i].getFaceValue()==(cards[i-1].getFaceValue()+1)){counter++;}		    
		      else{ return false;}
		      
		}
		
		return counter == 4;
	}
	
	private boolean isTHREEOFAKIND(Card[] cards){
		
		int counter =0;
		for(int i =cards.length-1; 0<=i ;i--){
			for(int j =cards.length-1; 0<=j ;j--){
    	      if(cards[i].getFaceValue()==cards[j].getFaceValue()){counter++; }
		      
			}  
		}
		
		return counter == 11;
	}

	private boolean isTWOPAIR(Card[] cards){
		
		int counter =0;
		for(int i =cards.length-1; 0<=i ;i--){
			for(int j =cards.length-1; 0<=j ;j--){
    	      if(cards[i].getFaceValue()==cards[j].getFaceValue()){counter++;}
		      
			}  
		}
		
		return counter == 9;
	}
	
	private boolean isONEPAIR(Card[] cards){
		
		int counter =0;
		for(int i =cards.length-1; 0<=i ;i--){
			for(int j =cards.length-1; 0<=j ;j--){
    	      if(cards[i].getFaceValue()==cards[j].getFaceValue()){counter++; }
		      
			}  
		}
		
		return counter == 7;
	}
	
	public int getRank(){
		return rank;
	}
	
	public void printHand(){
		
		if(rank ==FIVEOFAKIND)   { System.out.println("Five of a Kind");}
		if(rank ==STRAIGHTFLUSH) { System.out.println("StraightFlush");}
		if(rank ==FOUROFAKIND)   { System.out.println("Four of a Kind");}
		if(rank ==FULLHOUSE)     { System.out.println("FullHouse");}		
		if(rank ==FLUSH)         { System.out.println("Flush");}
		if(rank ==STRAIGHT)      { System.out.println("Straight");}
		if(rank ==THREEOFAKIND)  { System.out.println("Three of a Kind");}
		if(rank ==TWOPAIR)       { System.out.println("Two Pair");}
		if(rank ==ONEPAIR)       { System.out.println("One Pair");}
		if(rank ==HIGHCARD)      { System.out.println("High Card");}	 
				
	}
	
	public String toStringHand(){
		
		if(rank ==FIVEOFAKIND)   { return "Five of a Kind"; }
		if(rank ==STRAIGHTFLUSH) { return "StraightFlush";  }
		if(rank ==FOUROFAKIND)   { return "Four of a Kind"; }
		if(rank ==FULLHOUSE)     { return "FullHouse";      }		
		if(rank ==FLUSH)         { return "Flush";          }
		if(rank ==STRAIGHT)      { return "Straight";       }
		if(rank ==THREEOFAKIND)  { return "Three of a Kind";}
		if(rank ==TWOPAIR)       { return "Two Pair";       }
		if(rank ==ONEPAIR)       { return "One Pair";       }
		if(rank ==HIGHCARD)      { return "High Card";      }	 
		
		return "none";
	}
	
	public void printInfo(){
		
		for(int i =0; i < hand.length;i++){
			
			System.out.print(cardToString(i)+",");
		}	

		printHand();
	}
	
	public Card[] getHand(){
		return hand;
	}
	
	public int getHandLength(){
		return hand.length;
	}
	
	public String cardToString(int spot){
		return ""+hand[spot].getFaceValue()+hand[spot].getSuitType();
	}
	
	public String cardToStringReverse(int spot){
		return ""+hand[spot].getSuitType()+hand[spot].getFaceValue();
	}
	
	public int getFaceValue(int spot){
		return hand[spot].getFaceValue();
	}
	
	public String getSuitType(int spot){
		return ""+hand[spot].getSuitType();
	}
	
	public void equals(Card[] otherhand){
		for(int i=0;i<otherhand.length;i++){
		  hand[i] = otherhand[i];
		}
		
	}

	
}//end of Hand
