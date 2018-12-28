package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.GameController;

public class ButtonPane extends JPanel implements ActionListener {
	private static final long serialVersionUID = -5352856784205692008L;
	
	private GameController gc;
	private JButton ouvrirSalle = new JButton("Ouvrir Salle");
	public ButtonPane(GamePane gamePane) {
		super();
		ouvrirSalle.addActionListener(this);
		this.gc = new GameController(gamePane);
		this.setLayout(new GridLayout(3, 3));
		this.add(ouvrirSalle);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == this.ouvrirSalle) {
			gc.ouvrirSalle1();
			gc.ouvrirSalle2();
			gc.ouvrirSalle3();
			gc.ouvrirSalle4();
			gc.ouvrirSalle5();
			gc.ouvrirSalle6();
			gc.ouvrirSalle7();
			gc.ouvrirSalle8();
		}
	}
}
