import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.Collections;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

public class GUI extends JFrame{

	
	Image mapPanel = null;
	boolean mapLoaded = false;
	
	private static final long serialVersionUID = 1L;
	
	private JLabel newLabel;
	private JComboBox comboRuta;
	private JTextField sokText;
	private JButton searchKnapp;
	private JButton hideKnapp;
	private JButton removeKnapp;
	private JButton whatIsHereKnapp;
	

	
	private JLabel categories;
	private JTextArea eastText;
	private JButton hideButton;

	
	public GUI()
	{
	super("Karta");
	setLayout(new FlowLayout());
    
	
	
	//Menubar 
	JMenuBar menuBar = new JMenuBar();
	
	//Archive Menu
	JMenu archiveItem = new JMenu("Archive");
	JMenuItem newMapItem = new JMenuItem("New Map");
	JMenuItem saveItem = new JMenuItem("Save");
	JMenuItem quitItem = new JMenuItem("Exit");
	JMenuItem loadItem = new JMenuItem("Load Places");
	quitItem.addActionListener(new CloseListener());
	archiveItem.add(newMapItem);
	archiveItem.add(quitItem);
	archiveItem.add(saveItem);
	archiveItem.add(loadItem);
	menuBar.add(archiveItem);
	setJMenuBar(menuBar);
	
	//Norra panelen    
	JPanel northPanel = new JPanel();
	
	newLabel = new JLabel("New:");
	comboRuta = new JComboBox();
	sokText = new JTextField(10);
	searchKnapp = new JButton("Search");
	hideKnapp = new JButton("Hide");
	removeKnapp = new JButton("Remove");
	whatIsHereKnapp = new JButton("What is here?");
	
	northPanel.add(newLabel);
	northPanel.add(comboRuta);
	northPanel.add(sokText);
	northPanel.add(searchKnapp);
	northPanel.add(hideKnapp);
	northPanel.add(removeKnapp);
	northPanel.add(whatIsHereKnapp);
	add(northPanel, BorderLayout.NORTH);
	


	//Panel east
	JPanel eastPanel = new JPanel();
	categories = new JLabel("Categories:");
	eastText = new JTextArea(5,5);
	hideButton = new JButton("Hide Category");
	eastPanel.add(hideButton);
	eastPanel.add(eastText);
	eastPanel.add(categories);
	//eastPanel.add(categories, BorderLayout.EAST);
	add(eastPanel, BorderLayout.EAST);
	
	
	//Fönster egenskaper
	pack();
	setVisible(true);
	setSize(800,300);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	
	
	
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
	
	class CloseListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	class fileChooser implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogTitle("Open");
		
		
		}
	}
	
	
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		
		new GUI();	
		
	}
}


