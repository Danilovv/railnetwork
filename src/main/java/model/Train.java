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
        System.out.println(currentStation.getName() + nextStation.getName() + train.currentStation.getName() + train.nextStation.getName());
        if (moveToEachOther(train)
                || stayAtSameStation(train) ) { //stay at same position
            return true;
        }

            return false;
    }

    private boolean stayAtSameStation(Train train){
        return currentStation == nextStation && train.nextStation == train.currentStation && train.nextStation == nextStation;
    }

    private boolean moveToEachOther(Train train){
        return currentStation == train.nextStation && nextStation == train.currentStation;
    }

    @Override
    public String toString() {
        return "еду из " + currentStation + " в " + nextStation + " проехал: " + currentPosition + "/" + distance;
    }
}
