package org.fasttrackit.runningstatsapi.transfer;

import java.util.Date;

public class CreateRunningStatsRequest {

    private String name;
    private Date date;
    private double distance_km;
    private double time_min;
    private String terrain;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    @Override
    public String toString() {
        return "CreateRunningStatsRequest{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", distance_km=" + distance_km +
                ", time_min=" + time_min +
                ", terrain='" + terrain + '\'' +
                '}';
    }
}
