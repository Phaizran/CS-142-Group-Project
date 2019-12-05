import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter{

	@Override
	public void mouseMoved(MouseEvent e) {
		switch (Start.gameState) {
		case 0:
			for (int i = 0; i < Start.garden.allPlots.length; i++) {
				if (Start.garden.allPlots[i].rect.contains(e.getPoint())) {
					if (Start.garden.allPlots[i].isUnlocked) {
						if	(Start.garden.allPlots[i].plantType != -1) {
							if (Start.garden.allPlots[i].plantedPlant.sucessfulTurns == 
									Start.garden.allPlots[i].plantedPlant.turnsToGrow) {
								Start.status = "Harvest " + Start.garden.allPlots[i].plantedPlant.name;
							}else {
								Start.status = Start.garden.allPlots[i].plantedPlant.name;
							}
							break;
						}else {
							Start.status = "Empty Plot";
							break;
						}
					}else {
						Start.status = "Locked Plot";
						break;
					}
				}else {
					Start.status = "";
				}
			}
			if (Start.garden.water.contains(e.getPoint())) {
				Start.status = "Water";
			}
//			if (Start.garden.next.contains(e.getPoint())) {
//				Start.status = "Next Day";
//			}
			break;
		case 1:
			for (int i = 0; i < Start.store.inventory.length; i++) {
				if (Start.store.inventory[i].rect.contains(e.getPoint())) {
					Start.status = Start.store.inventory[i].name + " $" + Start.store.inventory[i].cost;
					break;
				}else {
					Start.status = "";
				}
			}
			break;
		case 2:
			for (int i = 0; i < Start.inventory.inventory.length; i++) {
				if (Start.inventory.inventory[i].rect.contains(e.getPoint())) {
					if (Start.inventory.inventory[i].itemType != 1) {
						Start.status = "Use " + Start.inventory.inventory[i].name + "?";
						break;
						}else {
							Start.status = "";
							break;
						}
				}else {
					Start.status = "";
				}
			}
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (Start.gameState) {
		case 0:
			if (Start.usingItem) {
				for (int i = 0; i < Start.garden.allPlots.length; i++) {
					if (Start.garden.allPlots[i].rect.contains(e.getPoint())) {
						switch (Start.itemInUse) {
						case 0:
							Start.garden.allPlots[i].plantPlant(Start.seedInUse);
	                    	Start.usingItem = false;
	                    	Start.itemInUse = -1;
	                    	Start.seedInUse = -1;
							break;
						case 1:
							Start.garden.allPlots[i].plantedPlant.sucessfulTurns++;
	                    	Start.usingItem = false;
	                    	Start.itemInUse = -1;
	                    	Start.seedInUse = -1;
							break;
						}
						break;
					}
				}
			}
			else if (Start.isWatering) {
				for (int i = 0; i < Start.garden.allPlots.length; i++) {
					if (Start.garden.allPlots[i].rect.contains(e.getPoint())) {
						Start.garden.allPlots[i].plantedPlant.timesWatered++;
						Start.isWatering = false;
					}
				}
			}
			else if (Start.garden.water.contains(e.getPoint())) {
				Start.isWatering = true;
//			}else if (Start.garden.next.contains(e.getPoint())) {
//				Start.garden.nextDay();
			}else if (!Start.usingItem) {
				for (int i = 0; i < Start.garden.allPlots.length; i++) {
					if (Start.garden.allPlots[i].rect.contains(e.getPoint()) &&
							Start.garden.allPlots[i].plantedPlant.sucessfulTurns == 
							Start.garden.allPlots[i].plantedPlant.turnsToGrow) {
						Rectangle r = new Rectangle(Start.garden.allPlots[i].rect.x, Start.garden.allPlots[i].rect.y, 
								Start.garden.allPlots[i].rect.width, Start.garden.allPlots[i].rect.height);
						Start.playerMoney += Start.garden.allPlots[i].plantedPlant.value;
						Start.garden.allPlots[i] = new Plot();
						Start.garden.allPlots[i].rect = new Rectangle(r.x, r.y, r.width, r.height);
						Start.garden.allPlots[i].isUnlocked = true;
					}
				}
			}

			break;
		case 1:
			for (int i = 0; i < Start.store.inventory.length; i++) {
				if (Start.store.inventory[i].rect.contains(e.getPoint())) {
					Start.store.inventory[i].isClicked();
					break;
				}
			}
			break;
		case 2:
			for (int i = 0; i < Start.store.inventory.length; i++) {
				if (Start.inventory.inventory[i].rect.contains(e.getPoint())) {
					Start.inventory.useItem(Start.inventory.inventory[i]);
					break;
				}
			}
			break;
		}

	}


}
