import java.awt.Graphics;

public class Platform {
	int x, y, width, height;

	public Platform(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	// check collision
	public Boolean collision(Player p) {
		if(p.x + p.moveX + p.width > x && p.x + p.moveX < x + width && p.y + p.moveY + p.height > y && p.y + p.moveY < y + height) {
			if(p.y + p.height <= y) {
				p.onGround = true;
				p.moveY = 0;
				p.velocity = 0;
			} else {
				p.moveX = 0;
			}
			return true;
		}
		return false;
	}
	public void render(Graphics g) {
		g.fillRect(x, y, width, height);
	}
}
