package org.fhnw.sport.sportclub.PlayerSkill;


import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlayerSkillKey implements Serializable {
    private Integer skillID;
    private Integer playerID;

    public PlayerSkillKey(Integer skillID, Integer playerID) {
        this.skillID = skillID;
        this.playerID = playerID;
    }

    public PlayerSkillKey() {

    }

    public Integer getSkillID() {
        return skillID;
    }

    public void setSkillID(Integer skillID) {
        this.skillID = skillID;
    }

    public Integer getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PlayerSkillKey that = (PlayerSkillKey) o;
        return Objects.equals(skillID, that.skillID) && Objects.equals(playerID, that.playerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skillID, playerID);
    }
}
