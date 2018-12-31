package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePane extends JPanel {
	private static final long serialVersionUID = -5201433530107117026L;
	
	private BufferedImage GRILLE, GRILLE_FERME, S1, S2, S3, S4, S5, S6, S7, S8;
	private boolean salle1 = false, salle2 = false, salle3 = false, salle4 = false, salle5 = false, salle6 = false, salle7 = false, salle8 = false; 

	public GamePane() {
		super();
		this.setPreferredSize(new Dimension(1120, 800));
		try {
			//GECHTER_IMG = ImageIO.read(new File("img/gechter.png"));
			GRILLE = ImageIO.read(new File("img/grille_couloirs.png"));
			GRILLE_FERME = ImageIO.read(new File("img/grille_couloirs_ferme.png"));
			S1 = ImageIO.read(new File("img/salle1.png"));
			S2 = ImageIO.read(new File("img/salle2.png"));
			S3 = ImageIO.read(new File("img/salle3.png"));
			S4 = ImageIO.read(new File("img/salle4.png"));
			S5 = ImageIO.read(new File("img/salle5.png"));
			S6 = ImageIO.read(new File("img/salle6.png"));
			S7 = ImageIO.read(new File("img/salle7.png"));
			S8 = ImageIO.read(new File("img/salle8.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(GRILLE, 0, 0, this);
		g.drawImage(GRILLE_FERME, 0, 0, this);
		if (salle1) {
			g.drawImage(S1, 0, 0, this);
		}
		if (salle2) {
			g.drawImage(S2, 0, 0, this);
		}
		if (salle3) {
			g.drawImage(S3, 0, 0, this);
		}
		if (salle4) {
			g.drawImage(S4, 0, 0, this);
		}
		if (salle5) {
			g.drawImage(S5, 0, 0, this);
		}
		if (salle6) {
			g.drawImage(S6, 0, 0, this);
		}
		if (salle7) {
			g.drawImage(S7, 0, 0, this);
		}
		if (salle8) {
			g.drawImage(S8, 0, 0, this);
		}
	}
	
	public boolean getSalle1() {
		return salle1;
	}

	public void setSalle1(boolean salle1) {
		this.salle1 = salle1;
	}

	public boolean getSalle2() {
		return salle2;
	}

	public void setSalle2(boolean salle2) {
		this.salle2 = salle2;
	}

	public boolean getSalle3() {
		return salle3;
	}

	public void setSalle3(boolean salle3) {
		this.salle3 = salle3;
	}

	public boolean getSalle4() {
		return salle4;
	}

	public void setSalle4(boolean salle4) {
		this.salle4 = salle4;
	}

	public boolean getSalle5() {
		return salle5;
	}

	public void setSalle5(boolean salle5) {
		this.salle5 = salle5;
	}

	public boolean getSalle6() {
		return salle6;
	}

	public void setSalle6(boolean salle6) {
		this.salle6 = salle6;
	}

	public boolean getSalle7() {
		return salle7;
	}

	public void setSalle7(boolean salle7) {
		this.salle7 = salle7;
	}

	public boolean getSalle8() {
		return salle8;
	}

	public void setSalle8(boolean salle8) {
		this.salle8 = salle8;
	}
}
