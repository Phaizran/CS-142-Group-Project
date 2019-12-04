import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenSelect extends JFrame implements ActionListener{
        String[] places = {"Garden", "Store", "Inventory"};
        JComboBox travel =  new JComboBox(places);
        public ScreenSelect(){
            setLayout(new FlowLayout());
            setSize(200,100);
            setTitle("Travel Selection");


            travel.setSelectedIndex(0);
            travel.addActionListener(this);
            add(travel);
            setUndecorated(true);
            getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        }



        public void actionPerformed (ActionEvent e){
            if (e.getSource() == travel){
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


