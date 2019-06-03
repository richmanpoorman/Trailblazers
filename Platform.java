import java.awt.Color;
import java.awt.Graphics;

public class Platform {
	int x, y, width, height;
	
	boolean[] isPaintX;
	

	
	
	public Platform(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		//Makes height/width into units of 10
		this.width = width * 10;
		this.height = height * 10;
		//Split the platform into 10 pixel zones
		this.isPaintX = new boolean[(int)Math.ceil((double)(this.width / 10))];


	}
	
	
	
	
	
	// check collision
	public Boolean collision(Player p) {// if the right edge of the player is greater than the left edge of the platform and if the left edge of the player is less than the right edge of the platform and of the lower height of the cube is greater than the upper height of the platform and if the upper height of the cuber is less than the lower height 
		if(p.x + p.moveX + p.width > x && p.x + p.moveX < x + width && p.y + p.moveY + p.height > y && p.y + p.moveY < y + height) {
			if(p.y + p.height <= y) {
				p.onGround = true;
				p.moveY = 0;
				p.velocity = 0;
				

				//if the left edge of the player is less than the far end of the platform
				if(p.x + p.moveX + p.width < x + width) {

					//for each square the player is on the floor, paint it orange					
					for (int a = 1; a < 4; a ++) {
						if ((int)Math.floor((double)(p.x + p.moveX + p.width - x) / 10) - a >= 0) {
							this.isPaintX[(int)Math.floor((double)(p.x + p.moveX + p.width - x) / 10) - a] = true;
						}
					}
					
					
				}
				else {// else if it goes over the edge, paint the final block
					
					this.isPaintX[(int)Math.ceil((double)(this.width / 10)) - 1] = true;
					
				}


				
				
				
				
				
			} else {
				p.moveX = 0;
			}
			return true;
		}
		return false;
	}
	public void render(Graphics g) {
		
		g.setColor(Color.black);
		//g.fillRect(x, y, width, height); // comment out to get rid of platforms
		
		g.setColor(Color.orange);
		
		for(int a = 0; a < isPaintX.length; a++) {
			if(isPaintX[a]) {
				g.fillRect(x + (a*10 ), y, 10, 10);
			}
		}


		
	}
}
