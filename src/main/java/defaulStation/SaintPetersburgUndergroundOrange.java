package defaulStation;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public enum SaintPetersburgUndergroundOrange implements SaintPetersburgUnderground {
    SPASSKAJA(SaintPetersburgUndergroundBlue.SPASSKAJA.getStationName()),
    DOSTOEVSKAJA("Достоевская"),
    LIGOVSKII("Лиговский"),
    ALEKSANDRA_NEVSKOGO(SaintPetersburgUndergroundGreen.ALEKSANDRA_NEVSKOGO.getStationName()),
    NOVOCHERKASKAJA("Новочеркаская"),
    LADOJSKAJA("Ладожская"),
    PROSPEKT_BOLSHEVIKOV("Проспект Большевиков"),
    DIBANKO("Дыбенко");

    private final String station;

    SaintPetersburgUndergroundOrange(String station) {
        this.station = station;
    }

    public String getStationName() {
        return station;
    }
}
