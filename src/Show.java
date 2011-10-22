
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class Show extends JApplet implements  Runnable ,MouseListener, KeyListener{

	private Thread t; 
	private Dimension size = new Dimension(900,400);
	private Font font1;
	private Font font2;
	
	private  Image img;
	
	Dealer dealer;
	Player player1;
	Player player2;
	Player player3;
	


	Hand playHand4;
	
	public TopTen score;
	
	
	
	
	
	JMenuBar menu = new JMenuBar();
	JButton savescore;
	JButton newHand;
	JButton draw;
	JButton button[];
	JTextArea bet;
	
	boolean isdraw = false;
	boolean go = false;
	
	int counter=0;
	
	String winvalue="50";
	String jackpotvalue="0";
	String wager = "0";
	
	
	public void init(){
		
		setSize(size);		
		addMouseListener(this);		
		addKeyListener(this);
		setName("Poker");
	 
	
		score = new TopTen();
		
		

     
		dealer = new Dealer();				 
		dealer.shuffle();
	 	
        player1 = new Player(new Hand(dealer.dealHand(5)), 10000000);
        player2 = new Player(new Hand(dealer.dealHand(5)), 10000000);
        player3 = new Player(new Hand(dealer.dealHand(5)), 10000000);
		playHand4= new Hand(dealer.dealHand(5));
		 t = new Thread(this);
		 t.start();
		
		 font1 = new Font("Helvetica", Font.BOLD, 40);
		 font2 = new Font("Helvetica", Font.ITALIC, 20);
		 
		 buttons();

		
	}
	
	public void buttons(){
		
		savescore = new JButton("SaveScore");
		savescore.addMouseListener(this);
        menu.add(savescore);
		
        newHand = new JButton("New Hand"); 
		newHand.setSize(40, 20);
		newHand.addMouseListener(this);
		menu.add(newHand);
		
	    draw = new JButton("draw"); 
		draw.setSize(40, 20);
		draw.addMouseListener(this);
		menu.add(draw);
		
		button = new JButton[5];
		for(int i=0;i<button.length;i++){
		    button[i]= new JButton(); 
		    button[i].addMouseListener(this);
		    button[i].setSelected(false);

		}
		
		menu.add(new JLabel("WINNINGS :"));
		
		JTextArea winnings = new JTextArea(winvalue);
		winnings.setFont(font2);
		winnings.setEditable(false);
		menu.add(winnings);
		
		menu.add(new JLabel("JACKPOT :"));
		
		JTextArea jackpot = new JTextArea(jackpotvalue);
		jackpot.setFont(font2);
		jackpot.setEditable(false);
		menu.add(jackpot);
		
		menu.add(new JLabel("BET :"));
		
	    bet = new JTextArea(wager);
		bet.setEditable(false);
		bet.addKeyListener(this);
		bet.setFont(font2);
		menu.add(bet);
		
		
		setJMenuBar(menu);	
		
	
	}


	public void run(){		
	
	        
		 System.out.println(TopTen.topTen[0].winnings);

      while(true){
    	    
			if(counter>=2){ draw.show(false);  }
			
			
		try{ t.sleep(40); }
		catch(Exception e){} //do nothing
		
		 setSize(size);
		 repaint();
		 menu.repaint();
		 requestFocus();
         
      }
		
		
		

		
	}
	
	public void paint(Graphics g){ 
		
		Hand handname = playHand4;
		int cardwidth = 64;
		int cardheight = 80;
		int startposX  = 100;
	    int startposY  = 100;
	    
		for(int i=0;i<5;i++){
			
		   startposX  = 100;
	       startposY  = 100;
		   
		   if(handname.getFaceValue(i)==11){g.drawString("J"+handname.getSuitType(i), startposX+(cardwidth*i), startposY );} else
		   if(handname.getFaceValue(i)==12){g.drawString("Q"+handname.getSuitType(i), startposX+(cardwidth*i), startposY );} else
		   if(handname.getFaceValue(i)==13){g.drawString("K"+handname.getSuitType(i), startposX+(cardwidth*i), startposY );} else
		   if(handname.getFaceValue(i)==14){g.drawString("A"+handname.getSuitType(i), startposX+(cardwidth*i), startposY );}
		   else{ g.drawString(handname.cardToString(i), startposX+(cardwidth*i), startposY);}
		  
		  
		   if(!isdraw||!draw.isShowing()){
			   img =  getImage(getCodeBase(), "../images/"+handname.cardToStringReverse(i)+".gif");
			   g.drawImage(img, startposX+(cardwidth*i), startposY , cardwidth,cardheight, this); 
			   for(int j =0; j<button.length;j++){
		          button[j].show(false);
		       }
		   }
		   else{
			   
			   
			   ImageIcon icon = new ImageIcon("../images/"+handname.cardToStringReverse(i)+".gif"); 
			    button[i].setSize(cardwidth, cardheight);			    
			    if(button[i].isSelected()){ startposY = 40;}
				
				if(!button[i].isSelected()){button[i].setIcon(icon);}
				button[i].setLocation(startposX+(cardwidth*i), startposY-20);
				button[i].show(true);
				add(button[i]);     
			   
			   
		   }
		  
		}
		
		 g.drawString(handname.toStringHand(),startposX ,startposY+cardheight+20);
		 
		   cardwidth = 32;
		   cardheight= 40;

	 

			drawhand(g, player1, cardwidth, cardheight, 10, 300);

			drawhand(g, player2, cardwidth, cardheight, 200, 300);

			drawhand(g, player3, cardwidth, cardheight, 400, 300);
			
			
			g.setColor(Color.BLACK);
			g.fillRect(600,20 ,getWidth(),getHeight());
			g.setColor(Color.RED);
			g.setFont(font1);
			g.drawString("SCORE!!!!!!!!", 600, 50);
			
		  	

		   for(int i=0;i<TopTen.topTen.length;i++){
				  g.drawString(""+TopTen.topTen[i].winnings+"", 600, 100+(60*i));
		  	   }
			
	}
	private void drawhand(Graphics g,Player player,int cardwidth,int cardheight,int startposX,int startposY){
		Hand handname = player.getHand();
		for(int i=0;i<handname.getHandLength();i++){
			
			   img =  getImage(getCodeBase(), "../images/"+handname.cardToStringReverse(i)+".gif");
			   
			   if(handname.getFaceValue(i)==11){g.drawString("J"+handname.getSuitType(i), startposX+(cardwidth*i), startposY);} else
			   if(handname.getFaceValue(i)==12){g.drawString("Q"+handname.getSuitType(i), startposX+(cardwidth*i), startposY);} else
			   if(handname.getFaceValue(i)==13){g.drawString("K"+handname.getSuitType(i), startposX+(cardwidth*i), startposY);} else
			   if(handname.getFaceValue(i)==14){g.drawString("A"+handname.getSuitType(i), startposX+(cardwidth*i), startposY);}
			   else{ g.drawString(handname.cardToString(i), startposX+(cardwidth*i), startposY);}
			  
			  
			     g.drawImage(img, startposX+(cardwidth*i), startposY, cardwidth,cardheight, this);
			 
			}
			
			 g.drawString(handname.toStringHand(),startposX , startposY+cardheight+20);
		
	}
	
	private void drawhand(Graphics g,Hand handname,int cardwidth,int cardheight,int startposX,int startposY){
		
		for(int i=0;i<handname.getHandLength();i++){
			
			   img =  getImage(getCodeBase(), "../images/"+handname.cardToStringReverse(i)+".gif");
			   
			   if(handname.getFaceValue(i)==11){g.drawString("J"+handname.getSuitType(i), startposX+(cardwidth*i), startposY);} else
			   if(handname.getFaceValue(i)==12){g.drawString("Q"+handname.getSuitType(i), startposX+(cardwidth*i), startposY);} else
			   if(handname.getFaceValue(i)==13){g.drawString("K"+handname.getSuitType(i), startposX+(cardwidth*i), startposY);} else
			   if(handname.getFaceValue(i)==14){g.drawString("A"+handname.getSuitType(i), startposX+(cardwidth*i), startposY);}
			   else{ g.drawString(handname.cardToString(i), startposX+(cardwidth*i), startposY);}
			  
			  
			     g.drawImage(img, startposX+(cardwidth*i), startposY, cardwidth,cardheight, this);
			 
			}
			
			 g.drawString(handname.toStringHand(),startposX , startposY+cardheight+20);
		
	}


	public void mouseClicked(MouseEvent arg0) {
		Graphics g = this.getGraphics();
		if (arg0.getSource()== savescore){
			score.setScore(player1);
			
		}
		if(arg0.getSource()== newHand){
			    isdraw = false;
			    counter=0;
			    wager="0";
			    bet.setText(wager);
			    draw.show(true);
				dealer.getNewDeck();
				dealer.shuffle();
				player1.setHand(new Hand(dealer.dealHand(5)));				
				player2.setHand(new Hand(dealer.dealHand(5)));
				player3.setHand(new Hand(dealer.dealHand(5)));
				playHand4 =new Hand(dealer.dealHand(5));				
				this.paint(g);
				g.clearRect(0, 0, getWidth(), getHeight());
		}
		if(arg0.getSource()== draw){
			
			if(counter == 0){
			  player1.setHand(dealer.drawOption(player1.getHand()));				
			  player2.setHand(dealer.drawOption(player2.getHand()));				
			  player3.setHand(dealer.drawOption(player3.getHand()));				
			}
			for(int i=0;i<button.length;i++){
				  if(button[i].isSelected()){
					playHand4 =new Hand(dealer.draw(playHand4.getHand(), i));
					button[i].setSelected(false);
				  }
			}
							
		
			this.paint(g);
			g.clearRect(0, 0, getWidth(), getHeight());
			counter++;
	    }
		
		
			for(int i=0;i<button.length;i++){
			  if(arg0.getSource()== button[i]){
				  go = !go;
				  button[i].setSelected(go);
			  }
			  
			}
	
		
	}


	public void mouseEntered(MouseEvent arg0) {
		
	}


	public void mouseExited(MouseEvent arg0) {
		
	}


	public void mousePressed(MouseEvent arg0) {
		Graphics g = this.getGraphics();

		if(arg0.getSource()== draw){
			isdraw = !isdraw;
			g.setColor(Color.RED);
			g.drawRect(95, 95, 350, 100);
			
		}
	}


	public void mouseReleased(MouseEvent arg0) {}//do nothing

	
	public void keyPressed(KeyEvent arg0) {
		
		if(arg0.getKeyChar()== '0'){ wager+=0;}

		if(arg0.getKeyChar()== '1'){ if(wager=="0"){wager = "1";}else{wager+=1;}}
		if(arg0.getKeyChar()== '2'){ if(wager=="0"){wager = "2";}else{wager+=2;}}
		if(arg0.getKeyChar()== '3'){ if(wager=="0"){wager = "3";}else{wager+=3;}}
		if(arg0.getKeyChar()== '4'){ if(wager=="0"){wager = "4";}else{wager+=4;}}
		if(arg0.getKeyChar()== '5'){ if(wager=="0"){wager = "5";}else{wager+=5;}}
		if(arg0.getKeyChar()== '6'){ if(wager=="0"){wager = "6";}else{wager+=6;}}
		if(arg0.getKeyChar()== '7'){ if(wager=="0"){wager = "7";}else{wager+=7;}}
		if(arg0.getKeyChar()== '8'){ if(wager=="0"){wager = "8";}else{wager+=8;}}
		if(arg0.getKeyChar()== '9'){ if(wager=="0"){wager = "9";}else{wager+=9;}}

		bet.setText(wager);
	}

	public void keyReleased(KeyEvent arg0) {}//do nothing


	public void keyTyped(KeyEvent arg0) {}//do nothing
	
	
	
}
