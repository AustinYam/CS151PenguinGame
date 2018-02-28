
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Field extends JPanel {
	
	  public static final int DRAWING_WIDTH = 800;
	  public static final int DRAWING_HEIGHT = 600;
	  
	  public boolean up;
	  public boolean left;
	  public boolean right;
	  public boolean space;
	  
	  private static GoodFish fish;
	  private static Fighter penguin;
	  private MovingImage platform;
	  private MovingImage platform1;
	  private MovingImage platform2;
	  private MovingImage platform3;
	  private MovingImage back;
	  
	  JLabel lives = new JLabel("Test");
	  JLabel points = new JLabel("TEST");
	  
	  public int gamePoints = 0;
	  
	  JButton end;
	  JButton reset;
	  /*
	   * KeyBindings Fields
	   * Space = increase velocity
	   * Up = Jump
	   * Right = move right
	   * left = move left
	   */
	  private static final String SPACE = "space";
	  private Action space1 = new AbstractAction(SPACE){
		public void actionPerformed(ActionEvent e){
			space = true;
	    	update();
		}
	  };
	  private static final String notspace = "space1";
	  private Action space2 = new AbstractAction(notspace){
		public void actionPerformed(ActionEvent e){
			space = false;
	    	update();
		}
	  };
	  
	  private static final String JUMP = "jump";
	  private Action jump = new AbstractAction(JUMP){
		public void actionPerformed(ActionEvent e){
			penguin.jumping = true;
	    	new Thread(new thread()).start();
	    	update();
		}
	  };
	  private static final String notJUMP = "jump1";
	  private Action jump1 = new AbstractAction(notJUMP){
		public void actionPerformed(ActionEvent e){
			penguin.jumping = false;
	    	update();
		}
	  };
	  
	  private static final String LEFT = "left";
	  private Action left1 = new AbstractAction(LEFT){
		public void actionPerformed(ActionEvent e){
			left = true;
	    	update();
		}
	  };
	  private static final String notLEFT = "notleft";
	  private Action left2 = new AbstractAction(notLEFT){
		public void actionPerformed(ActionEvent e){
			left = false;
	    	update();
		}
	  };
	  
	  private static final String RIGHT = "right";
	  private Action right1 = new AbstractAction(RIGHT){
		public void actionPerformed(ActionEvent e){
			right = true;
	    	update();
		}
	  };
	  private static final String notRIGHT = "notright";
	  private Action right2 = new AbstractAction(notRIGHT){
		public void actionPerformed(ActionEvent e){
			right = false;
	    	update();
		}
	  };
	  
	  public Field() {
		  super();
		  Random x = new Random();
		   int low = 0;
		   int high = 800;
		   int randX = x.nextInt(high-low)-low;
		   Random y = new Random();
		   int lowY = 0;
		   int highY = 600;
		   int randY = y.nextInt(highY-lowY)-lowY;
		   Random x2 = new Random();
		   int randX2 = x2.nextInt(high-low)-low;
		   Random y2 = new Random();
		   int randY2 = y2.nextInt(highY-lowY)-lowY;
		  penguin = new Fighter(380,0);
		  fish = new GoodFish(100,0);
		  platform = new MovingImage("C:/Users/Austin/Desktop/Pics/ICEBLOCK.png",200,550,400,10);
		  platform1 = new MovingImage("C:/Users/Austin/Desktop/Pics/ICEBLOCK.png",380,300,30,30);
		  platform2 = new MovingImage("C:/Users/Austin/Desktop/Pics/ICEBLOCK.png",randX,randY,30,30);
		  platform3 = new MovingImage("C:/Users/Austin/Desktop/Pics/ICEBLOCK.png",randX2,randY2,30,30);
		  back  = new MovingImage("C:/Users/Austin/Desktop/Pics/iceback.jpg", 0, 0, 800, 600);
		  lives.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		  lives.setText(" LIVES: " + penguin.lives);
		  points.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		  points.setText(" POINTS: " + gamePoints);
		  points.setLocation(0, 0);
		  end = new JButton("end");
			
		  end.addActionListener(new ActionListener(){
			  @Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);		
			}	  
		  });
		  this.add(lives);
		  this.add(points);
		  this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0,false), JUMP);
		  this.getActionMap().put(JUMP, jump);
		  this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0,true), notJUMP);
		  this.getActionMap().put(notJUMP, jump1);
		  this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0,false), RIGHT);
		  this.getActionMap().put(RIGHT, right1);
		  this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0,true), notRIGHT);
		  this.getActionMap().put(notRIGHT, right2);
		  this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0,false), LEFT);
		  this.getActionMap().put(LEFT, left1);
		  this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0,true), notLEFT);
		  this.getActionMap().put(notLEFT, left2);
		  this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,0,false), SPACE);
		  this.getActionMap().put(SPACE, space1);
		  this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE,0,true), notspace);
		  this.getActionMap().put(notspace, space2);
	
	  }
	  /*
	   * add points
	   */
	  public void gainPoint(){
	    	gamePoints += 1;
	    }
	  

	  public void paintComponent(Graphics g)
	  {
	    super.paintComponent(g);  // Call JPanel's paintComponent method to paint the background

	    int width = getWidth();
	    int height = getHeight();

	    double ratioX = (double)width/DRAWING_WIDTH;
	    double ratioY = (double)height/DRAWING_HEIGHT;

	    ((Graphics2D)g).scale(ratioX,ratioY);
	    
	    back.draw(g,this);
	    platform.draw(g,this);
	    platform1.draw(g,this);
	    platform2.draw(g,this);
	    platform3.draw(g, this);
	    penguin.draw(g,this);
	    fish.draw(g,this);

	  }
	  
	  /*
	   * This updates the game
	   * contains states for the keybindings to work with and manipulate the penguin
	   * used to update and stop the game if the number of lives reaches 0
	   * creates the ScoreScreen frame to display the final amount of points earned 
	   * adds the end button to the top of the frame
	   */
	  private void update() {
		
		    if(left) penguin.walk(-1);
		    else penguin.walk(0);
		    if(right) penguin.walk(1);
		    if(space) penguin.setVelocityX(6);
		    if(!space) penguin.setVelocityX(3);
		    lives.setText(" LIVES: " + penguin.lives);
		    points.setText(" POINTS: " + gamePoints);
		    if(penguin.lives <= 0){
		    	this.add(end);
		    	new ScoreScreen(""+gamePoints);
		    	penguin.setVisiblity(false);
		    }	
		  
		}

	  /*
	   * starts the game
	   */
	  public void run() {
	  	while(true) {
	  		// MAKE A CHANGE
			int xpenguinFeet = penguin.getX() + penguin.getWidth()/2;
	        int ypenguinFeet = penguin.getY() + penguin.getHeight()-5;
	        
	        int xFishFeet = fish.getX() + fish.getWidth()/2;
	        int yFishFeet = fish.getY() + fish.getHeight()-5;
	          
	          if (platform.isPointInImage(xpenguinFeet,ypenguinFeet))
	          {
	               penguin.setFalling(false);
	          }
	          else if (platform1.isPointInImage(xpenguinFeet,ypenguinFeet))
	          {
	               penguin.setFalling(false);
	               fish.jumping = true;
	               platform1.setX(-100);
	          }
	          else if (platform2.isPointInImage(xpenguinFeet,ypenguinFeet))
	          {
	        	  penguin.setFalling(false);
	               fish.jumping = true;
	               platform2.setX(-100);
	          }
	          else if (platform3.isPointInImage(xpenguinFeet,ypenguinFeet))
	          {
	        	  penguin.setFalling(false);
	               fish.jumping = true;
	               platform3.setX(-100);
	          }
	          else
	          {
	               penguin.setFalling(true);
	               fish.setFalling(true);
	               
	          }

	          penguin.act();
	          fish.act();
	          checkPenguin();
	          checkFish();

	  		// SHOW THE CHANGE
			repaint();

	  		// WAIT
	  		try{
	                Thread.sleep(10);
	           } catch (InterruptedException e) {}

	  	}
	  }
	  /*
	   * check() methods for penguin and fish
	   * used to check and update the position of the objects
	   * if the specified condition is met, then execute the action
	   * Penguin will be reinitialized at the top of the frame if it falls out of bounds 
	   * Fish will disappear and will be reinitialized at a random point at the top of the frame
	   * if it has hit the penguin or fallen out of bounds 
	   */

	  public void checkPenguin() {
	  	int x = penguin.getX() + penguin.getWidth()/2;
	  	int y = penguin.getY() + penguin.getHeight()/2;
	  	if (x < 0 || x > DRAWING_WIDTH || y < 0 || y > DRAWING_HEIGHT && penguin.lives > 0){
	  	//where fighter spawns after a complete fall
	  		
	  		penguin = new Fighter(380,0);
	  		this.add(lives);
	  	}
	  		
	  }
	  public void checkFish() {
		  int xFishFeet = fish.getX() + fish.getWidth()/2;
	        int yFishFeet = fish.getY() + fish.getHeight()-5;
		  	int x = fish.getX() + fish.getWidth()/2;
		  	int y = fish.getY() + fish.getHeight()/2;
		  	if (x < 0 || x > DRAWING_WIDTH || y < 0 || y > DRAWING_HEIGHT && penguin.lives > 0){
		  	//where fish spawns after a complete fall
		  		fish = GoodFish.randGoodFish();
		  		penguin.loseLife();
		  		this.add(lives);
		  		update();
		  	}
		  	else if(penguin.isPointInImage(xFishFeet,yFishFeet)){
		  		
		  		fish = GoodFish.randGoodFish();
		  		gainPoint();
		  		if(gamePoints <= 20){
		  			fish.setMod(5);
		  		}else if(gamePoints <= 40){
		  			fish.setMod(2);
		  		}
		  		
		  		this.add(points);
		  		update();
		  	
		    }
		  		
		  }
	  
	  public class thread implements Runnable{

		@Override
		public void run() {
			try{
				
				Thread.sleep(penguin.jumpTimer);
			}catch(Exception e){
				e.printStackTrace();
				new Thread(this).start();
				System.exit(0);
			}
		}
		  
	  }
	  
	
	  
	  
	}


