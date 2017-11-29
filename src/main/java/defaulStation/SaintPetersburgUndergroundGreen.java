package defaulStation;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public enum SaintPetersburgUndergroundGreen implements SaintPetersburgUnderground {
    PRIMORSKAJA("Приморская"),
    VASILEOSTROVSKAJA("Василеостровская"),
    NEVSKI("Гостинный двор"),
    VOSTANIJA("Площадь Восстания"),
    ALEKSANDRA_NEVSKOGO("Площадь Александра Невского"),
    ELIZAROVSKAJA("Елизаровская"),
    LOMONOSOVSKAJA("Ломоносовская"),
    PROLETARSKAJA("Пролетарская"),
    OBUHOVO("Обухово"),
    RIBAZKOE("Рыбацкое");


    private final String station;

    SaintPetersburgUndergroundGreen(String station) {
        this.station = station;
    }

    public String getStationName() {
        return station;
    }
}
