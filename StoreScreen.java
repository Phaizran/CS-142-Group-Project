import java.awt.Graphics;

public class StoreScreen extends Screen {
	int[] inventoryType = {0, 0, 0, 0, 0, 0, 0, 1}; //hard coded shop items
	int[] inventoryPlantType = {0, 1, 2, 3, 4, 5, 6, -1}; //hard coded plant types for shop items
	StoreItem[] inventory = new StoreItem[inventoryType.length];
	
	
	public StoreScreen(int width, int height) {
		int buttonSize = height / 10;
		int leftMargin = (width / 4) - (buttonSize / 2);
		int rightMargin = width - ((width / 4) + (buttonSize / 2));
		for (int i = 0; i < inventory.length; i++) {
			if (i < 4) {
				inventory[i] = new StoreItem(leftMargin, buttonSize + (buttonSize * i * 2), buttonSize, buttonSize, inventoryType[i], inventoryPlantType[i]);
			}else {
				inventory[i] = new StoreItem(rightMargin, buttonSize + (buttonSize * (i - 4) * 2), buttonSize, buttonSize, inventoryType[i], inventoryPlantType[i]);
			}
		}
	}

	@Override
	public void draw(Graphics g, int width, int height) {
		for (int i = 0; i < inventory.length; i++) {
			inventory[i].draw(g);
		}
	}


}
