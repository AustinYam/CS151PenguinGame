
import java.util.Random;

import javax.swing.ImageIcon;

public class GoodFish extends MovingImage implements Character{
	
	 // FIELDS
    private int walkingDir; 
    private boolean falling;
    protected int jumpTimer;
    protected int fallTimer;
    private int velocityY = 3;
    private int velocityX = 3;
    private static int redY = 0;
    protected static int mod = 10;
    
    protected int gravity;
    protected boolean jumping = false;
    protected int dy = -10;
    protected int maxY;
    protected int midY;
    protected static int lives = 5;
    protected int jumpS;
	
	public GoodFish(int x, int y){
		super("C:/Users/Austin/Desktop/Pics/GoodFish.png",x, y, 50, 50);
		walkingDir = 0;
        falling = true;
        jumpTimer = 200;
        fallTimer = 200;
        maxY = 0;
        midY = 400;
        jumpS = 5;   
 	
	}
	public GoodFish(int x, double a){
		super("C:/Users/Austin/Desktop/Pics/RedFish.png",x, redY, 50, 50);
		walkingDir = 0;
        falling = true;
        jumpTimer = 200;
        fallTimer = 200;
        maxY = 0;
        midY = 400;
        jumpS = 5;   
        this.velocityY = (int)a;
        	
	}
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
	    
	    public static GoodFish randGoodFish(){
			   Random x = new Random();
			   int low = 20;
			   int high = 780;
			   int randX = x.nextInt(high-low)-low;
			   Random r = new Random();
			   int min = 0;
			   int max = 100;
			   int rare = r.nextInt(max-min)-min;
			   
			   if(rare%mod == 0){
				 
				   return new GoodFish(randX,5.0);
			   }else{
				
			   return new GoodFish(randX,0);
			   }
		   }
	    

	    public void act()
	    {
	    	if(jumping){
	    		y -= 3;
	    	}
	    	if(y < maxY){
	    		jumping = false;
	    		falling = true;
	    		y += 10;
	    	}
	         //MOVE 
	         if(falling)
	         {
	              moveByAmount(0,velocityY);
	         }
	         moveByAmount(walkingDir*velocityX,0);// 3 is the walking speed
	    }
	    
	    public void setVelocityX(int v){
	    	this.velocityX = v;
	    }
	    
	    public int getVelocityY(){
	    	return velocityY;
	    }
	    
	    public void increaseVelocityY(){
	    	velocityY += 1;
	    }
	    
	    public void setMod(int a){
	    	this.mod = a;
	    }


}
