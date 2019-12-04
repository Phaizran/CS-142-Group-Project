import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class StoreItem extends Button {
	String name; // name of the item
	int itemType = -1; // keeps track of what the item is
	int plantType = -1; // if the item is seeds keeps track of what type of seeds
	int cost = 0; // keeps track of how much the user much pay to add the item to their inventory
	
	public StoreItem (int x, int y, int width, int height, int itemType, int plantType) {
		this.rect = new Rectangle(x, y, width, height);
		this.itemType = itemType;
		if (itemType == -1) { // if the item slot in the store is not empty set it to be clickable
			this.name = "";
			this.isClickable = false;
			}else {
				this.isClickable = true;
			}
		if (itemType == 0) { // check what type of item it is
			this.plantType = plantType;
			if (plantType == 0) { // if the item is a seed packet check what type of plant it is
				this.name = "Rose Seed";
				this.cost = 1;
			}
			else if(plantType == 1) {
				this.name = "Lavender Seed";
				this.cost = 3;
			}
			else if(plantType == 2) {
				this.name = "Cactus Seed";
				this.cost = 5;
			}
			else if(plantType == 3) {
				this.name = "Kitten Seed";
				this.cost = 10;
			}
			else if (plantType == 4) { 
				this.name = "Strawberry Seed";
				this.cost = 2;
			}
			else if(plantType == 5) {
				this.name = "Grape Seed";
				this.cost = 4;
			}
			else if(plantType == 6) {
				this.name = "Broccoli Seed";
				this.cost = 6;
			}
			else if(plantType == 7) {
				this.name = "Pumpkin Seed";
				this.cost = 8;
			}//else if () {} TO DO: add more else if statements for other plant types
		}
		else if ( itemType == 1) {//TO DO: add more else if statements for other item types
			this.name = "Fertilizer";
				this.cost = 4;
		} 
	}

	@Override
	public void isClicked() {
		if (cost <= Start.playerMoney) {
			for (int i = 0; i < Start.inventory.inventory.length; i++) {
				if (Start.inventory.inventory[i].itemType == -1) {
					Start.inventory.inventory[i].itemType = this.itemType;
					Start.inventory.inventory[i].plantType = this.plantType;
					Start.inventory.inventory[i].name = this.name;
					Start.playerMoney -= this.cost;
					break;
				}
			}
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(this.rect.x, this.rect.y, this.rect.width, this.rect.height);
		
		switch (this.itemType) {
		case 0:
			Plant.draw(g, this.rect.width, this.rect.x, this.rect.y, this.plantType);
			break;
		case 1:
			Color c = new Color(0.50f, 0.25f, 0.0f);
			g.setColor(c);
			g.fillOval(this.rect.x + this.rect.width / 4, this.rect.y + this.rect.height / 2, this.rect.width / 3, this.rect.width / 3);
			g.fillOval(this.rect.x + ((this.rect.width / 4) * 2) , this.rect.y + this.rect.height / 2, this.rect.width / 3, this.rect.width / 3);
			g.fillOval(this.rect.x + this.rect.width / 3, this.rect.y + this.rect.height / 4 , this.rect.width / 3, this.rect.width / 3);
			break;
		}
	}
	

}