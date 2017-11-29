package model;

import service.Navigator;
import service.TrainOnline;

import java.util.LinkedList;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public class Train implements Movable {

    private RailwayStation currentStation;
    private RailwayStation nextStation;
    private LinkedList<RailwayStation> route;
    private int distance;
    private int currentPosition;


    public Train(LinkedList<RailwayStation> route) {
        this.route = route;
        currentStation = route.pollFirst();
        nextStation = route.pollFirst();
        initDistance();
    }

    public Train(String from, String to) {
        route = new Navigator().getRoute(from, to);
        currentStation = route.pollFirst();
        nextStation = route.pollFirst();
        initDistance();
    }

    public void move() {
        if (nextStation == currentStation) {
            if (route.isEmpty()) {
                TrainOnline trainOnline = TrainOnline.getInstance();
                System.out.println("финишировал");
                trainOnline.unsubscribe(this);
                return;
            }
            nextStation();
            return;
        }
        currentPosition++;
        if (currentPosition == distance) arrivedToStation();
    }

    private void initDistance() {
        Railway railway = currentStation.getRelatoinsRailways().get(nextStation);
        distance = railway.getDistance();
        currentPosition = 0;
    }

    private void arrivedToStation() {
        currentStation = nextStation;
    }

    private void nextStation() {
        nextStation = route.pollFirst();
        initDistance();
    }


    public boolean accident(Train train) {
        if (currentStation == train.nextStation && nextStation == train.currentStation
                || currentStation == nextStation && train.nextStation == train.currentStation && train.nextStation == nextStation) {
            System.out.println("1train= "+ currentStation + nextStation + "2train= " +train.currentStation + train.nextStation);
            return true;
        }

            return false;
    }

    @Override
    public String toString() {
        return "еду из " + currentStation + " в " + nextStation + " проехал: " + currentPosition + "/" + distance;
    }
}
