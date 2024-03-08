package models;

public class GeographicArea {
    private String name;
    private int level;

    private int code;
    private long totalPopulation;

    public GeographicArea() {
    }

    public GeographicArea(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
