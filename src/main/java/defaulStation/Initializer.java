package defaulStation;

import model.RailwayNetwork;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public final class Initializer {
    private final RailwayNetwork railwayNetwork;

    public Initializer() {
         railwayNetwork = RailwayNetwork.getInstance();
    }

    public void work() {
        initStations(SaintPetersburgUndergroundBlue.values());
        initStations(SaintPetersburgUndergroundGreen.values());
        initStations(SaintPetersburgUndergroundOrange.values());
        initStations(SaintPetersburgUndergroundPurple.values());
        initStations(SaintPetersburgUndergroundRed.values());
    }

    private void initStations(final SaintPetersburgUnderground [] undergroundValues) {
        final Iterator<SaintPetersburgUnderground> iterator = Arrays.asList(undergroundValues).iterator();

        if (!iterator.hasNext()) return;

        String previousStationName = iterator.next().getStationName();

        createStation(previousStationName);

        while (iterator.hasNext()) {
            final String stationName = iterator.next().getStationName();
            
            createStation(stationName);
            createRelation(previousStationName, stationName);

            previousStationName = stationName;
        }
    }

    private void createStation(final String value) {
        railwayNetwork.createStation(value);
    }

    private void createRelation(final String previousStation, final String nextStation) {
        railwayNetwork.setConnectionStation(previousStation, nextStation, getDistance());
    }

    private int getDistance(){
      return util.Random.getDistance();
    }
}
