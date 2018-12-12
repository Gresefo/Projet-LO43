package control;

public class MenuControl {
	int selected_button;
	
	public MenuControl() {
		this.selected_button = 1;
	}
	
	public void changeSelectedButton(int change) {
		this.selected_button += change;
		if (this.selected_button  == 4) {
			this.selected_button = 3;
		}
		else if (this.selected_button == 0) {
			this.selected_button = 1;
		}
	}

	public int getSelectedButton() {
		return selected_button;
	}
}
