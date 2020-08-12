package com.mone.server.casemanagerstart.user.service.impl;

import com.mone.server.casemanagerstart.user.entity.Team;
import com.mone.server.casemanagerstart.user.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description
 * @Classname TeamServiceImplTest
 * @auther motao
 * @create 2020-08-12 16:10
 */

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class TeamServiceImplTest {

    @Autowired
    TeamService teamService;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveTeam() {
    }

    @Test
    void updateTeam() {
    }

    @Test
    void deleteTeam() {
    }

    @Test
    void getTeamInfoById() throws Exception {
        Team team = teamService.getTeamInfoById(1);
        log.info("" + team);
    }

    @Test
    void getTeamsByParentId() {
    }

    @Test
    void getTeamPageList() {
    }
}
