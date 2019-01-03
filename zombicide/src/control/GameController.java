package control;

import gui.GamePane;

public class GameController {
	private GamePane gamePane;
	
	public GameController(GamePane gp) {
		this.gamePane = gp;
	}
	public void ouvrirSalle1() {
		gamePane.setSalle1(true);
		gamePane.repaint();
	}
	public void ouvrirSalle2() {
		gamePane.setSalle2(true);
		gamePane.repaint();
	}
	public void ouvrirSalle3() {
		gamePane.setSalle3(true);
		gamePane.repaint();
	}
	public void ouvrirSalle4() {
		gamePane.setSalle4(true);
		gamePane.repaint();
	}
	public void ouvrirSalle5() {
		gamePane.setSalle5(true);
		gamePane.repaint();
	}
	public void ouvrirSalle6() {
		gamePane.setSalle6(true);
		gamePane.repaint();
	}
	public void ouvrirSalle7() {
		gamePane.setSalle7(true);
		gamePane.repaint();
	}
	public void ouvrirSalle8() {
		gamePane.setSalle8(true);
		gamePane.repaint();
	}
	
	public GamePane getGamePane() {
		return this.gamePane;
	}
}
