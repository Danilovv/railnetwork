package defaulStation;

/**
 * @author Gorchakov Vladimir
 * @version 1.0
 */
public enum  SaintPetersburgUndergroundRed implements SaintPetersburgUnderground {
    DEVJATKINO("Девяткино"),
    GRAJDANSKII_PROSPEKT("Гражданский проспект"),
    AKADEMICHESKAJA("Академическая"),
    POLITEXNICHESKAJA("Политехническая"),
    MUGESTVA("Площадь Мужества"),
    LESNAJA("Лесная"),
    VIBORGSKAJA("Выборгская"),
    LENINA("Ленина"),
    VOSSTANIJA(SaintPetersburgUndergroundGreen.VOSTANIJA.getStationName()),
    DOSTOEVSKAJA(SaintPetersburgUndergroundOrange.DOSTOEVSKAJA.getStationName()),
    PUSHKINSKAJA(SaintPetersburgUndergroundPurple.PUSHKINSKAJA.getStationName()),
    TEHNOLOJKA(SaintPetersburgUndergroundBlue.TECHNOLOJKA.getStationName()),
    BALTIISKAJA("Балтийская"),
    NARVSKAJA("Нарвская"),
    KIROVSKII_ZAVOD("Кировский завод"),
    AVTOVO("Автово"),
    LENINSKII_PROSPEKT("Ленинский проспект"),
    PROSPECT_VETERANOV("Проспект Ветеранов");


    private final String station;

    SaintPetersburgUndergroundRed(String station) {
        this.station = station;
    }

    public String getStationName() {
        return station;
    }
}
