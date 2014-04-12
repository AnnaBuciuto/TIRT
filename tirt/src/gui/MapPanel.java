package gui;

import map.MapLine;
import map.NetworkMap;

import javax.swing.*;
import java.awt.*;


public class MapPanel extends JPanel {
    NetworkMap map;
    ImageSolver imageSolver;
    public MapPanel(ImageSolver imageSolver) {
        super();
        this.imageSolver = imageSolver;
    }
    public void setMap(NetworkMap map) {
        this.map = map;
    }

    public void paintMap(NetworkMap map) {
        setMap(map);
        repaint();
        revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (map != null) {
            for (int y = 0; y < map.map.size(); y++) {
                for (int x = 0; x < map.map.get(y).line.size(); x++) {
                    int xCoordinate = x*20;
                    int yCoordinate = y*20;
                    g.drawImage(imageSolver.getImage(map.getElement(x,y).getMapKey()),xCoordinate,yCoordinate,null);
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (map != null && map.map.size() > 0 ) {
           return new Dimension(map.map.get(0).line.size() * 20, map.map.size() * 20);
        } else {
            return super.getPreferredSize();
        }


    }
}
