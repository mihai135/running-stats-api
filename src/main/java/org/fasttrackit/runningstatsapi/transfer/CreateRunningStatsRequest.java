package org.fasttrackit.runningstatsapi.transfer;

import java.time.LocalDate;
import java.util.Date;

public class CreateRunningStatsRequest {

    private String name;
    private LocalDate date;
    private double distance_km;
    private double time_min;
    private String terrain;
    private double pace;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getDistance_km() {
        return distance_km;
    }

    public void setDistance_km(double distance_km) {
        this.distance_km = distance_km;
    }

    public double getTime_min() {
        return time_min;
    }

    public void setTime_min(double time_min) {
        this.time_min = time_min;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public double getPace() {
        return pace;
    }

    public void setPace(double pace) {
        this.pace = pace;
    }

    @Override
    public String toString() {
        return "CreateRunningStatsRequest{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", distance_km=" + distance_km +
                ", time_min=" + time_min +
                ", terrain='" + terrain + '\'' +
                ", pace=" + pace +
                '}';
    }
}
