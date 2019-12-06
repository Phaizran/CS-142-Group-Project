import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenSelect implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (e.getSource() == Start.travel){
                JComboBox cb = (JComboBox)e.getSource();
                String msg = (String)cb.getSelectedItem();
                switch(msg){
	                case "Garden":
	                	Start.gameState = 0;
	                	break;
                    case "Store":
                    	Start.gameState = 1;
                    	Start.isWatering = false;
                    	Start.usingItem = false;
                    	Start.itemInUse = -1;
                    	Start.seedInUse = -1;
                    	break;
                    case "Inventory":
                    	Start.gameState = 2;
                    	Start.isWatering = false;
                    	Start.usingItem = false;
                    	Start.itemInUse = -1;
                    	Start.seedInUse = -1;
                    	break;
                }
            }
        }
}


