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
							Start.status = Start.garden.allPlots[i].plantedPlant.name;
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
		}

	}


}
