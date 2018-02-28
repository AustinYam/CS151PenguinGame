

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ScoreScreen extends JFrame{
	
	public ScoreScreen(String s){
		super("GAMEOVER");
		setBounds(100, 100, 250, 100);
		JLabel gameOver = new JLabel("test");
		JLabel score = new JLabel("TEST");
		score.setText("Score: "+s);
		score.setLocation(100,100);
		add(score);
		setLocationRelativeTo(null);
	    setResizable(true);
	    setVisible(true);
	}

}
