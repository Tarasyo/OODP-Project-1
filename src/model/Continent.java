package model;


        /*
        Enum for continents that will be used in country class for creation of new country
         */


public enum Continent {

    ASIA("Asia"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"),
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARCTICA("Antarctica"),
    SOUTH_AMERICA("South America");

    private final String continent;

    Continent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return  this.continent;
    }
}
