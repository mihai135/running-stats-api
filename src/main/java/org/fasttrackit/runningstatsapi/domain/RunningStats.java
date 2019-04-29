package org.fasttrackit.runningstatsapi.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class RunningStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   @NotNull
   @Size(min = 1, max = 80)
    private String name;

   private LocalDate date;
   private double distance_km;
   private double time_min;
   private String terrain;
   private double pace;

    public RunningStats() {
    }

    public RunningStats(double time_min, double distance_km) {
        this.time_min = time_min;
        this.distance_km = distance_km;
        pace = time_min/distance_km;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
