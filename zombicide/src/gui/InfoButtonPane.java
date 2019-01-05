package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Main;

public class InfoButtonPane extends JPanel implements ActionListener {
	private static final long serialVersionUID = -5408664565713957373L;
	
	private JButton retour, ouvrirPdf;
	private JFrame topLevelJFrame;
	
	public InfoButtonPane(JFrame topLevelJFrame) {
		this.topLevelJFrame = topLevelJFrame;
		
		this.retour = new JButton("Retour");
		this.ouvrirPdf = new JButton("Ouvrir pdf");
		
		this.retour.addActionListener(this);
		this.ouvrirPdf.addActionListener(this);
		
		this.setLayout(new GridLayout(1, 2));
		
		this.add(retour);
		this.add(ouvrirPdf);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == this.retour) {
			this.topLevelJFrame.dispose();
			Main.startGame();
		}
		else if (source == this.ouvrirPdf) { 
			try {
				java.awt.Desktop.getDesktop().open(new File("txt/Rapport.pdf"));
			} 
			catch (IOException io) {
				io.printStackTrace();
			}
		}
	}
}
