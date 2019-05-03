import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Window extends JFrame {
	public Window() {
		add(new Main());
		setTitle("Trailblazers");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(1400, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
	}

	public static void main(String[] args) {
		new Window();
	}
}
