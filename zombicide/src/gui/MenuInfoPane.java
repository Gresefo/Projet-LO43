package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MenuInfoPane extends JPanel {
	private static final long serialVersionUID = 3898564768293014589L;
	private BufferedImage BG_IMG;

	public MenuInfoPane() {
		super();
		try {
			BG_IMG = ImageIO.read(new File("img/menuImg.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(BG_IMG, 0, 0, this);
		
		g.setColor(Color.RED);
		g.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		g.drawString("C'est la panique : Un bug s'est (encore) produit dans l'UTBM, et toutes les inscriptions aux", 30, 300);
		g.drawString("UVs n'ont pas �t� valid�es. 4 vaillants professeurs ont tent� en vain de g�rer cette crise", 30, 330);
		g.drawString("mais s'en est trop. Les �l�ves, r�volt�s sont trop nombreux. Nos vaillants professeurs ont", 30, 360);
		g.drawString("donc d�cid�s de se cacher, mais apr�s 3 jours dans le noir les ressources commencent � manquer.", 30, 390);
		g.drawString("Une seule solution : sortir du batiment. Mais m�me apr�s 3 jours les �l�ves sont toujours l�", 30, 420);
		g.drawString("et il faudra donc se confronter � inscrire les plus r�calcitrants...", 30, 450);
		
	}
}
