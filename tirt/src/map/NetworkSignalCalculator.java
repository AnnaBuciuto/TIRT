package map;

import map.element.AccessPoint;
import map.element.Door;
import map.element.Obstacle;
import map.element.WindowObstacle;


public class NetworkSignalCalculator {

    final double maxSignalPower = 0.025118864, minSignalPower = 0.00000001;
    final double wallFactor = 0.2, doorFactor = 0.8, windowFactor = 0.5;
    final double unit = 0.5;
    final double maxDistance = 20.0 / unit;
    NetworkMap map;

    public NetworkSignalCalculator(NetworkMap map) {
        this.map = map;
    }

    public double distanceBetween(int point1Column, int point1Row, int point2Column, int point2Row) {
        return Math.sqrt(Math.pow(point1Column - point2Column, 2) + Math.pow(point1Row - point2Row, 2));
    }

    public double signalPowerBetween(int receiverColumn, int receiverRow, int accessPointColumn, int accessPointRow) {
        double signalPower;
        double distance = distanceBetween(receiverColumn, receiverRow, accessPointColumn, accessPointRow);
        if (distance > maxDistance) {
            signalPower = 0;
        } else {
            double tempSignalPower = maxSignalPower / (4*unit*Math.PI*Math.pow(distance, 2));
            int[] obstacles = obstaclesBetween(receiverColumn, receiverRow, accessPointColumn, accessPointRow);
            signalPower = tempSignalPower*(obstacles[0] > 0? Math.pow(wallFactor, obstacles[0]) : 1)
                    *(obstacles[1] > 0? Math.pow(doorFactor, obstacles[1]) : 1)
                    *(obstacles[2] > 0? Math.pow(windowFactor, obstacles[2]) : 1);
            if (signalPower < minSignalPower) {
                signalPower = 0;
            }
        }
        return signalPower;
    }

    public double bestSignalPowerAtPoint(int receiverColumn, int receiverRow) {
        double signalPower = 0;
        for (int row = 0; row < map.getRowNumber(); row++) {
            for (int column = 0; column < map.getColumnNumber(); column++) {
                if (map.getElement(column, row).getMapKey() == AccessPoint.MAP_KEY) {
                    double accessPointSignalPower = signalPowerBetween(receiverColumn, receiverRow, column, row);
                    if (accessPointSignalPower > signalPower) {
                        signalPower = accessPointSignalPower;
                    }
                }
            }
        }
        return signalPower;
    }


    /**
     *
     * @param point1Column
     * @param point1Row
     * @param point2Column
     * @param point2Row
     * @return array with number of [wall,doors,windows]
     */
    public int[] obstaclesBetween(int point1Column, int point1Row, int point2Column, int point2Row) {
        int wallCounter = 0, doorCounter = 0, windowCounter = 0;
        if (point1Column == point2Column) {
            int sign = (point1Row < point2Row)? 1 : -1;
            for (int i = point1Row + sign; (sign == 1? i < point2Row : i > point2Row); i += sign) {
                if (map.getElement(point1Column, i).getMapKey() == Obstacle.MAP_KEY) {
                    wallCounter++;
                } else if (map.getElement(point1Column, i).getMapKey() == Door.MAP_KEY) {
                    doorCounter++;
                } else if (map.getElement(point1Column, i).getMapKey() == WindowObstacle.MAP_KEY) {
                    windowCounter++;
                }
            }
        } else {
            double a = (double)(point2Row - point1Row) / (point2Column - point1Column);
            double b = point1Row - a*point1Column;

            int sign = (point1Column < point2Column)? 1 : -1;
            int previousColumn = -1, previousRow = -1;
            for (double i = point1Column; (sign == 1? i < point2Column : i > point2Column); i += (double)sign/map.map.size()) {
                int actualColumn = (int)Math.round(i);
                int actualRow = (int)Math.round(a*i + b);
                if (actualColumn != previousColumn || actualRow != previousRow) {
                    if (map.getElement(actualColumn, actualRow).getMapKey() == Obstacle.MAP_KEY) {
                        wallCounter++;
                    } else if (map.getElement(actualColumn, actualRow).getMapKey() == Door.MAP_KEY) {
                        doorCounter++;
                    } else if (map.getElement(actualColumn, actualRow).getMapKey() == WindowObstacle.MAP_KEY) {
                        windowCounter++;
                    }
                    previousColumn = actualColumn;
                    previousRow = actualRow;
                }
            }
        }
        return new int[]{wallCounter, doorCounter, windowCounter};
    }
}
