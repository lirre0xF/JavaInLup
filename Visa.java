import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

class BildPanel extends JPanel{
    private ImageIcon bild;
    public BildPanel(String filnamn){
	bild = new ImageIcon(filnamn);
	int w = bild.getIconWidth();
	int h = bild.getIconHeight();
	setPreferredSize(new Dimension(w,h));
    }
    protected void paintComponent(Graphics g){
	super.paintComponent(g);
	g.drawImage(bild.getImage(), 0, 0, this);
    }
}

public class Visa extends JFrame{
    JFileChooser jfc = new JFileChooser(".");
    BildPanel bp = null;
    JScrollPane scroll = null;
    Visa(){
	super("Visa");

	FileFilter bildFilter = new FileNameExtensionFilter("Bilder","jpg",
							    "gif","png");
	jfc.setFileFilter(bildFilter);
	
	JPanel uppe = new JPanel();
	add(uppe, BorderLayout.NORTH);
	JButton öppnaKnapp = new JButton("Öppna");
	uppe.add(öppnaKnapp);
	öppnaKnapp.addActionListener(new OpenLyss());

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	//	setSize(300,400);
	pack();
	setVisible(true);
    }

    class OpenLyss implements ActionListener{
	public void actionPerformed(ActionEvent ave){
	    int svar = jfc.showOpenDialog(Visa.this);
	    if (svar != JFileChooser.APPROVE_OPTION)
		return;
	    File fil = jfc.getSelectedFile();
	    String filnamn = fil.getAbsolutePath();
	    if (scroll != null)
		remove(scroll);
	    bp = new BildPanel(filnamn);
	    scroll = new JScrollPane(bp);
	    add(scroll);
	    pack();
	    validate();
	    repaint();
	}
    }

    public static void main(String[] args){
	new Visa();
    }
}
