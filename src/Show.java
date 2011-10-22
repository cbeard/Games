
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class Show extends JApplet implements  Runnable ,MouseListener{

	private Thread t; 
	private Dimension size = new Dimension(600,400);
	private Font font1;
	private Font font2;
	
	private  Image img;
	
	Player player1;
	Hand playHand1;
	Hand playHand2;
	Hand playHand3;
	Hand playHand4;
	
	Dealer dealer;
	
	JButton newHand;
	JButton draw;
	JButton button[];
	
	boolean isdraw = false;
	boolean go = false;
	
	int counter=0;
	
	String winvalue="50";
	String jackpotvalue="0";
	
	
	public void init(){
		
		setSize(size);		
		addMouseListener(this);		
		setName("Poker");
		setLayout(new FlowLayout(3));

		
		Image image = Toolkit.getDefaultToolkit().getImage("images/log.gif");

		
		
		 t = new Thread(this);
		 t.start();
		
		 font1 = new Font("Helvetica", Font.BOLD, 40);
		 font2 = new Font("Helvetica", Font.ITALIC, 20);
		 
		 buttons();

		
	}
	
	public void buttons(){
		JMenuBar menu = new JMenuBar();
        menu.add(new JButton("file"));
		
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
		
		setJMenuBar(menu);
	}


	public void run(){
		
	
		
		
		dealer = new Dealer();
		
		
		//for(int i = 0; i<dealer.getDeck().length;i++){System.out.println(dealer.cardToString(i));}
		//dealer.shuffle();
		//System.out.println("-------------------------  \n");
		//for(int i = 0; i<dealer.getDeck().length;i++){System.out.println(dealer.cardToString(i));}
		//Hand playHand =new Hand(dealer.dealHand(5));
        //playHand.printHand();
		//System.out.println("-------------------------  \n");
		//for(int i = 0; i<dealer.getDeck().length;i++){System.out.println(dealer.cardToString(i));}
		//dealer.getNewDeck();
		//System.out.println("-------------------------  \n");
		//	for(int i = 0; i<dealer.getDeck().length;i++){System.out.println(dealer.cardToString(i)); }
				 
		dealer.shuffle();
		
		System.out.println("-------------------------  \n");
		
			System.out.println(dealer.deckListToString());
			
		//Card[] testHand = { new Card(3,'c'),new Card(3,'s'),new Card(3,'c'),new Card(8,'h'),new Card(3,'c')};
	    //Hand hand = new Hand(testHand);
		//hand.printInfo();
			
		//System.out.println("\n-------------------------  \n");
        playHand1 =new Hand(dealer.dealHand(5));
        //playHand1.printInfo();
        System.out.println("\n-------------------------  \n");
	    playHand2 =new Hand(dealer.dealHand(5));
	    //playHand2.printInfo();
	    //System.out.println("\n-------------------------  \n");
	    playHand3 =new Hand(dealer.dealHand(5));
	    //playHand3.printInfo();
	    //System.out.println("\n-------------------------  \n");
	    playHand4 =new Hand(dealer.dealHand(5));
	    //playHand4.printInfo();
	    //System.out.println("\n-------------------------  \n");
  
		System.out.println(dealer.deckListToString());
       player1 = new Player(playHand1, 10000000);
      while(true){
    	    
			if(counter>=2){ draw.show(false);  }
			else{ draw.show(true);}
			
		try{ t.sleep(40); }
		catch(Exception e){} //do nothing
		
		 setSize(size);
		 repaint();
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
		  
		   
		   if(!isdraw){
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

	 

			drawhand(g, player1.getHand(), cardwidth, cardheight, 10, 300);

			drawhand(g, playHand2, cardwidth, cardheight, 200, 300);

			drawhand(g, playHand3, cardwidth, cardheight, 400, 300);
			
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
		
		if(arg0.getSource()== newHand){
			    counter=0;
				dealer.getNewDeck();
				dealer.shuffle();
				player1.setHand(new Hand(dealer.dealHand(5)));				
				playHand2 =new Hand(dealer.dealHand(5));				
				playHand3 =new Hand(dealer.dealHand(5));				
				playHand4 =new Hand(dealer.dealHand(5));				
				this.paint(g);
				g.clearRect(0, 0, getWidth(), getHeight());
		}
		if(arg0.getSource()== draw){
			
			if(counter == 0){
			  player1.setHand(dealer.drawOption(player1.getHand()));				
			  playHand2 = dealer.drawOption(playHand2);				
			  playHand3 = dealer.drawOption(playHand3);
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


	public void mouseReleased(MouseEvent arg0) {
		

		if(arg0.getSource()== draw){
			//isdraw = true;
	
			
		}
		

	}
	
	
	
}
