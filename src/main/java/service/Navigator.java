package service;

import model.NavigatorNode;
import model.Railway;
import model.RailwayNetwork;
import model.RailwayStation;

import java.util.*;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public final class Navigator {
    private final Integer START_STATION = 0;
    private final Integer NOT_VISITED = Integer.MAX_VALUE / 2;

    private final RailwayNetwork railwayNetwork = RailwayNetwork.getInstance();
    private final Map<String, NavigatorNode> visited;

    public Navigator() {
        visited = new HashMap<>();
    }

    public final LinkedList<RailwayStation> getRoute(final String from, final String to) {
        RailwayStation start = railwayNetwork.getStation(from);
        RailwayStation finish = railwayNetwork.getStation(to);

        makeVisitedMap();

        visited.put(from, new NavigatorNode(START_STATION, start));
        makeNavigateMap(start, finish);

        return makeRoadList(start, finish);
    }

    private void makeNavigateMap(RailwayStation currentStation, RailwayStation finish) {
        Map<RailwayStation, Railway> railwayRelations = currentStation.getRelatoinsRailways();

        if (!(currentStation == finish)) {
            for (Map.Entry<RailwayStation, Railway> entry : railwayRelations.entrySet()) {
                int valueCurrentStation = visited.get(currentStation.getName()).getValue();
                int railwayValue = entry.getValue().getDistance();
                RailwayStation nextStation = entry.getValue().getAnotherStation(currentStation);
                int valueNextStation = visited.get(nextStation.getName()).getValue();

                if (valueCurrentStation + railwayValue < valueNextStation) {
                    NavigatorNode navigatorNode = visited.get(nextStation.getName());
                    navigatorNode.set(valueCurrentStation + railwayValue, currentStation);
                    visited.put(nextStation.getName(), navigatorNode);
                    makeNavigateMap(nextStation, finish);
                }
            }
        }
    }

    private void makeVisitedMap() {
        final Iterator<String> stationIterator = railwayNetwork.getStationsName().iterator();

        while (stationIterator.hasNext()) {
            final String station = stationIterator.next();

            final NavigatorNode navigatorNode = new NavigatorNode(NOT_VISITED, railwayNetwork.getStation(station));

            visited.put(station, navigatorNode);
        }
    }

    private LinkedList<RailwayStation> makeRoadList(RailwayStation startStation, RailwayStation finishStation) {
        LinkedList<RailwayStation> roadList = new LinkedList();
        RailwayStation currentStation = finishStation;
        while (!(currentStation == startStation)) {
            roadList.addFirst(currentStation);
            currentStation = visited.get(currentStation.getName()).getStation();
        }
        roadList.addFirst(currentStation);
        return roadList;
    }

}
