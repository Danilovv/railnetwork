package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public final class RailwayNetwork {
    private static volatile RailwayNetwork instance;

    private final Map<String, RailwayStation> stationMap = new HashMap<>();

    public static RailwayNetwork getInstance() {
        if (instance == null)
            instance = new RailwayNetwork();

        return instance;
    }

    private RailwayNetwork() {
    }

    public void createStation(final String name) {
        stationMap.put(name, new RailwayStation(name));
    }

    public RailwayStation getStation(final String name) {
        return stationMap.get(name);
    }

    public Set<String> getStationsName() {
        return stationMap.keySet();
    }

    public void setConnectionStation(final String firstStation, final String secondStation, final int length) {
        final RailwayStation railwayStation1 = getStation(firstStation);
        final RailwayStation railwayStation2 = getStation(secondStation);

        railwayStation1.addConnection(railwayStation2, length);
    }


}
