

import java.awt.*;
import java.awt.geom.*;

public class Fighter extends MovingImage implements Character{
	
    // FIELDS
	 // -1 is left , 1 is right , 0 is not walking
    private int walkingDir;
    private boolean falling;
    protected int jumpTimer;
    protected int fallTimer;
    private int velocityX = 3;
    

    protected int gravity;
    protected boolean jumping = false;
    protected int dy = -10;
    protected int maxY;
    protected int midY;
    protected static int lives = 5;
    protected int jumpS;
    
    // CONSTRUCTOR
    public Fighter(int x, int y) {
         super("C:/Users/Austin/Desktop/Pics/Penguin1.png",x,y,50,50);
         walkingDir = 0;
         falling = true;
         jumpTimer = 200;
         fallTimer = 200;
         maxY = 0;
         midY = 400;
         jumpS = 5;    
    }

    // METHODS

    public void walk(int dir)
    {
         walkingDir = dir;
    }

    public void jump()
    {
		if(!falling)
		{
			jumpTimer = 10;
		}
    }

    public void setFalling(boolean falling)
    {
         this.falling = falling;
    }
    
   
    
    public void loseLife(){
    	this.lives -= 1;
    }
    
    
    public void resetLife(){
    	this.lives = 5;
    }

    public void act()
    {
    	if(jumping){
    		y -= 10;
    	}
    	if(y < maxY){
    		jumping = false;
    		falling = true;
    		y += 10;
    	}
         //MOVE 
         if(falling)
         {
              moveByAmount(0,5);
         }
         moveByAmount(walkingDir*velocityX,0);// 3 is the walking speed
    }
    
    public void setVelocityX(int v){
    	this.velocityX = v;
    }

}
