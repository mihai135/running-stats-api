package org.fasttrackit.runningstatsapi.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class RunningStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   @NotNull
   @Size(min = 1, max = 80)
    private String name;

   private Date date;
   private double distance_km;
   private double time_min;
   private String terrain;

   public double pace_minkm(double distance, double time){
       double pace = distance/time;
       return pace;
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
}
