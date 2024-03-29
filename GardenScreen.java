import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class GardenScreen extends Screen{
	Plot[] plotColumnOne = new Plot[32];
	Plot[] plotColumnTwo = new Plot[32];
	Plot[] plotColumnThree = new Plot[32];
	Plot[] allPlots = new Plot[96];
	static int rowSize = 4;
	static int rowsInColumn = 8;
	static int plotSize = 0;
	Color brown = new Color(0.55f, 0.30f, 0.0f);
	Rectangle water;
	Rectangle next;
	
	public GardenScreen(int width, int height) {
		int thirdOfWidth = (int) (width * 0.9) / 3;
		plotSize = (int) Math.ceil((height * 0.8) / (rowsInColumn * 1.5));
		int plotRowOffset = (int) (thirdOfWidth - (plotSize * rowSize)) / 2;
		
		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		
		
		for (int i = 0; i < 32; i++) {
			plotColumnOne[i] = new Plot();
		}
		for (int r = 0; r < rowsInColumn; r++) {
			for (int p = 0; p < rowSize; p++) {
				plotColumnOne[c1].rect = new Rectangle((int) plotRowOffset + (p * plotSize), (int) (height * 0.1) + (int) (r * plotSize * 1.5), plotSize, plotSize);
				c1++;
			}
		}
		for (int i = 0; i < 32; i++) {
			plotColumnTwo[i] = new Plot();	
				}
		for (int r = 0; r < rowsInColumn; r++) {
			for (int p = 0; p < rowSize; p++) {
				plotColumnTwo[c2].rect = new Rectangle((int) plotRowOffset + (p * plotSize) + thirdOfWidth, (int) (height * 0.1) + (int) (r * plotSize * 1.5), plotSize, plotSize);
				c2++;
			}
		}
		for (int i = 0; i < 32; i++) {
			plotColumnThree[i] = new Plot();
		}
		for (int r = 0; r < rowsInColumn; r++) {
			for (int p = 0; p < rowSize; p++) {
				plotColumnThree[c3].rect = new Rectangle((int) plotRowOffset + (p * plotSize) + (thirdOfWidth * 2), (int) (height * 0.1) + (int) (r * plotSize * 1.5), plotSize, plotSize);
				c3++;
			}
		}
		for (int i = 0; i < 4; i++) {
			plotColumnOne[i].isUnlocked = true;
		}
		
		int aP = 0;
		while (aP < allPlots.length) {
			for (int i = 0; i < plotColumnOne.length; i++) {
				allPlots[aP] = plotColumnOne[i];
				aP++;
			}
			for (int i = 0; i < plotColumnTwo.length; i++) {
				allPlots[aP] = plotColumnTwo[i];
				aP++;
			}
			for (int i = 0; i < plotColumnThree.length; i++) {
				allPlots[aP] = plotColumnThree[i];
				aP++;
			}
		}
		
		water = new Rectangle((int) (width * 0.89), (int) (height * 0.77), (int) (width * 0.1), (int) (width * 0.1));
		next = new Rectangle((width - plotSize*4), (int)(height*.1), plotSize *3, plotSize);
		
	}
	
	public void draw(Graphics g, int width, int height) {		
		for (int i = 0; i < allPlots.length; i++) {
				if (allPlots[i].isUnlocked == false) {
					g.setColor(Color.lightGray);
				}else {
					g.setColor(brown);
				}
				g.fillRect(allPlots[i].rect.x, allPlots[i].rect.y, allPlots[i].rect.width, allPlots[i].rect.height);
				g.setColor(Color.BLACK);
				g.drawRect(allPlots[i].rect.x, allPlots[i].rect.y, allPlots[i].rect.width, allPlots[i].rect.height);
				if (allPlots[i].plantType > -1) {
					Plant.draw(g, plotSize, allPlots[i].rect.x, allPlots[i].rect.y, allPlots[i].plantedPlant.type);
					if (allPlots[i].plantedPlant.sucessfulTurns == allPlots[i].plantedPlant.turnsToGrow) {
						g.setColor(Color.YELLOW);
					}else {
						g.setColor(Color.GREEN);
					}
					g.fillRect(allPlots[i].rect.x , allPlots[i].rect.y + allPlots[i].rect.height,
							(int) (allPlots[i].rect.width * (allPlots[i].plantedPlant.sucessfulTurns / allPlots[i].plantedPlant.turnsToGrow) ), (int) (allPlots[i].rect.height * 0.3));
					g.setColor(Color.BLACK);
					g.drawRect(allPlots[i].rect.x , allPlots[i].rect.y + allPlots[i].rect.height, allPlots[i].rect.width, (int) (allPlots[i].rect.height * 0.3));
				}
		}
		g.setColor(Color.BLUE);
		g.fillOval(water.x, water.y, water.width, water.height);
		
		g.setColor(Color.pink);
		g.fillRect(next.x, next.y, next.width, next.height);
		
		g.setColor(Color.black);
		g.drawRect(next.x, next.y, next.width, next.height);
		g.drawString("Next Day", next.x + (int) (next.width * 0.2), next.y + (int) (next.height * 0.7));
	}
	
	public void nextDay() {
		
		for( int i= 0; i < allPlots.length; i++){
			if(allPlots[i].plantType != -1) {
				if(allPlots[i].plantedPlant.timesWatered == allPlots[i].plantedPlant.waterPerTurn) {
					allPlots[i].plantedPlant.sucessfulTurns++;
				}
				if(allPlots[i].plantedPlant.timesWatered == 0) {
					if (allPlots[i].plantedPlant.sucessfulTurns > 0) {
						allPlots[i].plantedPlant.sucessfulTurns--;
					}else {
						Rectangle r = new Rectangle(Start.garden.allPlots[i].rect.x, Start.garden.allPlots[i].rect.y, 
								Start.garden.allPlots[i].rect.width, Start.garden.allPlots[i].rect.height);
						Start.garden.allPlots[i] = new Plot();
						Start.garden.allPlots[i].rect = new Rectangle(r.x, r.y, r.width, r.height);
						Start.garden.allPlots[i].isUnlocked = true;
					}
				}
				if(allPlots[i].plantType != -1) {
					allPlots[i].plantedPlant.timesWatered = 0;
				}
			}
		}
		
    	Start.isWatering = false;
    	Start.usingItem = false;
    	Start.itemInUse = -1;
    	Start.seedInUse = -1;
	}



}
