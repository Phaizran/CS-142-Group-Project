import java.awt.Graphics;


public class InventoryScreen extends Screen {
	int inventorySlots = 8;
	int[] invetoryType;
	StoreItem[] inventory = new StoreItem[inventorySlots];
	
	public InventoryScreen(int width, int height) {
		int buttonSize = height / 10;
		int leftMargin = (width / 4) - (buttonSize / 2);
		int rightMargin = width - ((width / 4) + (buttonSize / 2));
		for (int i = 0; i < inventory.length; i++) {
			if (i < 4) {
				inventory[i] = new StoreItem(leftMargin, buttonSize + (buttonSize * i * 2), buttonSize, buttonSize, -1, -1);
			}else {
				inventory[i] = new StoreItem(rightMargin, buttonSize + (buttonSize * (i - 4) * 2), buttonSize, buttonSize, -1, -1);
			}
		}
	}

	@Override
	public void draw(Graphics g, int width, int height) {
		for (int i = 0; i < inventory.length; i++) {
			inventory[i].draw(g);
		}

	}
	
	public void useItem(StoreItem s) {
		Start.usingItem = true;
		switch (s.itemType) {
		case 0:
			Start.itemInUse = s.itemType;
			Start.seedInUse = s.plantType;
			break;
		case 1:
			Start.itemInUse = s.itemType;
			break;
		}
		s.itemType = -1;
		s.plantType = -1;
		s.name = null;
		Start.gameState = 0;
	}



}
