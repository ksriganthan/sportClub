package org.fhnw.sport.sportclub.Skill;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Skill {
    @Id
    @GeneratedValue
    @Column(name = "Skill ID")
    private Integer skillID;
    @Column (name = "Skill Type")
    private SkillType skill;

    public Skill(SkillType skill) {
        this.skill = skill;
    }

    public Skill() {

    }

    public Integer getSkillID() {
        return skillID;
    }

    public void setSkillID(Integer skillID) {
        this.skillID = skillID;
    }

    public SkillType getSkill() {
        return skill;
    }

    public void setSkill(SkillType skill) {
        this.skill = skill;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || o.getClass() != this.getClass()) {
            return  false;
        }
        else{
            Skill otherSkill = (Skill)o;
            return Objects.equals(otherSkill.skillID,this.skillID) && Objects.equals(otherSkill.skill,this.skill);
        }
    }

    @Override
    public int hashCode() {
        return  Objects.hash(this.skillID);
    }
}
