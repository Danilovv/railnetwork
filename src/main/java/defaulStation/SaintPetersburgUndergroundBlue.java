package defaulStation;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public enum SaintPetersburgUndergroundBlue implements SaintPetersburgUnderground {
    PARNAS("Парнас"),
    PROSPECT_PROSVECHNIJA("Проспект Просвещения"),
    OZERKI("Озерки"),
    YDELNAJA("Удельная"),
    PIONERSKAJA("Пионерская"),
    CHERNAJA_RECHKA("Черная речка"),
    PETROGRADSKAJA("Петроградская"),
    GORKOVSKAJA("Горьковская"),
    NEVSKII("Невский"),
    SPASSKAJA("Спасская"),
    TECHNOLOJKA("Техноложка"),
    FRUNZENSKAJA("Фрунзенская"),
    ELECKTROSILA("Электросила"),
    PARCK_POBEDI("Парк победы"),
    MOSKOVSKAJA("Московская"),
    ZVEZDNAJA("Звездная"),
    KYPCHINO("Купчино");

    private final String station;

    SaintPetersburgUndergroundBlue(String station) {
        this.station = station;
    }

    public String getStationName() {
        return station;
    }
}
