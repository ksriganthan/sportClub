package org.fhnw.sport.sportclub.PlayerSkill;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.fhnw.sport.sportclub.Player.Player;
import org.fhnw.sport.sportclub.Skill.Skill;

@Entity
public class PlayerSkill {
    @EmbeddedId
    @Column(name = "Key")
    private PlayerSkillKey key; //alles muss lowercase sein

    @Column(name = "Skill Level")
    private Integer skillLevel;

    @ManyToOne
    @JoinColumn(name = "skillID", updatable = false, insertable = false)
    @JsonIgnore
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "playerID", updatable = false, insertable = false)
    @JsonIgnore
    private Player player;

    public PlayerSkill(Integer skillID, Integer playerID, Integer skillLevel) {
        this.key = new PlayerSkillKey(skillID,playerID);
        this.skillLevel = skillLevel;
    }

    public PlayerSkill() {

    }

    public PlayerSkillKey getKey() {
        return key;
    }

    public void setKey(PlayerSkillKey key) {
        this.key = key;
    }

    public Integer getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


}
