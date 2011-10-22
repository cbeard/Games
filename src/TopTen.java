
public class TopTen {
    public static Player topTen[] = new Player[10];
    private static  String list ="";
    
   public TopTen(){
	   System.out.print("going..");
	   Card cards[]= {new Card(14,'S'),new Card(14,'S'),new Card(14,'S'),new Card(14,'S'),new Card(14,'S')};
	   Hand demo = new Hand(cards);
	 for(int i=0;i<topTen.length;i++){
    	topTen[i]= new Player(demo,0);
    }  
   }
   
    
   public void setScore(Player p){
	   Player temp[] = new Player[topTen.length+1]; 
	   temp[0] = p;
	   for(int i=1,j=0;i<temp.length;i++,j++){
		  temp[i]=topTen[j];	        
	   }    
	  	 
 

	   for(int i=0;i<temp.length;i++){
		
		  
	     if(temp[i].getWinnings()>temp[i].getWinnings()){
	    	 Player holder = temp[i];
	    	   temp[i] = temp[i];
	    	     temp[i] = holder;
              
	     }
	   }
	   
	   for(int i=0;i<topTen.length;i++){
		   topTen[i]= temp[i];	
	  	  System.out.println(""+topTen[i].winnings);
  	  }
	   
	   
   }
   

}
