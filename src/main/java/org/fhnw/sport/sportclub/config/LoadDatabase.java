package org.fhnw.sport.sportclub.config;

import jakarta.transaction.Transactional;
import org.fhnw.sport.sportclub.Coach.Coach;
import org.fhnw.sport.sportclub.Coach.CoachRepository;
import org.fhnw.sport.sportclub.Player.Player;
import org.fhnw.sport.sportclub.Player.PlayerRepository;
import org.fhnw.sport.sportclub.PlayerSkill.PlayerSkill;
import org.fhnw.sport.sportclub.PlayerSkill.PlayerSkillKey;
import org.fhnw.sport.sportclub.PlayerSkill.PlayerSkillRepository;
import org.fhnw.sport.sportclub.Skill.Skill;
import org.fhnw.sport.sportclub.Skill.SkillRepository;
import org.fhnw.sport.sportclub.Skill.SkillType;
import org.fhnw.sport.sportclub.Stadium.Stadium;
import org.fhnw.sport.sportclub.Stadium.StadiumRepository;
import org.fhnw.sport.sportclub.Team.Team;
import org.fhnw.sport.sportclub.Team.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LoadDatabase implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private StadiumRepository stadiumRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private PlayerSkillRepository playerSkillRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Coach c1 = new Coach("Pep Guardiola");
        Coach c2 = new Coach("Jose Mourinho");

        Player p1 = new Player("Lionel Messi");
        Player p2 = new Player("Cristiano Ronaldo");

        // Coach <--> Player
        p1.setCoach(c1);
        c1.getPlayers().add(p1);

        p2.setCoach(c2);
        c2.getPlayers().add(p2);


        Team t1 = new Team("FC Barcelona", 1000.0);
        Team t2 = new Team("Real Madrid", 500.0);

        // Team <--> Player
        p1.setCurrentTeam(t1);
        t1.getPlayers().add(p1);

        p2.setCurrentTeam(t2);
        t2.getPlayers().add(p2);

        // Coach <--> Team
        c1.getTeams().add(t1);
        t1.getCoaches().add(c1);

        c2.getTeams().add(t2);
        t2.getCoaches().add(c2);


        Stadium s1 = new Stadium("Camp Nou", "Barcelona");
        Stadium s2 = new Stadium("San Bernabeo", "Madrid");

        // Stadium <-> Team  -   Hier reicht einseitig, da man nur vom Team aus auf Stadium zugreift
        t1.setStadium(s1);
        t2.setStadium(s2);



        Skill skAtt = new Skill(SkillType.Attack);
        Skill skDef = new Skill(SkillType.Defence);
        Skill skKee = new Skill(SkillType.Keeper);
        Skill skMen = new Skill(SkillType.Mental);
        Skill skTec = new Skill(SkillType.Technic);
        Skill skPhy = new Skill(SkillType.Physic);



        log.info("Preloading Stadium 1: " + stadiumRepository.save(s1));
        log.info("Preloading Stadium 2: " + stadiumRepository.save(s2));

        log.info("Preloading Skill Attack: " + skillRepository.save(skAtt));
        log.info("Preloading Skill Defence: " + skillRepository.save(skDef));
        log.info("Preloading Skill Keeper: " + skillRepository.save(skKee));
        log.info("Preloading Skill Mental: " + skillRepository.save(skMen));
        log.info("Preloading Skill Technical: " + skillRepository.save(skTec));
        log.info("Preloading Skill Physical: " + skillRepository.save(skPhy));

        log.info("Preloading Team 1: " + teamRepository.save(t1));
        log.info("Preloading Team 2: " + teamRepository.save(t2));

        log.info("Preloading Player 1: " + playerRepository.save(p1));
        log.info("Preloading Player 2: " + playerRepository.save(p2));

        log.info("Preloading Coach 1: " + coachRepository.save(c1));
        log.info("Preloading Coach 2: " + coachRepository.save(c2));

        log.info("Preloading PlayerSkill: " + playerSkillRepository.save(new PlayerSkill(1, 1, 97)));
        log.info("Preloading PlayerSkill: " + playerSkillRepository.save(new PlayerSkill(2, 1, 50)));
        log.info("Preloading PlayerSkill: " + playerSkillRepository.save(new PlayerSkill(3, 1, 100)));

        log.info("Preloading PlayerSkill: " + playerSkillRepository.save(new PlayerSkill(4, 2, 0)));
        log.info("Preloading PlayerSkill: " + playerSkillRepository.save(new PlayerSkill(5, 2, 100)));
        log.info("Preloading PlayerSkill: " + playerSkillRepository.save(new PlayerSkill(6, 2, 90)));

    }
}
