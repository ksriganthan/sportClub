package org.fhnw.sport.sportclub.Team;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.fhnw.sport.sportclub.Coach.Coach;
import org.fhnw.sport.sportclub.Player.Player;
import org.fhnw.sport.sportclub.Stadium.Stadium;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "teamID") // für n:m
public class Team {
    @Id
    @GeneratedValue
    @Column(name="Team ID")
    private Integer teamID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Worth")
    private Double netWorth;
    @OneToMany(mappedBy = "currentTeam")
    @JsonManagedReference
    private List<Player> players = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "coaches_teams",
            joinColumns = @JoinColumn(name = "Team ID"),
            inverseJoinColumns = @JoinColumn(name ="Coach ID"))
    private List<Coach>coaches = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "Stadion")
    private Stadium stadium;

    public Team(String name, Double netWorth) {
        this.name = name;
        this.netWorth = netWorth;
    }

    public Team() {

    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(Double netWorth) {
        this.netWorth = netWorth;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamID, team.teamID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(teamID);
    }
}
