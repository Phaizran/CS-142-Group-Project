import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter{

	@Override
	public void mouseMoved(MouseEvent e) {
		switch (Start.gameState) {
		case 0:
			for (int i = 0; i < Start.garden.plotColumnOne.length; i++) {
				if (Start.garden.plotColumnOne[i].rect.contains(e.getPoint())) {
					if (Start.garden.plotColumnOne[i].isUnlocked) {
						if	(Start.garden.plotColumnOne[i].plantType != -1) {
							Start.status = Start.garden.plotColumnOne[i].plantedPlant.name;
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
			for (int i = 0; i < Start.garden.plotColumnTwo.length; i++) {
				if (Start.garden.plotColumnTwo[i].rect.contains(e.getPoint())) {
					if (Start.garden.plotColumnTwo[i].isUnlocked) {
						if	(Start.garden.plotColumnTwo[i].plantType != -1) {
							Start.status = Start.garden.plotColumnOne[i].plantedPlant.name;
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
			for (int i = 0; i < Start.garden.plotColumnThree.length; i++) {
				if (Start.garden.plotColumnThree[i].rect.contains(e.getPoint())) {
					if (Start.garden.plotColumnThree[i].isUnlocked) {
						if	(Start.garden.plotColumnThree[i].plantType != -1) {
							Start.status = Start.garden.plotColumnOne[i].plantedPlant.name;
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
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (Start.gameState) {
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}

	}


}
