import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Set;

import javax.swing.JPanel;

public class Main extends JPanel implements Runnable, MouseMotionListener, ComponentListener {	
	private Thread t;
	public static Set<Integer> pressed;
	public Main() {
		addKeyListener(new TAdapter());
		addMouseListener(new MAdapter());
		setFocusable(true);
		setDoubleBuffered(false);
		addMouseMotionListener(this);
		addComponentListener(this);
		t = new Thread(this);
		t.start();
	}
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(10, 10, 100, 100);
		g.dispose();
	}
	
	public void run() {
		long beforeTime = System.currentTimeMillis();
		while (true) {
			long timeDiff = System.currentTimeMillis() - beforeTime;
			beforeTime = System.currentTimeMillis();
			long sleep = 30 - timeDiff;
			repaint();
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
	private class MAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}
	}

	private class TAdapter extends KeyAdapter {
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}