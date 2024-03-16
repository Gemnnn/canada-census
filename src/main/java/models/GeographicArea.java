package models;

public class GeographicArea {
    private String name;
    private int code;
    private int level;
    private int totalPopulation;
    private int censusYear = 2021;

    private int geographicAreaID;

    // Constructors
    public GeographicArea() {
    }

    public GeographicArea(String name, int code, int level, int totalPopulation, int geographicAreaID) {
        this.name = name;
        this.code = code;
        this.level = level;
        this.totalPopulation = totalPopulation;
        this.geographicAreaID = geographicAreaID;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public int getTotalPopulation() { return totalPopulation; }
    public void setTotalPopulation(int totalPopulation) { this.totalPopulation = totalPopulation; }
    public int getCensusYear() { return censusYear; }
    public void setCensusYear(int censusYear) { this.censusYear = censusYear; }
    public int getGeographicAreaID() { return geographicAreaID; }
    public void setGeographicAreaID(int geographicAreaID) { this.geographicAreaID = geographicAreaID; }
}
