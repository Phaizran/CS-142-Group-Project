import java.awt.Graphics;

public class StoreScreen extends Screen {
	int[] inventoryType = {0, 0, 0, 0, 0, 0, 0, 1, 2}; //hard coded shop items
	int[] inventoryPlantType = {0, 1, 2, 3, 4, 5, 6, -1, -1}; //hard coded plant types for shop items
	StoreItem[] inventory = new StoreItem[inventoryType.length];
	
	
	public StoreScreen(int width, int height) {
		int buttonSize = height / 8;
		int leftMargin = (int) ((width / 6.0) - (buttonSize / 2.0));
		for (int i = 0; i < inventory.length; i++) {
			if (i < 3) {
				inventory[i] = new StoreItem(leftMargin + (int) ((width / 3.0) * i), buttonSize * 2, buttonSize, buttonSize, inventoryType[i], inventoryPlantType[i]);
			}else if (i < 6) {
				inventory[i] = new StoreItem(leftMargin + (int) ((width / 3.0) * (i - 3)), buttonSize + (buttonSize * 3), buttonSize, buttonSize, inventoryType[i], inventoryPlantType[i]);
			}else {
				inventory[i] = new StoreItem(leftMargin + (int) ((width / 3.0) * (i - 6)), buttonSize + (buttonSize * 5), buttonSize, buttonSize, inventoryType[i], inventoryPlantType[i]);
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
