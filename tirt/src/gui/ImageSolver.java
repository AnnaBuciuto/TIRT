package gui;

import map.element.AccessPoint;
import map.element.EmptySpace;
import map.element.Obstacle;
import map.element.User;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class ImageSolver {

    Image emptySpaceImg, accessPointImg, obstacleImg, userImg;
    public ImageSolver() {
        try {
            emptySpaceImg = ImageIO.read(new File("tirt/img/emptySpace.png"));
            accessPointImg = ImageIO.read(new File("tirt/img/accessPoint.png"));
            obstacleImg = ImageIO.read(new File("tirt/img/obstacle.jpg"));
            userImg = ImageIO.read(new File("tirt/img/user.jpg"));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public  Image getImage(char mapKey) {
        switch (mapKey) {
            case EmptySpace.MAP_KEY:
                return emptySpaceImg;
            case AccessPoint.MAP_KEY:
                return accessPointImg;
            case Obstacle.MAP_KEY:
                return obstacleImg;
            case User.MAP_KEY:
                return userImg;
        }
        return null;
    }
}
