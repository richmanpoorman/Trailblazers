import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;


public class Player {
	double x, y;
	int width, height;
	double moveX, moveY;
	boolean onGround = true;
	float velocity = 0;
	public Player(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	public void keyEvents(Set<Integer> pressed) {
		moveY = 0;
		moveX *= 0.9;
		for(Integer i : pressed) {
			switch(i) {
			case KeyEvent.VK_A:
				moveX = moveX * 0.9 - 0.1 * 4;
				break;
			case KeyEvent.VK_D:
				moveX = moveX * 0.9 + 0.1 * 4;
				break;
			case KeyEvent.VK_S:
				height -= 1;
				break;
			case KeyEvent.VK_W:
				height += 1;
				break;
			case KeyEvent.VK_SPACE:
				if(onGround) {
					velocity = 5;
				}
				break;
			}
		}
	}
	// update player position
	public void playerUpdate(ArrayList<Platform> plats) {
		velocity -= velocity > -10 ? 0.2 : 0;
		moveY -= velocity;
		boolean successful = true;
		for(Platform p : plats) {
			if(p.collision(this)) successful = false;
		}
		if(!successful) {onGround = true;} else {onGround = false;}
		x += moveX; y += moveY;
		
		if (y > 1000) {
			y = 10;
			x = 10;
		}
	}
}
