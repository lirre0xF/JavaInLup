import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class BildPanel extends JFrame {
	
		private String filnamn;
		private ImageIcon bild;
		
		public BildPanel(String filnamn) 
		{
			bild = new ImageIcon(filnamn);
			int width = bild.getIconHeight();
			int height = bild.getIconHeight();
			setPreferredSize(new Dimension(width, height)); // Sätter dimensionerna 
		}
		
	    protected void paintComponent(Graphics g){
	    	super.paintComponents(g);
	    	g.drawImage(bild.getImage(), 0, 0, this);
	    	
	    }
	
		}