
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mainframe extends JFrame{
	
	public Mainframe(){
		super("Penguin Game");

		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Field panel = new Field();
	    
	    
	    //menu
	   
	    JPanel menu = new JPanel(new BorderLayout());
	    JPanel options = new JPanel(new GridLayout());
	    JButton start = new JButton("START");
	    JButton exit = new JButton("EXIT");
	    start.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
	    start.setForeground(Color.black);
	    start.setBackground(Color.CYAN);
	    exit.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
	    exit.setForeground(Color.black);
	    exit.setBackground(Color.CYAN);
	    options.add(start);
	    options.add(exit);
	    menu.add(options);
	    add(menu);
	    
	    start.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				add(panel);
				 menu.setVisible(false);
			}
			
	    	
	    });
	    
	    exit.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent e){
	    		System.exit(0);
	    	}
	    });
	    
	    
	    setLocationRelativeTo(null);
	    setResizable(true);
	    setVisible(true);
	   
	    panel.run();
	}
	
	  public static void main(String[] args)
	  {   
		  
	    Mainframe frame = new Mainframe();

	  }
	  
	  public void reset(){
		  Mainframe.this.dispose();
	  }

}
