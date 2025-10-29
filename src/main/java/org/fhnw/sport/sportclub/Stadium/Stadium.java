package org.fhnw.sport.sportclub.Stadium;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.fhnw.sport.sportclub.Team.Team;

import java.util.Objects;

@Entity
public class Stadium {
    @Id
    @GeneratedValue
    private Integer stadiumID;
    @Column(name = "Stadium_Name")
    private String name;
    @Column(name = "Ort")
    private String ort;
    @OneToOne(mappedBy = "stadium")
    private Team team;

    public Stadium(String name, String ort) {
        this.name = name;
        this.ort = ort;
    }

    public Stadium() {

    }

    public Integer getStadiumID() {
        return stadiumID;
    }

    public void setStadiumID(Integer stadiumID) {
        this.stadiumID = stadiumID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Stadium stadium = (Stadium) o;
        return Objects.equals(stadiumID, stadium.stadiumID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stadiumID);
    }
}
