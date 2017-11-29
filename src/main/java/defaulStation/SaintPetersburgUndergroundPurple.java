package defaulStation;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public enum SaintPetersburgUndergroundPurple implements SaintPetersburgUnderground {

    KOMENDANTSHII("Коменданский проспект"),
    STARAJA_DEREVNJA("Старая деревня"),
    KRESTOVSKII_OSTROV("Крестовский остров"),
    CHKALOVSKAJA("Чкаловская"),
    SPORTIVNAJA("Спортивная"),
    ADMIRALTEISKAJA("Адмиралтейская"),
    SPASSKAJA(SaintPetersburgUndergroundBlue.SPASSKAJA.getStationName()),
    PUSHKINSKAJA("Пушкинская"),
    OBVODNII_KANAL("Обводный канал"),
    VOLKOVSKAJA("Волковская"),
    BUHARESTSKAJA("Бухарестская"),
    MEJDUNARODNAJA("Международная"),
    PROSPECT_SLAVI("Проспект Славы"),
    DUNAISKAJA("Дунайская"),
    SHUSHARI("Шушары");



    private final String station;

    SaintPetersburgUndergroundPurple(String station) {
        this.station = station;
    }

    public String getStationName() {
        return station;
    }
}
