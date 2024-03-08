package models;

public class AgeData {
    private int year;
    private long malePopulation;
    private long femalePopulation;

    // Constructor
    public AgeData(int year, long malePopulation, long femalePopulation) {
        this.year = year;
        this.malePopulation = malePopulation;
        this.femalePopulation = femalePopulation;
    }

    // Getters and setters
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public long getMalePopulation() { return malePopulation; }
    public void setMalePopulation(long malePopulation) { this.malePopulation = malePopulation; }
    public long getFemalePopulation() { return femalePopulation; }
    public void setFemalePopulation(long femalePopulation) { this.femalePopulation = femalePopulation; }
}
