package org.fhnw.sport.sportclub.Coach;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.fhnw.sport.sportclub.Player.Player;
import org.fhnw.sport.sportclub.Team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "coachID") // für n:m
public class Coach {
    @Id
    @GeneratedValue
    @Column(name = "Coach ID")
    private Integer coachID;
    @Column(name = "Name")
    private String name;
    @ManyToMany(mappedBy = "coaches")
    private List<Team> teams = new ArrayList<>();
    @OneToMany(mappedBy = "coach")
    @JsonManagedReference
    private List<Player>players = new ArrayList<>();

    public Coach(String name) {
        this.name = name;
    }

    public Coach() {

    }

    public Integer getCoachID() {
        return coachID;
    }

    public void setCoachID(Integer coachID) {
        this.coachID = coachID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(coachID, coach.coachID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coachID);
    }
}
