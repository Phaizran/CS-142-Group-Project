import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Start{
	static int gameState = 0; // keep track of the screen user is on
	static int playerMoney = 10;
	static String status = "";
	static GardenScreen garden;
	static StoreScreen store;
	static InventoryScreen inventory;
	static MouseHandler mH = new MouseHandler();
	static boolean isWatering = false;
	static boolean usingItem = false;
	static int itemInUse = -1;
	static int seedInUse = -1;
    static String[] places = {"Garden", "Store", "Inventory"};
    static JComboBox travel =  new JComboBox(places);
    static ScreenSelect sS = new ScreenSelect();
	
	

	public static void main(String[] args) {		
//		Setting up graphics window.
		JFrame window = new JFrame("Garden Simulator");
		window.setLocationByPlatform(true);
		@SuppressWarnings("serial")
		final JPanel panel = new JPanel() {

			protected void paintComponent(Graphics gx) {
				Graphics2D g = (Graphics2D) gx;
				int width = getWidth();
				int height = getHeight();
				g.clearRect(0, 0, width, height);
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.setBackground(Color.WHITE);
				g.setColor(Color.BLACK);
				g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

				this.repaint(17000);
				draw(g, width, height);
			}
		};

		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int wWidth = (int) (d.width * 0.8);
		int wHeight = (int) (d.height * 0.8);
		window.setSize(wWidth, wHeight);
		window.setBackground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		window.setContentPane(panel);
		window.setVisible(true);
		window.setResizable(false);		
		panel.addMouseListener(mH);
		panel.addMouseMotionListener(mH);
		
		garden = new GardenScreen(panel.getWidth(), panel.getHeight());
		store = new StoreScreen(panel.getWidth(), panel.getHeight());
		inventory = new InventoryScreen(panel.getWidth(), panel.getHeight());
		
		Container c = window.getContentPane();
		GridBagConstraints gC = new GridBagConstraints();
		Insets sSI = new Insets((int) (panel.getHeight() * 0.04), 0, 0, (int) (panel.getWidth() * 0.065));
		gC.anchor =  GridBagConstraints.FIRST_LINE_END;
		gC.insets = sSI;
		gC.weightx = 0.01;
		gC.weighty = 0.01;
		c.setLayout(new GridBagLayout());

        travel.setSelectedIndex(0);
        travel.addActionListener(sS);
        c.add(travel, gC);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void draw(Graphics g, int width, int height) {
		g.drawString("$" + playerMoney, width / 2, 20);
		g.setColor(Color.BLUE);
		if (isWatering) {
			g.drawString("Watering " + status, width / 2, (int) (height * 0.98));
		}else {
			g.drawString(status, width / 2, (int) (height * 0.98));
		}
		switch (gameState) {
		case 0:
			garden.draw(g, width, height);
			break;
		case 1:
			store.draw(g, width, height);
			break;
		case 2:
			inventory.draw(g, width, height);
			break;
		}
	}
}