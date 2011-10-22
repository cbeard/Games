
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class RankList extends JApplet implements  Runnable {

	private Thread t; 
	private Dimension size = new Dimension(400,800);
	private Font font1;
	private Font font2;
	

		
	int counter=0;
	
	String winvalue="50";
	String jackpotvalue="0";
	String wager = "0";
	
	
	public void init(){
		
		setSize(size);		
	
		setName("Poker");
	 
	
		
		

     	 t = new Thread(this);
		 t.start();
		
		 font1 = new Font("Helvetica", Font.BOLD, 40);
		 font2 = new Font("Helvetica", Font.ITALIC, 20);
		 


		
	}
	



	public void run(){		
	
	        

      while(true){
    	    
			
			
		try{ t.sleep(40); }
		catch(Exception e){} //do nothing
		
		 setSize(size);
		 repaint();
	
         
      }
		
		
		

		
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.BLACK);
		g.fillRect(600,20 ,getWidth(),getHeight());
		g.setColor(Color.RED);
		g.setFont(font1);
		g.drawString("SCORE!!!!!!!!", 600, 50);
		
	  	

	   for(int i=0;i<TopTen.topTen.length;i++){
			  g.drawString(""+TopTen.topTen[i].winnings+"", 600, 100+(60*i));
	   }
		
	}
	
}
