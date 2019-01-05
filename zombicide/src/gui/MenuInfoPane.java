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
		g.drawString("UVs n'ont pas été validées. 4 vaillants professeurs ont tenté en vain de gérer cette crise", 30, 330);
		g.drawString("mais s'en est trop. Les élèves, révoltés sont trop nombreux. Nos vaillants professeurs ont", 30, 360);
		g.drawString("donc décidé de se cacher, mais après 3 jours dans le noir les ressources commencent à manquer.", 30, 390);
		g.drawString("Une seule solution : sortir du batiment. Mais même après 3 jours les élèves sont toujours là", 30, 420);
		g.drawString("et il faudra donc se confronter à inscrire les plus récalcitrants...", 30, 450);
		
	}
}
