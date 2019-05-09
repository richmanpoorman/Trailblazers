import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

// the JPanel in which graphics are projected
public class Main extends JPanel implements Runnable, MouseMotionListener, ComponentListener {	
	private Thread t;
	// keys that are currently being pressed, added/removed through TAdapter
	public static Set<Integer> pressed;
	public static ArrayList<Platform> plats = new ArrayList<>();
	Player p = new Player(10, 10, 100, 100);
	
	// initializer
	public Main() {
		addKeyListener(new KeyListener());
		addMouseListener(new MouseListener());
		setFocusable(true);
		setDoubleBuffered(false);
		addMouseMotionListener(this);
		addComponentListener(this);
		pressed = new HashSet<Integer>();
		plats.add(new Platform(10, 300, 100, 20));
		plats.add(new Platform(50, 400, 200, 20));
		plats.add(new Platform(300, 500, 100, 20));
		t = new Thread(this);
		t.start();
	}
	
	// if you don't know what this is, then you actually are not intelligent
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int)Math.round(p.x), (int)Math.round(p.y), p.width, p.height);
		plats.stream().forEach((p) -> p.render(g));
		g.dispose();
	}
	
	// repaint loop, ~40 fps
	public void run() {
		long beforeTime = System.currentTimeMillis();
		while (true) {
			long timeDiff = System.currentTimeMillis() - beforeTime;
			beforeTime = System.currentTimeMillis();
			long sleep = 30 - timeDiff;
			repaint();
			p.keyEvents(pressed);
			p.playerUpdate(plats);
			if (sleep < 2) {
				sleep = 2;
			}
			try {
				Thread.sleep(sleep);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private class MouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}
	}

	private class KeyListener extends KeyAdapter {
		@Override
		public synchronized void keyPressed(KeyEvent e) {
			pressed.add(e.getKeyCode());
		}

		@Override
		public synchronized void keyReleased(KeyEvent e) {
			pressed.remove(e.getKeyCode());
		}
	}

	@Override
	public void componentResized(ComponentEvent e) {
		
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		
	}
	@Override
	public void componentShown(ComponentEvent e) {
		
	}
	@Override
	public void componentHidden(ComponentEvent e) {
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {

	}
}