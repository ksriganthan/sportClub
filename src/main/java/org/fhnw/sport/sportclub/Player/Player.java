package org.fhnw.sport.sportclub.Player;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.fhnw.sport.sportclub.Coach.Coach;
import org.fhnw.sport.sportclub.PlayerSkill.PlayerSkill;
import org.fhnw.sport.sportclub.Team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Player")
public class Player {
    @Id
    @GeneratedValue
    @Column(name = "Player ID")
    private Integer playerID;
    @Column(name = "Name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "Team")
    @JsonBackReference
    private Team currentTeam;
    @ManyToOne
    @JoinColumn(name = "Coach")
    @JsonBackReference
    private Coach coach;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<PlayerSkill> skills = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }
    public Player() {

    }

    public Integer getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getCurrentTeam() {
        return currentTeam;
    }

    public void setCurrentTeam(Team currentTeam) {
        this.currentTeam = currentTeam;
    }

    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public List<PlayerSkill> getSkills() {
        return skills;
    }

    public void setSkills(List<PlayerSkill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerID, player.playerID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(playerID);
    }
}
